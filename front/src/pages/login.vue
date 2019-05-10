<template>
  <div class="lo-container">
    <div class="login-top">
      <!-- <img src="../assets/logo.jpg" style="width:1rem;height:1rem;"> -->
      <div class="login-top-button">
          <el-button  class="button" type="primary" round @click="goToregister">注册</el-button>
          <el-button class="button" type="primary" round @click="back">返回首页</el-button>
        </div>
    </div>    
    <div class="login-content">
      <div class="login-main">
          <div class="title">账号登录</div>
          <div class="middle-part">
              <el-form label-position="right" :model="userInfo" ref="userInfo"  class="demo-ruleForm" :rules="rules">
                  <el-form-item label="账号" prop="name">
                      <el-input v-model="userInfo.name" placeholder="请输入手机号码/邮箱">
                        <i slot="prefix" class="iconfont icon-user"></i>
                      </el-input>
                  </el-form-item>
                  <el-form-item label="密码" prop="password">
                      <el-input type="password" v-model="userInfo.password" placeholder="请输入密码">
                        <i slot="prefix" class="iconfont icon-password"></i>
                      </el-input>
                  </el-form-item>
              </el-form>
          </div>
          <div class="buttom-part">忘记密码?</div>
          <div class="login-part">
              <el-button class="login-button" type="primary" round @click="login('userInfo')">登录</el-button>
              <p @click="goToregister">立即注册</p>
          </div>
      </div>
    </div>
  </div>
</template>
<script>
import userApi from '../client/bll/apis/user.js'
import commonFunc from '../client/bll/apis/common/common.js'
export default {
  name: 'login',
  data () {
    return {
      title: '登录',
      userInfo: {
        name: '',
        password: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入手机号码或者邮箱', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    back () {
      this.$router.push(
        {name: 'index'}
      )
    },
    goToregister () {
      this.$router.push({name: 'register'})
    },
    async login (formName) {
      let parms = {
        userName: this.userInfo.name,
        password: this.userInfo.password
      }
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          let res = await userApi.login(parms)
          // console.log(res)
          if (res.code === 0) {
            commonFunc.showMessage('登录成功', 'success')
            commonFunc.setLocalStorage('menuActiveIndex', 'show')
            commonFunc.setLocalStorage('showQuesStep', false)
            commonFunc.setLocalStorage('userInfo', JSON.stringify(res.data))
            this.$router.push({name: 'show'})
          } else {
            commonFunc.showMessage('登录失败，请重新输入', 'error')
          }
        } else {
          // console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style lang="scss" scoped>

button{
  background-color: #415DDE;
  width: 1rem;
}
.lo-container {
  width: 90%;
  height: 90%;

  margin: 0 auto;
}
.login-top{
   display: flex;
   width: 100%;
   padding-top:0.1rem;
}
.login-top-button{
  // display: flex;
  // justify-content: flex-end;
  text-align: right;
  padding-top:0rem;
  width:90%;
}
.login-content{
    font-size: 0.26rem;
    color: #303133;
    // background: url('../assets/login-bg.jpg') center center no-repeat;
    // background-size: cover;
    width: 100%;
    height: 80%;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    .login-main {
        // margin-top:1.5rem;
        // background: #ffffff;
        // border-radius: 0.2rem;
        width: 3.5rem;
        height: 4rem;
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
            cursor: pointer;
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
