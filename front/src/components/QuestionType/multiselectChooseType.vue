<template>
  <div class="multiselectType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" :required="required">
        <p class="multi-descri" style="font-size:0.18rem">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="multi-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item >
        <el-checkbox-group v-model="checkList" v-for="(item) in formData.options" :key="item.key" @change="chooseAnswer()">
          <el-checkbox :label="item.optionId" >{{item.optionContent}}</el-checkbox>
        </el-checkbox-group>
      </el-form-item>
    </el-form>
    <div class="optionPart" v-if="editOrPreview === 'edit'">
      <el-button-group>
        <el-button  plain icon="el-icon-edit" @click="edit"></el-button>
        <el-button  plain icon="el-icon-delete" @click="deleteQues(formData.questionId)"></el-button>
      </el-button-group>
    </div>
  </div>
</template>
<script>
import questionApi from '../../client/bll/apis/question'
import commonFunc from '../../client/bll/apis/common/common'
export default {
  props: ['formData', 'index'],
  data () {
    return {
      editOrPreview: '',
      answerData: {
        questionId: '',
        optionId: ''
      },
      checkList: [],
      required: false
    }
  },
  mounted () {
    this.required = (this.formData.required === 'true')
    this.editOrPreview = commonFunc.getLocalStorage('editOrPreview')
    this.initChooseOption()
  },
  methods: {
    initChooseOption () {
      if (commonFunc.isDefine(this.formData.currChoose)) {
        this.checkList = this.formData.currChoose
      }
    },
    chooseAnswer () {
      // var answers = {}
      this.answerData.optionId = ''
      this.answerData.questionId = this.formData.questionId
      for (let item of this.checkList) {
        this.answerData.optionId += item
        this.answerData.optionId += ','
      }
      // answers.push(this.answerData)
      this.$emit('getAnswerData', this.answerData)
    },
    edit () {
      this.formData.display = true
      let quesType = 'select'
      this.formData.optionMethod = 'edit'
      this.formData.quesType = quesType
      this.$emit('editSelectForm', this.formData)
    },
    async deleteQues (id) {
      let res = await questionApi.deleteByQuestionId(id)
      if (res.code === 0) {
        commonFunc.showMessage('删除成功', 'success')
      }
    }
  }
}
</script>
<style lang="scss" scoped>
.el-form-item{
margin-bottom: 0;
}
.selectPart{
  flex: 15;
}
.optionPart{
  flex: 2;
}
.multiselectType{
  display: flex;
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .multi-descri{
    font-size: 0.12rem;
  }
}
</style>
