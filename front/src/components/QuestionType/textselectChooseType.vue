<template>
  <div class="textSelectType">
    <el-form :model='formData' label-width="0.1rem" label-position="left">
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
  </div>
</template>
<script>
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
  }
}
</script>
<style lang="scss" scoped>
.el-form-item{
margin-bottom: 0;
}
.textSelectType{
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .textSelect-descri{
    font-size: 0.12rem;
  }
}
</style>
