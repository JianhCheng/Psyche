<template>
  <div class="container">
    <el-container>
      <el-header>
        <Nav></Nav>
      </el-header>
      <el-main>
        <div>

          <div class="container">
            <!-- 首图 -->
            <div class="head">
              <div class="head-left">
                <img :src="headimg" class="head-left-headimg">
              </div>
              <div class="head-right">
                <div class="head-right-title">Welcome to Psyhe</div>
                <div class="head-right-intro">For graduate students in psychology</div>
                <el-button plain class="head-right-bnt" @click="signin">sign in</el-button>
              </div>
            </div>

            <!-- 论文 -->
            <div class="paper" v-show="true">
              <div class="paper-title">Easier access to journals</div>
              <div class="paper-paper">
                <el-card shadow="always" v-for="item in journalList" :key="item.id" class="paper-paper-card">
                  <div>
                    <img :src="item.coverurl" class="paper-paper-card-img">
                  </div>
                  <div class="paper-paper-card-intro">
                    <div class="paper-paper-card-intro-name_en">{{ item.nameEn }}</div>
                    <div class="paper-paper-card-intro-name_zn">{{ item.nameZn }}</div>
                    <div class="paper-paper-card-intro-content">{{ item.intro }}</div>
                  </div>
                </el-card>
              </div>
            </div>

          </div>

          <!-- 文章 -->
          <div class="article">
            <div class="article-title">Over 3,000 professional articles in psychology</div>
            <el-carousel :interval="5000" type="card" height="400px" arrow="never" autoplay="false"
              class="article-carousel">
              <el-carousel-item v-for="item in latestPaperList" :key="item">
                <el-card shadow="hover" class="article-card">
                  <div class="article-card-mark">“</div>
                  <div class="article-card-intro">{{ item.intro }}</div>
                  <div class="article-card-title">
                    <router-link :to="{ path: '/PaperDetail', query: { id: item.id } }">{{
                      item.title
                    }}</router-link>
                  </div>
                </el-card>
              </el-carousel-item>
            </el-carousel>
          </div>

          <div class="container">
            <!-- psyche的使用 -->
            <div class="intro">
              <div class="intro-left">
                <div class="intro-left-content">
                  <div class="intro-left-content-name">Psyche</div>
                  <div class="intro-left-content-title">How can Psyche be used</div>
                  <div class="intro-left-content-intro" v-html="introtxt"></div>
                </div>
              </div>
              <div class="intro-right">
                <img :src="introimg" class="img">
              </div>
            </div>
          </div>

          <div class="goto">
            <div class="i" v-for="item in gotoList" :key="item.id">
              <img :src="item.img" class="goto-img" />
              <div class="goto-title">{{ item.title }}</div>
              <div class="goto-intro">{{ item.intro }}</div>
              <el-button plain class="goto-intro-bnt">
                <router-link target="_blank" rel="opener" :to="item.path">goto</router-link>
              </el-button>
            </div>

          </div>

          <div class="waist">
            <div class="waist-back">
              <div class="waist-back-line">
                <div class="waist-back-line-title">The Best Psyche. Period.</div>
                <div class="waist-back-line-intro">Psyche was founded by myself. Though it was a graduation project, it
                  aimed at serving psychology graduate students.</div>
                <el-button plain class="waist-back-line-bnt">Get Start</el-button>
              </div>
            </div>
          </div>

          <div class="about">
            <div class="i" v-for="item in aboutUs" :key="item.id">
              <div class="about-title">{{ item.title }}</div>
              <div class="about-content">{{ item.content }}</div>
            </div>
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
import 'element-ui/lib/theme-chalk/base.css'
import '@/assets/css/front_end_layout.css'
import '@/assets/css/front_end_body.css'

