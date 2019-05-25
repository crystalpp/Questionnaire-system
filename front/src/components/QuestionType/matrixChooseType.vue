<template>
  <div class="matrixRadioChooseType">
    <el-form :model='formData' label-width="0.1rem" label-position="left" class="selectPart">
      <el-form-item   :label="' '" required:true>
        <p class="matrixRadio-title" >{{index+1}}、{{formData.title}}</p>
      </el-form-item>
      <el-form-item>
       <p class="matrixRadio-descri">{{formData.subdesc}}</p>
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
        <table class="matrixTable-radio" v-if="formData.type === 'matrix-radio'">
          <tr>
            <th></th>
            <th v-for="(item,index) in formData.options" :key="index">{{item.optionContent}} </th>
          </tr>
          <tr v-for="(item1,index) in formData.questions" :key="index">
            <td>{{item1.questionName}}</td>
            <el-radio-group  v-model="radioCheckList[index]" v-for="(item2,index1) in formData.options" :key="index1" @change="chooseAnswer(item1,item2)" style="flex:1">
              <td >
                <el-radio :label="item2.optionId" >{{text}}</el-radio>
              </td>
            </el-radio-group>
             <!-- <td>
                <el-radio v-model="item1.questionId"  :label="index+2">{{text}}</el-radio>
            </td>
             <td>
                <el-radio v-model="item1.questionId"  :label="index+3">{{text}}</el-radio>
            </td> -->
          </tr>
        </table>
        <table class="matrixTable-mutil" v-if="formData.type === 'matrix-multi'">
          <tr>
            <th></th>
            <th v-for="(item,index) in formData.options" :key="index">{{item.optionContent}} </th>
          </tr>
          <tr v-for="(item1,index) in formData.questions" :key="index">
            <td>{{item1.questionName}}</td>
            <!-- v-for="(item2,index) in formData.options" :key="index" -->
             <el-checkbox-group v-model="checkList[index]" v-for="(item2,index1) in formData.options" :key="index1" style="flex:1" @change="chooseAnswerMulti()">
              <td>
                <el-checkbox :label="item2.optionId" >{{text}}</el-checkbox>
              </td>
             </el-checkbox-group>
          </tr>
        </table>
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
// import questionApi from '../../client/bll/apis/question'
import commonFunc from '../../client/bll/apis/common/common'
export default {
  props: ['formData', 'index'],
  data () {
    return {
      text: '',
      editOrPreview: '',
      // 参考数据
      radio: '',
      checkList: [],
      radioCheckList: [],
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
          },
          {
            name: 'firefox',
            checked: ''
          }
        ]
      },
      answerData: {
      }
    }
  },
  mounted () {
    this.initCheckList()
    // console.log(this.formData)
    this.editOrPreview = commonFunc.getLocalStorage('editOrPreview')
  },
  methods: {
    initCheckList () {
      debugger
      this.checkList = []
      // eslint-disable-next-line
      for (let i of this.formData.questions) {
        let item = []
        let radioItem = ''
        if (commonFunc.isDefine(this.formData.subChoose)) {
          if (this.formData.subChoose[i.questionId].length === 1) {
            radioItem = this.formData.subChoose[i.questionId][0]
          } else {
            item = radioItem = this.formData.subChoose[i.questionId]
          }
        } else {
          item = []
          radioItem = ''
        }
        // console.log(i)
        this.radioCheckList.push(radioItem)
        this.checkList.push(item)
      }
    },
    chooseAnswerMulti () {
      var answerData = []
      var answerDataItem = {
        checkOptions: [],
        checkQuestions: []
      }
      for (let i in this.checkList) {
        answerDataItem.checkOptions = this.checkList[i]
        answerDataItem.checkQuestions = this.formData.questions[i]
        answerData.push(JSON.parse(JSON.stringify(answerDataItem)))
      }
       // 重新组装数据成后端需要的格式
      let oneItem = {
        questionId: '',
        subQuestionId: '',
        optionId: ''
      }
      var realAnswers = []
      for (let item of answerData) {
        oneItem.questionId = this.formData.questionId
        oneItem.subQuestionId = item.checkQuestions.questionId
        oneItem.optionId = ''
        for (let item1 of item.checkOptions) {
          oneItem.optionId += item1.optionId
          oneItem.optionId += ','
        }
        realAnswers.push(JSON.parse(JSON.stringify(oneItem)))
      }
      this.$emit('getAnswerDataMulti', realAnswers)
    },
    chooseAnswer () {
      var answerData = []
      var answerDataItem = {
        checkOptions: '',
        checkQuestions: ''
      }
      for (let i in this.radioCheckList) {
        answerDataItem.checkOptions = this.radioCheckList[i]
        answerDataItem.checkQuestions = this.formData.questions[i]
        answerData.push(JSON.parse(JSON.stringify(answerDataItem)))
      }
      // 重新组装数据成后端需要的格式
      let oneItem = {
        questionId: '',
        subQuestionId: '',
        optionId: ''
      }
      var realAnswers = []
      for (let item of answerData) {
        oneItem.questionId = this.formData.questionId
        oneItem.optionId = item.checkOptions.optionId
        oneItem.subQuestionId = item.checkQuestions.questionId
        realAnswers.push(JSON.parse(JSON.stringify(oneItem)))
      }
      this.$emit('getAnswerData', realAnswers)
    }
    // edit () {
    //   this.formData.display = true
    //   let quesType = 'matrix'
    //   this.formData.optionMethod = 'edit'
    //   this.formData.quesType = quesType
    //   this.$emit('editSelectForm', this.formData)
    // },
    // async deleteQues (id) {
    //   let res = await questionApi.deleteByQuestionId(id)
    //   if (res.code === 0) {
    //     commonFunc.showMessage('删除成功', 'success')
    //   }
    // },
  }
}
</script>
<style lang="scss" scoped>
.matrixTable-radio{
  font-size: 0.12rem;
  width: 100%;
  tr{
    align-items: center;
    display: flex;
    td{
      flex:1;
    }
    th{
      font-weight: normal;
      flex: 1;
    }
  }
}
.matrixTable-mutil {
  font-size: 0.12rem;
  width: 100%;
  tr{
    display: flex;
    td{
      flex:1;
    }
    th{
      font-weight: normal;
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
