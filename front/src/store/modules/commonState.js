const state = {
  showQuesStep: true
}
const getters = {
  getShowQuesStep: state => {
    return state.showQuesStep
  }
}
const mutations = {
  set_showQuesStep (state, val) {
    state.showQuesStep = val
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
