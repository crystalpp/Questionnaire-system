/**
 * 配置文件
 */

const config = {
  APISERVER: {
    // host: 'http://localhost:8080'
    host: 'http://101.132.106.184:8080'
  }
}

const PROXY_PATH = process.env.PROXY_PATH
if (undefined !== PROXY_PATH && PROXY_PATH != null) {
  config.APclsISERVER.host = PROXY_PATH + config.APISERVER.host
}
export default config
