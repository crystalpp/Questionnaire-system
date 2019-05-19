<template>
  <div class="user-info">
    <div class="back" @click="gobackindex"> <i class="el-icon-back"></i></div>
    <div class="header">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="修改基本信息" name="first">
          <div class="container">
            <div class="edit-userInfo" >
              <el-form label-position="right" :model="regUserInfo"  :rules="UserInfoRules" ref="regUserInfo"   class="demo-ruleForm">
                <el-form-item label="用户名" prop="userName">
                  <el-input type="text" v-model="regUserInfo.userName" auto-complete="off">
                    <i slot="prefix" class="iconfont icon-user"></i>
                  </el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="userEmail">
                  <el-input type="text" v-model="regUserInfo.userEmail" auto-complete="off" v-on:input="searchByPhone('email', regUserInfo.userEmail)">
                    <i slot="prefix" class="iconfont icon-emailFilled"></i>
                  </el-input>
                </el-form-item>
                <el-form-item label="手机号" prop="userPhone">
                  <el-input type="text" v-model="regUserInfo.userPhone" auto-complete="off"  v-on:input="searchByPhone('phone', regUserInfo.userPhone)">
                    <i slot="prefix" class="iconfont icon-tel"></i>
                  </el-input>
                </el-form-item>
                <el-form-item>
                  <el-button style="width:100%" type="primary" round class="button" @click="editUserInfo">确认修改</el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </el-tab-pane>
        <el-tab-pane label="修改密码" name="second">
          <div class="container">
            <div class="edit-psw" >
              <el-form label-position="right" :model="passwordForm"  :rules="passwordFormRules" ref="passwordForm"   class="demo-ruleForm">
                <el-form-item label="旧密码" prop="oldPassword">
                  <el-input type="password" v-model="passwordForm.oldPassword" auto-complete="off">
                    <i slot="prefix" class="iconfont icon-password"></i>
                  </el-input>
                </el-form-item>
                <el-form-item label="新密码" prop="password">
                  <el-input type="password" v-model="passwordForm.password" auto-complete="off">
                    <i slot="prefix" class="iconfont icon-password"></i>
                  </el-input>
                </el-form-item>
                <el-form-item>
                  <el-button style="width:100%" type="primary" round class="button" @click="editPass">确认修改</el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </el-tab-pane>
      </el-tabs>
      <!-- <el-button type="primary" @click="changeShowUser">修改基本信息</el-button>
      <el-button type="primary" @click="changeShowPSW">修改密码</el-button> -->
    </div>
  </div>
</template>
<script>
import userApi from '../client/bll/apis/user'
import commonFunc from '../client/bll/apis/common/common'
const delay = (function () {
  let timer = 0
  return function (callback, ms) {
    clearTimeout(timer)
    timer = setTimeout(callback, ms)
  }
})()
export default {
  data () {
    var valiate = (rule, value, callback) => {
      if (this.valiteInfo !== '') {
        callback(new Error(this.valiteInfo))
      } else {
        callback()
      }
    }
    var validateOldPass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else if (this.passValiteInfo !== '') {
        callback(new Error(this.passValiteInfo))
      } else {
        callback()
      }
    }
    return {
      regUserInfo: {
        userName: '',
        userEmail: '',
        userPhone: '',
        userPassword: ''
      },
      passwordForm: {
        oldPassword: '',
        password: ''
      },
      activeName: 'first',
      valiteInfo: '',
      passValiteInfo: '',
      show: 'userInfo',
      passwordFormRules: {
        oldPassword: [
          { required: true, validator: validateOldPass, trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      },
      UserInfoRules: {
        userPhone: [
          { required: true, trigger: 'blur', message: '电话号码不能为空' },
          { required: true, trigger: 'change', validator: valiate },
          { len: 11, trigger: 'change', message: '电话号码不合法' }
        ],
        userName: [
          { required: true, trigger: 'blur', message: '用户名不能为空' }
        ],
        userEmail: [
          { required: true, trigger: 'blur', message: '邮箱不能为空' },
          { type: 'email', message: '请输入正确的邮箱格式', trigger: 'blur' },
          { required: true, trigger: 'blur', validator: valiate }
        ]
      }
    }
  },
  watch: {
    'passwordForm.oldPassword' () {
      delay(() => {
        this.checkOldPass()
      }, 500)
    }
  },
  mounted () {
    commonFunc.setLocalStorage('fillOrCreat', 'creat')
    this.getUserInfo()
  },
  methods: {
    editPass () {
      this.$refs['passwordForm'].validate(async (valid) => {
        if (valid) {
          console.log('submit')
          this.regUserInfo.userPassword = this.passwordForm.password
          let res = await userApi.update(this.regUserInfo)
          if (res.code === 0) {
            commonFunc.setLocalStorage('userInfo', JSON.stringify(this.regUserInfo))
            commonFunc.showMessage('修改密码成功，请重新登录', 'success')
            this.$router.push({name: 'login'})
          }
        } else {
          console.log('error submit')
          return false
        }
      })
    },
    checkOldPass () {
      let pass = JSON.parse(commonFunc.getLocalStorage('userInfo')).userPassword
      if (this.passwordForm.oldPassword !== pass) {
        this.passValiteInfo = '旧密码与原密码不同'
      } else {
        this.passValiteInfo = ''
      }
    },
    gobackindex () {
      this.$router.go(-1)
    },
    async editUserInfo () {
      this.$refs['regUserInfo'].validate(async (valid) => {
        if (valid) {
          let res = await userApi.update(this.regUserInfo)
          if (res.code === 0) {
            commonFunc.setLocalStorage('userInfo', JSON.stringify(this.regUserInfo))
            commonFunc.showMessage('修改成功', 'success')
          }
        } else {
          return false
        }
      })
    },
    getUserInfo () {
      let user = JSON.parse(commonFunc.getLocalStorage('userInfo'))
      this.regUserInfo = user
    },
    handleClick () {
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
    },
    changeShowUser () {
      this.show = 'userInfo'
    },
    changeShowPSW () {
      this.show = 'psw'
    }
  }
}
</script>
<style lang="scss" scoped>
.el-tabs__header {
  background: white;
}
.user-info{
  background: #efefef;
  width: 100%;
  height: 100%;
  overflow: auto;
  margin: 0 auto;
   .back{
      cursor: pointer;
      float: left;
      margin-top: 0.35rem;
      /* margin-right: 0.2rem; */
      margin-left: 0.2rem;
    }
  .header{
    width: 90%;
    margin: 0 auto;
    margin-top: 0.2rem;
    text-align: left;
    font-size:0.22rem;
    // margin-left: 0.5rem;
   
    
  }
  .container {
    // border: 1px solid red;
    width: 4rem;
    height: 4rem;
    margin:  0 auto;
    margin-top:0.3rem;
    .edit-userInfo{
      width: 100%;
      height: 100%;
       box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
      border-radius: 4px;
      background: #ffffff;
      border: 1px solid #ebeef5;
      .demo-ruleForm{
        width: 80%;
        margin: 0 auto;
      }
    }
    .edit-psw{
      width: 100%;
      height: 70%;
       box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
      border-radius: 4px;
      background: #ffffff;
      border: 1px solid #ebeef5;
      .demo-ruleForm{
        width: 80%;
        margin: 0 auto;
      }
    }
  }
  
}
</style>
