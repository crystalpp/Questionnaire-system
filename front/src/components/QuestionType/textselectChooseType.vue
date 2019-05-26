<template>
  <div class="textSelectType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="textSelect-title">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="textSelect-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item style="width:60%">
        <el-input type="textarea" autosize :rows="2" v-model="textAnswer" @blur='chooseAnswer'></el-input>
      </el-form-item>
    </el-form>
    <div class="optionPart" v-if="editOrPreview === 'edit'">
      <el-button-group>
        <el-button  plain icon="el-icon-edit" @click="edit"></el-button>
        <el-button  plain icon="el-icon-delete" @click="deleteQues(formData.questionId)" ></el-button>
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
      textAnswer: '',
      editOrPreview: '',
      answerData: []
    }
  },
  mounted () {
    this.editOrPreview = commonFunc.getLocalStorage('editOrPreview')
    this.initChooseOption()
  },
  methods: {
    initChooseOption () {
      if (commonFunc.isDefine(this.formData.currChoose)) {
        this.textAnswer = this.formData.currChoose[0]
      }
    },
    chooseAnswer () {
      this.answerData.questionId = this.formData.questionId
      this.answerData.answerText = this.textAnswer
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
.textSelectType{
  display: flex;
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .textSelect-descri{
    font-size: 0.12rem;
  }
  .textSelect-title{
    font-size: 0.18rem;
  }
}
</style>
