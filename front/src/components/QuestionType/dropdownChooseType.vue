<template>
  <div class="dropDownType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" :required=required>
        <p class="dropdown-descri" style="font-size:0.18rem">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="dropdown-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item >
         <el-select v-model="chooseValue" placeholder="请选择" @change="chooseAnswer" >
          <el-option
            v-for="item in formData.options"
            :key="item.optionId"
            :label="item.optionContent"
            :value="item.optionId">
          </el-option>
        </el-select>
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
      chooseValue: '',
      flag: true,
      required: true
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
        this.chooseValue = this.formData.currChoose[0]
        this.flag = false
      }
    },
    chooseAnswer (item) {
      let answerData = {
        questionId: '',
        optionId: ''
      }
      answerData.questionId = this.formData.questionId
      answerData.optionId = item
      this.$emit('getAnswerData', answerData)
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
.dropDownType{
  display: flex;
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .radio-descri{
    font-size: 0.12rem;
  }
}
</style>
