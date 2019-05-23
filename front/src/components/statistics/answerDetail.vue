<template>
  <div class="answerDetail">
    <div class="tableArea">
      <el-table
        :data="answerData"
        stripe
        style="width: 100%">
        <el-table-column
          align="center"
          prop="index"
          label="编号"
          width="200">
        </el-table-column>
        <el-table-column
          prop="startTime"
          label="开始答题时间"
          width="280">
        </el-table-column>
        <el-table-column
          prop="endTime"
          label="结束答题时间"
          width="280">
        </el-table-column>
        <el-table-column
          prop="time"
          label="答题时长"
          width="250">
        </el-table-column>
        <el-table-column
          align="center"
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
            <el-button type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination 
        style="text-align:right;margin-top:0.1rem;"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[5, 10 ,20]"
        :page-size="5"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>
<script>
import commonFunc from '../../client/bll/apis/common/common'
import participatenApi from '../../client/bll/apis/participate'
export default {
  props: ['surverStaticData'],
  data () {
    return {
      answerData: [],
      pageNum: 1,
      pageSize: 5,
      pageData: '',
      total: 0
    }
  },
  async mounted () {
    await this.getAllByPage()
  },
  methods: {
    async getAllByPage () {
      let params = {
        surverId: this.$route.query.surverId,
        pageNum: this.pageNum,
        pageSize: this.pageSize
      }
      let res = await participatenApi.getAllByPage(params)
      if (res.code === 0) {
        this.pageData = res.data.list
        this.total = res.data.total
        this.randerTableData()
      }
    },
    randerTableData () {
      this.answerData = []
      let i = 1
      for (let item of this.pageData) {
        let part = {
          index: 0,
          startTime: '',
          endTime: '',
          time: '',
          id: ''
        }
        part.index = i
        part.startTime = commonFunc.formateDate(item.participateStarttime)
        part.endTime = commonFunc.formateDate(item.participateEndtime)
        part.time = commonFunc.computedTime(item.participateEndtime - item.participateStarttime)
        part.id = item.participateId
        i++
        this.answerData.push(JSON.parse(JSON.stringify(part)))
      }
    },
    async handleSizeChange (val) {
      this.pageSize = val
      await this.getAllByPage()
      console.log(`每页 ${val} 条`)
    },
    async handleCurrentChange (val) {
      this.pageNum = val
      await this.getAllByPage()
      console.log(`当前页: ${val}`)
    }
  }
}
</script>
<style lang="scss" scoped>
.answerDetail {
  width: 100%;
  height: 100%;
  .tableArea{
    padding: 0.2rem;
    background: #ffffff;
  }
}
</style>
