<template>
  <div class="user-info">
    <div class="header">
      <el-button type="primary" @click="changeShowUser">修改基本信息</el-button>
      <el-button type="primary" @click="changeShowPSW">修改密码</el-button>
    </div>
    <div class="container">
      <div class="edit-userInfo" v-if="show==='userInfo'">
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
          <el-form-item>
            <el-button style="width:100%" type="primary" round class="button">确认修改</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div class="edit-psw" v-if="show==='psw'">
         <el-form label-position="right" :model="regUserInfo"  :rules="reUserInfoRules" ref="regUserInfo"   class="demo-ruleForm">
          <el-form-item label="旧密码" prop="password">
            <el-input type="password" v-model="regUserInfo.password" auto-complete="off">
              <i slot="prefix" class="iconfont icon-password"></i>
            </el-input>
          </el-form-item>
          <el-form-item label="新密码" prop="checkPassword">
            <el-input type="password" v-model="regUserInfo.checkPassword" auto-complete="off">
              <i slot="prefix" class="iconfont icon-password"></i>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-button style="width:100%" type="primary" round class="button">确认修改</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      regUserInfo: {
        name: '',
        email: '',
        telphone: '',
        password: '',
        checkPassword: ''
      },
      show: 'userInfo'
    }
  },
  methods: {
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
.user-info{
  background: #efefef;
  width: 100%;
  height: 100%;
  overflow: auto;
  margin: 0 auto;
  .header{
    margin-top: 0.5rem;
    text-align: left;
    margin-left: 0.5rem;
    
    
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
  }
  
}
</style>
