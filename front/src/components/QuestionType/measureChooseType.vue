<template>
  <div class="measurechooseType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="measure-descri" style="font-size:0.18rem">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="measure-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item>
        <el-rate v-model="score" :colors="['#99A9BF', '#F7BA2A', '#FF9900']"  @change="chooseAnswer"> </el-rate>
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
      score: 0,
      showText: [],
      editOrPreview: '',
      answerData: {
        questionId: '',
        answerText: ''
      }
    }
  },
  mounted () {
    // this.changeText()
    this.editOrPreview = commonFunc.getLocalStorage('editOrPreview')
    this.initChooseOption()
  },
  methods: {
    initChooseOption () {
      if (commonFunc.isDefine(this.formData.currChoose)) {
        this.score = parseInt(this.formData.currChoose[0])
      }
    },
    chooseAnswer (item) {
      this.answerData.questionId = this.formData.questionId
      this.answerData.answerText = item
      this.$emit('getAnswerData', this.answerData)
    },
    edit () {
      this.formData.display = true
      let quesType = 'measure'
      this.formData.optionMethod = 'edit'
      this.formData.quesType = quesType
      this.$emit('editSelectForm', this.formData)
    },
    // 根据选择不同的量表类型，评分时显示不同的文字
    // changeText () {
    //   if (this.formData.options.length > 0) {
    //     let value1 = '非常不' + this.formData.options[0].optionContent
    //     let value2 = '不' + this.formData.options[0].optionContent
    //     let value3 = '一般'
    //     let value4 = this.formData.options[0].optionContent
    //     let value5 = '非常' + this.formData.options[0].optionContent
    //     this.showText = [value1, value2, value3, value4, value5]
    //   }
    // },
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
.measurechooseType{
  display: flex;
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .measure-descri{
    font-size: 0.12rem;
  }
}
</style>
