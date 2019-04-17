import Vue from 'vue'
import Router from 'vue-router'
// import VueResource from 'vue-resource'
import index from '@/pages/index'
import login from '@/pages/login'
import register from '@/pages/register'
import questionIndex from '@/pages/questionIndex'
import creatQues from '@/components/question/creatQues'
import myQues from '@/components/question/myQues'
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
    },
    {
      path: '/register',
      name: 'register',
      component: register,
      meta: {
        title: '新用户注册'
      }
    },
    {
      path: '/questionaire',
      name: 'questionaire',
      component: questionIndex,
      meta: {
        title: '创建问卷'
      },
      children: [
        {
          path: '/creat',
          name: 'creat',
          component: creatQues,
          meta: {
            title: '创建问卷'
          }
        },
        {
          path: '/show',
          name: 'show',
          component: myQues,
          meta: {
            title: '我的问卷'
          }
        }
      ]
    }
  ]
})
