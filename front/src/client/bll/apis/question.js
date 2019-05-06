import config from '../../config/config.js'
import requestService from './common/request.js'
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
    let param = {
      title: params.title,
      subdesc: params.subdesc,
      type: typeCode,
      required: params.required,
      options: params.options
    }
    let url = config.APISERVER.host + '/question/add/'
    let res = await requestService.post(url, param)
    return res
  }
}
export default questionApi
