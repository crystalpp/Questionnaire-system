<template>
  <div class="result-container">
     <pc-preview :survey='survey' :currentParticPateId='currentParticPateId' v-if="currentParticPateId&&flag"></pc-preview>
  </div>
</template>
<script>
// import phonePreview from '../components/preview/phonePreview'
import pcPreview from '../components/preview/pcPreview'
import surverApi from '../client/bll/apis/surver'
import answerApi from '../client/bll/apis/answer'
import questionApi from '../client/bll/apis/question'
import commonFunc from '../client/bll/apis/common/common'
export default {
  components: {
    'pc-preview': pcPreview
    // 'phone-preview': phonePreview
  },
  data () {
    return {
      survey: {
        title: '',
        descr: '',
        surverQuestions: [],
        participatIp: '',
        particiAddress: '',
        particiDevice: '',
        ipFlag: false,
        partcipateInfo: ''
      },
      answerData: [],
      currentParticPateId: '',
      answerResultData: [],
      flag: false
    }
  },
  async mounted () {
    debugger
    commonFunc.setLocalStorage('fillOrCreat', 'fill')
    commonFunc.setLocalStorage('editOrPreview', 'preview')
    await this.getSurvers()
    await this.getSurverQuesions()
    await this.getAnswersByParticipateId()
  },
  methods: {
    /**
     * 将每一个问题和自己的答案组装起来
     */
    randerSurverChooseData () {
      let res = []
      for (let item of this.survey.surverQuestions) {
        let resultItem = {
          ...item,
          currChoose: [],
          subChoose: {
          }
        }
        for (let answerItem of this.answerData) {
          if (answerItem.questionId === item.questionId) {
            if (answerItem.optionMap === null) {
              for (let item1 of answerItem.participateSubAnswers) {
                if (item1.optionId !== null) {
                  resultItem.currChoose.push(item1.optionId)
                } else {
                  resultItem.currChoose.push(item1.answerText)
                }
              }
            } else {
              resultItem.subChoose = answerItem.optionMap
            }
          }
        }
        res.push(resultItem)
      }
      debugger
      this.survey.surverQuestions = res
      console.log(res)
    },
    async getAnswersByParticipateId () {
      debugger
      this.currentParticPateId = this.$route.query.participateId
      let params = {
        participateId: this.currentParticPateId,
        surverId: this.$route.query.surverId
      }
      let res = await answerApi.getAnswersByParticipateId(params)
      if (res.code === 0) {
        this.answerData = res.data
        this.randerSurverChooseData()
        this.flag = true
      }
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
        // this.surverQuestionsData = res.data
        this.transTypeCode(res.data)
      }
    },
    transTypeCode (data) {
      for (let item of data) {
        let oneitem = {}
        if (item.quetypeId === '1') {
          item.quesType = 'radioselect'
        } else if (item.quetypeId === '2') {
          item.quesType = 'Multiselect'
        } else if (item.quetypeId === '3') {
          item.quesType = 'Drop-down'
        } else if (item.quetypeId === '4') {
          item.quesType = 'textselect'
        } else if (item.quetypeId === '5') {
          item.quesType = 'measure'
        } else if (item.quetypeId === '6') {
          item.quesType = 'matrix-radio'
        } else if (item.quetypeId === '7') {
          item.quesType = 'matrix-multi'
        }
        oneitem.type = item.quesType
        oneitem.title = item.questionName
        oneitem.questionId = item.questionId
        oneitem.subdesc = item.questionDirection
        oneitem.required = item.questionNeed
        oneitem.surverId = item.surverId
        oneitem.options = item.options
        oneitem.questions = item.subQuestions
        this.survey.surverQuestions.push(oneitem)
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.result-container {
  // background: #000000;
  width: 100%;
  height: 100%;
  cursor: not-allowed;
  pointer-events: none;
}
</style>
