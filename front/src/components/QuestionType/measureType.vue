<template>
<!-- 用于量表题的设计-->
  <div class="measureType">
    <el-form :model='selectForm' label-width="0.8rem" class="demo-dynamic" ref="selectForm" :rules="rules">
      <el-form-item label="题目" prop="title">
        <el-input v-model="selectForm.title"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="selectForm.subdesc"></el-input>
      </el-form-item>
      <el-form-item label="必填">
          <el-switch v-model="selectForm.required"></el-switch>
      </el-form-item>
      <!-- <el-form-item label="量表类型" :rules="{
          required: true, message: '量表类型不能为空', trigger: 'blur'
        }"> -->
        <!-- <el-select  v-model="selectForm.options[0].optionContent"  placeholder="请选择量表类型">
          <el-option
            v-for="item in selectForm.options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
      </el-select> -->
      <!-- </el-form-item> -->
      <el-form-item>
        <div class="line"></div>
      </el-form-item>
      <el-form-item style="text-align:right">
        <el-button plain>取消</el-button>
        <el-button type="primary" @click="confirm('selectForm')">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import commonFunc from '../../client/bll/apis/common/common'
import questionApi from '../../client/bll/apis/question.js'
export default {
  props: ['selectForm'],
  data () {
    return {
      rules: {
        title: [
          { required: true, message: '请输入题目', trigger: 'blur' }
        ]
      }
    }
  },
  mounted () {
  },
  methods: {
    async editQuestion () {
      let res = await questionApi.updateByQuestionId(this.selectForm)
      if (res.code === 0) {
        commonFunc.showMessage('修改成功', 'success')
      } else {
        commonFunc.showMessage('修改失败，请稍后再试', 'error')
      }
    },
    async addQuestion () {
      this.selectForm.surverId = this.$route.query.surverId
      let res = await questionApi.add(this.selectForm)
      if (res.code === 0) {
        commonFunc.showMessage('新增成功', 'success')
      } else {
        commonFunc.showMessage('新增失败，请稍后再试', 'fail')
      }
    },
    confirm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          if (this.selectForm.optionMethod === 'edit') {
            await this.editQuestion()
          } else {
            await this.addQuestion()
          }
          debugger
          this.selectForm.display = false
          this.$emit('getmeasureSelectform', this.selectForm)
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
.measureType{
  width: 60%;
  margin: 0 auto;
  margin-top: 0.1rem;
  .line{
    border: 1px solid #E0E0E0;
  }
}
</style>