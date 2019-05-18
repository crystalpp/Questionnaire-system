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
      <el-form-item label="量表类型" :rules="{
          required: true, message: '量表类型不能为空', trigger: 'blur'
        }">
        <el-select  v-model="selectForm.options[0].optionContent"  placeholder="请选择量表类型">
          <el-option
            v-for="item in selectForm.options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
      </el-select>
      </el-form-item>
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
      // selectForm: {
      //   title: '', // 题目
      //   subdesc: '', // 备注
      //   type: 'measure', // 题目类型
      //   required: true, // 是否必填
      //   measureValue: '',
      //   options: [
      //     {
      //       value: '满意',
      //       label: '满意度'
      //     },
      //     {
      //       value: '认同',
      //       label: '认同度'
      //     },
      //     {
      //       value: '重要',
      //       label: '重要度'
      //     },
      //     {
      //       value: '符合',
      //       label: '符合度'
      //     }
      //   ] // 选项
      // }
    }
  },
  mounted () {
  },
  methods: {
    confirm (formName) {
      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          this.selectForm.display = false
          this.$emit('getmeasureSelectform', this.selectForm)
          this.selectForm.optionsValue = this.selectForm.options[0].optionContent
          this.selectForm.surverId = this.$route.query.surverId
          let res = await questionApi.add(this.selectForm)
          if (res.code === 0) {
            commonFunc.showMessage('新增成功', 'success')
          } else {
            commonFunc.showMessage('新增失败，请稍后再试', 'fail')
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
.measureType{
  width: 60%;
  margin: 0 auto;
  margin-top: 0.1rem;
  .line{
    border: 1px solid #E0E0E0;
  }
}
</style>