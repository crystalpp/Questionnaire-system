<template>
  <div class="dropDownType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="dropdown-descri">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="dropdown-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item>
         <el-select v-model="formData.dropdownValue" placeholder="请选择">
          <el-option
            v-for="item in formData.options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
         </el-select>
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
