<template>
  <div class="matrixRadioChooseType">
    <el-form :model='tableData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="matrixRadio-title" >{{index+1}}、{{tableData.name}}</p>
      </el-form-item>
      <el-form-item>
       <p class="matrixRadio-descri">{{tableData.subdesc}}</p>
      </el-form-item>
      <el-form-item style="width:88%" >
        <!-- <el-table
          :data="formData.questions"
          style="width: 100%">
          <el-table-column
            label=""
           >
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.questionName }}</span>
            </template>
          </el-table-column>
          <el-table-column v-for="(option,index) in formData.options" :key="option.key"
            :label="option.optionContent"
            >
            <template slot-scope="scope">
             <el-radio v-model="formData.questions[scope.$index]"  @change="getCurrentColumn(scope.$index,scope.row)" v-if="formData.type === 'matrix-radio'"> </el-radio>
             <el-checkbox v-model="formData.questions[scope.$index]"  @change="getCurrentColumn(scope.$index,scope.row)" v-if="formData.type === 'matrix-multi'"> </el-checkbox>
            </template>
          </el-table-column>
        </el-table> -->
        <table class="matrixTable">
          <tr>
            <th></th>
            <th v-for="(item,index) in tableData.options" :key="index">{{item.name}} </th>
          </tr>
          <tr v-for="(item1,index) in tableData.questions" :key="index">
            <td>{{item1.name}}</td>
            <td>
                <el-radio v-model="item1.checked" :label="index+1">{{text}}</el-radio>
            </td>
             <td>
                <el-radio v-model="item1.checked"  :label="index+2">{{text}}</el-radio>
            </td>
             <td>
                <el-radio v-model="item1.checked"  :label="index+3">{{text}}</el-radio>
            </td>
          </tr>
        </table>
        <!-- <div class="table-header">
          <p >123 </p>
          <p v-for="(item,index) in tableData.questions" :key="index">{{item.name}} </p>
        </div>
        <div class="table-body">
          <div class="table-body-item" v-for="(item,index) in tableData.options" :key="index">
            <p class="item1">{{item.name}}</p>
            <el-radio-group v-model="item.name" class="item2">
              <el-radio :label="item1.name" v-for="(item1,index) in tableData.questions" :key="index" ></el-radio>
            </el-radio-group>
          </div>
        </div> -->
      </el-form-item>
    </el-form>
    <div class="optionPart" v-if="editOrPreview === 'edit'">
      <el-button-group>
        <el-button  plain icon="el-icon-edit" @click="edit"></el-button>
        <el-button  plain icon="el-icon-delete" @click="deleteQues(formData.questionId)"></el-button>
      </el-button-group>
    </div>
  </div>
</template>
<script>
import questionApi from '../../client/bll/apis/question'
import commonFunc from '../../client/bll/apis/common/common'
export default {
  props: ['formData', 'index'],
  data () {
    return {
      text: '',
      editOrPreview: '',
      // 参考数据
      radio: '',
      radio1: '',
      tableData: {
        name: '浏览器1',
        subdesc: '单选',
        options: [
          {
            name: 'like',
            checked: ''
          },
          {
            name: 'hate',
            checked: ''
          },
          {
            name: 'xixi',
            checked: ''
          }
        ],
        questions: [
          {
            name: 'baidu',
            checked: ''
          },
          {
            name: 'google',
            checked: ''
          }
        ]
      }
    }
  },
  mounted () {
    this.editOrPreview = commonFunc.getLocalStorage('editOrPreview')
  },
  methods: {
    edit () {
      this.formData.display = true
      let quesType = 'matrix'
      this.formData.optionMethod = 'edit'
      this.formData.quesType = quesType
      this.$emit('editSelectForm', this.formData)
    },
    async deleteQues (id) {
      let res = await questionApi.deleteByQuestionId(id)
      if (res.code === 0) {
        commonFunc.showMessage('删除成功', 'success')
      }
    },
    getCurrentColumn (index, row, itemIndex) {
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
.matrixTable{
  width: 100%;
  tr{
    display: flex;
    td{
      flex:1;
    }
    th{
      flex: 1;
    }
  }
}
.selectPart{
  flex: 15;
  width: 100%;
}
.optionPart{
  flex: 2;
}
.el-form-item{
margin-bottom: 0;
}
.matrixRadioChooseType{
  display: flex;
  width: 95%;
  margin: 0 auto;
  margin-top: 0.1rem;
  margin-bottom: 0.2rem;
  .matrixRadio-descri{
    font-size: 0.12rem;
  }
  .matrixRadio-title{
    font-size: 0.18rem;
  }
  .table-header{
    display: flex;
    p{
      margin-left: 0.2rem;
      flex: 1;
    }
  }
  .table-body-item{
    display: flex;
    .item1{
      flex:1;
    }
    .item2{
      flex:2;
    }
  }
}
</style>
