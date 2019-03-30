// API 接口参数统一封装返回
import config from '../../..//client/config/config.js'

const getOptions = function(requestOptions) {
  var options = {
    method: 'POST',
    url: config.APISERVER.host,
    // mode:'cors',
    headers: {
      Accept: 'application/json',
      'Content-Type': 'application/json'
    },
    data: requestOptions
  }
  return options
}

export default getOptions
