<template>
  <div class="pcPreview-container" id="pdfDom">
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
       <div class="submit" v-if="resultOrFill === 'fill'">
        <el-button type="primary" @click="setAnswerData" style="width:1.5rem;">提交</el-button>
      </div>
    </div>
   <!-- <div class="footer">
   </div> -->
  </div>
</template>
<script>
import radioType from '../QuestionType/radioChooseType'
import multiselect from '../QuestionType/multiselectChooseType'
import dropdownType from '../QuestionType/dropdownChooseType'
import textselectType from '../QuestionType/textselectChooseType'
import measureChooseType from '../QuestionType/measureChooseType'
import matrixChooseType from '../QuestionType/matrixChooseType'
import participatenApi from '../../client/bll/apis/participate'
import answerApi from '../../client/bll/apis/answer'
import commonFunc from '../../client/bll/apis/common/common'
import surverApi from '../../client/bll/apis/surver'
export default {
  props: ['survey', 'participatInfo', 'answerData', 'pcOrPhone'],
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
      currentParticPateId: '',
      answers: [],
      radioAnswer: '',
      multiAnswer: '',
      dropAnswer: '',
      textAnswer: '',
      measureAnswer: '',
      matrixRadioAnswer: '',
      matrixMultiAnswer: '',
      resultOrFill: '', // 如果为查看问卷结果状态则不显示提交按钮
      fillOrPreview: '' // 判断是否为填写还是预览界面，如果是预览界面则不能提交数据到后台
    }
  },
  mounted () {
    this.fillOrPreview = commonFunc.getLocalStorage('fillOrPreview')
    this.resultOrFill = commonFunc.getLocalStorage('resultOrFill')
    if (this.pcOrPhone === 'phone') {
      document.getElementsByTagName('html')[0].style.fontSize = '50px'
    } else {
      document.getElementsByTagName('html')[0].style.fontSize = '100px'
    }
    //
  },
  methods: {
    /**
     * 判断是否填完了所有的必填项题目，必须所有的填完才能够提交
     * [将该份问卷的所有必填项的问题id加入到一个数组A，再将已经填写完的答案的问题id加入到数组B
     * 通过判断B数组是否含有A数组的任意一个元素]
     */
    judgeSubmit () {
      let flag = true
      let surverQuestions = []
      let answerQuestions = []
      for (let item of this.survey.surverQuestions) {
        if (item.required === 'true') {
          surverQuestions.push(item.questionId)
        }
      }
      for (let item of this.answers) {
        answerQuestions.push(item.questionId)
      }
      for (let item of surverQuestions) {
        if (answerQuestions.indexOf(item) <= -1) {
          flag = false
          return
        }
      }
      return flag
    },
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
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getMultiAnswerData (data) {
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getDropAnswerData (data) {
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getTextAnswerData (data) {
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getMeasureAnswerData (data) {
      let flag = this.isSameQuestion(data.questionId)
      if (!flag) {
        this.answers.push(data)
      } else {
        this.answers[this.findSameQuestion(data.questionId)] = data
      }
    },
    getMatrixAnswerData (data) {
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
      for (let i in data) {
        let flag = this.isSameQuestionSub(data[i].subQuestionId)
        if (!flag) {
          this.answers.push(data[i])
        } else {
          this.answers[this.findSameQuestionSub(data[i].subQuestionId)] = data[i]
        }
      }
    },
    async addParticipate (time) {
      this.participatInfo.endTime = time
      let res = await participatenApi.add(this.participatInfo)
      if (res.code === 0) {
        this.currentParticPateId = res.data
        if (this.currentParticPateId === 'FILLED') {
          this.$router.push({name: 'error', params: {type: 'filled'}})
        } else {
          await this.addAnswer()
        }
      }
    },
    /**
     * 点击提交，添加用户已经填写的数据，以及更新用户完成时间
     */
    async setAnswerData () {
      if (this.fillOrPreview === 'preview') {
        commonFunc.showMessage('当前为预览状态，无法提交数据', 'success')
      } else if (this.fillOrPreview === 'fill') {
        let flag = this.judgeSubmit()
        if (!flag) {
          commonFunc.showMessage('问卷还没填写完成，不能提交', 'success')
        } else {
          // 先提交participate中的数据，再提交answer中的数据，防止
          // 提交参与者信息表
          await this.addParticipate(new Date().getTime())
        }
      }
    },
    async addAnswer () {
      let res = ''
      for (let item of this.answers) {
        if (commonFunc.isDefine(item.optionId) && item.optionId.indexOf(',') > 0) {
          let optionIds = item.optionId.split(',')
          for (let item1 of optionIds) {
            if (item1 !== '') {
              let params = {
                surverId: this.$route.params.id,
                questionId: item.questionId,
                subQuestionId: item.subQuestionId,
                optionId: item1,
                answerText: item.answerText,
                participateId: this.currentParticPateId
              }
              res = await answerApi.add(params)
            }
          }
        } else {
          let params = {
            surverId: this.$route.params.id,
            questionId: item.questionId,
            subQuestionId: item.subQuestionId,
            optionId: item.optionId,
            answerText: item.answerText,
            participateId: this.currentParticPateId
          }
          res = await answerApi.add(params)
        }
        if (res.code === 0) {
          console.log(res.data)
        }
      }
      // await this.updateEndTime()
      await this.updateRecoverNum()
      this.$router.push({name: 'thank'})
      console.log(this.answers)
    },
    // 更新问卷的回收数量
    async updateRecoverNum () {
      let params = {
        surverId: this.$route.params.id
      }
      let res = surverApi.updateRecoverNum(params)
      if (res.code === 0) {
        console.log('success')
      }
    },
    // 更新用户完成时间
    async updateEndTime () {
      let params = {
        participateId: this.currentParticPateId
      }
      let res = participatenApi.updateEndTime(params)
      if (res.code === 0) {
        commonFunc.showMessage('恭喜你，填写问卷成功', 'success')
      }
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
