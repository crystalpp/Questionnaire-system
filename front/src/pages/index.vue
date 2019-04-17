<template>
  <div class="index-content">
      <div class="header">
          <div>关于我们</div>
          <div>联系我们</div>
          <div>案例展示</div>
      </div>
      <div class="main-container">
          <div class="title">{{title}}</div>
          <div class="text">本系统旨在为同学和老师提供更加便捷的统计方式，为学院制定个性化的教学目标以及人才培养方案提供数据支撑。本系统可以快速的创建问卷并且发布，实时的分析图表，带给用户更好的使用体验</div>
          <el-button type="primary" class="buttion" round @click="goToLogin">创建问卷</el-button>
      </div>
  </div>
</template>
<script>
export default {
  name: 'index',
  data () {
    return {
      title: '计算机学院学生问卷调查系统'
    }
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
.index-content{
    font-size: 0.18rem;
    color: #6D6F85;
    background: url('../assets/img/index.png') center center no-repeat;
    background-size: cover;
    width: 100%;
    height: 100%;
    .header{
        padding-top: 0.55rem;
        padding-left: 2.6rem;
        display: flex;
        div{
            width:1rem;
        }
    }
    .main-container{
        text-align: left;
        padding-top: 1.8rem;
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
