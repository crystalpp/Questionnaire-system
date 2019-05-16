<template>
  <div class="templateQues">
    <el-container>
      <el-aside >
        <div class="aside-container">
          <div class="title">模板分类</div>
          <div class="line"></div>
          <div class="classfiyList">
            <ul>
              <li>全部</li>
              <li>新生调查</li>
              <li>毕业生调查</li>
              <li>应届毕业生调查</li>
              <li>计算机科学与技术系</li>
              <li>软件工程系</li>
              <li>物联网工程系</li>
            </ul>
          </div>
        </div>
      </el-aside>
      <el-main>
        <div class="main-container">
          <div class="oneItem">
            <div class="line"></div>
            <div class="text">
              <div class="text1">计算机学院新生入学调查问卷</div>
              <div class="text2"><i class="el-icon-view"></i> 预览</div>
            </div>
          </div>
          <div class="oneItem">
            <div class="line"></div>
            <div class="text">
              <div class="text1">计算机科学与技术专业毕业生问卷调查</div>
              <div class="text2"><i class="el-icon-view"></i> 预览</div>
            </div>
          </div>
          <div class="oneItem">
            <div class="line"></div>
            <div class="text">
              <div class="text1">计算机学院应届毕业生调查</div>
              <div class="text2"><i class="el-icon-view"></i> 预览</div>
            </div>
          </div>
          <div class="oneItem">
            <div class="line"></div>
            <div class="text">
              <div class="text1">计算机学院往届毕业生调查</div>
              <div class="text2"><i class="el-icon-view"></i> 预览</div>
            </div>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
export default {
  data () {
    return {
    }
  }
}
</script>
<style lang="scss" scoped>
.el-main {
    background-color: #FFFFFF;
    color: #333;
    // text-align: center;
    // line-height: 160px;
    height: 100%;
  }
.el-aside {
    // width: 0.5rem;
    background-color: #FAFAFA;
    color: #333;
    text-align: left;
    height: 100%;
    // line-height: 200px;
  }
  .el-container {
    padding: 0.2rem;
    // background: #FAFAFA;
    // border-radius: 1rem;
    width: 100%;
    height: 100%;
    // padding-top: 0.63rem;
  }
.templateQues{
  width: 100%;
  height: 100%;
  .aside-container{
    // padding: 0.2rem;
    border-top: 1px solid #DEDFE0;
    // border-left: 1px solid #DEDFE0;
    // border-right: 1px solid #DEDFE0;
    border-radius: 0.04rem;
    .title{
      // text-align: center;
      line-height: 0.52rem;
      font-size: 0.14rem;
      color: #999999;
      padding-left: 0.5rem;
    }
    .line{
      width: 100%;
      height: 0.01rem;
      background: #DEDFE0;
      margin-bottom: 0.2rem;
    }
    .classfiyList{
      padding-left: 0.3rem;
      ul{
        list-style: none;
        li{
          padding: 0.1rem;
          cursor: pointer;
          color: #222222;
        }
      }
      // text-align: center;
    }
  }
  .main-container{
    // border-top: 1px solid #DEDFE0;
    // border-left: 1px solid #DEDFE0;
    // border-right: 1px solid #DEDFE0;
    border-radius: 0.04rem;
    .oneItem{
      padding-bottom: 0.2rem;
      width: 95%;
      margin: 0 auto;
      .line{
        width: 100%;
        height: 0.01rem;
        background: #DEDFE0;
        margin-bottom: 0.2rem;
      }
      .text{
        font-size: 0.16rem;
        display: flex;
        .text1{
          flex: 5;
          text-align: left;
        }
        .text2{
          text-align: center;
          flex:1;
        }
      }
    }
  }
}
</style>
