<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <div class="container">
      <router-view/>
      <!-- <div>
        <div>123</div>
        <div>123</div>
        <div>123</div>
        <div>123</div>
        <div>123</div>
        <div>123</div>
      </div> -->
    </div>
    <div class="footer" v-if="fillOrCreat === 'creat'">
        <span>计算机学院学生问卷调查系统</span>
        <span>&nbsp &nbsp &nbsp 让调查变得更简单</span>
    </div>
  </div>
</template>

<script>
import commonFunc from './client/bll/apis/common/common'
export default {
  name: 'app',
  data () {
    return {
      fillOrCreat: 'creat'
    }
  },
  mounted () {
    // commonFunc.setLocalStorage('fillOrCreat', 'creat')
    this.fillOrCreat = commonFunc.getLocalStorage('fillOrCreat')
  }
}
</script>

<style>
*{
    margin: 0;
    padding: 0;
}
html{
  font-size: 100px;
}
body{
  font-size: 16px;
}
html, body{
    width: 100%;
    height: 100%;
}
#app {
  /* font-size: 0.12rem; */
  font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100%;
  height: 100%;
  /* overflow: auto; */
  /* margin-top: 60px; */
}
.container{
  width: 100%;
  height: 90%;
  background: #efefef;
  /* margin-bottom: 0.1rem; */
  /* overflow: auto; */
}
.footer{
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0.16rem;
  background: #F7F8F9;
  width: 100%;
  height: 10%;
  color: #888888;
  /* padding-top: 0.2rem; */
}
</style>