export default {
  name: 'Index',
  data() {
    return {
      // waistimg:require('../../assets/imges/zmd/5.jpg'),
      headimg: 'https://pic3.zhimg.com/v2-6a84e0bcdebbc4f1b3337b8ea6ada787_r.jpg?source=1940ef5c',
      introimg: 'https://desk-fd.zol-img.com.cn/t_s960x600c5/g2/M00/0C/05/Cg-4WlVoEYeIIc_4AAz3n0BRKfkAAEVMQGQP6oADPe3849.jpg',

      introtxt: 'Most psychology graduates have difficulty finding online learning sites, and Psyche was created to solve this problem. Although the website construction is not yet comprehensive, but we are still working hard!<br/><br/>Today, for many people, using mobile electronic devices is a daily habit. Because of this, we think it is necessary and understandable to move traditional learning styles online.',
      imglist: [
        { id: 1, src: require('@/assets/imges/zmd/1.jpg') },
        { id: 2, src: require('@/assets/imges/zmd/2.jpg') },
        { id: 3, src: require('@/assets/imges/zmd/3.jpg') },
        { id: 4, src: require('@/assets/imges/zmd/4.jpg') },
        { id: 5, src: require('@/assets/imges/zmd/5.jpg') },
        { id: 6, src: require('@/assets/imges/zmd/6.jpg') }
      ],
      gotoList: [
        {
          id: 1,
          img: 'https://desk-fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/09/ChMkJ1bKzq2IQqM3AAonbPfNyU0AALJNQGxYagACieE333.jpg',
          title: 'Access to articles related to psychology',
          intro: 'You can use our website to read the current literature or other psychology related articles, rest assured, we will update on time!',
          path: '/PaperShow'
        },
        {
          id: 2,
          img: 'https://desk-fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/09/ChMkJlbKzquIB9ICAB92IHdta3YAALJNQDSZy4AH3Y4648.jpg',
          title: 'Select the appropriate question bank according to the need',
          intro: 'Our website has a lot of questions related to psychology postgraduate entrance examination. You can choose the ones you need to do exercises, or create your own question bank.',
          path: '/QuestionBankList'
        },
        {
          id: 3,
          img: 'https://desk-fd.zol-img.com.cn/t_s960x600c5/g5/M00/02/09/ChMkJlbKzquIHVjfAGyAvP3VtEUAALJNQANqnEAbIDU528.jpg',
          title: 'Know your situation',
          intro: 'Once logged in, you can see how well you brush and adjust your study schedule accordingly. You will see their efforts, even if no one applaud you, also want to elegant curtain call, thanks to their serious pay.',
          path: '/Home'
        },
      ],

      aboutUs: [],
      journalList: [],
      latestPaperList: [],
      userInfo: [],

      activeName: 'first',
      dataListLoading: false,
      journalLoading: false,
      aboutUsLoading: false,
    }

  },
  components: {
    Nav,
    Foot
  },
  methods: {
    signin() {
      this.$router.push('/FrontEndLogin')
    },
    getAboutUs() {
      this.aboutUsLoading = true;
      this.$http.get("/zcxy/aboutUs/list").then((res) => {
        this.aboutUs = res.data.data;
        // console.log(res.data.data)
      });
    },
    getJournalList() {
      this.$http.get("/zcxy/journals/list").then((res) => {
        this.journalList = res.data.data;
        // console.log(res.data.data)
      });
    },
    getLatestPaperList() {
      // 声明params 查询的参数
      const params = {
        params: {
          pageIndex: 1,
          pageSize: 6,
          srouce: '心理学空间',
        },
      };
      this.$http.get("/zcxy/paperList/srcList", params).then((res) => {
        this.latestPaperList = res.data.data.list;
        // console.log(res.data.data.list)
      });
    },
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
  mounted() {
    this.getUser()
    this.getJournalList()
    this.getLatestPaperList()
    this.getAboutUs()


  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less"scoped>
.about {
  float: left;

  .i {
    margin-top: 100px;
    margin-left: 20%;
    margin-right: 20%;

    .about-title {
      margin-top: 80px;
      font-family: YuYang_W03;
      font-size: 1.8em;
    }

    .about-content {
      margin-top: 0px;
      font-family: YuYang_W02;
      font-size: 1.3em;
    }
  }

}

.waist {
  background-image: url("../../assets/imges/zmd/5.jpg");
  float: left;
  height: 400px;
  width: 100%;
  margin-top: 100px;

  .waist-back {
    background-color: #ffffff;
    float: left;
    width: 350px;
    height: 300px;
    margin-left: 70px;
    margin-top: 20px;

    .waist-back-line {
      border: 2px solid #000000;
      height: 90%;
      margin: 4%;
      float: left;

      .waist-back-line-title {
        margin-top: 20px;
        font-family: YuYang_W05;
        font-size: 1.3em;
      }

      .waist-back-line-intro {
        width: 80%;
        margin: 10%;
        font-family: YuYang_W01;
        font-size: 1em;
      }

      .waist-back-line-bnt {
        background-color: #DD8E87;
        margin-top: 20px;
        font-family: YuYang_W05;
        font-size: 1em;
        color: #ffffff;
      }

      .waist-back-line-bnt:hover {
        background-color: #e6c6c3;
        border-color: #DD8E87;
        margin-top: 20px;
        font-family: YuYang_W05;
        font-size: 1em;
        color: #ffffff;
      }
    }
  }
}

.goto {
  float: left;
  margin-top: 100px;

  .i {
    float: left;
    width: 30%;
    margin: 1.6%;

    // text-align: center;
    .goto-img {
      width: 450px;
    }

    .goto-title {
      margin-top: 10px;
      font-family: YuYang_W05;
      font-size: 1.3em;
    }

    .goto-intro {

      font-family: YuYang_W01;
      font-size: 1em;
    }

    .goto-intro-bnt {
      margin-top: 10px;
      background: none;
      color: #000000 !important;
      border-color: #E1DEFD !important;
    }

    .goto-intro-bnt:hover {
      // background: #ffffff5a;
      color: rgb(0, 0, 0) !important;
      border-color: #6b5aff !important;
    }
  }

}

.intro {
  float: left;
  margin-top: 100px;
  margin-left: 100px;
  margin-right: 200px;

  .intro-left {
    float: left;
    width: 50%;

    .intro-left-content {
      margin-left: 5%;

      .intro-left-content-name {
        text-align: left;
        font-family: YuYang_W01;
        font-size: 1em;
      }

      .intro-left-content-title {
        text-align: left;
        font-family: YuYang_W03;
        font-size: 2em;
      }

      .intro-left-content-intro {
        text-align: left;
        font-family: YuYang_W02;
        font-size: 1.2em;
        margin-top: 10px;
      }
    }

  }

  .intro-right {
    width: 50%;
    float: left;

    .img {
      height: 300px;
    }
  }
}

.article {
  background: #fbfaff;
  float: left;
  width: 100%;
  margin-top: 100px;

  .article-title {
    margin-bottom: 50px;
    margin-top: 50px;
    font-family: YuYang_W05;
    font-size: 2em;
  }

  .article-carousel {
    width: 90%;
    padding: 4%;

    .article-card {
      width: 90%;
      text-align: center;


      .article-card-mark {
        font-family: YuYang_W05;
        font-size: 2em;
        margin-bottom: 30px;
      }

      .article-card-intro {
        font-family: YuYang_W02;
        font-size: 1.5em;
        margin-bottom: 50px;
        margin-left: 20px;
        margin-right: 20px;
      }

      .article-card-title {
        font-family: YuYang_W05;
        font-size: 1.5em;
        margin-bottom: 10px;
      }
    }




  }


}

.head {
  width: 100%;

  .head-left {
    width: 50%;

    .head-left-headimg {
      width: 100%;
      float: left;
    }
  }

  .head-right {
    width: 50%;
    background-color: #2c2c2c;

    .head-right-title {
      margin-top: 20%;
      color: #ffffff;
      font-family: YuYang_W05;
      font-size: 2em;
      margin-bottom: 10px;
    }

    .head-right-intro {
      color: #ffffff;
      font-family: YuYang_W01;
      font-size: 1em;
      margin-bottom: 20px;
    }

    .head-right-bnt {
      background: none;
      color: #ffffff;
      border-color: #ffffff
    }

    .head-right-bnt:hover {
      background: #ffffff5a;
      color: #E1DEFD !important;
      border-color: #E1DEFD !important;
    }
  }

  clear: both;
  display: flex;
  float: left;
  padding: 0;
  margin-bottom: 20px;
  margin-top: 20px;
}

.paper {
  float: left;
  margin-left: 150px;
  margin-right: 100px;

  .paper-title {
    margin-top: 30px;
    margin-bottom: 50px;
    font-family: YuYang_W05;
    font-size: 2em;
  }

  .paper-paper {
    display: flex;
    float: left;

    .paper-paper-card {
      width: 32%;
      margin: 10px;
      display: inline-flex;

      .paper-paper-card-img {
        float: left;
        height: 150px;
      }

      .paper-paper-card-intro {
        text-align: left;
        margin-left: 1px;

        .paper-paper-card-intro-name_zn {
          font-family: YuYang_W03;
          font-size: 1em;
        }

        .paper-paper-card-intro-name_en {
          font-family: YuYang_W03;
          font-size: 0.6em;
        }

        .paper-paper-card-intro-content {
          font-family: YuYang_W01;
          font-size: 0.8em;
          color: #2c2c2c;
        }
      }
    }

  }
}
</style>
