<template>
  <div class="blankques-container">
     <!-- <div id="editor" class="editor"></div> -->
     <!-- <button class="btn btn-royal" @click="postfillContent()">保存</button>
    <span v-if="display" @click="changeNo(display)">{{data}} </span>
    <el-input v-if="!display" v-model="data" @blur="unfocused(data,$event)"></el-input> -->
    <el-container>
      <el-aside width="2.2rem">
        <el-tabs type="border-card">
          <el-tab-pane label="题型列表">
            <el-button class="ques-button" @click="showQuestion('radioselect')"><i class="iconfont icon-danxuan"></i>单选题</el-button>
            <el-button class="ques-button" @click="showQuestion('Multiselect')"><i class="iconfont icon-duoxuanyixuan"></i>多选题</el-button>
            <el-button class="ques-button" @click="showQuestion('Drop-down')"><i class="iconfont icon-xialakuang"></i>下拉框</el-button>
            <el-button class="ques-button" @click="showQuestion('textselect')"><i class="iconfont icon-wenben"></i>文本题</el-button>
            <el-button class="ques-button" @click="showQuestion('sort')"><i class="iconfont icon-paixu"></i>排序题</el-button>
            <el-button class="ques-button" @click="showQuestion('matrix-radio')"><i class="iconfont icon-square-inc"></i>矩阵单选题</el-button>
            <el-button class="ques-button" @click="showQuestion('matrix-multi')"><i class="iconfont icon-danxuan"></i>矩阵多选题</el-button>
            <!-- <el-button class="ques-button" @click="showQuestion('radio')"><i class="iconfont icon-jindutiao"></i>滑动条类型题</el-button> -->
            <el-button class="ques-button" @click="showQuestion('measure')"><i class="iconfont icon-star"></i>量表题</el-button>
            <el-button class="ques-button" @click="showQuestion('text')"><i class="iconfont icon-stars"></i>文本描述</el-button>
          </el-tab-pane>
          <el-tab-pane label="问卷大纲" class="tab2">
            <p class="sigelQues" v-for="(item,index) in surverQuestionsData" :key="item.keys">
              {{index+1}}.
              <i  v-if="item.type === 'radioselect'">(单选)</i>
              <i  v-if="item.type === 'Multiselect'">(多选)</i>
              <i  v-if="item.type === 'Drop-down'">(下拉题)</i>
              <i  v-if="item.type === 'textselect'">(文本题)</i>
              <i  v-if="item.type === 'sort'">(排序题)</i>
              <i  v-if="item.type === 'matrix-radio'">(矩阵单选)</i>
              <i  v-if="item.type === 'matrix-multi'">(矩阵多选)</i>
              <i  v-if="item.type === 'measure'">(量表题)</i>
              <i  v-if="item.type === 'text'">(文字)</i>
            {{item.title}} </p>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
      <el-main>
        <div class="main-container">
          <div class="survey-head">
            <p v-if="survey.surveyTitle.display"  @click="changeStatus(survey.surveyTitle)" class="survey-title">{{survey.surveyTitle.value}}</p>
            <el-input v-if="!survey.surveyTitle.display" v-model="survey.surveyTitle.value" @blur="unfocused(survey.surveyTitle,$event)"></el-input>
            <p v-if="survey.surveyDescr.display"  @click="changeStatus(survey.surveyDescr)" class="survey-descr">{{survey.surveyDescr.value}}</p>
            <el-input type="textarea" autosize :rows="2" v-if="!survey.surveyDescr.display" v-model="survey.surveyDescr.value" @blur="unfocused(survey.surveyDescr,$event)"></el-input>
          </div>
          <!-- 设计好的问卷显示的div -->
           <div  class="survey-container"  v-for="(item,index) in surverQuestionsData" :key="item.key" >
            <div v-if="item.type === 'radioselect'">
              <radio-choose-type :formData = 'item' :index = 'index' @editSelectForm = 'editSelectForm' ></radio-choose-type>
            </div>
            <div v-if="item.type === 'Multiselect'">
              <multiselect-choose-type :formData = 'item' :index = 'index' @editSelectForm = 'editSelectForm'></multiselect-choose-type>
            </div>
            <div v-if="item.type === 'Drop-down'">
              <dropdown-choose-type :formData = 'item' :index = 'index' @editSelectForm = 'editSelectForm'></dropdown-choose-type>
            </div>
            <div v-if="item.type === 'textselect'"> 
              <textselect-choose-type :formData = 'item' :index = 'index' @editSelectForm = 'editSelectForm'></textselect-choose-type>
            </div>
            <div v-if="item.type === 'measure'">
              <measure-choose-type :formData = 'item' :index = 'index' @editSelectForm = 'editSelectForm'></measure-choose-type>
            </div>
            <div v-if="item.type === 'matrix-radio' || item.type === 'matrix-multi'">
              <matrix-choose-type :formData = 'item' :index = 'index' @editSelectForm = 'editSelectForm'></matrix-choose-type>
            </div>
          </div>
          <!-- 问卷设计的div -->
          <div v-if="selectForm.display"  class="survey-container">
            <div  v-if="quesType==='select'">
              <select-type :selectFormdata='selectForm' @getSelectForm = 'getSelectForm'></select-type>
            </div>
            <div  v-if="quesType==='matrix'">
              <matrix-type :selectForm='selectForm' @getSelectForm = 'getSelectForm'></matrix-type>
            </div>
            <div  v-if="quesType==='measure'">
              <measure-type :selectForm='selectForm' @getmeasureSelectform = 'getSelectForm'></measure-type>
            </div>
            <div  v-if="quesType==='text'">
              <text-type></text-type>
            </div>
          </div>
         
          <!-- <measure-type></measure-type> -->
          <!-- <matrix-type></matrix-type> -->
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
// import E from 'wangeditor'
import selectType from '../QuestionType/selectType'
import measureType from '../QuestionType/measureType'
import matrixType from '../QuestionType/matrixType'
import textType from '../QuestionType/textType'
import radioType from '../QuestionType/radioChooseType'
import multiselect from '../QuestionType/multiselectChooseType'
import dropdownType from '../QuestionType/dropdownChooseType'
import textselectType from '../QuestionType/textselectChooseType'
import measureChooseType from '../QuestionType/measureChooseType'
import matrixChooseType from '../QuestionType/matrixChooseType'
import surverApi from '../../client/bll/apis/surver'
import questionApi from '../../client/bll/apis/question'
import commonFunc from '../../client/bll/apis/common/common'
// import questionApi from '../../client/bll/apis/question'
export default {
  components: {
    'select-type': selectType,
    'measure-type': measureType,
    'matrix-type': matrixType,
    'text-type': textType,
    'radio-choose-type': radioType,
    'multiselect-choose-type': multiselect,
    'dropdown-choose-type': dropdownType,
    'textselect-choose-type': textselectType,
    'measure-choose-type': measureChooseType,
    'matrix-choose-type': matrixChooseType
  },
  data () {
    return {
      step: 2, // 当前的状态
      quesType: '', // 按照四个大类分的问题的题型
      currentType: '', // 当前选择的题型
      text: '', // 纯文本的文字
      editor: null,
      survey: {
        surveyTitle: {
          value: '问卷标题',
          display: true
        },
        surveyDescr: {
          value: '感谢您能抽出几分钟时间来参加本次答题，现在我们就马上开始吧！',
          display: true
        },
        questions: []
      },
      selectForm: {
        option: '', // 操作方式，增加或者修改
        display: false,
        title: '', // 题目
        subdesc: '', // 备注
        type: '', // 题目类型
        required: true, // 是否必填
        options: [
          {
            optionContent: ''
          },
          {
            optionContent: ''
          }
        ], // 选项
        questions: [
          {
            questionName: ''
            // checked: false
          },
          {
            questionName: ''
            // checked: false
          }
        ],
        dropdownValue: ''
      },
      surverQuestionsData: []
    }
  },
  watch: {
    'selectForm': {
      handler (val, oldVal) {
        // console.log('b.value: ' + val.value, oldVal.value)
      },
      deep: true
    }
  },
  async mounted () {
    commonFunc.setLocalStorage('editOrPreview', 'edit')
    await this.getSurverQuesions()
    await this.getSurvers()
  },
  methods: {
    async getSurvers () {
      let surverId = this.$route.query.surverId
      let res = await surverApi.search(surverId)
      if (res.code === 0) {
        this.survey.surveyTitle.value = res.data[0].surverTitle
        this.survey.surveyDescr.value = res.data[0].surverDescription
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
        this.surverQuestionsData.push(oneitem)
      }
    },
    handleSelect (key) {
      this.$router.push({name: key})
    },
    editSelectForm (data) {
      this.selectForm = JSON.parse(JSON.stringify(data))
      if (this.selectForm.required === 'true') {
        this.selectForm.required = true
      } else {
        this.selectForm.required = false
      }
      this.quesType = data.quesType
    },
    getSelectForm (data) {
      this.selectForm = JSON.parse(JSON.stringify(data))
      // this.survey.questions.push(JSON.parse(JSON.stringify(data)))
    },
    // createWangeditor () {
    //   var editor = new E('#editor')
    //   editor.customConfig.onchange = (html) => {
    //     this.formArticle = html
    //   }
    //   editor.customConfig.uploadImgServer = '<%=path%>/Img/upload' // 上传URL
    //   editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
    //   editor.customConfig.uploadImgMaxLength = 5
    //   editor.customConfig.uploadFileName = 'myFileName'
    //   editor.create()
    // },
    // 根据题型判断应该选择哪种类型的设计样式，并传入不同的值
    showQuestion (type) {
      this.selectForm.display = true
      this.selectForm.type = type
      this.selectForm.title = ''
      this.selectForm.subdesc = ''
      if (type === 'radioselect' || type === 'Multiselect' || type === 'Drop-down' || type === 'sort') {
        this.quesType = 'select'
        this.selectForm.options = [
          {
            optionContent: ''
          },
          {
            optionContent: ''
          }
        ]
      } else if (type === 'textselect') {
        this.quesType = 'select'
        this.selectForm.options = ''
      } else if (type === 'matrix-radio' || type === 'matrix-multi') {
        this.quesType = 'matrix'
        this.selectForm.questions = [
          {
            questionName: ''
          },
          {
            questionName: ''
          }
        ]
        this.selectForm.options = [
          {
            optionContent: '',
            checked: false
          },
          {
            optionContent: '',
            checked: false
          }
        ]
        this.selectForm.measureValue = ''
      } else if (type === 'measure') {
        this.quesType = 'measure'
        this.selectForm.options = [
          {
            value: '满意',
            label: '满意度'
          },
          {
            value: '认同',
            label: '认同度'
          },
          {
            value: '重要',
            label: '重要度'
          },
          {
            value: '符合',
            label: '符合度'
          }
        ]
      } else if (type === 'text') {
        this.quesType = 'text'
      }
    },
    // 改变问卷标题和问卷标题下面问候语的编辑和显示状态
    changeStatus (item) {
      item.display = false
    },
    // 改变问卷标题和问卷标题下面问候语的编辑和显示状态
    unfocused (item, e) {
      let surverId = this.$route.query.surverId
      item.display = true
      let params = {
        title: this.survey.surveyTitle.value,
        description: this.survey.surveyDescr.value,
        id: surverId
      }
      let res = surverApi.update(params)
      if (res.code === 0) {
        console.log(1)
      }
    },
    removeOption (item) {
      var index = this.selectForm.options.indexOf(item)
      if (index !== -1) {
        this.selectForm.options.splice(index, 1)
      }
    },
    addOption () {
      this.selectForm.options.push({
        value: '',
        key: Date.now()
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.el-steps--simple{
  background-color: #ffffff;
}
.ques-button {
  width: 1.5rem;
  height: 0.4rem;
  margin: 0 auto;
  margin-top: 0.1rem;
  text-align: left;
  // line-height: 0.05rem;
}
.blankques-container {
  width:100%;
  height: 100%;
  font-size: 0.14rem;
  
}
.el-main {
    background-color: #E9EEF3;
    color: #333;
    // text-align: center;
    // line-height: 160px;
    height: 100%;
  }
.el-aside {
    background-color: #FAFAFA;
    color: #333;
    text-align: left;
    height: 100%;
    // line-height: 200px;
  }
  .el-container {
    width: 100%;
    height: 100%;
    // padding-top: 0.63rem;
  }
  .tab2{
    color: #999999;
    text-align: left;
    font-size: 0.14rem;
    margin-left: 0.05rem;
    .sigelQues{
      margin-top: 0.2rem;
    }
  }
.main-container {
    text-align: left;
    background-color: #FAFAFA;
    width: 95%;
    margin: 0 auto;
    border: 1px solid #DADADA;
    .survey-head{
      width: 80%;
      margin: 0 auto;
      text-align: center;
      margin-top: 0.2rem;
      margin-bottom: 0.2rem;
      .survey-title{
        font-size: 0.24rem;
        // text-align: center;
      }
    .survey-descr{
        font-size: 0.16rem;
        // text-align: center;
        margin-top: 0.2rem;
        word-break: break-word;
        text-align: left;
      }
    }
    .survey-container{
      width: 100%;
      margin: 0 auto;
      border-top: 1px solid #E0E0E0;
    }
    
}
</style>
