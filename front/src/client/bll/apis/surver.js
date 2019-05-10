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
  }
}

export default surverApi
