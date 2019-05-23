import config from '../../config/config.js'
import requestService from './common/request.js'
// import commonFunc from './common/common.js'
const answerApi = {
  async add (params) {
    debugger
    let url = config.APISERVER.host + '/answer/add'
    let res = await requestService.post(url, params)
    return res
  },
  async getAnswersBySurverId (params) {
    let url = config.APISERVER.host + '/answer/getAnswersBySurverId'
    let res = await requestService.get(url, params)
    return res
  },
  async getAnswersByParticipateId (params) {
    let url = config.APISERVER.host + '/answer/getAnswersByParticipateId'
    let res = await requestService.get(url, params)
    return res
  },
  async staticAnswerText (params) {
    let url = config.APISERVER.host + '/answer/staticAnswerText'
    let res = await requestService.get(url, params)
    return res
  }
}
export default answerApi
