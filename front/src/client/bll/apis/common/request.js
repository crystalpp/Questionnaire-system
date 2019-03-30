/**
 * requestService用于与 Server Api 服务进行数据交换,
 * 军哥后面重新封装, 用于本项目将 ‘withCredentials’改为false
 */
import commonFunc from './common.js'
import qs from 'qs'
import getOptions from '../common/myinter.js'
import Vue from 'vue'

// axios.interceptors.response.use(
//   res => {
//     console.log(res)
//     return res
//   },
//   err => {
//     console.log(err)
//   }
// )
// 网络请求封装
const requestService = {
  /**
   * GET
   * @param  {object} optionsParams  相关参数传入
   * @param  {string} serverUrl  动态传入的获取数据的地址
   * @return {object}       结果
   */
  get: function(serverUrl, optionsParams) {
    commonFunc.myConsole('get optionsParams ===> ')
    commonFunc.myConsole(serverUrl)
    commonFunc.myConsole(optionsParams)
    let options = {
      method: 'get',
      url: serverUrl,
      // mode:'cors',
      headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
      },
      // timeout: 3600,
      // `withCredentials` indicates whether or not cross-site Access-Control requests
      // should be made using credentials
      withCredentials: false, // default: false

      // `params` are the URL parameters to be sent with the request
      // Must be a plain object or a URLSearchParams object
      params: optionsParams,
      paramsSerializer: params => {
        let getParamsStr = qs.stringify(params, { indices: false })
        if (optionsParams) {
          getParamsStr += '&t=' + Date.now()
        } else {
          getParamsStr += '?t=' + Date.now()
        }
        return getParamsStr
      }
    }
    commonFunc.showLoading()
    return new Promise((resolve, reject) => {
      Vue.axios(options)
        .then(resp => {
          // commonFunc.myConsole(resp)
          if (resp.data.code === 0) {
            // 成功正确的返回 -- resolve
            commonFunc.hideLoading()
            resolve(resp.data)
          } else {
            // 业务自定义错误码返回 -- reject
            commonFunc.hideLoading()
            resolve(resp.data)
          }
        })
        .catch(error => {
          // 服务器或网络错误码返回 -- reject
          // commonFunc.myConsole(error)
          commonFunc.hideLoading()
          resolve(error)
        })
    })
  },
  /**
   * POST
   * @param  {object} optionsParams   相关参数传入
   * @param  {string} serverUrl  动态传入的获取数据的地址
   * @return {object}       结果
   */
  post: function(serverUrl, optionsParams, formSubmission) {
    commonFunc.myConsole('post optionsParams ===> ')
    commonFunc.myConsole(serverUrl)
    commonFunc.myConsole(optionsParams)
    //
    let isForm =
      commonFunc.isDefine(formSubmission) && formSubmission === 'form'
    let options = {
      method: 'post',
      url: serverUrl,
      // mode:'cors',
      headers: {
        Accept: 'application/json',
        'Content-Type': isForm
          ? 'application/x-www-form-urlencoded'
          : 'application/json'
      },
      // timeout: 3600,
      // `withCredentials` indicates whether or not cross-site Access-Control requests
      // should be made using credentials -- web need set cookie
      withCredentials: false, // default: false

      // `data` is the data to be sent as the request body
      // Only applicable for request methods 'PUT', 'POST', and 'PATCH'
      data: isForm
        ? qs.stringify(optionsParams, { indices: false })
        : optionsParams
    }
    commonFunc.showLoading()
    return new Promise((resolve, reject) => {
      Vue.axios(options)
        .then(resp => {
          // commonFunc.myConsole(resp)
          if (resp.data.code === 0) {
            // 成功正确的返回 -- resolve
            // console.log(resp)
            commonFunc.hideLoading()
            resolve(resp.data)
          } else {
            // 业务自定义错误码返回 -- reject
            commonFunc.hideLoading()
            resolve(resp.data)
          }
        })
        .catch(error => {
          // 服务器或网络错误码返回 -- reject
          // commonFunc.myConsole(error)
          commonFunc.hideLoading()
          resolve(error)
        })
    })
  },
  /**
   * PATCH
   * @param  {object} optionsParams   相关参数传入
   * @param  {string} serverUrl  动态传入的获取数据的地址
   * @return {object}       结果
   */
  patch: function(serverUrl, optionsParams, formSubmission) {
    commonFunc.myConsole('patch optionsParams ===> ')
    commonFunc.myConsole(serverUrl)
    commonFunc.myConsole(optionsParams)
    // commonFunc.showLoading()
    let isForm =
      commonFunc.isDefine(formSubmission) && formSubmission === 'form'
    let options = {
      method: 'patch',
      url: serverUrl,
      // mode:'cors',
      headers: {
        Accept: 'application/json',
        'Content-Type': isForm
          ? 'application/x-www-form-urlencoded'
          : 'application/json'
      },
      // timeout: 3600,
      // `withCredentials` indicates whether or not cross-site Access-Control requests
      // should be made using credentials -- web need set cookie
      withCredentials: false, // default: false

      // `data` is the data to be sent as the request body
      // Only applicable for request methods 'PUT', 'POST', and 'PATCH'
      data: isForm
        ? qs.stringify(optionsParams, { indices: false })
        : optionsParams
    }

    return new Promise((resolve, reject) => {
      Vue.axios(options)
        .then(resp => {
          // commonFunc.myConsole(resp)
          if (resp.data.code === 0) {
            // 成功正确的返回 -- resolve
            // console.log(resp)
            commonFunc.hideLoading()
            resolve(resp.data)
          } else {
            // 业务自定义错误码返回 -- reject
            commonFunc.hideLoading()
            resolve(resp.data)
          }
        })
        .catch(error => {
          // 服务器或网络错误码返回 -- reject
          // commonFunc.myConsole(error)
          commonFunc.hideLoading()
          resolve(error)
        })
    })
  },
  request: function(requestOptions) {
    const options = getOptions(requestOptions)
    return new Promise((resolve, reject) => {
      Vue.axios(options)
        .then(resp => {
          resolve(resp.data)
        })
        .catch(error => {
          resolve(error)
        })
    })
  }
}

export default requestService
