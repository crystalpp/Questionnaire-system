import Vue from 'vue'
import vuex from 'vuex'
import commonState from './modules/commonState'
Vue.use(vuex)
export default new vuex.Store({
  modules: {
    commonState
  }
})
