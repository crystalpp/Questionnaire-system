<template>
  <div class="phonePreview-container">
    <div class="phone-body">
      <div class="survey-head">
        <!-- {{survey.surveyTitle.value}} {{survey.surveyDescr.value}} -->
        <p class="survey-title">{{survey.title}}</p> 
        <p class="survey-descr">{{survey.descr}}</p>
    </div>
    <div class="survey-container">
      <div v-for="(item,index) in survey.surverQuestions" :key="item.key" >
        <div v-if="item.type === 'radioselect'">
          <radio-choose-type :formData = 'item' :index = 'index' ></radio-choose-type>
        </div>
        <div v-if="item.type === 'Multiselect'">
          <multiselect-choose-type :formData = 'item' :index = 'index' ></multiselect-choose-type>
        </div>
        <div v-if="item.type === 'Drop-down'">
          <dropdown-choose-type :formData = 'item' :index = 'index' ></dropdown-choose-type>
        </div>
        <div v-if="item.type === 'textselect'"> 
          <textselect-choose-type :formData = 'item' :index = 'index' ></textselect-choose-type>
        </div>
        <div v-if="item.type === 'measure'">
          <measure-choose-type :formData = 'item' :index = 'index' ></measure-choose-type>
        </div>
        <div v-if="item.type === 'matrix-radio' || item.type === 'matrix-multi'">
          <matrix-choose-type :formData = 'item' :index = 'index' ></matrix-choose-type>
        </div>
      </div>
    </div>
    <div class="submit" v-if="resultOrFill === 'fill'">
      <el-button type="primary" @click="setAnswerData">提交</el-button>
    </div>
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
import commonFunc from '../../client/bll/apis/common/common'
export default {
  props: ['survey', 'currentParticPateId'],
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
      resultOrFill: ''
    }
  },
  mounted () {
    this.$emit('showPdfButtonevent', false)
    this.resultOrFill = commonFunc.getLocalStorage('resultOrFill')
    document.getElementsByTagName('html')[0].style.fontSize = '50px'
  },
  methods: {
    setAnswerData () {
      commonFunc.showMessage('当前为预览状态，无法提交数据', 'success')
    }
  }
}
</script>
<style lang="scss" scoped>
.phone-body::-webkit-scrollbar{
    width: 0.1rem;
  }
.phonePreview-container{
  background-image: url('../../assets/img/bg_preview_mobile.png') ;
  width: 250px;
  height: 480px;
  margin: 0 auto;
  position: relative;
  padding-top: 20px;
  background-size: 100%;
  .phone-body{
    word-wrap: break-word;
    word-break: break-all;
    overflow: auto;
    width: 180px;
    height: 360px;
    /* margin: 0 auto; */
    margin-left: 25px;
    margin-top: 38px;
     .survey-head{
      width: 100%;
      margin: 0 auto;
      background: #ffffff;
      padding-top: 0.2rem;
      .survey-title{
        font-size: 0.15rem;
        color: #000000;
      }
      .survey-descr{
        font-size: 0.08rem;
        margin-top: 0.1rem;
        padding-bottom: 0.1rem;
      }
    }
    .survey-container {
      text-align: left;
      width: 100%;
      margin: 0 auto;
      background: #ffffff;
    }
    .submit{
        text-align: center;
        padding-bottom: 0.2rem;
      }
  }
}
</style>
