<template>
  <div class="answerChart">
    <div class="oneQues">
      <div class="titleArea">
        1、你的年龄?
      </div>
      <div class="tableArea">
        <el-table
        :data="quesionData"
        show-summary
        style="width: 100%">
        <el-table-column
          prop="name"
          label="选项"
          width="700">
        </el-table-column>
        <el-table-column
          prop="value"
          label="小计"
          width="180">
        </el-table-column>
      </el-table>
      </div>
      <div class="chartArea">
        <div class="title">
          <el-button-group>
            <el-button type="primary" @click="changeChart('pie')">饼状图</el-button>
            <el-button type="primary" @click="changeChart('bar')">柱状图</el-button>
          </el-button-group>
        </div>
        <div class="chart" v-show="currentChart === 'pie'">
          <div id="quesPieChart" style="width:9rem;height:4rem;"></div>
        </div>
        <div class="chart" v-show="currentChart === 'bar'">
          <div id="quesBarChart" style="width:9rem;height:4rem;"></div>      
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      quesionData: [
        {
          name: '大三',
          value: 1
        },
        {
          name: '大四',
          value: 2
        },
        {
          name: '其他',
          value: 3
        }
      ],
      currentChart: 'bar'
    }
  },
  mounted () {
    this.drawBarChart('quesBarChart', this.getLengendData(), this.getValueData())
    this.drawPieChart('quesPieChart', this.getLengendData(), this.quesionData)
  },
  methods: {
    changeChart (key) {
      this.currentChart = key
    },
    getValueData () {
      let res = []
      for (let item of this.quesionData) {
        res.push(item.value)
      }
      return res
    },
    getLengendData () {
      let res = []
      for (let item of this.quesionData) {
        res.push(item.name)
      }
      return res
    },
    drawBarChart (id, legendData, data) {
      var initChart = this.$echarts.init(document.getElementById(id))
      var option = {
        color: ['#5AA9ED'],
        xAxis: {
          type: 'category',
          data: legendData
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: data,
          type: 'bar'
        }]
      }
      initChart.setOption(option)
    },
    drawPieChart (id, legendData, data) {
      var initChart = this.$echarts.init(document.getElementById(id))
      var option = {
        title: {
          x: 'left'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{b} : {c} ({d}%)'
        },
        legend: {
          x: 'center',
          y: '80%',
          data: legendData
        },
        series: [
          {
            type: 'pie',
            radius: '55%',
            center: ['50%', '35%'],
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
      initChart.setOption(option)
    }
  }
}
</script>
<style lang="scss" scoped>
.answerChart{
  width: 100%;
  height: 100%;
  .oneQues{
    width: 80%;
    height: 8rem;
    margin: 0 auto;
    border: 1px solid #DBDBDB;
    background: #ffffff;
    .titleArea{
      color: #333333;
      text-align: left;
      padding: 0.2rem;
    }
    .tableArea{
      padding: 0.2rem;
    }
    .chartArea{
      padding: 0.2rem;
      .title{
        text-align: left;
      }
      .chart{
        height: 100%;
        width: 100%;
      }
      .chart1{
        height: 100%;
        width: 100%;
      }
    }
  }
}
</style>
