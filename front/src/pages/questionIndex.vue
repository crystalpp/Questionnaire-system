<template>
  <div class="quesion-container">
    <div class="ques-header">
      <div class="ques-header-select">
        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          background-color="#0078C8"
          text-color="#EFFFFF"
          active-text-color="#FFF799">
          <el-submenu index="1">
            <template slot="title">创建问卷</template>
            <el-menu-item index="creat">创建空白问卷</el-menu-item>
            <el-menu-item index="1-2">选择现有模板</el-menu-item>
            <el-menu-item index="1-3">文本编辑问卷</el-menu-item>
          </el-submenu>
          <el-menu-item index="show">我的问卷</el-menu-item>
          <el-menu-item index="3">问卷统计</el-menu-item>
        </el-menu>
      </div>
      <div class="ques-header-user">
        <i class="iconfont icon-xxhdpiShape item1"></i> 
        <p class="item2">遇见</p>
        <i class="iconfont icon-exit item3"></i> 
        <p class="item4">退出</p>
      </div>
    </div>
    <div class="ques-content">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      activeIndex: '1'
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
// .usericon {
//   font-size: 0.16rem;
// }
.el-menu.el-menu--horizontal {
  border: 0;
}
.quesion-container{

  font-size: 0.16rem;
  width: 100%;
  height: 100%;
  .ques-header {
    background: #0078C8;
    width: 100%;
    margin: 0 auto;
    border-bottom: 1px solid #0078C8;
    display: flex;
    // justify-content: center;
    align-items: center;
    height: 0.65rem;
    .ques-header-select{
      width: 100%;
      margin: 0 auto;
      margin-left: 1rem;
    }
    .ques-header-user{
        color: #efffff;
      display: flex;
      width: 20%;
      .item1{
        margin-right: 0.1rem;
        margin-top: 0.04rem;
      }
      .item2{
        margin-right: 0.3rem;
      }
      .item3{
        margin-top: 0.04rem;
        margin-right: 0.1rem;
      }

    }
  }
  .ques-content {
    width: 100%;
    height: 90%;
    background: #F0F0F0;
  }
}
</style>
