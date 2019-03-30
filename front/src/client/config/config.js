/**
 * 配置文件
 */

const config = {
  APISERVER: {
    host: 'localhost:8080'
  }
}

const PROXY_PATH = process.env.PROXY_PATH
if (undefined !== PROXY_PATH && null != PROXY_PATH) {
  config.APISERVER.host = PROXY_PATH + config.APISERVER.host
}
export default config
