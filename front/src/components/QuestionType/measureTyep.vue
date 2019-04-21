<template>
<!-- 用于量表题的设计-->
  <div class="measureType">
    <el-form :model='selectForm' label-width="0.8rem" class="demo-dynamic">
      <el-form-item label="题目">
        <el-input v-model="selectForm.title"></el-input>
      </el-form-item>
      <el-form-item label="备注">
        <el-input v-model="selectForm.subdesc"></el-input>
      </el-form-item>
      <el-form-item label="必填">
          <el-switch v-model="selectForm.required"></el-switch>
      </el-form-item>
      <el-form-item label="量表类型">
        <el-select  v-model="selectForm.measureValue"  placeholder="请选择量表类型">
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
        <el-button type="primary">确定</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  data () {
    return {
      selectForm: {
        title: '', // 题目
        subdesc: '', // 备注
        type: '', // 题目类型
        required: true, // 是否必填
        measureValue: '',
        options: [
          {
            value: 'item1',
            label: '满意度'
          },
          {
            value: 'item2',
            label: '认同度'
          },
          {
            value: 'item3',
            label: '重要度'
          },
          {
            value: 'item4',
            label: '符合度'
          }
        ] // 选项
      }
    }
  },
  methods: {}
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