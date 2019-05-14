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
            <el-form label-position="right" :model="regUserInfo"  :rules="reUserInfoRules" ref="regUserInfo"   class="demo-ruleForm">
              <el-form-item label="用户名" prop="name">
                <el-input type="text" v-model="regUserInfo.name" auto-complete="off">
                  <i slot="prefix" class="iconfont icon-user"></i>
                </el-input>
              </el-form-item>
              <el-form-item label="邮箱" prop="email">
                <el-input type="text" v-model="regUserInfo.email" auto-complete="off" v-on:input="searchByPhone('email', regUserInfo.email)">
                  <i slot="prefix" class="iconfont icon-emailFilled"></i>
                </el-input>
              </el-form-item>
              <el-form-item label="手机号" prop="telphone">
                <el-input type="text" v-model="regUserInfo.telphone" auto-complete="off"  v-on:input="searchByPhone('phone', regUserInfo.telphone)">
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
              <el-button class="re-button" type="primary" round @click="submitForm('regUserInfo')">立即注册</el-button>
              <p @click="goToLogin">已有账号，现在登录</p>
          </div>
      </div>
    </div>
  </div>
</template>
<script>
import userApi from '../client/bll/apis/user.js'
import commonFunc from '../client/bll/apis/common/common.js'
export default {
  data () {
    var valiate = (rule, value, callback) => {
      console.log(this.valiteInfo + '1111')
      if (this.valiteInfo !== '') {
        callback(new Error(this.valiteInfo))
      }
    }
    var validatePass = (rule, value, callback) => {
      // console.log(rule)
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
        email: '',
        telphone: '',
        idenCode: '',
        password: '',
        checkPassword: ''
      },
      valiteInfo: '',
      debounce: 2000,
      timer: null,
      reUserInfoRules: {
        password: [
          { required: true, validator: validatePass, trigger: 'blur' }
        ],
        checkPassword: [
          { required: true, validator: validatePass2, trigger: 'blur' }
        ],
        telphone: [
          { required: true, trigger: 'blur', message: '电话号码不能为空' },
          { required: true, trigger: 'change', validator: valiate },
          { len: 11, trigger: 'change', message: '电话号码不合法' }
        ],
        name: [
          { required: true, trigger: 'blur', message: '用户名不能为空' }
        ],
        email: [
          { required: true, trigger: 'blur', message: '邮箱不能为空' },
          { type: 'email', message: '请输入正确的邮箱格式', trigger: 'blur' },
          { required: true, trigger: 'blur', validator: valiate }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          let res = await userApi.addUser(this.regUserInfo)
          if (res.code === 0) {
            commonFunc.showMessage('注册成功', 'success')
            this.$router.push(
              {name: 'login'}
            )
          } else {
            commonFunc.showMessage('注册失败', 'error')
          }
        } else {
          // console.log('error submit!!')
          return false
        }
      })
    },
    async searchByPhone (type, val) {
      let param = {
        type: type,
        value: val
      }
      let res = await userApi.userValiate(param)
      if (res.code === 1) {
        this.valiteInfo = res.msg
      } else {
        this.valiteInfo = ''
      }
      if (this.timer) {
        return
      }
      this.timer = window.setTimeout(async () => {
        // console.log('111')
        // let res = await userApi.userValiate(param)
        // console.log(res)
        this.timer = null
      }, this.debounce)
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
  width: 100%;
  height: 100%;
  overflow: auto;
  margin: 0 auto;
  // padding-bottom: 0.2rem;
  .re-top{
    padding-top: 0.2rem;
    display: flex;
    justify-content: flex-end;
    padding-right: 1.5rem;
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
    height: 90%;
    align-items: center;
    .re-main {
        // margin-top:1.5rem;
        // background: #ffffff;
        // border-radius: 0.2rem;
        width: 4rem;
        height: 100%;
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
          // margin-left:0.2rem;
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
