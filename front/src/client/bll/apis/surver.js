import config from '../../config/config.js'
import requestService from './common/request.js'
const surverApi = {
  async addQues (params) {
    let url = config.APISERVER.host + '/surver/addQues/'
    let res = await requestService.post(url, params)
    return res
  }
}

export default surverApi
