<template>
  <div class="myQues">
    <div class="myQues-header">
      <i :class="'el-icon-menu '+cardIcon" @click="showCard"></i>
      <i :class="'el-icon-tickets '+ tableIcon" @click="showTable"></i>
      <el-select class="select" v-model="timeValue" placeholder="请选择" size="small">
        <el-option 
          v-for="item in timeOptions"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <el-input class="input" v-model="searchData"  suffix-icon="el-icon-search" size="small" placeholder="问卷标题"></el-input>
      <el-button @click="creatQues" type="primary" icon="el-icon-circle-plus" size="small" style="background: #2672FF;margin-left:0.2rem;" v-show="show2 === 'table'">新建问卷</el-button>
    </div>
    <div class="myQues-body-card" v-show="show2 === 'card'">
      <div class="creatQues" @click="creatQues">
          <div class="card-container">
            <i class="el-icon-circle-plus"></i>
            新建
          </div>
      </div>
      <div class=" questions" @mouseover="showOption(index)" @mouseout="showStatus(index)" v-for="(item, index) in tableData" :key="item.key">
          <div class="card-container">
            <div class="card-icon">问卷</div>
            <div class="card-title">{{item.title}}</div>
            <div class="card-time">{{item.date}}</div>
            <div class="card-footer" v-show="show === 'status' || indexitem !== index ">
              <div class="card-num">{{item.dataNum}}份数据</div>
              <div class="card-status">{{item.status}}</div>
            </div>
            <div class="card-footer-Option" v-show="show === 'option' && indexitem === index ">
              <div class="item"><i class="el-icon-edit-outline"></i><br/>编辑</div>
              <div class="item"><i class="el-icon-upload"></i><br/>发布</div>
              <div class="item"><i class="el-icon-view"></i><br/>预览</div>
              <div class="item"><i class="el-icon-document"></i><br/>数据</div>
              <div class="item"><i class="el-icon-delete"></i><br/>删除</div>
            </div>
          </div>
      </div>
    </div>
    <div class="myQues-body-table" v-show="show2 === 'table'">
      <el-table
        :data="tableData"
        stripe
        style="width: 100%">
        <el-table-column
          fixed
          align='left'
          prop="title"
          label="问卷标题"
          width="500">
        </el-table-column>
        <el-table-column
          prop="status"
          align='center'
          label="状态"
          width="120">
        </el-table-column>
        <el-table-column
          prop="dataNum"
          align='center'
          label="收到数据"
          width="120">
        </el-table-column>
        <el-table-column
          prop="date"
          align='center'
          label="创建时间"
          width="200">
        </el-table-column>
        <el-table-column
          align='center'
          fixed="right"
          label="操作"
          width="300">
          <template slot-scope="scope">
            <el-button type="text" size="small">编辑</el-button>
            <el-button type="text" size="small">发布</el-button>
            <el-button  type="text" size="small">预览</el-button>
            <el-button  type="text" size="small">数据</el-button>
            <el-button type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script>
