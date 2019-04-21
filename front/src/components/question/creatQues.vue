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
            <el-button class="ques-button" @click="showQuestion('radio')"><i class="iconfont icon-jindutiao"></i>滑动条类型题</el-button>
            <el-button class="ques-button" @click="showQuestion('measure')"><i class="iconfont icon-star"></i>量表题</el-button>
            <el-button class="ques-button" @click="showQuestion('text')"><i class="iconfont icon-stars"></i>文本描述</el-button>
          </el-tab-pane>
          <el-tab-pane label="问卷大纲" class="tab2">
            <p class="sigelQues"><i class="iconfont icon-danxuan"></i>1.单选题</p>
            <p class="sigelQues"><i class="iconfont icon-danxuan"></i>2.单选题</p>
            <p class="sigelQues"><i class="iconfont icon-danxuan"></i>3.矩阵单选题</p>
          </el-tab-pane>
        </el-tabs>
      </el-aside>
      <el-main>
        <div class="main-container">
          <div class="survey-head">
            <p v-if="survey.surveyTitle.display"  @click="changeStatus(survey.surveyTitle)" class="survey-title">{{survey.surveyTitle.value}}</p>
            <el-input v-if="!survey.surveyTitle.display" v-model="survey.surveyTitle.value" @blur="unfocused(survey.surveyTitle,$event)"></el-input>
            <p v-if="survey.surveyDescr.display"  @click="changeStatus(survey.surveyDescr)" class="survey-descr">{{survey.surveyDescr.value}}</p>
            <el-input type="textarea" :rows="2" v-if="!survey.surveyDescr.display" v-model="survey.surveyDescr.value" @blur="unfocused(survey.surveyDescr,$event)"></el-input>
          </div>
          <div>123</div>
          <div class="survey-container" v-if="quesType==='select'">
            <select-type :selectForm='selectForm'></select-type>
          </div>
          <div class="survey-container" v-if="quesType==='matrix'">
            <matrix-type :selectForm='selectForm'></matrix-type>
          </div>
          <div class="survey-container" v-if="quesType==='measure'">
            <measure-type></measure-type>
          </div>
           <div class="survey-container" v-if="quesType==='text'">
            <text-type></text-type>
          </div>
          <!-- <measure-type></measure-type> -->
          <!-- <matrix-type></matrix-type> -->
        </div>
      </el-main>
    </el-container>
    
  </div>
  
</template>
<script>
import E from 'wangeditor'
import selectType from '../QuestionType/selectType'
import measureType from '../QuestionType/measureTyep'
import matrixType from '../QuestionType/matrixType'
import textType from '../QuestionType/textType'
export default {
  components: {
    'select-type': selectType,
    'measure-type': measureType,
    'matrix-type': matrixType,
    'text-type': textType
  },
  data () {
    return {
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
        title: '', // 题目
        subdesc: '', // 备注
        type: '', // 题目类型
        required: true, // 是否必填
        options: [
          {
            value: ''
          },
          {
            value: ''
          }
        ] // 选项
      }
    }
  },
  mounted () {
    // this.createWangeditor()
  },
  methods: {
    createWangeditor () {
      var editor = new E('#editor')
      editor.customConfig.onchange = (html) => {
        this.formArticle = html
      }
      editor.customConfig.uploadImgServer = '<%=path%>/Img/upload' // 上传URL
      editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
      editor.customConfig.uploadImgMaxLength = 5
      editor.customConfig.uploadFileName = 'myFileName'
      editor.create()
    },
    // 根据题型判断应该选择哪种类型的设计样式，并传入不同的值
    showQuestion (type) {
      this.currentType = type
      if (type === 'radioselect' || type === 'Multiselect' || type === 'Drop-down' || type === 'sort') {
        this.quesType = 'select'
        this.selectForm.options = [
          {
            value: ''
          },
          {
            value: ''
          }
        ]
      } else if (type === 'textselect') {
        this.quesType = 'select'
        this.selectForm.options = ''
      } else if (type === 'matrix-radio' || type === 'matrix-multi') {
        this.quesType = 'matrix'
        this.selectForm.questions = [
          {
            value: ''
          },
          {
            value: ''
          }
        ]
        this.selectForm.options = [
          {
            value: ''
          },
          {
            value: ''
          }
        ]
        this.selectForm.measureValue = ''
      } else if (type === 'measure') {
        this.quesType = 'measure'
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
      item.display = true
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
    padding-top: 0.2rem;
  }
  .tab2{
    color: #999999;
    text-align: left;
    font-size: 0.14rem;
    margin-left: 0.3rem;
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
      text-align: left;
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
      }
    }
    .survey-container{
      // width: 80%;
      margin: 0 auto;
      border-top: 1px solid #E0E0E0;
    }
    
}
</style>
