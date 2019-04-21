<template>
<!-- 用于纯文本的设计，比如结束语之类的-->
  <div class="textType">
    <el-form :model='selectForm' label-width="0.8rem" class="demo-dynamic">
      <el-form-item >
        <el-input v-model="value"></el-input>
      </el-form-item>
       <!-- <el-form-item>
        <div class="line"></div>
      </el-form-item> -->
      <el-form-item style="text-align:right">
        <el-button plain>取消</el-button>
        <el-button type="primary">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  props: ['value'],
  data () {
    return {
    }
  },
  methods: {
  }
}
</script>
<style lang="scss" scoped>
.textType{
  width: 60%;
  margin: 0 auto;
  margin-top: 0.1rem;
  .line{
    border: 1px solid #E0E0E0;
  }
}
</style>
