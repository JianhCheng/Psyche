<template>
  <div class="main">



      <el-card class="usercard" >
        <div class="user">
          <img :src="user.userhead" />
          <div class="userinfo">
            <p class="name">{{user.username}}</p>
            <p class="access">{{user.userAuthority}}</p>
          </div>
        </div>
        <div class="login-info">
          <p>电话:<span>{{user.mobile}}</span></p>
          <p>email:<span>{{user.email}}</span></p>
        </div>
      </el-card>




        <el-card class="system_bulletin" style="margin-bottom: 20px">
          <div slot="header" class="system_title">
            <span>系统公告</span>
          </div>
          <div
            v-for="item in systemData"
            :key="item.id"
            class="system_context item"
          >
            <div>
              {{ item.title }}
            </div>
            <div>
              <i class="el-icon-timer"> {{ item.createtime }}</i>
            </div>
          </div>
        </el-card>

  </div>
</template>

<script>
export default {
  name: "firstPage",
  data() {
    return {
      systemData: [],
      user:{
        username:this.$store.getters.getUserName,
        userhead:'',
        userAuthority:'',
        email:'',
        mobile:''
      }
    };
  },
  methods:{
    getUserInfo(){
      const params = {
        params: {
          name: this.user.username,
        },
      };
      this.$http.get("/sys/sysUser/getUserInfo", params).then((res) => {
        console.log(res.data.data)
        let info=res.data.data[0]

        this.user.username=info['username']
        this.user.userhead=info['userhead']
        this.user.userAuthority=info['name']
        this.user.email=info['email']
        this.user.mobile=info['mobile']

      });
    },
    getAnnouncement(){
      this.$http.get("/zcxy/Announcement/getAList").then((res) => {
        console.log(111)
        console.log(res.data.data)
        this.systemData=res.data.data
      });
    }
  },
  mounted() {
    this.getUserInfo()
    this.getAnnouncement()
  },
};
</script>

<style lang="less" scoped>
.main{
  float: left;
  width: 90%;
  margin: 0;
  .usercard{
    width: 80%;
    .user {
      padding-bottom: 20px;
      margin-bottom: 20px;
      border-bottom: 1px solid #999;
      display: flex;
      align-items: center;
      img {
        margin-left: 40px;
        width: 150px;
        height: 150px;
        border-radius: 50%;
      }
      .userinfo {
        margin-left: 40px;
        .name {
          font-size: 32px;
          margin-bottom: 10px;
        }
        .access {
          color: #999;
          margin-top: 0px;
        }
      }
    }
    .login-info {
      p {
        font-size: 14px;
        color: #999999;
        line-height: 28px;
        span {
          color: #666666;
          margin-left: 20px;
        }
      }
    }
  }
  .system_bulletin {
    margin-top: 10px;
    .system_title {
      font-size: 22px;
      color: #000000;
    }
    .system_context {
      padding-bottom: 10px;
      border-bottom: 1px #f2f2f2 solid;
      margin-bottom: 10px;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
  }
}




</style>