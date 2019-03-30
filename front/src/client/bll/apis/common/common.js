// 用方法和变量封装
import Vue from 'vue'
// import { Toast, Indicator } from 'mint-ui'
const commonFunc = {
  // 全局统一控制打印log日志--部署版本前请务必注释打印代码
  myConsole(logObj) {
    // console.log(logObj)
  },
  // 全局统一 debugger --部署版本前请务必注释该行
  myDebugger() {
    // debugger
  },
  // 判断是否定义或存在
  isDefine(para) {
    let paraType = typeof para
    if (
      para === 'undefined' ||
      para === 'null' ||
      para === '' ||
      para === '[]' ||
      para === null ||
      para === undefined
    ) {
      return false
    } else if (
      paraType === 'number' ||
      paraType === 'object' ||
      paraType === 'string' ||
      paraType === 'function' ||
      paraType === 'boolean'
    ) {
      return true
    } else {
      for (var o in para) {
        return true
      }
      return false
    }
  },
  // 隐藏 loading
  // hideLoading() {
  //   Indicator.close()
  // },
  // 显示 loading
  // showLoading() {
  //   Indicator.open()
  // },
  // 显示提示
  // showToast(msg, position) {
  //   Toast({
  //     message: msg,
  //     position: position,
  //     duration: 2000
  //   })
  // },
  // 获取元素是否存在或数组中的定位
  getArrayIndexByValue(val, ArrayObj) {
    for (var i = 0; i < ArrayObj.length; i++) {
      if (ArrayObj[i].originId === val.originId) {
        return i
      }
    }
    return -1
  },
  // 根据元素值在数组中删除某个元素
  arrayRemoveByValue(val, ArrayObj) {
    var index = this.getArrayIndexByValue(val, ArrayObj)
    if (index > -1) {
      ArrayObj.splice(index, 1)
    }
    return ArrayObj
  },
  /** *
    实现通过localStorage对本地数据进行存取 anna;
   * **/
  //将数据存储在本地
  setLocalStorage(key, value) {
    window.localStorage.setItem(key, value)
  },
  //取出存在本地的数据
  getLocalStorage(key) {
    return window.localStorage.getItem(key)
  },
  //删除本地的数据
  removeLocalStorage(key) {
    return window.localStorage.removeItem(key)
  }
}

export default commonFunc
