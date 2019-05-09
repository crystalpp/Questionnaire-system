import config from '../../config/config.js'
import requestService from './common/request.js'
import commonFunc from './common/common.js'
const questionApi = {
  async add (params) {
    var typeCode = ''
    if (params.type === 'radioselect') {
      typeCode = '1'
    } else if (params.type === 'Multiselect') {
      typeCode = '2'
    } else if (params.type === 'Drop-down') {
      typeCode = '3'
    } else if (params.type === 'textselect') {
      typeCode = '4'
    } else if (params.type === 'measure') {
      typeCode = '5'
    } else if (params.type === 'matrix-radio') {
      typeCode = '6'
    }
    let questionsValue = []
    if (commonFunc.isDefine(params.questionsValue)) {
      questionsValue = params.questionsValue
    }
    let param = {
      title: params.title,
      subdesc: params.subdesc,
      type: typeCode,
      required: params.required,
      options: params.optionsValue,
      surverId: params.surverId,
      questions: questionsValue
    }
    let url = config.APISERVER.host + '/question/add/'
    let res = await requestService.post(url, param)
    return res
  },
  /**
   * 根据surverId查询所有的问题
   * @param {*} params
   */
  async searchBySueverId (params) {
    let param = {
      surverId: params
    }
    let url = config.APISERVER.host + '/question/searchBySurverId'
    let res = await requestService.get(url, param)
    return res
  },
  async deleteBySueverId (params) {
    let param = {
      surverId: params
    }
    let url = config.APISERVER.host + '/question/deleteBySurverId'
    let res = await requestService.post(url, param)
    return res
  },
  async deleteByQuestionId (params) {
    let param = {
      questionId: params
    }
    let url = config.APISERVER.host + '/question/deleteByQuestionId'
    let res = await requestService.post(url, param)
    return res
  },
  async updateByQuestionId (params) {
    let url = config.APISERVER.host + '/question/updateByQuestionId'
    let res = await requestService.postJson(url, params)
    return res
  }
}
export default questionApi
