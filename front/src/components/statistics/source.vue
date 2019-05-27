<template>
  <div class="statis-source">
    <!-- 数据总览 -->
    <div class="dataScreening">
      <div class="item">
        <p class="title">有效回收量</p>
        <p class="num">{{effectiveDataNum}}</p>
      </div>
      <div class="item">
        <p class="title">浏览量</p>
        <p class="num">{{browseDataNum}}</p>
      </div>
      <div class="item">
        <p class="title">平均答题时间</p>
        <p class="num">{{averageAnswerTime}}</p>
      </div>
      <div class="item">
        <p class="title">回收率</p>
        <p class="num">{{(effectiveDataNum/browseDataNum*100).toFixed(1)}}%</p>
      </div>
    </div>
    <!-- 每日回答情况（散点图）和回答者地域（中国地图）分布 -->
    <div class="part1">
      <el-row :gutter="20">
        <el-col :span="12">
          <div class="grid-content bg-purple answerSituation">
            <div class="title">
              <p class="text">回答情况</p>
              <div class="dateChoose">
                <el-date-picker style="width: 3rem" @change="timeChoose"
                  v-model="anserTimeRange"
                  type="daterange"
                  range-separator="-"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
                </el-date-picker>
                <!-- <el-select v-model="timeType" placeholder="请选择" style="width: 1rem">
                  <el-option
                    v-for="item in timeOption"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select> -->
              </div>
              
            </div>
            <div class="chart">
              <div id="answerLineChart" style="width:100%;height:4.5rem;"></div>
            </div>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="grid-content bg-purple">
            <div class="chart">
              <div id="areaMapChart" style="width:100%;height:4.5rem;"></div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <!-- 回到者所使用的操作系统，设备类型（使用柱状图） -->
    <div class="part2">
      <el-row :gutter="20">
        <el-col :span="8">
          <div class="grid-content-part2 bg-purple">
            <!-- 浏览器类型 -->
            <div class="chart">
              <div id="browerSourceChart" style="width:100%;height:3.5rem;"></div>
            </div>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="grid-content-part2 bg-purple">
            <!-- 操作系统类型 -->
            <div class="chart">
              <div id="operatingTypeChart" style="width:100%;height:3.5rem;"></div>
            </div>
          </div>
        </el-col>
         <el-col :span="8">
          <div class="grid-content-part2 bg-purple">
            <!-- 设备类型 -->
            <div class="chart">
              <div id="deviceTypeChart" style="width:100%;height:3.5rem;"></div>
            </div>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
