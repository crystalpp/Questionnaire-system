import config from '../../config/config.js'
import requestService from './common/request.js'
const demoApi = {
  async getById (id) {
    // let params = {
    //   id: id
    // }
    // commonFunc.myConsole('nowModelIdCode'+nowModelIdCode)
    let url = config.APISERVER.host + '/article/get/' + id
    let res = await requestService.get(url, '')
    return res
  }
}

export default demoApi
