import Vue from 'vue'
import Router from 'vue-router'

//前端页面
import Index from '@/components/front_end/Index.vue'
import PaperList from '@/components/front_end/PaperList.vue'
import PaperDetail from '@/components/front_end/PaperDetail.vue'
import QuestionBankList from '@/components/front_end/QuestionBankList.vue'
import QuestionBankDetail from '@/components/front_end/QuestionBankDetail.vue'
import Home from '@/components/front_end/Home.vue'
import FrontEndLogin from '@/components/front_end/Login.vue'
import Register from '@/components/front_end/Register.vue'
import KnowledgeList from '@/components/front_end/KnowledgeList.vue'
import PaperShow from '@/components/front_end/PaperShow.vue'
import AnwserQuestion from '@/components/front_end/AnwserQuestion.vue'
import KnowledgeDetail from '@/components/front_end/KnowledgeDetail.vue'
import Setting from '@/components/front_end/Setting.vue'

//前端组件
import Plan from '@/components/front_end/common/Plan.vue'
import CollectPaper from '@/components/front_end/common/CollectPaper.vue'
import CollectKnowledge from '@/components/front_end/common/CollectKnowledge.vue'
import CollectQuestionBank from '@/components/front_end/common/CollectQuestionBank.vue'
import Note from '@/components/front_end/common/Note.vue'
import Record from '@/components/front_end/common/Record.vue'
import Tab from '@/components/front_end/common/Tab.vue'

import Statistics from '@/components/front_end/common/Statistics.vue'

//后台页面
import Login from '@/components/back_end/Login.vue'
import IndexBack from '@/components/back_end/Index.vue'

//后台组件
import FirstPage from '@/components/back_end/common/FirstPage.vue'

//后台组件
import QuestionBankDetailManage from '@/components/back_end/common/function/QuestionBankDetail.vue'
import QuestionBankManage from '@/components/back_end/common/function/QuestionBank.vue'
import PaperManage from '@/components/back_end/common/function/Paper.vue'
import KnowledgeManage from '@/components/back_end/common/function/Knowledge.vue'
import StatisticManage from '@/components/back_end/common/function/Statistic.vue'

//后台组件
import SysMenuManage from '@/components/back_end/common/sys/SysMenu.vue'
import SysRoleManage from '@/components/back_end/common/sys/SysRole.vue'
import SysUserManage from '@/components/back_end/common/sys/SysUser.vue'
import SysLogManage from '@/components/back_end/common/sys/SysLog.vue'

Vue.use(Router)

export default new Router({
  routes: [
    //后台路由
    {
      path: '/Admin',
      name: 'IndexBack',
      component: IndexBack,
      children:[
        {
          path: '/Admin/Index',
          name: 'FirstPage',
          component: FirstPage
        },
        {
          path: '/Admin/QuestionBankManage',
          name: 'QuestionBankManage',
          component: QuestionBankManage
        },
        {
          path: '/Admin/QuestionBankDetailManage',
          name: 'QuestionBankDetailManage',
          component: QuestionBankDetailManage
        },
        {
          path: '/Admin/PaperManage',
          name: 'PaperManage',
          component: PaperManage
        },
        {
          path: '/Admin/KnowledgeManage',
          name: 'KnowledgeManage',
          component: KnowledgeManage
        },
        {
          path: '/Admin/StatisticManage',
          name: 'StatisticManage',
          component: StatisticManage
        },
        {
          path: '/Admin/SysUserManage',
          name: 'SysUserManage',
          component: SysUserManage
        },
        {
          path: '/Admin/SysRoleManage',
          name: 'SysRoleManage',
          component: SysRoleManage
        },
        {
          path: '/Admin/SysMenuManage',
          name: 'SysMenuManage',
          component: SysMenuManage
        },
        {
          path: '/Admin/SysLogManage',
          name: 'SysLogManage',
          component: SysLogManage
        }
      ]
    },
    {
      path: '/Admin/Login',
      name: 'Login',
      component: Login
    },
    //前端路由
    {
      path: '/Setting',
      name: 'Setting',
      component: Setting
    },
    {
      path: '/KnowledgeDetail',
      name: 'KnowledgeDetail',
      component: KnowledgeDetail
    },
    {
      path: '/AnwserQuestion',
      name: 'AnwserQuestion',
      component: AnwserQuestion
    },
    {
      path: '/QuestionBankDetail',
      name: 'QuestionBankDetail',
      component: QuestionBankDetail
    },
    {
      path: '/PaperShow',
      name: 'PaperShow',
      component: PaperShow
    },
    {
      path: '/KnowledgeList',
      name: 'KnowledgeList',
      component: KnowledgeList
    },
    {
      path: '/Register',
      name: 'Register',
      component: Register
    },
    {
      path: '/FrontEndLogin',
      name: 'FrontEndLogin',
      component: FrontEndLogin
    },
    {
      path: '/',
      name: 'Index',
      component: Index
    },
    {
      path: '/PaperList',
      name: 'PaperList',
      component: PaperList,
    },{
      path: '/PaperDetail',
      name: 'PaperDetail',
      component: PaperDetail
    },{
      path: '/QuestionBankList',
      name: 'QuestionBankList',
      component: QuestionBankList
    },{
      path: '/Home',
      name: 'Home',
      component: Home,
      children:[
        {
          path: '/Plan',
          name: 'Plan',
          component: Plan
        },
        {
          path: '/CollectPaper',
          name: 'CollectPaper',
          component: CollectPaper
        },
        {
          path: '/CollectKnowledge',
          name: 'CollectKnowledge',
          component: CollectKnowledge
        },
        {
          path: '/CollectQuestionBank',
          name: 'CollectQuestionBank',
          component: CollectQuestionBank
        },
        {
          path: '/Note',
          name: 'Note',
          component: Note
        },
        {
          path: '/Record',
          name: 'Record',
          component: Record
        },
        {
          path: '/Statistics',
          name: 'Statistics',
          component: Statistics
        },
      ]
    }
  ]
})
