import config from '../../config/config.js'
import requestService from './common/request.js'
// import commonFunc from './common/common.js'
const participatenApi = {
  async getDeviceType () {
    let url = config.APISERVER.host + '/participate/getDeviceType'
    let res = await requestService.get(url, '')
    return res
  },
  async getIp () {
    let url = config.APISERVER.host + '/participate/getIp'
    let res = await requestService.get(url, '')
    return res
  },
  async getAddress () {
    let url = config.APISERVER.host + '/participate/getAddress'
    let res = await requestService.get(url, '')
    return res
  }
}
export default participatenApi
