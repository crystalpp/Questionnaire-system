import config from '../../config/config.js'
import requestService from './common/request.js'
const surverApi = {
  async add (params) {
    let url = config.APISERVER.host + '/surver/add'
    let res = await requestService.post(url, params)
    return res
  },
  async update (params) {
    let url = config.APISERVER.host + '/surver/update'
    let res = await requestService.post(url, params)
    return res
  },
  async searchByuserId (params) {
    let param = {
      userId: params
    }
    let url = config.APISERVER.host + '/surver/seachByUserId'
    let res = await requestService.get(url, param)
    return res
  },
  async search (params) {
    let param = {
      surverId: params
    }
    let url = config.APISERVER.host + '/surver/search'
    let res = await requestService.get(url, param)
    return res
  },
  async deleteById (params) {
    let param = {
      surverId: params
    }
    let url = config.APISERVER.host + '/surver/deleteById'
    let res = await requestService.post(url, param)
    return res
  },
  async updateEndTime (params) {
    let url = config.APISERVER.host + '/surver/updatePublish'
    let res = await requestService.post(url, params)
    return res
  },
  async getQRcodeImage (params) {
    let url = config.APISERVER.host + '/surver/getQRimage'
    let res = await requestService.get(url, params)
    return res
  },
  // 根据问卷标题和问卷分类查询问卷
  async selectSuvers (title, surverTypeId) {
    let parmas = {
      surverTypeId: surverTypeId,
      surverTitle: title
    }
    let url = config.APISERVER.host + '/surver/selectSurvers'
    let res = await requestService.get(url, parmas)
    return res
  },
  // 根据问卷类别查询模板问卷
  async getTemplate (params) {
    let parma = {
      surverTypeId: params
    }
    let url = config.APISERVER.host + '/surver/getTemplate'
    let res = await requestService.get(url, parma)
    return res
  },
  // 更新问卷类型
  async updateSurverType (params) {
    let url = config.APISERVER.host + '/surver/updateSurverType'
    let res = await requestService.post(url, params)
    return res
  }
}

export default surverApi
