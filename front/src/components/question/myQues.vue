<template>
  <div class="myQues">
    <div class="myQues-header">
      <i :class="'el-icon-menu '+cardIcon" @click="showCard"></i>
      <i :class="'el-icon-tickets '+ tableIcon" @click="showTable"></i>
      <el-select class="select" v-model="surverType" placeholder="请选择" size="small" @change="selectSurverType">
        <el-option 
          v-for="item in dynamicTags"
          :key="item.survertypeId"
          :label="item.survertypeName"
          :value="item.survertypeId">
        </el-option>
      </el-select>
      <el-input class="input" v-model="searchData"  suffix-icon="el-icon-search" size="small" placeholder="问卷标题"></el-input>
      <el-button @click="resetSurverData" type="primary" size="small" style="background: #2672FF;margin-left:0.2rem;" >重置</el-button>
      <el-button @click="creatQues" type="primary" icon="el-icon-circle-plus" size="small" style="background: #2672FF;margin-left:0.2rem;" v-show="show2 === 'table'">新建问卷</el-button>
      
    </div>
    <div class="myQues-body-card" v-show="show2 === 'card'">
      <div class="creatQues" @click="creatQues">
          <div class="card-container">
            <i class="el-icon-circle-plus"></i>
            新建
          </div>
      </div>
      <div class=" questions" @mouseover="showOption(index)" @mouseout="showStatus(index)" v-for="(item, index) in surversData" :key="item.key">
          <div class="card-container">
            <div class="card-icon">{{item.surverTypeName}}</div>
            <div class="card-title">{{item.surverTitle}}</div>
            <div class="card-time">{{item.surverCreattime}}</div>
            <div class="card-footer" v-show="show === 'status' || indexitem !== index ">
              <div class="card-num">{{item.surverRecovernum}}份数据</div>
              <div class="card-status">{{item.surverPulishstarttime}}</div>
            </div>
            <div class="card-footer-Option" v-show="show === 'option' && indexitem === index ">
              <div class="item" @click="editSurver(item.surverId)"><i class="el-icon-edit-outline"></i><br/>编辑</div>
              <div class="item"><i class="el-icon-upload"></i><br/>发布</div>
              <div class="item"><i class="el-icon-view"></i><br/>预览</div>
              <div class="item"><i class="el-icon-document"></i><br/>数据</div>
              <div class="item" @click="showDeleteDialog(item.surverId)"><i class="el-icon-delete"></i><br/>删除</div>
            </div>
          </div>
      </div>
    </div>
    <div class="myQues-body-table" v-show="show2 === 'table'">
      <el-table
        :data="surversData"
        stripe
        style="width: 100%">
        <el-table-column
          fixed
          align='left'
          prop="surverTitle"
          label="问卷标题"
          width="450">
        </el-table-column>
        <el-table-column
          prop="surverTypeName"
          align='center'
          label="分类"
          width="120">
        </el-table-column>
        <el-table-column
          prop="surverPulishstarttime"
          align='center'
          label="状态"
          width="100">
        </el-table-column>
        <el-table-column
          prop="surverRecovernum"
          align='center'
          label="收到数据"
          width="100">
        </el-table-column>
        <el-table-column
          prop="surverCreattime"
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
            <el-button type="text" size="small" @click="editSurver(scope.row.surverId)">编辑</el-button>
            <el-button type="text" size="small">发布</el-button>
            <el-button  type="text" size="small">预览</el-button>
            <el-button  type="text" size="small">数据</el-button>
            <el-button type="text" size="small" @click="showDeleteDialog(scope.row.surverId)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
      title="删除提醒"
      :visible.sync="deleteSuverVisible"
      width="30%"
      >
      <span>确定要删除该问卷吗？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="deleteSuverVisible = false">取 消</el-button>
        <el-button type="primary" @click="deleteSurver">确 定</el-button>
      </span>
  </el-dialog>
  <el-dialog
      title="问卷类型"
      :visible.sync="surverTypeVisible"
      width="50%"
      >
      <el-tag
        :key="tag.survertypeId"
        v-for="tag in dynamicTags"
        closable
        :disable-transitions="false"
        @close="handleClose(tag)">
        {{tag.survertypeName}}
      </el-tag>
      <el-input
        class="input-new-tag"
        v-if="inputVisible"
        v-model="inputValue"
        ref="saveTagInput"
        size="small"
        @keyup.enter.native="handleInputConfirm"
        @blur="handleInputConfirm"
      >
      </el-input>
      <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
      <span slot="footer" class="dialog-footer">
        <el-button @click="surverTypeVisible = false">取 消</el-button>
        <el-button type="primary" >确 定</el-button>
      </span>
  </el-dialog>
  </div>
