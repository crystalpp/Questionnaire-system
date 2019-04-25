<template>
  <div class="myQues">
    <div class="myQues-header">
      <i class="el-icon-menu icon1"></i>
      <i class="el-icon-tickets icon2"></i>
      <el-select class="select" v-model="timeValue" placeholder="请选择" size="small">
        <el-option 
          v-for="item in timeOptions"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <el-input class="input" v-model="searchData"  suffix-icon="el-icon-search" size="small" placeholder="问卷标题"></el-input>
    </div>
    <div class="myQues-body">
      <div class="creatQues" >
          <div class="card-container">
            <i class="el-icon-circle-plus"></i>
            新建
          </div>
      </div>
      <div class=" questions" >
          <div class="card-container">
            <div class="card-icon">问卷</div>
            <div class="card-title">大学生消费调查</div>
            <div class="card-time">2018-02-04</div>
            <div class="card-footer">
              <div class="card-num">0份数据</div>
              <div class="card-status">未发布</div>
            </div>
          </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
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
  }
}
</script>
<style lang="scss" scoped>
.myQues{
  // display: flex;
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
    .icon1{
      // flex:1;
      margin-left: 0.25rem;
    }
    .icon2{
      margin-left: 0.1rem;
    }
    .input{
      // flex:5;
      margin-left: 0.2rem;
    }
  }
  .myQues-body{
    width: 95%;
    display: flex;
    flex-wrap: wrap;
    margin:  0 auto;
    .creatQues{
      margin-right: 0.25rem;
      width: 3rem;
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
  .creatQues :hover {
      border: 2px solid #2672FF;
      border-radius: 4px;
    }
  .questions{
      margin-right: 0.25rem;
      width: 3rem;
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
    }
    
  }
  
}

</style>
