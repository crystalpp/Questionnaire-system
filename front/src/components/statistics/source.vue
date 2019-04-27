<template>
  <div class="statis-source">
    <!-- 数据总览 -->
    <div class="dataScreening">
      <div class="item">
        <p class="title">有效回收量</p>
        <p class="num">5</p>
      </div>
      <div class="item">
        <p class="title">浏览量</p>
        <p class="num">5</p>
      </div>
      <div class="item">
        <p class="title">平均答题时间</p>
        <p class="num">1分20秒</p>
      </div>
      <div class="item">
        <p class="title">回收率</p>
        <p class="num">50%</p>
      </div>
    </div>
    <!-- 每日回答情况（散点图）和回答者地域（中国地图）分布 -->
    <div class="part1">
      <el-row :gutter="20">
        <el-col :span="16">
          <div class="grid-content bg-purple answerSituation">
            <div class="title">
              <p class="text">回答情况</p>
              <div class="dateChoose">
                <el-date-picker style="width: 2rem"
                  v-model="anserTimeRange"
                  type="daterange"
                  range-separator="-"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
                </el-date-picker>
                <el-select v-model="timeType" placeholder="请选择" style="width: 1rem">
                  <el-option
                    v-for="item in timeOption"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                  </el-option>
                </el-select>
              </div>
              
            </div>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="grid-content bg-purple">
            
          </div>
        </el-col>
      </el-row>
    </div>
    <!-- 回到者所使用的操作系统，设备类型（使用柱状图） -->
    <div class="part2">2222</div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      anserTimeRange: '', // 查看答题人数的时间范围
      timeType: '', // 查看时间点的类型
      timeOption: [
        {
          value: 'day',
          label: '按天'
        },
        {
          value: 'week',
          label: '按周'
        },
        {
          value: 'year',
          label: '按月'
        }
      ]
    }
  }
}
</script>
<style lang="scss" scoped>
.el-row {
    margin-bottom: 0.2rem;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 0.04rem;
  }
  .bg-purple {
    background: #ffffff;
  }
  .grid-content {
    border-radius: 0.04rem;
    min-height: 0.36rem;
    height: 5.2rem;
  }
  .row-bg {
    padding: 0.1rem 0;
    background-color: #f9fafc;
  }
.statis-source{
  width: 100%;
  height: 100%;
  .dataScreening{
    display: flex;
    align-items: center;
    background: #E9EEF3;
    width: 90%;
    margin: 0 auto;
    .item{
      margin-top: 0.35rem;
      flex:1;
      height: 0.75rem;
      .num{
        color: #0078C8;
        font-size: 0.24rem;
        // font-weight: bolder;
      }
      // line-height: 0.325rem;
    }
  }
  .part1{
    background: #E9EEF3;
    width: 90%;
    margin: 0 auto;
    .answerSituation{
      .title{
        padding:0.2rem;
        display: flex;
        .text{
          flex:1;
          text-align: left;
        }
        .dateChoose{
          flex: 3;
          // justify-content: flex-end;
          text-align: right;
        }
      }
    }
    // border-left: 1px solid #DBDBDB;
    // border-right: 1px solid #DBDBDB;
    // border-top: 1px solid #DBDBDB;
  }
  .part2{
    background: #E9EEF3;
    width: 90%;
    margin: 0 auto;
    // border-left: 1px solid #DBDBDB;
    // border-right: 1px solid #DBDBDB;
    // border-bottom: 1px solid #DBDBDB;
  }
}
</style>
