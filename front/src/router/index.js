import Vue from 'vue'
import Router from 'vue-router'
// import VueResource from 'vue-resource'
import index from '@/pages/index'
import login from '@/pages/login'

Vue.use(Router)
// Vue.use(VueResource)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
    {
      path: '/login',
      name: 'login',
      component: login,
      meta: {
        title: '登录'
      }
    }
  ]
})
