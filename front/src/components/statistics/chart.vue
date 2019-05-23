<template>
  <div class="answerChart">
    <div class="oneQues" v-for="(item,index) in answers" :key ="index">
      <div class="titleArea">
        {{item.title}}
      </div>
      <div class="tableArea">
        <el-table
        :data="item.options"
        show-summary
        style="width: 100%">
        <el-table-column
          prop="optionContent"
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
import surverApi from '../../client/bll/apis/surver'
import questionApi from '../../client/bll/apis/question'
import answerApi from '../../client/bll/apis/answer'
export default {
  data () {
    return {
      answers: [
        {
          title: '你对所学的专业是否满意',
          quesionData: [
            {
              name: '非常满意',
              value: 8
            },
            {
              name: '一般',
              value: 2
            },
            {
              name: '非常不满意',
              value: 0
            }
          ]
        }
      ],
      currentChart: 'bar',
      survey: {
        title: '',
        descr: ''
      },
      surverQuestionsData: []
    }
  },
  async mounted () {
    // await this.getSurvers()
    // await this.getSurverQuesions()
    await this.staticAnswerText()
    this.drawBarChart('quesBarChart', this.getLengendData(), this.getValueData())
    this.drawPieChart('quesPieChart', this.getLengendData(), this.answers[0].quesionData)
  },
  methods: {
    async staticAnswerText () {
      let params = {
        surverId: this.$route.query.surverId
      }
      let res = await answerApi.staticAnswerText(params)
      if (res.code === 0) {
      }
    },
    async getAnswersBySurverId () {
    },
    async getSurvers () {
      let surverId = this.$route.query.surverId
      let res = await surverApi.search(surverId)
      if (res.code === 0) {
        this.survey.title = res.data[0].surverTitle
        this.survey.descr = res.data[0].surverDescription
      }
    },
    async getSurverQuesions () {
      let surverId = this.$route.query.surverId
      let res = await questionApi.searchBySueverId(surverId)
      console.log(res)
      if (res.code === 0) {
        this.surverQuestionsData = res.data
        console.log(this.surverQuestionsData)
        // this.transTypeCode(res.data)
      }
    },
    changeChart (key) {
      this.currentChart = key
    },
    getValueData () {
      let res = []
      for (let item of this.answers[0].quesionData) {
        res.push(item.value)
      }
      return res
    },
    getLengendData () {
      let res = []
      for (let item of this.answers[0].quesionData) {
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
