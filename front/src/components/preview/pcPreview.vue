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
    }
  },
  mounted () {
  },
  methods: {
  }
}
</script>
<style lang="scss" scoped>
.pcPreview-container{
    background: #EFEFEF;
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
    }
  }
</style>
