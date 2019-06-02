<template>
 <div class="releaseQues">
   <!-- 控制内层的宽度和高度 -->
   <div class="releaseQues-container">
     <div class="QRcode">
        <img :src="imageUrl" alt="" style="width:100%" id="QRimg">
      </div>
      <div class="option">
        <div class="link">
          <p class="link-url">{{linkUrl + surverId}}</p>
          <el-button plain size="smalll"
          v-clipboard:copy="linkUrl + surverId"
          v-clipboard:success="onCopy"
          v-clipboard:error="onError">复制</el-button>
          <el-button plain size="smalll" @click="openNewTab">打开</el-button>
        </div>
        <div class="downloadQR">
          <!-- <el-button plain size="smalll" @click="downloadQR">下载二维码</el-button> -->
        </div>
      </div>
   </div>
  </div>
</template>
<script>
import commonFunc from '../../client/bll/apis/common/common'
import surverApi from '../../client/bll/apis/surver'
export default {
  data () {
    return {
      linkUrl: 'http://101.132.106.184/#/fill/',
      surverId: '123',
      imageUrl: '',
      releaseFlag: false
    }
  },
  async mounted () {
    this.imageUrl = commonFunc.getLocalStorage('currentQR')
    this.surverId = this.$route.query.surverId
    await this.search()
    if (!this.releaseFlag) {
      await this.getQRcode()
    }
  },
  methods: {
    downloadQR () {
      // this.downloadIamge(this.imageUrl, 'pic')
      // let clipboard = new Clipboard('#QRimg')
    },
    downloadIamge (imgsrc, name) {
      var image = new Image()
      // 解决跨域 Canvas 污染问题
      image.setAttribute('crossOrigin', 'anonymous')
      image.onload = function () {
        var canvas = document.createElement('canvas')
        canvas.width = image.width
        canvas.height = image.height
        var context = canvas.getContext('2d')
        context.drawImage(image, 0, 0, image.width, image.height)
        var url = canvas.toDataURL('image/png') // 得到图片的base64编码数据
        var a = document.createElement('a') // 生成一个a元素
        var event = new MouseEvent('click') // 创建一个单击事件
        a.download = name || 'photo' // 设置图片名称
        a.href = url // 将生成的URL设置为a.href属性
        a.dispatchEvent(event) // 触发a的单击事件
      }
      image.src = imgsrc
    },
    async search () {
      let res = await surverApi.search(this.surverId)
      if (res.code === 0) {
        if (res.data[0].surverQrnum !== null) {
          this.releaseFlag = true
        }
      }
    },
    async getQRcode () {
      // this.surverId = this.$route.query.surverId
      let params = {
        url: 'http://101.132.106.184/#/fill/' + this.surverId
      }
      let res = await surverApi.getQRcodeImage(params)
      if (res.code === 0) {
        let url = 'http://101.132.106.184:8080/QR/' + res.data
        this.imageUrl = url
        commonFunc.setLocalStorage('currentQR', url)
        await this.updateQR(res.data)
      }
    },
    async updateQR (img) {
      let params = {
        surverId: this.surverId,
        QRNum: img
      }
      let res = await surverApi.updateQRNum(params)
      if (res.code === 0) {
        console.log(res.data)
      }
    },
    // copyUrl () {
    //   var input = document.getElementById('input')
    //   input.value = (this.linkUrl + this.surverId) // 修改文本框的内容
    //   input.select() // 选中文本
    //   document.execCommand('copy') // 执行浏览器复制命令
    //   commonFunc.showMessage('复制成功', 'success')
    // },
    onCopy () {
      commonFunc.showMessage('复制成功', 'success')
    },
    onError () {
      commonFunc.showMessage('复制失败', 'error')
    },
    openNewTab () {
      // let url = this.linkUrl + this.surverId
      // window.open(url)
      let routeData = this.$router.resolve({path: '/fill/' + this.surverId})
      window.open(routeData.href, '_blank')
      // this.$router.push({path: '/fill/' + this.surverId})
    }
  }
}
</script>
<style lang="scss" scoped>
#input{
  display: none;
}
.releaseQues{
  width: 100%;
  height: 90%;
  padding-top: 0.2rem;
  .releaseQues-container {
    width: 90%;
    margin: 0 auto;
    height: 50%;
    background: #ffffff;
    display: flex;
    align-items: center;
    justify-content: center;
    .QRcode{
      width: 1.5rem;
      height: 1.5rem;
      // line-height: 50%;
    }
    .link{
      margin-left: 0.1rem;
      display: flex;
      .link-url{
        text-align: left;
        padding-left: 0.1rem;
        width:3.3rem;
        height: 0.4rem;
        border: 1px solid #E1E7F2;
        border-radius: 0.04rem;
        line-height: 0.4rem;
        background-color: #F6F6F6;
      }
    }
    .downloadQR {
      text-align: left;
      margin-left: 0.1rem;
      margin-top: 0.2rem;
    }
  }
  
}
</style>
