<template>
  <div class="preiewContainer">
    <div class="header">
      <div class="option">
        <div :class="PCClass" @click="pcPreview">
          <i class="iconfont icon-pc" style="font-size: 38px"></i>
          <span class="text">电脑预览</span>
        </div>
        <div :class="phoneClass" @click="phonePreview">
          <i class="iconfont icon-phone" style="font-size: 38px;"></i>
          <span class="text">手机预览</span>
        </div>
        
      </div>
      <div class="closeButon" >
         <el-button plain type="primary" size="small" @click="getPdf(survey.title)" v-if="showPdfButton">导出pdf</el-button>
         <el-button plain type="primary" size="small" @click="creatPreview">退出</el-button>
      </div>
    </div>
    <div class="pre-body">
      <pc-preview :survey='survey' v-if="pcOrPhone === 'PC'" @showPdfButtonevent = 'showPdfButtonevent'></pc-preview>
      <phone-preview :survey='survey' v-if="pcOrPhone === 'phone'" @showPdfButtonevent = 'showPdfButtonevent'></phone-preview>
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
      htmlTitle: '页面导出PDF文件名',
      survey: {
        title: '',
        descr: '',
        surverQuestions: []
      },
      phoneClass: 'phone',
      PCClass: 'PCCheck',
      pcOrPhone: 'PC',
      showPdfButton: true
    }
  },
  async mounted () {
    commonFunc.setLocalStorage('fillOrPreview', 'preview') // 判断是填写界面还是预览界面，预览界面提交无效
    commonFunc.setLocalStorage('resultOrFill', 'fill') // 判断是看结果还是填写界面看某个用户填的结果不需要提交两个字
    commonFunc.setLocalStorage('fillOrCreat', 'creat') // 控制是否是填写界面或者是创建空白问卷 前者不需要footer
    document.getElementsByTagName('html')[0].style.fontSize = '100px'
    commonFunc.setLocalStorage('editOrPreview', 'preview')
    await this.getSurvers()
    await this.getSurverQuesions()
  },
  methods: {
    showPdfButtonevent (data) {
      this.showPdfButton = data
    },
    creatPreview () {
      this.$router.go(-1)
    },
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
.preiewContainer{
  background: #EFEFEF;
  font-size: 16px;
  width: 100%;
  height: 104%;
  overflow: auto;
  .header{
    background: #FFFFFF;
    height: 80px;
    display: flex;
    align-items: center;
    justify-content: center;
    .option{
      flex: 3;
      display: flex;
      justify-content: center;
      margin-left: 280px;
      .phoneCheck {
        cursor: pointer;
        color: #479DE6;
        line-height: 80px;
        display: flex;
        margin-left: 10px;
        margin-right: 10px;
      }
      .phone{
        cursor: pointer;
        color: #000000;
        line-height: 80px;
        display: flex;
        margin-left: 10px;
        margin-right: 10px;
      }
      .PCCheck{
        cursor: pointer;
        color: #479DE6;
        line-height: 80px;
        display: flex;
        margin-left:10px;
        margin-right: 10px;
      }
      .PC{
        cursor: pointer;
        color: #000000;
        line-height: 80px;
        display: flex;
        margin-left: 10px;
        margin-right: 10px;
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
