<template>
  <div class="radioType" >
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="radio-descri" style="font-size:0.18rem">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="radio-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item v-for="(item) in formData.options" :key="item.key">
        <el-radio :label="item.optionContent" v-model="formData.selected" @change="chooseAnswer(item)"></el-radio>
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
      }
    }
  },
  mounted () {
    this.editOrPreview = commonFunc.getLocalStorage('editOrPreview')
  },
  methods: {
    chooseAnswer (item) {
      this.answerData.questionId = this.formData.questionId
      this.answerData.optionId = item.optionId
      this.$emit('getAnswerData', this.answerData)
    },
    async edit () {
      this.formData.display = true
      // this.formData.quesType = 'select'
      let quesType = 'select'
      this.formData.optionMethod = 'edit'
      this.formData.quesType = quesType
      // this.$emit('editQuesType', quesType)
      this.$emit('editSelectForm', this.formData)
      // let res = await questionApi.updateByQuestionId(this.formData)
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
.radioType{
  display: flex;
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .formPart {
    flex: 4;
  }
  .iconPart {
    flex: 1;
    font-size: 0.2rem;
  }
  .radio-descri{
    font-size: 0.12rem;
  }
}
</style>
