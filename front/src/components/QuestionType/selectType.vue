<template>
<!-- 用于单选题，双选题，文本题的设计(文本题就是没有选项)-->
  <div class="selectType">
    <el-form :model='selectFormdata' label-width="0.8rem" class="demo-dynamic" :rules="rules" ref="selectFormdata">
      <el-form-item label="题目" prop="title">
        <el-input v-model="selectFormdata.title"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="subdesc">
        <el-input v-model="selectFormdata.subdesc"></el-input>
      </el-form-item>
      <el-form-item label="必填" prop="required">
          <el-switch v-model="selectFormdata.required"></el-switch>
      </el-form-item>
      <el-form-item :rules="{
          required: true, message: '选项不能为空', trigger: 'blur'
        }"
        v-for="(option, index) in selectFormdata.options"
        :label="'选项' + (index+1)"
        :key="option.key"
        :prop="'options.' + index + '.value'">
      <el-input v-model="option.value"></el-input><i @click.prevent="removeOption(option)" class="el-icon-close deleteicon"></i>
      </el-form-item>
      <el-form-item>
          <el-button type="primary" plain @click="addOption" v-if="selectFormdata.options.length>0">新增选项</el-button>
      </el-form-item>
      <el-form-item>
        <div class="line"></div>
      </el-form-item>
      <el-form-item style="text-align:right">
        <el-button plain @click="cancelSubmit()">取消</el-button>
        <el-button type="primary" @click="confirm('selectFormdata')">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import questionApi from '../../client/bll/apis/question.js'
import commonFunc from '../../client/bll/apis/common/common'
export default {
  props: ['selectFormdata'],
  data () {
    return {
      rules: {
        title: [
          { required: true, message: '请输入题目', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    removeOption (item) {
      var index = this.selectFormdata.options.indexOf(item)
      if (index !== -1) {
        this.selectFormdata.options.splice(index, 1)
      }
    },
    addOption () {
      this.selectFormdata.options.push({
        value: '',
        key: Date.now()
      })
    },
    // 取消按钮
    cancelSubmit () {
      this.selectFormdata.display = false
    },
    // 确定按钮
    confirm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          debugger
          this.selectFormdata.display = false
          this.$emit('getSelectForm', this.selectFormdata)
          let newOptionsArr = []
          for (let i of this.selectFormdata.options) {
            newOptionsArr.push(i.value)
          }
          this.selectFormdata.optionsValue = newOptionsArr
          this.selectFormdata.surverId = this.$route.query.surverId
          let res = await questionApi.add(this.selectFormdata)
          if (res.code === 0) {
            commonFunc.showMessage('新增成功', 'success')
          } else {
            commonFunc.showMessage('新增失败，请稍后再试', 'error')
          }
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.selectType{
  width: 60%;
  margin: 0 auto;
  margin-top: 0.1rem;
  // .que-option{
  //   display: flex;
  //   align-items: center;
  //   margin-left: 0.05rem;
  // }
  .deleteicon{
    float: right;
    margin-right: -0.2rem;
    margin-top: 0.1rem;
  }
  .line{
    border: 1px solid #E0E0E0;
  }
}
</style>