import surverApi from '../../client/bll/apis/surver.js'
import commonFunc from '../../client/bll/apis/common/common.js'
export default {
  data () {
    return {
      tableData: [
        {
          title: '网购消费者的行为调查',
          status: '未发布',
          dataNum: 0,
          date: '2019-02-04'
        },
        {
          title: '大学生在校消费调查表',
          status: '未发布',
          dataNum: 0,
          date: '2019-02-04'
        },
        {
          title: '计算机学院毕业设计要求调查表',
          status: '未发布',
          dataNum: 0,
          date: '2019-02-04'
        },
        {
          title: '大学生网络调查',
          status: '未发布',
          dataNum: 0,
          date: '2019-02-04'
        }
      ],
      cardIcon: 'icon1Click',
      tableIcon: 'icon2',
      indexitem: 0,
      show: 'status',
      show2: 'card', // 控制是列表还是卡片模式
      searchData: '',
      timeValue: '',
      timeOptions: [
        {
          value: 'week',
          label: '过去一周内'
        },
        {
          value: 'month',
          label: '过去一个月内'
        },
        {
          value: 'year',
          label: '过去一个年内'
        }
      ]
    }
  },
  methods: {
    // 新建问卷
    async creatQues () {
      let userInfor = JSON.parse(commonFunc.getLocalStorage('userInfo'))
      let res = await surverApi.add(userInfor.userId)
      if (res.code === 0) {
        commonFunc.setLocalStorage('contentClass', 'ques-content')
        commonFunc.setLocalStorage('showQuesStep', true)
        commonFunc.setLocalStorage('menuActiveIndex', 'newQues')
        commonFunc.setLocalStorage('submenuActiveIndex', 'creat')
        this.$router.push({name: 'creat', query: {surverId: res.data.surverId}})
      }
    },
    showOption (index) {
      this.indexitem = index
      this.show = 'option'
    },
    showStatus () {
      // this.indexitem = index
      this.show = 'status'
    },
    showCard () {
      this.cardIcon = 'icon1Click'
      this.tableIcon = 'icon2'
      this.show2 = 'card'
    },
    showTable () {
      this.cardIcon = 'icon1'
      this.tableIcon = 'icon2Click'
      this.show2 = 'table'
    }

  }
}
</script>
<style lang="scss" scoped>
.myQues{
    height: 100%;
    overflow: auto;
  // display: flex;
  .icon1:hover{
    color:#2672FF;
  }
  .icon2:hover{
    color:#2672FF;
  }
  

  .myQues-header{
    display: flex;
    text-align: left;
    width: 45%;
    // margin: 0 auto;
    height: 1rem;
    align-items: center;
    color: #D8D8D8;
    font-size: 0.28rem;
    .select{
      // flex:5;
      margin-left: 0.2rem;
    }
    .icon1Click {
      color: #2672ff;
      margin-left: 0.25rem;
    }
    .icon2Click {
      color: #2672ff;
      margin-left: 0.1rem;
    }
    .icon1{
      // flex:1;
      color: #D8D8D8;
      margin-left: 0.25rem;
    }
    .icon2{
      color: #D8D8D8;
      margin-left: 0.1rem;
    }
    .input{
      // flex:5;
      margin-left: 0.2rem;
    }
  }
  .myQues-body-table{
     width: 95%;
     margin: 0 auto;
  }
  .myQues-body-card{
    width: 95%;
    display: flex;
    flex-wrap: wrap;
    margin:  0 auto;
    .creatQues{
      margin-right: 0.25rem;
      width: 2.8rem;
      height: 2rem;
      // border: 1px solid black;
      box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
      border-radius: 4px;
      background: #ffffff;
      border: 1px solid #ebeef5;
      text-align: center;
      line-height: 2rem;
      // .box-card{
      //   width: 100%;
      //   height: 100%;
      //   .card-container{
      //     text-align: center;
      //     line-height: 1.5rem;
      //   }
      // }
    }
    
  }
  .creatQues:hover {
      border: 2px solid #2672FF;
      border-radius: 4px;
    }
    .questions:hover {
      border: 2px solid #2672FF;
      border-radius: 4px;
    }
  .questions{
      margin-bottom: 0.2rem;
      margin-right: 0.25rem;
      width: 2.8rem;
      height: 2rem;
      // border: 1px solid black;
      box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
      border-radius: 4px;
      background: #ffffff;
      border: 1px solid #ebeef5;
      // text-align: center;
      // line-height: 2rem;
    .card-container{
      width: 90%;
      margin: 0 auto;
      .card-icon {
        width: 0.4rem;
        height: 0.2rem;
        line-height: 0.2rem;
        background: #2672FF;
        font-size: 0.12rem;
        color: #ffffff;
        border-bottom-right-radius:0.03rem;
        border-bottom-left-radius:0.03rem;
      }
      .card-title{
        color: #434A5D;
        font-size:0.16rem;
        text-align: left;
        margin-top:0.2rem;
      }
      .card-time{
        color: #ADADAD;
        font-size:0.14rem;
        text-align: left;
        margin-top:0.1rem;
      }
      .card-footer{
        display: flex;
        // margin-bottom: 0.2rem;
        margin-top:0.7rem;
        .card-num{
          color: #ADADAD;
          font-size:0.14rem;
          width: 50%;
          text-align: left;
        }
        .card-status{
          color: #FFD471;
          font-size:0.14rem;
          width: 50%;
          text-align: right;
        }
      }
      .card-footer-Option{
        display: flex;
        margin-top:0.7rem;
        font-size: 0.16rem;
        .item{
          flex: 1;
          font-size: 0.14rem;
        }
      }
    }
    
  }
  
}

</style>
