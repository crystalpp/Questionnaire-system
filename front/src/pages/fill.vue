<template>
  <div class="fill-container">
     <pc-preview :survey='survey' ></pc-preview>
     <!-- <phone-preview :survey='survey' v-if="pcOrPhone === 'phone'"></phone-preview> -->
  </div>
</template>
<script>
// import phonePreview from '../components/preview/phonePreview'
import pcPreview from '../components/preview/pcPreview'
import surverApi from '../client/bll/apis/surver'
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
        surverQuestions: []
      }
    }
  },
  async mounted () {
    commonFunc.setLocalStorage('editOrPreview', 'preview')
    await this.getSurvers()
    await this.getSurverQuesions()
  },
  methods: {
    async getSurvers () {
      debugger
      let surverId = this.$route.params.id
      let res = await surverApi.search(surverId)
      if (res.code === 0) {
        this.survey.title = res.data[0].surverTitle
        this.survey.descr = res.data[0].surverDescription
      }
    },
    async getSurverQuesions () {
      let surverId = this.$route.params.id
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

</style>
