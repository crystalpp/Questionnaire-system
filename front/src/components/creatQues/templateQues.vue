<template>
  <div class="templateQues">
    <el-container>
      <el-aside >
        <div class="aside-container">
          <div class="title">模板分类</div>
          <div class="line"></div>
          <div class="classfiyList">
            <ul>
              <li :class="currentClass" @click="selectTemplate">全部</li>
            </ul>
            <ul v-for="(item,index) in templateSurverTypes" :key="item.survertypeId">
              <!-- <li>全部</li> -->
              <li @click="selectTemplateByType(index,item)" :class="currentIndex===index?'clickClass':'noClickClass'">{{item.survertypeName}}</li>
            </ul>
          </div>
        </div>
      </el-aside>
      <el-main>
        <div class="main-container">
          <div class="oneItem" v-for="(item) in templateSurvers" :key="item.surverId">
            <div class="line"></div>
            <div class="text">
              <div class="text1">{{item.surverTitle}}</div>
              <div class="text2" @click="previewTemplate(item)"><i class="el-icon-view"></i> 预览</div>
            </div>
          </div>
        </div>
      </el-main>
    </el-container>
  </div>
</template>
<script>
import surverTypeApi from '../../client/bll/apis/surverType'
import surverApi from '../../client/bll/apis/surver'
export default {
  data () {
    return {
      templateSurverTypes: [],
      currentIndex: '',
      currentClass: 'clickClass',
      templateSurvers: []
    }
  },
  async mounted () {
    await this.selectTemplateType()
    await this.selectTemplate()
  },
  methods: {
    previewTemplate (item) {
      this.$router.push({name: 'preview', query: {surverId: item.surverId}})
    },
    /**
     * 查找不同分类的模板
     */
    async selectTemplateByType (index, item) {
      this.currentIndex = index
      this.currentClass = 'noClickClass'
      let res = await surverApi.getTemplate(item.survertypeId)
      if (res.code === 0) {
        this.templateSurvers = res.data
      }
    },
    /**
     * 查找所有的模板问卷类型
     */
    async selectTemplateType () {
      let res = await surverTypeApi.selectTemplateType()
      if (res.code === 0) {
        this.templateSurverTypes = res.data
      }
    },
    /**
     * 查找所有的模板问卷
     */
    async selectTemplate () {
      this.currentClass = 'clickClass'
      this.currentIndex = ''
      let res = await surverApi.getTemplate('')
      if (res.code === 0) {
        this.templateSurvers = res.data
      }
    }
    // async getAllSurverTypes () {
    //   let params = {
    //     userId: JSON.parse(commonFunc.getLocalStorage('userInfo')).userId
    //   }
    //   let res = await surverTypeApi.getAll(params)
    //   if (res.code === 0) {
    //     this.dynamicTags = res.data
    //   }
    // }
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
      .clickClass {
        color: #409eff;
        background: #ecf5ff;
        border-color: #b3d8ff;
      }
      .noClickClass {
        color: #222222;
        background: white;
        border: none;
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
          cursor: pointer;
          text-align: center;
          flex:1;
        }
      }
    }
  }
}
</style>
