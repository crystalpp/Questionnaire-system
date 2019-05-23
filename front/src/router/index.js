import Vue from 'vue'
import Router from 'vue-router'
// import VueResource from 'vue-resource'
import index from '@/pages/index'
import login from '@/pages/login'
import register from '@/pages/register'
import questionIndex from '@/pages/questionIndex'
import user from '@/pages/user'
import creatQues from '@/components/question/creatQues'
import myQues from '@/components/question/myQues'
import release from '@/components/question/releaseQues'
import statistics from '@/components/question/statisticsQues'
import preview from '@/pages/preview'
import fill from '@/pages/fill'
import result from '@/pages/result'
import error from '@/pages/error'
import source from '@/components/statistics/source'
import chart from '@/components/statistics/chart'
import answerDetail from '@/components/statistics/answerDetail'
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
      path: '/preview',
      name: 'preview',
      component: preview,
      meta: {
        title: '问卷预览'
      }
    },
    {
      path: '/fill/:id',
      name: 'fill',
      component: fill,
      meta: {
        title: '问卷填写'
      }
    },
    {
      path: 'result',
      name: 'result',
      component: result,
      meta: {
        title: '统计结果'
      }
    },
    {
      path: '/error',
      name: 'error',
      component: error,
      meta: {
        title: '错误页面'
      }
    },
    {
      path: '/user',
      name: 'user',
      component: user,
      meta: {
        title: '用户中心'
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
          path: '/edit',
          name: 'edit',
          component: creatQues,
          meta: {
            title: '编辑问卷'
          }
        },
        {
          path: '/show',
          name: 'show',
          component: myQues,
          meta: {
            title: '我的问卷'
          }
        },
        {
          path: '/release',
          name: 'release',
          component: release,
          meta: {
            title: '问卷发布'
          }
        },
        {
          path: '/statistics',
          name: 'statistics',
          component: statistics,
          meta: {
            title: '数据统计'
          },
          children: [
            {
              path: '/source',
              name: 'source',
              component: source,
              meta: {
                title: '来源概览'
              }
            },
            {
              path: '/chart',
              name: 'chart',
              component: chart,
              meta: {
                title: '基本图表'
              }
            },
            {
              path: '/answerDetail',
              name: 'answerDetail',
              component: answerDetail,
              meta: {
                title: '答卷详情'
              }
            }
          ]
        }
      ]
    }
  ]
})
