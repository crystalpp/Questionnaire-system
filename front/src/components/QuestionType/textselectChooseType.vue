<template>
  <div class="textSelectType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="textSelect-descri">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="textSelect-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item>
        <el-input ></el-input>
      </el-form-item>
    </el-form>
    <div class="optionPart">
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
      // formData: {
      //   title: '问题1', // 题目
      //   subdesc: '描述', // 备注
      //   type: '', // 题目类型
      //   required: true, // 是否必填
      //   selected: '',
      //   options: [
      //     {
      //       value: '选项一'
      //     },
      //     {
      //       value: '选项二'
      //     }
      //   ] // 选项
      // }
    }
  },
  methods: {
    edit () {
      this.formData.display = true
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
}
</style>
