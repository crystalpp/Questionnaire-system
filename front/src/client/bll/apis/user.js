import config from '../../config/config.js'
import requestService from './common/request.js'
const userApi = {
  async login (params) {
    let url = config.APISERVER.host + '/user/login'
    let res = await requestService.get(url, params)
    return res
  },
  async addUser (params) {
    let param = {
      userName: params.name,
      userPassword: params.password,
      userPhone: params.telphone,
      userEmail: params.email
    }
    let url = config.APISERVER.host + '/user/addUser'
    let res = await requestService.post(url, param)
    return res
  },
  // 验证输入的邮箱或者电话号码是否被注册过
  async userValiate (params) {
    let param = {
      type: params.type,
      value: params.value
    }
    let url = config.APISERVER.host + '/user/valiate'
    let res = await requestService.get(url, param)
    return res
  },
  async update (params) {
    let url = config.APISERVER.host + '/user//update'
    let res = await requestService.get(url, params)
    return res
  }
}

export default userApi