// 引入china的json文件
import china from '../../../node_modules/echarts/map/json/china.json'
import chinaDataJSON from '../../assets/chinaData.json'
import commonFunc from '../../client/bll/apis/common/common'
import participatenApi from '../../client/bll/apis/participate'
export default {
  props: ['surverStaticData'],
  data () {
    return {
      anserTimeRange: [], // 查看答题人数的时间范围
      timeType: '', // 查看时间点的类型
      timeOption: [
        {
          value: 'day',
          label: '按天'
        },
        {
          value: 'week',
          label: '按周'
        },
        {
          value: 'year',
          label: '按月'
        }
      ],
      browerLegendData: ['chrome', 'firefox', 'oprea', 'ie', '其他'],
      operateLegendData: ['IOS', 'windows', 'MacOS', 'Android', '其他'],
      deviceLegendData: ['计算机', '移动设备', '其他'],
      browerData: [],
      operateData: [
        {value: 2, name: 'IOS'},
        {value: 0, name: 'Windows'},
        {value: 0, name: 'MacOS'},
        {value: 8, name: 'Android'},
        {value: 0, name: '其他'}
      ],
      deviceData: [
        {value: 5, name: '计算机'},
        {value: 5, name: '移动设备'},
        {value: 0, name: '其他'}
      ],
      chinaData: chinaDataJSON.data,
      effectiveDataNum: 0, // 有效回收数据数量
      browseDataNum: 0, // 浏览数据数量
      averageAnswerTime: '', // 平均答题时间
      effectiveData: [], // 有效数据
      rangeData: [], // 一定时间范围内的统计数据
      lineChartData: {
        times: [],
        values: []
      } //  折线图需要的数据
    }
  },
  mounted () {
    this.computeData()
    this.raderAreaData()
    this.randerPieData()
    this.initRangeData()
    this.drawChart()
  },
  methods: {
    // 初始化用户刚进来没有选择时间时的折线图的开始时间和结束时间(初始化为当前时间往后一周)
    async initRangeData () {
      let nowDate = new Date().toLocaleDateString()
      let endTime = new Date(nowDate)
      let statDate = new Date((endTime.getTime() - (7 * 24 * 60 * 60 * 1000))).toLocaleDateString()
      let startTime = new Date(statDate)
      this.anserTimeRange.push(startTime)
      this.anserTimeRange.push(endTime)
      let params = {
        startTime: startTime,
        endTime: endTime,
        surverId: this.$route.query.surverId
      }
      let res = await participatenApi.selectParticiByTime(params)
      if (res.code === 0) {
        this.lineChartData = {
          times: [],
          values: []
        }
        this.rangeData = res.data
        this.randerLineChartData(startTime.getTime(), endTime.getTime())
        this.drawLineChart()
      }
    },
    /**
     * 统计每个元素出现的次数
     */
    countItemAndValue (data) {
      var obj = {}
      for (var i = 0, l = data.length; i < l; i++) {
        var item = data[i]
        obj[item] = (obj[item] + 1) || 1
      }
      return obj
    },
    /**
     * 组装饼图所需要的数据
     */
    randerPieData () {
      let browers = []
      for (let item of this.surverStaticData) {
        browers.push(item.participateDevice)
      }
      let browersCount = this.countItemAndValue(browers)
      console.log(browersCount)
      for (let item of this.browerLegendData) {
        let part = {
          name: '',
          value: ''
        }
        part.value = browersCount[item.toUpperCase()]
        if (commonFunc.isDefine(browersCount[item.toUpperCase()])) {
          part.name = item
        } else {
          part.value = 0
        }
        this.browerData.push(part)
      }
    },
    /**
     * 组装地图所需要的数据
     */
    raderAreaData () {
      let citys = []
      for (let item of this.surverStaticData) {
        citys.push(item.participateArea)
      }
      let citysCount = this.countItemAndValue(citys)
      console.log(citysCount)
      for (let i of this.chinaData) {
        if (commonFunc.isDefine(citysCount[i.name])) {
          i.value = citysCount[i.name]
        }
      }
      // console.log(this.chinaData)
    },
    /**
     * 组装折线图所需要的数据
     */
    randerLineChartData (startTimeDateValueMs, endTimeDateValueMs) {
      let times = []
      for (let item of this.rangeData) {
        let time = (commonFunc.formateDate(item.participateEndtime).split(' '))[0]
        times.push(new Date(time).getTime())
      }
      let countTimes = this.countItemAndValue(times)
      for (let i = startTimeDateValueMs; i <= endTimeDateValueMs; i += 86400000) {
        let item = {
          time: '',
          value: ''
        }
        item.time = (commonFunc.formateDate(i).split(' '))[0]
        if (commonFunc.isDefine(countTimes[i])) {
          item.value = countTimes[i]
        } else {
          item.value = 0
        }
        this.lineChartData.times.push(JSON.parse(JSON.stringify(item.time)))
        this.lineChartData.values.push(JSON.parse(JSON.stringify(item.value)))
      }
    },
    formateDateFromMs (time) {
      return time.getFullYear() + '-' + (time.getMonth() + 1) + '-' + time.getDate()
    },
    /**
     * 选择不同时间范围内，显示不同的数据
     */
    async timeChoose () {
      let startTime = this.anserTimeRange[0]
      let startTimeDateValue = this.formateDateFromMs(startTime)
      let startTimeDateValueMs = new Date(startTimeDateValue).getTime()
      let endTime = this.anserTimeRange[1]
      let endTimeDateValue = this.formateDateFromMs(endTime)
      let endTimeDateValueMs = new Date(endTimeDateValue).getTime()
      let params = {
        startTime: startTime,
        endTime: endTime,
        surverId: this.$route.query.surverId
      }
      let res = await participatenApi.selectParticiByTime(params)
      if (res.code === 0) {
        this.lineChartData = {
          times: [],
          values: []
        }
        this.rangeData = res.data
        this.randerLineChartData(startTimeDateValueMs, endTimeDateValueMs)
        this.drawLineChart()
        console.log(this.lineChartData)
      }
    },
    /**
     * 统计有效数据
     */
    randerEffectiveData (data) {
      for (let item of this.surverStaticData) {
        if (item.participateEndtime !== null) {
          this.effectiveData.push(item)
        }
      }
    },
    /**
     * 根据回收的数据计算回收量，浏览量，答题时间等
     */
    computeData () {
      let sum = 0
      for (let item of this.surverStaticData) {
        if (item.participateEndtime === null) {
          this.browseDataNum ++
        } else {
          sum += (item.participateEndtime - item.participateStarttime)
          this.effectiveDataNum ++
          this.browseDataNum ++
        }
      }
      console.log(this.averageAnswerTime)
      this.averageAnswerTime = commonFunc.computedTime(sum / this.effectiveDataNum)
    },
    drawChart () {
      this.drawLineChart()
      this.drawMapChart(this.chinaData)
      this.drawPieChart('浏览器类型', 'browerSourceChart', this.browerLegendData, this.browerData)
      this.drawPieChart('操作系统类型', 'operatingTypeChart', this.operateLegendData, this.operateData)
      this.drawPieChart('设备类型', 'deviceTypeChart', this.deviceLegendData, this.deviceData)
    },
    drawLineChart () {
      var answerLineChart = this.$echarts.init(document.getElementById('answerLineChart'))
      var option = {
        color: ['#0078C8'],
        xAxis: {
          type: 'category',
          data: this.lineChartData.times
        },
        yAxis: {
          name: '人',
          type: 'value'
        },
        series: [{
          data: this.lineChartData.values,
          type: 'line'
        }]
      }
      answerLineChart.setOption(option)
    },
    drawMapChart (data) {
      this.$echarts.registerMap('china', china)
      var areaMapChart = this.$echarts.init(document.getElementById('areaMapChart'))
      var option = {
        title: {
          subtext: '地域位置'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b}<br/>{c} (人)'
        },
        visualMap: {
          min: 0,
          max: this.surverStaticData.length,
          text: ['高', '低'],
          realtime: false,
          calculable: true,
          inRange: {
            color: ['#B5D5FF', 'yellow', 'orangered']
          }
        },
        series: [
          {
            name: '',
            type: 'map',
            mapType: 'china', // 自定义扩展图表类型
            itemStyle: {
              normal: {
                label: {
                  show: true
                }
              },
              emphasis: {
                label: {
                  show: true
                }
              }
            },
            data: data
          }
        ]
      }
      areaMapChart.setOption(option)
    },
    drawPieChart (title, id, legendData, data) {
      var browerSourceChart = this.$echarts.init(document.getElementById(id))
      var option = {
        title: {
          subtext: title,
          x: 'left'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          x: 'center',
          y: 'bottom',
          data: legendData
        },
        series: [
          {
            name: title,
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            label: {
              normal: {
                position: 'inner'
              }
            },
            data: data,
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      }
      browerSourceChart.setOption(option)
    }
  }
}
</script>
<style lang="scss" scoped>
.el-row {
    margin-bottom: 0.2rem;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 0.04rem;
  }
  .bg-purple {
    background: #ffffff;
  }
  .grid-content {
    border-radius: 0.04rem;
    min-height: 0.36rem;
    height: 5.2rem;
  }
  .grid-content-part2 {
    border-radius: 0.04rem;
    min-height: 0.36rem;
    height: 4rem;
  }
  .row-bg {
    padding: 0.1rem 0;
    background-color: #f9fafc;
  }
.statis-source{
  width: 100%;
  height: 100%;
  .dataScreening{
    display: flex;
    align-items: center;
    background: #E9EEF3;
    width: 90%;
    margin: 0 auto;
    .item{
      margin-top: 0.35rem;
      flex:1;
      height: 0.75rem;
      .num{
        color: #0078C8;
        font-size: 0.24rem;
        // font-weight: bolder;
      }
      // line-height: 0.325rem;
    }
  }
  .part1{
    background: #E9EEF3;
    width: 90%;
    margin: 0 auto;
    .answerSituation{
      .title{
        padding:0.2rem;
        display: flex;
        .text{
          flex:1;
          text-align: left;
        }
        .dateChoose{
          flex: 2;
          // justify-content: flex-end;
          text-align: right;
        }
      }
      
    }
    // border-left: 1px solid #DBDBDB;
    // border-right: 1px solid #DBDBDB;
    // border-top: 1px solid #DBDBDB;
  }
  .chart {
    // padding: 0.2rem;
    height: 100%;
    // margin: 0 auto;
    width: 100%;
  }
  .part2{
    background: #E9EEF3;
    width: 90%;
    margin: 0 auto;
    margin-top: 0.2rem;
    // border-left: 1px solid #DBDBDB;
    // border-right: 1px solid #DBDBDB;
    // border-bottom: 1px solid #DBDBDB;
  }
}
</style>
