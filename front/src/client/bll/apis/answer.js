import config from '../../config/config.js'
import requestService from './common/request.js'
// import commonFunc from './common/common.js'
const answerApi = {
  async add () {
    let url = config.APISERVER.host + '/answer/add'
    let res = await requestService.get(url, '')
    return res
  }
}
export default answerApi
