const state = {
  showQuesStep: false,
  createQuesType: 'newQues',
  menuActiveIndex: 'show',
  submenuActiveIndex: 'creat'
}
const getters = {
  getSubmenuActiveIndex: state => {
    return state.submenuActiveIndex
  },
  getMenuActiveIndex: state => {
    return state.menuActiveIndex
  },
  getShowQuesStep: state => {
    return state.showQuesStep
  },
  getCreateQuesType: state => {
    return state.createQuesType
  }
}
const mutations = {
  set_submenuActiveIndex (state, val) {
    state.submenuActiveIndex = val
  },
  set_menuActiveIndex (state, val) {
    state.menuActiveIndex = val
  },
  set_showQuesStep (state, val) {
    state.showQuesStep = val
  },
  set_createQuesType (state, val) {
    state.createQuesType = val
  }
}
const actions = {
}
export default {
  state,
  getters,
  mutations,
  actions
}
