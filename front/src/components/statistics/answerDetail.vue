<template>
  <div class="answerDetail">
    <div class="tableArea">
      <el-table
        :data="answerData"
        stripe
        style="width: 100%">
        <el-table-column
          align="center"
          prop="id"
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
        :current-page="currentPage"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="40">
      </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      answerData: [
        {
          id: 1,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        },
        {
          id: 1,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        },
        {
          id: 1,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        },
        {
          id: 1,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        }
      ],
      currentPage: 1
    }
  },
  methods: {
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange (val) {
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
