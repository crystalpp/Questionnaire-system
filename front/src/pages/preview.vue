<template>
  <div class="preiewContainer">
    <div class="header">
      <div class="option">
        <div :class="phoneClass" @click="phonePreview">
          <i class="iconfont icon-phone" style="font-size: 0.38rem;"></i>
          <span class="text">手机预览</span>
        </div>
        <div :class="PCClass" @click="pcPreview">
          <i class="iconfont icon-pc" style="font-size: 0.38rem;"></i>
          <span class="text">电脑预览</span>
        </div>
      </div>
      <div class="closeButon">
         <el-button plain type="primary" size="small">退出</el-button>
      </div>
    </div>
    <div class="pre-body">
      <pc-preview :survey='survey' v-if="pcOrPhone === 'PC'"></pc-preview>
      <phone-preview v-if="pcOrPhone === 'phone'"></phone-preview>
      <!-- 设计好的问卷显示的div -->
      
    </div>
  </div>
</template>
<script>
import phonePreview from '../components/preview/phonePreview'
import pcPreview from '../components/preview/pcPreview'
import surverApi from '../client/bll/apis/surver'
import questionApi from '../client/bll/apis/question'
import commonFunc from '../client/bll/apis/common/common'
export default {
  components: {
    'pc-preview': pcPreview,
    'phone-preview': phonePreview
  },
  data () {
    return {
      survey: {
        title: '',
        descr: '',
        surverQuestions: []
      },
      phoneClass: 'phoneCheck',
      PCClass: 'PC',
      pcOrPhone: 'phone'
    }
  },
  async mounted () {
    commonFunc.setLocalStorage('editOrPreview', 'preview')
    await this.getSurvers()
    await this.getSurverQuesions()
  },
  methods: {
    pcPreview () {
      this.phoneClass = 'phone'
      this.PCClass = 'PCCheck'
      this.pcOrPhone = 'PC'
    },
    phonePreview () {
      this.phoneClass = 'phoneCheck'
      this.PCClass = 'PC'
      this.pcOrPhone = 'phone'
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
.preiewContainer{
  font-size: 0.16rem;
  width: 100%;
  height: 104%;
  overflow: auto;
  .header{
    background: #FFFFFF;
    height: 0.8rem;
    display: flex;
    align-items: center;
    justify-content: center;
    .option{
      flex: 3;
      display: flex;
      justify-content: center;
      margin-left: 2.8rem;
      .phoneCheck {
        cursor: pointer;
        color: #479DE6;
        line-height: 0.8rem;
        display: flex;
        margin-left: 0.1rem;
        margin-right: 0.1rem;
      }
      .phone{
        cursor: pointer;
        color: #000000;
        line-height: 0.8rem;
        display: flex;
        margin-left: 0.1rem;
        margin-right: 0.1rem;
      }
      .PCCheck{
        cursor: pointer;
        color: #479DE6;
        line-height: 0.8rem;
        display: flex;
        margin-left: 0.1rem;
        margin-right: 0.1rem;
      }
      .PC{
        cursor: pointer;
        color: #000000;
        line-height: 0.8rem;
        display: flex;
        margin-left: 0.1rem;
        margin-right: 0.1rem;
      }
    }
    .closeButon{
    //  float: right;
      flex: 1;
    }
  }
  .pre-body{
    background: #EFEFEF;
  }
}
</style>
