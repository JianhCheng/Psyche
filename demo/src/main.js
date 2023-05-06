// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/assets/fonts/font.css'
import '@/assets/css/layout.css'
import store from './store';
import axios from 'axios'

Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.prototype.$http = axios // 修改内部的$http为 axios
axios.defaults.baseURL='http://192.168.121.1:8086/psyche'

// 添加 Axios 的拦截器
axios.interceptors.request.use(config =>{
  // 每次发送请求我们都携带token信息
  var token = localStorage.getItem('token')
  // var token='suheeyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODEzMjA4MjAsInVzZXJuYW1lIjoic3VoZSJ9.cICWNuoYQeZIK2VE6wol7zXpQ0hru0Tt__v9O550_gQ'

  config.headers['Authorization']=token // 请求头带上Token
  return config;
  },error=>{
  return Promise.reject(error);
  })

/** 使用router钩子函数处理登录检验 */
router.beforeEach((to, from, next) => {
  const username = localStorage.getItem('username')
  // if (to.name !== 'Register' && to.name !== 'FrontEndLogin' && !username){
  //   console.log(1)
  //   next({ name: 'FrontEndLogin' })
  // } 
  // else if(to.name == 'Register') next({name:'Register'})
  // else next()

  if(to.name == 'Register'){
    next()
  }
  else{
    if(to.name !== 'FrontEndLogin' && !username){
      next({ name: 'FrontEndLogin' })
    }
    else next()
  }
  })



/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
