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
        :page-sizes="[5, 10]"
        :page-size="5"
        layout="total, sizes, prev, pager, next, jumper"
        :total="10">
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
          startTime: '2019-05-11 12:39:59',
          endTime: '2019-03-30 12:40:21',
          time: '0分22秒'
        },
        {
          id: 2,
          startTime: '2019-05-11 15:11:20',
          endTime: '2019-05-11 15:11:42',
          time: '0分22秒'
        },
        {
          id: 3,
          startTime: '2019-05-11 21:19:59',
          endTime: '2019-05-11 21:20:18',
          time: '0分19秒'
        },
        {
          id: 4,
          startTime: '2019-05-11 22:05:01',
          endTime: '2019-05-11 22:05:21',
          time: '0分20秒'
        },
        {
          id: 5,
          startTime: '2019-05-12 8:05:05',
          endTime: '2019-05-12 8:05:23',
          time: '0分18秒'
        },
        {
          id: 6,
          startTime: '2019-05-12 13:16:23',
          endTime: '2019-05-12 13:16:44',
          time: '0分21秒'
        },
        {
          id: 7,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        },
        {
          id: 8,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        },
        {
          id: 9,
          startTime: '2019-03-30 21:39:59',
          endTime: '2019-03-30 21:40:21',
          time: '0分49秒'
        },
        {
          id: 10,
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
