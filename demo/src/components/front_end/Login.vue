<template>
  <div>

    <el-container>
      <el-header>
        <Nav></Nav>
      </el-header>
      <el-main>


        <div class="contain">
          <div class="i">
            <div class="contain-left">

              <div class="login_form">
                <p class="login_title">Log in</p>
                <el-form :model="form" :rules="rules" status-icon label-width="100px" ref="formName" hide-required-asterisk="false">
                  <el-form-item label="Account" prop="username">
                    <el-input v-model="form.username" placeholder="Please enter the account" class="input"></el-input>
                  </el-form-item>
                  <el-form-item label="PassWord" prop="password" hide-required-asterisk="true">
                    <el-input type="password" v-model="form.password" placeholder="Please enter the password" class="input"></el-input>
                  </el-form-item>
                  <el-form-item>
                      <div class="login-register" @click="gotoRegister">hasn`t account？</div>
                  
                  </el-form-item>
                  <el-form-item>
                    <el-button size="medium" @click="submitFormData" class="login-bnt">Login</el-button>
                  </el-form-item>
                </el-form>
              </div>

            </div>
            <img src="@/assets/imges/static/login1.jpg" class="contain-right-img">
          </div>
        </div>

      </el-main>
      <el-footer>
        <Foot></Foot>
      </el-footer>
    </el-container>

  </div>
</template>

<script>
import Nav from '@/components/front_end/template/Nav.vue'
import Foot from '@/components/front_end/template/Foot.vue';
import '@/assets/css/front_end_layout.css'

export default {
  name: "FrontEndLogin",
  data() {
    return {
      form: {
        username: "",
        password: "",
      },
      rules: {
        username: [{ required: true, message: "请输入账号", trigger: "blur" }],
        password: [{ required: true, message: "请输入密码", trigger: "blur" }],
      },

    };
  },
  methods: {
    gotoRegister(){
      this.$router.push('/Register')
    },
    // 提交登录表单的数据
    submitFormData() {
      this.$refs['formName'].validate((valid) => {
        if (valid) {
          this.$http.post("/login", this.form)
            .then((res) => {
              if (res.data.code === 200) {
                // 表示登录成功
                // 1.存储相关的token信息  token信息在响应的header中
                console.log(res.data)
                console.log(res.headers.authorization)
                localStorage.setItem("token", res.headers.authorization)
                // sessionStorage.setItem("username", this.form.username)
                localStorage.setItem('username',this.form.username)
                console.log(localStorage)
                // 2.路由到主页面
                this.$router.push("/")
              } else {
                // 表示登录失败
                this.$message.error(res.data.msg)
              }
            });
        } else {
          return false;
        }
      });
    }
  },
  mounted(){
    console.log(localStorage.getItem("username"))
  },
  components: {
    Nav, Foot
  }
};
</script>

<style lang="less" scoped>
.contain {
  width: 100%;
  margin-top: 80px;

  //居中
  display: flex;
  justify-content: center;
  align-items: center;

  .i {
    width: 80%;
    background-color: #0c100f;
    float: left;
    display: flex;
    justify-content: center;
    align-items: center;
    .contain-left {
      float: left;
      width: 50%;
      .login_form {
        width: 400px;
        margin: 0px auto;
        padding: 0 55px 15px 35px;
        background-color: none;
        // border: 1px solid #fff;
        border-radius: 5px;
        // background-color: #ffffff00;
        padding-left: 0;
        // 添加阴影效果
        .login_title {
          font-family: YuYang_W05;
          font-size: 2em;
          font-weight: 700;
          color: rgb(255, 255, 255);
          margin-top: 50px;
          margin-bottom: 30px;
          margin-left: 50px;
          text-align: center;
        }
        .input /deep/ .el-input__inner{
          background: #ffffff00;
        }

        .login-register {
          color: #9a9a9a;
          font-family: YuYang_W01;
          font-size: 0.5em;
          float: right;
        }

        .login-register:hover {
          color: #ffffff;
          font-family: YuYang_W01;
          font-size: 0.5em;
          float: right;
          cursor: pointer;//鼠标变手
        }

        .login-bnt {
          background-color: #c93b2e;
          margin-top: 20px;
          font-family: YuYang_W05;
          font-size: 1em;
          color: #ffffff;
          border: #a22e24;
        }

        .login-bnt:hover {
          background-color: #ff8378cd;
          margin-top: 20px;
          font-family: YuYang_W05;
          font-size: 1em;
          color: #ffffff;
          border: #a22e24;
        }
      }
    }

    .contain-right-img {
      float: right;
      width: 50%;

    }


  }

}
.el-form-item__label{

}

</style>