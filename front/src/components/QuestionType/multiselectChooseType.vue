<template>
  <div class="multiselectType">
    <el-form :model='formData' label-width="0.1rem" label-position="left">
      <el-form-item   :label="' '" required:true>
        <p class="multi-descri">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="multi-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item v-for="(item) in formData.options"  v-model="formData.selected" :key="item.key">
        <el-checkbox :label="item.value"></el-checkbox>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  props: ['formData', 'index'],
  data () {
    return {
    }
  }
}
</script>
<style lang="scss" scoped>
.el-form-item{
margin-bottom: 0;
}
.multiselectType{
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .multi-descri{
    font-size: 0.12rem;
  }
}
</style>
