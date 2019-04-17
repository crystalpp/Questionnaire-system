<template>
  <div class="re-container">
    <div class="re-top">
      <el-button  class="button" type="primary" @click="goToLogin" round>登录</el-button>
      <el-button class="button" type="primary" round @click="back">返回首页</el-button>
    </div>
    <div class="re-content">
      <div class="re-main">
          <div class="title">新用户注册</div>
          <div class="middle-part">
            <el-form label-position="right" :model="regUserInfo"  :rules="reUserInfoRules" ref="regUserInfo"   label-width="100px" class="demo-ruleForm">
              <el-form-item label="用户名" prop="name">
                <el-input type="text" v-model="regUserInfo.name" auto-complete="off">
                  <i slot="prefix" class="iconfont icon-user"></i>
                </el-input>
              </el-form-item>
              <el-form-item label="手机号" prop="telphone">
                <el-input type="text" v-model="regUserInfo.telphone" auto-complete="off">
                  <i slot="prefix" class="iconfont icon-tel"></i>
                </el-input>
              </el-form-item>
              <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="regUserInfo.password" auto-complete="off">
                  <i slot="prefix" class="iconfont icon-password"></i>
                </el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPassword">
                <el-input type="password" v-model="regUserInfo.checkPassword" auto-complete="off">
                  <i slot="prefix" class="iconfont icon-password"></i>
                </el-input>
              </el-form-item>
              <!-- <el-form-item>
                <el-button style="width:100%" type="primary" round class="button" @click="submitForm('regUserInfo')">立即注册</el-button>
              </el-form-item> -->
            </el-form>
            
          </div>
          <!-- <div class="buttom-part">忘记密码?</div> -->
          <div class="re-part">
              <el-button class="re-button" type="primary" round @click="goToLogin">立即注册</el-button>
              <p @click="goToLogin">已有账号，现在登录</p>
          </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.regUserInfo.checkPassword !== '') {
          this.$refs.regUserInfo.validateField('checkPassword')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.regUserInfo.password) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      regUserInfo: {
        name: '',
        telphone: '',
        idenCode: '',
        password: '',
        checkPassword: ''
      },
      reUserInfoRules: {
        password: [
          { required: true, validator: validatePass, trigger: 'blur' }
        ],
        checkPassword: [
          { required: true, validator: validatePass2, trigger: 'blur' }
        ],
        telphone: [
          { required: true, trigger: 'blur', message: '电话号码不能为空' }
        ],
        name: [
          { required: true, trigger: 'blur', message: '用户名不能为空' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    back () {
      this.$router.push(
        {name: 'index'}
      )
    },
    goToLogin () {
      this.$router.push(
        {name: 'login'}
      )
    }
  }
}
</script>
<style lang="scss" scoped>
.button{
  background-color: #415DDE;
  width: 1rem;
}
.re-container{
  width: 90%;
  height: 90%;
  margin: 0 auto;
  // padding-bottom: 0.2rem;
  .re-top{
    padding-top: 0.2rem;
    display: flex;
    justify-content: flex-end;
  }
  
}
.re-content{
    font-size: 0.26rem;
    color: #303133;
    // background: url('../assets/login-bg.jpg') center center no-repeat;
    // background-size: cover;
    width: 100%;
    // height: 80%;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    .re-main {
        // margin-top:1.5rem;
        // background: #ffffff;
        // border-radius: 0.2rem;
        width: 3.5rem;
        // height: 4rem;
        .title{
            margin-bottom: 0.3rem;
            margin-left: 0.4rem;
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
        .re-part{
          margin-left:0.2rem;
            cursor: pointer;
            color: #415DDE;
            font-size: 0.16rem;
            margin-top: 0.3rem;
            width: 100%;
            text-align: center;
            .re-button{
                background-color: #415DDE;
                width: 80%;
                margin-bottom: 0.1rem;
            }
        }
    }
}
</style>
