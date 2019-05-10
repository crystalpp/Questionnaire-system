import config from '../../config/config.js'
import requestService from './common/request.js'
const questioinTypeApi = {
  async getAll (params) {
    let url = config.APISERVER.host + '/surverType/getAll'
    let res = await requestService.get(url, params)
    return res
  },
  async add (params) {
    debugger
    let url = config.APISERVER.host + '/surverType/add'
    let res = await requestService.post(url, params)
    return res
  },
  async delete (params) {
    let url = config.APISERVER.host + '/surverType/delete'
    let res = await requestService.post(url, params)
    return res
  }
}
export default questioinTypeApi
