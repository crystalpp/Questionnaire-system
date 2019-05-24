<template>
  <div class="answerChart">
    <div class="oneQues-answerText" v-for="(item, index) in answerData.type1" :key="index">
       <div class="titleArea">
        {{item.questionName}}
      </div>
      <div class="tableArea" v-if="item.questionType === 4">
        <el-table
          :data="answerTextData"
          style="width: 100%">
          <el-table-column
            prop="id"
            label="编号"
            width="100">
          </el-table-column>
          <el-table-column
            prop="text"
            label="文本答案"
            width="580">
          </el-table-column>
        </el-table>
      </div>
      <div class="tableArea" v-if="item.questionType === 5">
        <el-table
          :data="answerMeasureData"
          style="width: 100%">
          <el-table-column
            prop="id"
            label="编号"
            width="100">
          </el-table-column>
          <el-table-column
            prop="score"
            label="分值"
            width="280">
          </el-table-column>
          <el-table-column
            prop="num"
            label="小计"
            width="280">
          </el-table-column>
        </el-table>
      </div>
    </div>
    <div class="oneQues" v-for="(item,index) in answerData.type2" :key ="index">
      <div class="titleArea">
        {{item.questionName}}
      </div>
      <div class="tableArea">
        <el-table
        :data="item.listAnswer"
        show-summary
        style="width: 100%">
        <el-table-column
          prop="optionContent"
          label="选项"
          width="700">
        </el-table-column>
        <el-table-column
          prop="num"
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
          <div id='quesPieChart'  style="width:9rem;height:4rem;"></div>
        </div>
        <div class="chart" v-show="currentChart === 'bar'">
          <div id='quesBarChart' style="width:9rem;height:4rem;"></div>      
        </div>
      </div>
    </div>
    <div class="oneQues-sub" v-for="(item,index) in answerData.type3" :key="index">
      <div class="titleArea">
        {{item.questionName}}
      </div>
      <table class="matrixTable-radio">
        <tr>
          <th></th>
          <th v-for="(item1,index1) in item.subList[0].optionNums" :key="index1">{{item1.qoption.optionContent}} </th>
        </tr>
        <tr v-for="(item2,index2) in item.subList" :key="index2">
          <td>{{item2.sub_QuestionName}}</td>
          <td v-for="(item3,index3) in item2.optionNums" :key="index3">{{item3.num}}</td>
          <!-- <td>{{item2.optionNums[1].num}}</td> -->
        </tr>
      </table>
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
      answerTextData: [
        {
          id: 1,
          text: '非常满意'
        },
        {
          id: 2,
          text: '不满意'
        }
      ],
      answerMeasureData: [
        {
          id: 1,
          score: 5,
          num: 2
        },
        {
          id: 2,
          score: 2,
          num: 1
        }
      ],
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
      surverQuestionsData: [],
      answerData: []
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
        this.answerData = res.data
        console.log(this.answerData)
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
.matrixTable-radio{
  font-size: 0.12rem;
  width: 100%;
  tr{
    height: 0.4rem;
    align-items: center;
    display: flex;
    td{
      flex:1;
    }
    th{
      font-weight: normal;
      flex: 1;
    }
  }
}
.oneQues-answerText {
   width: 80%;
    // height: 8rem;
    margin: 0 auto;
    border: 1px solid #DBDBDB;
    background: #ffffff;
    .titleArea{
      color: #333333;
      text-align: left;
      padding: 0.2rem;
    }
}
.oneQues-sub {
  width: 80%;
    // height: 8rem;
    margin: 0 auto;
    border: 1px solid #DBDBDB;
    background: #ffffff;
    .titleArea{
      color: #333333;
      text-align: left;
      padding: 0.2rem;
    }
}
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
