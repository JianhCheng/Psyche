<template>
  <div class="container_back">
    <el-container>
      <el-aside width="auto" >
        <Aside></Aside>
      </el-aside>
      <el-container>
        <el-header>
             <Header></Header>
        </el-header>

          <el-main>
              <!-- 路由的出口 -->
              <router-view></router-view>
          </el-main>
        
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from '@/components/back_end/template/Aside.vue'
import Header from '@/components/back_end/template/Header.vue'
import '@/assets/css/back_end_layout.css'

export default {
  name: "Index",
  components:{
    Aside,
    Header
  },
  methods:{
    getUser() {
      const params = {
        params: {
          name: this.$store.getters.getUserName,
        },
      };
      this.$http.get("/sys/sysUser/getUserInfo", params).then((res) => {
        console.log(res.data.data)
        var userInfo = res.data.data[0];

        localStorage.setItem('username', userInfo['username'])
        localStorage.setItem('userhead', userInfo['userhead'])
        localStorage.setItem('email', userInfo['email'])
        localStorage.setItem('mobile', userInfo['mobile'])
        localStorage.setItem('age', userInfo['age'])
        localStorage.setItem('sex', userInfo['sex'])
        localStorage.setItem('intro', userInfo['intro'])
        console.log(localStorage)

      });
    },
  },
  mounted(){
    this.getUser()
  }
};
</script>


<style scoped>

.el-header{
  padding: 0;
}
.container{
  padding: 0;
  margin: 0;
}
.el-main{
  padding-bottom: 0;
}
</style>
