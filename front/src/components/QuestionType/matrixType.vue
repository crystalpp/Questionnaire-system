<template>
<!-- 用于量表题的设计-->
  <div class="matrixType">
    <el-form :model='selectForm' label-width="0.8rem"  :rules="rules" ref="selectForm">
      <el-form-item label="题目" prop="title">
        <el-input v-model="selectForm.title"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="selectForm.subdesc"></el-input>
      </el-form-item>
      <el-form-item label="必填">
          <el-switch v-model="selectForm.required"></el-switch>
      </el-form-item>
      <!-- 问题 -->
      <el-form-item :rules="{
          required: true, message: '问题不能为空', trigger: 'blur'
        }"
          v-for="(question, index) in selectForm.questions"
          :label="'问题' + (index+1)"
          :key="question.key"
          :prop="'questions.' + index + '.questionName'"
        >
        <el-input v-model="question.questionName"></el-input><i @click.prevent="removeQuestion(question)" class="el-icon-close deleteicon"></i>
       </el-form-item>
       <el-form-item>
          <el-button type="primary" plain @click="addQuestion" v-if="selectForm.questions.length>0">新增问题</el-button>
      </el-form-item>
      <!-- 选项 -->
       <el-form-item :rules="{
          required: true, message: '选项不能为空', trigger: 'blur'
        }"
          v-for="(option, index) in selectForm.options"
          :label="'选项' + (index+1)"
          :key="option.key"
          :prop="'options.' + index + '.optionContent'"
        >
        <el-input v-model="option.optionContent"></el-input><i @click.prevent="removeOption(option)" class="el-icon-close deleteicon"></i>
       </el-form-item>
       <el-form-item>
          <el-button type="primary" plain @click="addOption" v-if="selectForm.options.length>0">新增选项</el-button>
      </el-form-item>
      <el-form-item>
        <div class="line"></div>
      </el-form-item>
      <el-form-item style="text-align:right">
        <el-button plain @click="cancelSubmit()">取消</el-button>
        <el-button type="primary" @click="confirm('selectForm')">确定</el-button>
      </el-form-item>
    </el-form>
    
  </div>
</template>
<script>
import commonFunc from '../../client/bll/apis/common/common'
import questionApi from '../../client/bll/apis/question.js'
export default {
  props: ['selectForm'],
  data () {
    return {
      rules: {
        title: [
          { required: true, message: '请输入题目', trigger: 'blur' }
        ]
      }
    }
  },
  mounted () {
  },
  methods: {
    async editQuestion () {
      let res = await questionApi.updateByQuestionId(this.selectForm)
      if (res.code === 0) {
        commonFunc.showMessage('修改成功', 'success')
      } else {
        commonFunc.showMessage('修改失败，请稍后再试', 'error')
      }
    },
    async addQuestionRequest () {
      let newOptionsArr = []
      for (let i of this.selectForm.options) {
        newOptionsArr.push(i.optionContent)
      }
      this.selectForm.optionsValue = newOptionsArr
      let newQuestionsArr = []
      for (let j of this.selectForm.questions) {
        newQuestionsArr.push(j.questionName)
      }
      this.selectForm.questionsValue = newQuestionsArr
      this.selectForm.surverId = this.$route.query.surverId
      let res = await questionApi.add(this.selectForm)
      if (res.code === 0) {
        commonFunc.showMessage('新增成功', 'success')
      } else {
        commonFunc.showMessage('新增失败，请稍后再试', 'error')
      }
    },
    confirm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          if (this.selectForm.optionMethod === 'edit') {
            await this.editQuestion()
          } else {
            await this.addQuestionRequest()
          }
          this.selectForm.display = false
          this.$emit('getSelectForm', this.selectForm)
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    // 取消按钮
    cancelSubmit () {
      this.selectForm.display = false
      this.$emit('getSelectForm', this.selectForm)
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
        key: Date.now(),
        checked: false
      })
    },
    removeQuestion (item) {
      var index = this.selectForm.questions.indexOf(item)
      if (index !== -1) {
        this.selectForm.questions.splice(index, 1)
      }
    },
    addQuestion () {
      this.selectForm.questions.push({
        value: '',
        key: Date.now()
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.matrixType{
  display: flex;
  width: 60%;
  margin: 0 auto;
  margin-top: 0.1rem;
  .line{
    border: 1px solid #E0E0E0;
  }
   .deleteicon{
    float: right;
    margin-right: -0.2rem;
    margin-top: 0.1rem;
  }
}
</style>