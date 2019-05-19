<template>
  <div class="index-content">
    <!-- <img src="../assets/img/index.png" alt="" style="width:100%"> -->
      <div class="header">
        <!-- 下面三个为学院的介绍 -->
          <div> <a href="http://cs.cqut.edu.cn/xygk/xyjj.htm" target="_blank" class="aStyle">学院简介</a> </div>
          <div><a href="https://github.com/crystalpp" target="_blank" class="aStyle">反馈意见</a></div>
          <div><a href="https://crystalpp.github.io/" target="_blank" class="aStyle">关于我</a> </div>
      </div>
      <div class="main-container">
          <div class="title">{{title}}</div>
          <div class="text">本系统旨在为同学和老师提供更加便捷的统计方式，为学院制定个性化的教学目标以及人才培养方案提供数据支撑。本系统可以快速的创建问卷并且发布，实时的分析图表，带给用户更好的使用体验</div>
          <el-button type="primary" class="buttion" round @click="goToLogin">创建问卷</el-button>
      </div>
  </div>
</template>
<script>
import commonFunc from '../client/bll/apis/common/common'
export default {
  name: 'index',
  data () {
    return {
      title: '计算机学院学生问卷调查系统'
    }
  },
  mounted () {
    commonFunc.setLocalStorage('fillOrCreat', 'creat')
  },
  methods: {
    goToLogin () {
      this.$router.push({name: 'login'})
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style lang="scss" scoped>
.aStyle{
  text-decoration: none;
  color: #6D6F85;
}
.index-content{
    font-size: 0.18rem;
    color: #6D6F85;
    background: url('../assets/img/index.png') no-repeat;
    background-size: cover;
    width: 100%;
    height: 100%;
    .header{
        padding-top: 1.15rem;
        padding-left: 2.6rem;
        // position: absolute;
        // top: 1.2rem;
        // left: 2.3rem;
        display: flex;
        div{
            width:1rem;
        }
    }
    .main-container{
        text-align: left;
        // position: absolute;
        // top: 3rem;
        // left: 1rem;
        padding-top: 1.3rem;
        padding-left: 1rem;
        .title{
            text-align: left;
            color: #494E6B;
            font-size: 0.3rem;
            font-weight: 550;
            width: 2.2rem;
        }
        .text{
            font-size: 0.14rem;
            margin-top: 0.2rem;
            text-align: left;
            width: 4rem;
        }
        .buttion {
            margin-top: 0.2rem;
            // margin-left: 0.4rem;
            background-color: #415DDE;
        }
    }
}

</style>
