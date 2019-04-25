<template>
  <div class="matrixRadioChooseType">
    <el-form :model='formData' label-width="0.1rem" label-position="left">
      <el-form-item   :label="' '" required:true>
        <p class="matrixRadio-descri">{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="matrixRadio-descri">{{formData.subdesc}}</p>
      </el-form-item>
      <el-form-item>
        <el-table
          :data="formData.questions"
          style="width: 100%">
          <el-table-column
            label=""
            width="180">
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.value }}</span>
            </template>
          </el-table-column>
          <el-table-column v-for="(option,index) in formData.options" :key="option.key"
            :label="option.value"
            width="180">
            <template slot-scope="scope">
             <!-- <el-radio-group v-model="radio2">
              <el-radio :label="3">备选项</el-radio>
              <el-radio :label="6">备选项</el-radio>
              <el-radio :label="9">备选项</el-radio>
            </el-radio-group> -->
             <el-radio v-model="formData.questions[scope.$index].checked"  @change="getCurrentColumn(scope.$index,scope.row)" v-if="formData.type === 'matrix-radio'"> </el-radio>
             <el-checkbox v-model="formData.questions[scope.$index].checked"  @change="getCurrentColumn(scope.$index,scope.row)" v-if="formData.type === 'matrix-multi'"> </el-checkbox>
            </template>
          </el-table-column>
        </el-table>
        <!-- <el-table
          :data="tableData">
          <el-table-column
            prop="apperance">
          </el-table-column>
          <el-table-column
            v-for="(item,index) in tableData"
            :key="index"
            :label="item.label">
            <template slot-scope="scope">
              <el-radio :label="''" v-model="tableData[scope.$index].checked[index]"
              @change="getCurrentColumn(scope.$index,scope.row)"
              >
              </el-radio>
            </template>
          </el-table-column>
        </el-table> -->
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  props: ['formData', 'index'],
  data () {
    return {
      // 参考数据
      radio: '',
      tableData: [{
        'apperance': 'google',
        'chooseType': 'radio',
        'label': 'one',
        'value': '',
        'checked': [false, false, false]
      },
      {
        'apperance': 'baidu',
        'chooseType': 'radio',
        'label': 'two',
        'value': '',
        'checked': [false, false, false]
      },
      {
        'apperance': 'souguo',
        'chooseType': 'radio',
        'label': 'three',
        'value': '',
        'checked': [false, false, false]
      }
      ]
    }
  },
  methods: {
    getCurrentColumn (index, row, itemIndex) {
      // debugger
      // for (let i = 0; i < this.formData.questions.length; i++) {
      //   if (this.formData.questions[i].value !== row.value) {
      //     this.formData.options[i].checked = false
      //   }
      //   else {
      //     this.formData.questions[i].checked = true
      //   }
      // }
      // for (let i = 0; i < row.checked.length; i++) {
      // row.checked = false
      // }
      // this.radio = false
      // this.radio = true
      // row.checked[index] = true
    }
  }
}
</script>
<style lang="scss" scoped>
.el-form-item{
margin-bottom: 0;
}
.matrixRadioChooseType{
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .matrixRadio-descri{
    font-size: 0.12rem;
  }
}
</style>
