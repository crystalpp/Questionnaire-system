<template>
  <div class="measurechooseType">
    <el-form :model='formData' label-width="0.1rem" label-position="left">
      <el-form-item   :label="' '" required:true>
        <p class="measure-descri">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="measure-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item>
        <el-rate v-model="score" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" show-text :texts="showText"> </el-rate>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  props: ['formData', 'index'],
  data () {
    return {
      score: '',
      showText: []
    }
  },
  mounted () {
    this.changeText()
  },
  methods: {
    // 根据选择不同的量表类型，评分时显示不同的文字
    changeText () {
      let value1 = '非常不' + this.formData.measureValue
      let value2 = '不' + this.formData.measureValue
      let value3 = '一般'
      let value4 = this.formData.measureValue
      let value5 = '非常' + this.formData.measureValue
      this.showText = [value1, value2, value3, value4, value5]
    }
  }
}
</script>
<style lang="scss" scoped>
.el-form-item{
margin-bottom: 0;
}
.measurechooseType{
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .measure-descri{
    font-size: 0.12rem;
  }
}
</style>
