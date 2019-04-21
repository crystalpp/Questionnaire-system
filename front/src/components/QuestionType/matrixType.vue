<template>
<!-- 用于量表题的设计-->
  <div class="matrixType">
    <el-form :model='selectForm' label-width="0.8rem" class="demo-dynamic">
      <el-form-item label="题目">
        <el-input v-model="selectForm.title"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="selectForm.subdesc"></el-input>
      </el-form-item>
      <el-form-item label="必填">
          <el-switch v-model="selectForm.required"></el-switch>
      </el-form-item>
     <el-form-item 
        v-for="(question, index) in selectForm.questions"
        :label="'问题' + (index+1)"
        :key="question.key"
        :prop="'questions.' + index + '.value'">
        <el-input v-model="question.value"></el-input><i @click.prevent="removeQuestion(question)" class="el-icon-close deleteicon"></i>
      </el-form-item>
      <el-form-item>
          <el-button type="primary" plain @click="addQuestion" v-if="selectForm.questions.length>0">新增问题</el-button>
      </el-form-item>
      <el-form-item 
        v-for="(option, index) in selectForm.options"
        :label="'选项' + (index+1)"
        :key="option.key"
        :prop="'options.' + index + '.value'">
        <el-input v-model="option.value"></el-input><i @click.prevent="removeOption(option)" class="el-icon-close deleteicon"></i>
      </el-form-item>
      <el-form-item>
          <el-button type="primary" plain @click="addOption" v-if="selectForm.options.length>0">新增选项</el-button>
      </el-form-item>
      <el-form-item>
        <div class="line"></div>
      </el-form-item>
      <el-form-item style="text-align:right">
        <el-button plain>取消</el-button>
        <el-button type="primary">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  props: ['selectForm'],
  data () {
    return {
    }
  },
  methods: {
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