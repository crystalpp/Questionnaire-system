<template>
  <div class="statisQues">
    <el-container>
      <el-aside width="1.5rem">
        <el-menu
          @select="handleSelect"
          default-active="source"
          class="el-menu-vertical-demo">
          <el-menu-item index="source" class="aside-item">
            <i class="el-icon-service"></i>
            <span slot="title">来源概览</span>
          </el-menu-item>
          <el-menu-item index="chart" class="aside-item">
            <i class="el-icon-picture"></i>
            <span slot="title">统计图表</span>
          </el-menu-item>
          <el-menu-item index="answerDetail" class="aside-item">
            <i class="el-icon-document"></i>
            <span slot="title">答卷详情</span>
          </el-menu-item>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </div>
</template>
<script>
export default {
  data () {
    return {
    }
  },
  methods: {
    handleSelect (key) {
      this.$router.push({name: key})
    }
  }
}
</script>
<style lang="scss" scoped>
.el-main {
    background-color: #E9EEF3;
    color: #333;
    // text-align: center;
    // line-height: 160px;
    height: 100%;
  }
.el-aside {
    background-color: #FAFAFA;
    color: #333;
    text-align: left;
    height: 100%;
    border-top: 1px solid #DCDFE6;
    // line-height: 200px;
  }
  .el-container {
    width: 100%;
    height: 100%;
    // padding-top: 0.63rem;
  }
.statisQues {
  width:100%;
  height: 100%;
  .aside-item{
    margin-top: 0.4rem;
    margin-bottom: 0.4rem
  }
  // padding-top: 0.63rem;
}
</style>