</template>
<script>
import surverTypeApi from '../../client/bll/apis/surverType.js'
import surverApi from '../../client/bll/apis/surver.js'
import commonFunc from '../../client/bll/apis/common/common.js'
import questionApi from '../../client/bll/apis/question'
export default {
  data () {
    return {
      // tableData: [
      //   {
      //     title: '网购消费者的行为调查',
      //     status: '未发布',
      //     dataNum: 0,
      //     date: '2019-02-04'
      //   },
      //   {
      //     title: '大学生在校消费调查表',
      //     status: '未发布',
      //     dataNum: 0,
      //     date: '2019-02-04'
      //   },
      //   {
      //     title: '计算机学院毕业设计要求调查表',
      //     status: '未发布',
      //     dataNum: 0,
      //     date: '2019-02-04'
      //   },
      //   {
      //     title: '大学生网络调查',
      //     status: '未发布',
      //     dataNum: 0,
      //     date: '2019-02-04'
      //   }
      // ],
      surverTypeVisible: false,
      inputVisible: false,
      inputValue: '',
      dynamicTags: [],
      deleteSuverVisible: false, // 问卷删除提醒dialog
      deleteSurverId: '',
      cardIcon: 'icon1Click',
      tableIcon: 'icon2',
      indexitem: 0,
      show: 'status',
      show2: 'card', // 控制是列表还是卡片模式
      searchData: '',
      surverType: '',
      surversData: []
    }
  },
  async beforeRouteUpdate (to, from, next) {
    await this.getSurvers()
    await this.getAllSurverTypes()
    next()
  },
  async mounted () {
    await this.getSurvers()
    await this.getAllSurverTypes()
  },
  methods: {
    /**
     * 重置搜索和筛选条件
     */
    async resetSurverData () {
      this.surverType = ''
      await this.getSurvers()
    },
    /**
     * 根据分类筛选问卷
     */
    async selectSurverType () {
      debugger
      let res = await surverApi.selectBySurverType(this.surverType)
      if (res.code === 0) {
        this.surversData = res.data
        await this.rederData()
      }
    },
    async handleClose (tag) {
      let params = {
        id: tag.survertypeId
      }
      let res = await surverTypeApi.delete(params)
      if (res.code === 0) {
        commonFunc.showMessage('删除成功', 'success')
        await this.getAllSurverTypes()
      }
      // this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
    },
    showInput () {
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },
    async handleInputConfirm () {
      let inputValue = this.inputValue
      if (inputValue) {
        let params = {
          name: this.inputValue,
          userId: JSON.parse(commonFunc.getLocalStorage('userInfo')).userId
        }
        let res = await surverTypeApi.add(params)
        if (res.code === 0) {
          // this.dynamicTags.push(inputValue)
          commonFunc.showMessage('新增成功', 'success')
          await this.getAllSurverTypes()
        }
        this.inputVisible = false
        this.inputValue = ''
      }
    },
    /**
     * 根据问卷id删除问卷
     */
    async deleteSurver () {
      this.deleteSuverVisible = false
      let res = await questionApi.deleteBySueverId(this.deleteSurverId)
      let res1 = await surverApi.deleteById(this.deleteSurverId)
      if (res.code === 0 && res1.code === 0) {
        await this.getSurvers()
      }
    },
    showDeleteDialog (id) {
      this.deleteSurverId = id
      this.deleteSuverVisible = true
    },
    /**
     * 根据问卷id修改问卷
     */
    editSurver (id) {
      commonFunc.setLocalStorage('contentClass', 'ques-content')
      commonFunc.setLocalStorage('showQuesStep', true)
      commonFunc.setLocalStorage('menuActiveIndex', 'newQues')
      commonFunc.setLocalStorage('submenuActiveIndex', 'creat')
      this.$router.push({name: 'edit', query: {surverId: id}})
    },
    async getSurvers () {
      let userId = JSON.parse(commonFunc.getLocalStorage('userInfo')).userId
      let res = await surverApi.searchByuserId(userId)
      if (res.code === 0) {
        this.surversData = res.data
        await this.rederData()
      }
      // console.log(res)
    },
    async rederData () {
      // eslint-disable-next-line
      Date.prototype.toLocaleString = function () {
        return this.getFullYear() + '-' + (this.getMonth() + 1) + '-' + this.getDate() + ' ' + this.getHours() + ':' + this.getMinutes() + ':' + this.getSeconds()
      }
      for (let item of this.surversData) {
        if (item.surverPulishstarttime === null) {
          item.surverPulishstarttime = '未发布'
        } else {
          item.surverPulishstarttime = '已发布'
        }
        var unixTimestamp = new Date(item.surverCreattime)
        let commonTime = unixTimestamp.toLocaleString()
        item.surverCreattime = commonTime
        // alert(commonTime)
        let res = await surverTypeApi.selectById(item.survertypeId)
        if (res.code === 0) {
          if (res.data.length >= 1) {
            item.surverTypeName = res.data[0].survertypeName
          } else {
            item.surverTypeName = ''
          }
        }
      }
    },
    async getAllSurverTypes () {
      let params = {
        userId: JSON.parse(commonFunc.getLocalStorage('userInfo')).userId
      }
      let res = await surverTypeApi.getAll(params)
      if (res.code === 0) {
        this.dynamicTags = res.data
      }
    },
    // 新建问卷
    async creatQues () {
      this.surverTypeVisible = true
      await this.getAllSurverTypes()
      // let userInfor = JSON.parse(commonFunc.getLocalStorage('userInfo'))
      // let res = await surverApi.add(userInfor.userId)
      // if (res.code === 0) {
      //   commonFunc.setLocalStorage('contentClass', 'ques-content')
      //   commonFunc.setLocalStorage('showQuesStep', true)
      //   commonFunc.setLocalStorage('menuActiveIndex', 'newQues')
      //   commonFunc.setLocalStorage('submenuActiveIndex', 'creat')
      //   this.$router.push({name: 'creat', query: {surverId: res.data.surverId}})
      // }
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
 .el-tag + .el-tag {
    margin-left: 10px;
  }
  .button-new-tag {
    margin-left: 10px;
    height: 32px;
    line-height: 30px;
    padding-top: 0;
    padding-bottom: 0;
  }
  .input-new-tag {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
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
        // width: 0.4rem;
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
