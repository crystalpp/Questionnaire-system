<template>
  <div class="radioType" >
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="radio-descri">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="radio-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item v-for="(item) in formData.options" :key="item.key">
        <el-radio :label="item.value" v-model="formData.selected"></el-radio>
      </el-form-item>
    </el-form>
    <div class="optionPart">
      <el-button-group>
        <el-button  plain icon="el-icon-edit" @click="edit"></el-button>
        <el-button  plain icon="el-icon-delete"></el-button>
      </el-button-group>
    </div>
  </div>
</template>
<script>
export default {
  props: ['formData', 'index'],
  data () {
    return {
    }
  },
  methods: {
    edit () {
      this.formData.display = true
      this.$emit('editSelectForm', this.formData)
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
