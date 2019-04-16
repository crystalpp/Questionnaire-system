<template>
  <div class="login-content">
    <div class="login-top">
      <el-button round>注册</el-button>
      <el-button round>返回首页</el-button>
    </div>
    <div class="login-main">
        <div class="title">账号登录</div>
        <div class="middle-part">
            <el-form label-position="right" :model="userInfo" ref="userInfo"  class="demo-ruleForm">
                <el-form-item label="账号" prop="name">
                    <el-input v-model="userInfo.name" placeholder="请输入手机号码/邮箱"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input type="password" v-model="userInfo.password" placeholder="请输入密码"></el-input>
                </el-form-item>
            </el-form>
        </div>
        <div class="buttom-part">忘记密码?</div>
        <div class="login-part">
            <el-button class="login-button" type="primary" round>登录</el-button>
            <p>立即注册</p>
        </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'login',
  data () {
    return {
      title: '登录',
      userInfo: {
        name: '',
        password: ''
      }
    }
  },
  methods: {}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style lang="scss" scoped>
.login-content{
    font-size: 0.26rem;
    color: #303133;
    // background: url('../assets/login-bac.jpg') center center no-repeat;
    // background-size: cover;
    width: 100%;
    height: 100%;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    .login-main {
        // margin-top:1.5rem;
        // background: #ffffff;
        // border-radius: 0.2rem;
        width: 3.5rem;
        height: 4.5rem;
        .title{
            margin-bottom: 0.3rem;
        }
        .middle-part{
            width: 100%;
            text-align: center;
            margin: 0 auto;
        }
        .buttom-part{
            font-size: 0.12rem;
            color:#415DDE;
            text-align: right;
            // margin-right: 0.3rem;
        }
        .login-part{
            color: #415DDE;
            font-size: 0.16rem;
            margin-top: 0.3rem;
            width: 100%;
            text-align: center;
            .login-button{
                background-color: #415DDE;
                width: 100%;
                margin-bottom: 0.1rem;
            }
        }
      
    }
}

</style>
