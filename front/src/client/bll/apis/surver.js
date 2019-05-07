import config from '../../config/config.js'
import requestService from './common/request.js'
const surverApi = {
  async add (params) {
    var param = {
      userId: params
    }
    let url = config.APISERVER.host + '/surver/add'
    let res = await requestService.post(url, param)
    return res
  },
  async update (params) {
    let url = config.APISERVER.host + '/surver/update'
    let res = await requestService.post(url, params)
    return res
  }
}

export default surverApi
