<template>
  <div class="pcPreview-container">
    <div class="survey-head">
        <!-- {{survey.surveyTitle.value}} {{survey.surveyDescr.value}} -->
        <p class="survey-title">{{survey.title}}</p> 
        <p class="survey-descr">{{survey.descr}}</p>
    </div>
    <div class="survey-container">
      <div v-for="(item,index) in survey.surverQuestions" :key="item.key" >
        <div v-if="item.type === 'radioselect'">
          <radio-choose-type :formData = 'item' :index = 'index' @getAnswerData='getRadioAnswerData'></radio-choose-type>
        </div>
        <div v-if="item.type === 'Multiselect'">
          <multiselect-choose-type :formData = 'item' :index = 'index' @getAnswerData='getMultiAnswerData'></multiselect-choose-type>
        </div>
        <div v-if="item.type === 'Drop-down'">
          <dropdown-choose-type :formData = 'item' :index = 'index' @getAnswerData='getDropAnswerData'></dropdown-choose-type>
        </div>
        <div v-if="item.type === 'textselect'"> 
          <textselect-choose-type :formData = 'item' :index = 'index' @getAnswerData='getTextAnswerData'></textselect-choose-type>
        </div>
        <div v-if="item.type === 'measure'">
          <measure-choose-type :formData = 'item' :index = 'index' @getAnswerData='getMeasureAnswerData'></measure-choose-type>
        </div>
        <div v-if="item.type === 'matrix-radio' || item.type === 'matrix-multi'">
          <matrix-choose-type :formData = 'item' :index = 'index'  @getAnswerData='getMatrixAnswerData' @getAnswerDataMulti='getMatrixAnswerDataMulti'></matrix-choose-type>
        </div>
      </div>
       <div class="submit">
        <el-button type="primary" @click="getAnswerData">提交</el-button>
      </div>
    </div>
   <div class="footer">
   </div>
  </div>
</template>
<script>
import radioType from '../QuestionType/radioChooseType'
import multiselect from '../QuestionType/multiselectChooseType'
import dropdownType from '../QuestionType/dropdownChooseType'
import textselectType from '../QuestionType/textselectChooseType'
import measureChooseType from '../QuestionType/measureChooseType'
import matrixChooseType from '../QuestionType/matrixChooseType'
export default {
  props: ['survey'],
  components: {
    'radio-choose-type': radioType,
    'multiselect-choose-type': multiselect,
    'dropdown-choose-type': dropdownType,
    'textselect-choose-type': textselectType,
    'measure-choose-type': measureChooseType,
    'matrix-choose-type': matrixChooseType
  },
  data () {
    return {
      answers: [],
      radioAnswer: '',
      multiAnswer: '',
      dropAnswer: '',
      textAnswer: '',
      measureAnswer: '',
      matrixRadioAnswer: '',
      matrixMultiAnswer: ''
    }
  },
  mounted () {
    document.getElementsByTagName('html')[0].style.fontSize = '100px'
  },
  methods: {
    // 判断当前的问题答案中是否有要被插入的问题
    isSameQuestion (currentId) {
      let flag = false
      if (this.answers) {
        for (let item of this.answers) {
          if (item.questionId === currentId) {
            flag = true
          }
        }
      }
      return flag
    },
    findSameQuestion (currentId) {
      let index = 0
      for (let i in this.answers) {
        if (this.answers[i].questionId === currentId) {
          index = i
        }
      }
      return index
    },
    isSameQuestionSub (currentId) {
      let flag = false
      if (this.answers) {
        for (let item of this.answers) {
          if (item.subQuestionId === currentId) {
            flag = true
          }
        }
      }
      return flag
    },
    findSameQuestionSub (currentId) {
      let index = 0
      for (let i in this.answers) {
        if (this.answers[i].subQuestionId === currentId) {
          index = i
        }
      }
      return index
    },
    getRadioAnswerData (data) {
      debugger
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getMultiAnswerData (data) {
      debugger
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getDropAnswerData (data) {
      debugger
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getTextAnswerData (data) {
      debugger
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getMeasureAnswerData (data) {
      debugger
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getMatrixAnswerData (data) {
      debugger
      for (let i in data) {
        let flag = this.isSameQuestionSub(data[i].subQuestionId)
        if (!flag) {
          this.answers.push(data[i])
        } else {
          this.answers[this.findSameQuestionSub(data[i].subQuestionId)] = data[i]
        }
      }
    },
    getMatrixAnswerDataMulti (data) {
      debugger
      for (let i in data) {
        let flag = this.isSameQuestionSub(data[i].subQuestionId)
        if (!flag) {
          this.answers.push(data[i])
        } else {
          this.answers[this.findSameQuestionSub(data[i].subQuestionId)] = data[i]
        }
      }
    },
    getAnswerData (data) {
      debugger
      this.answers
      console.log(this.answers)
    }
  }
}
</script>
<style lang="scss" scoped>
.el-button--primary{
  width: 20%;
}
.pcPreview-container{
    background: #EFEFEF;
    // margin-bottom: 1rem;
    .survey-head{
      width: 75%;
      margin: 0 auto;
      background: #EFEFEF;
      padding-top: 0.2rem;
      .survey-title{
        font-size: 0.3rem;
        color: #000000;
      }
      .survey-descr{
        font-size: 0.16rem;
        margin-top: 0.2rem;
        padding-bottom: 0.2rem;
      }
    }
    .survey-container {
      text-align: left;
      width: 75%;
      margin: 0 auto;
      background: #ffffff;
      .submit{
        text-align: center;
        padding-bottom: 0.2rem;
      }
    }
    .footer{
      height: 0.2rem;
      background: #EFEFEF;
    }
  }
</style>
