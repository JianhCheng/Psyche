<template>
    <div class="container">
        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>
                <div class="main">
                    <div class="home">

                        <!--左侧个人简介-->
                        <el-card class="home-left">
                            <img :src="userhead" class="home-left-img">
                            <div class="home-left-intro">
                                <div class="home-left-intro-about">
                                    <div class="home-left-intro-about-title">About</div>
                                    <div class="home-left-intro-about-text">{{ intro }}</div>
                                </div>
                            </div>
                            <!-- <div class="home-left-intro-operation-followers">
                                <div class="home-left-intro-operation-followers-name">Followers</div>
                                <div class="home-left-intro-operation-followers-num">2023</div>
                            </div>
                            <div class="home-left-intro-operation-followers">
                                <div class="home-left-intro-operation-followers-name">QuestionBank</div>
                                <div class="home-left-intro-operation-followers-num">12</div>
                            </div>
                            <div class="home-left-intro-operation-followers" style="margin-bottom: 7%;">
                                <div class="home-left-intro-operation-followers-name">ranking</div>
                                <div class="home-left-intro-operation-followers-num">2</div>
                            </div> -->
                        </el-card>

                        <!--右侧动态-->
                        <div class="home-right">
                            <div class="home-right-head">
                                <div class="home-right-head-name">{{ username }}</div>
                                <div class="home-right-head-intro">An angel in charge of demons</div>
                            </div>
                            <div class="home-right-cards">

                                <el-card class="home-right-card">
                                    <div class="home-right-card-head">

                                        <div class="home-right-card-head-title">What She/He Likes</div>
                                    </div>
                                    <div class="home-right-card-content">
                                        <!-- <img src="@/assets/imges/icon/off.png" class="home-right-card-content-img"> -->
                                        
                                        <div class="home-right-content-operation">
                                            <el-dropdown>
                                                <span class="el-dropdown-link">
                                                    <button id="frozen-btn" class="purple">Hover</button>
                                                </span>
                                                <el-dropdown-menu slot="dropdown">
                                                    <router-link to="/CollectQuestionBank"><el-dropdown-item
                                                            icon="el-icon-folder-opened">题库收藏</el-dropdown-item></router-link>
                                                    <router-link to="/CollectPaper"><el-dropdown-item
                                                            icon="el-icon-star-on">文章收藏</el-dropdown-item></router-link>
                                                            <router-link to="/CollectKnowledge"><el-dropdown-item
                                                                icon="el-icon-star-on">知识点收藏</el-dropdown-item></router-link>
                                                    <!-- <router-link to="/Note"><el-dropdown-item
                                                            icon="el-icon-tickets">笔记本</el-dropdown-item></router-link> -->
                                                </el-dropdown-menu>
                                            </el-dropdown>
                                        </div>
                                        <div class="home-right-card-content-word">
                                            <div class="home-right-card-content-word-en">年龄：{{age}}</div>
                                            <div class="home-right-card-content-word-en">性别：{{sex}}</div>
                                            <div class="home-right-card-content-word-en">email：{{email}}</div>

                                        </div>
                                    </div>
                                </el-card>
                            </div>

                            <div class="home-right-content">

                                <div class="home-right-content-text">

                                    <router-view></router-view>
                                </div>
                            </div>
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
import Nav from '@/components/front_end/template/Nav.vue';
import Foot from '@/components/front_end/template/Foot.vue';
import Search from '@/components/front_end/template/Search.vue';
import '@/assets/css/front_end_layout.css'

export default {
    name: 'PaperList',
    data() {
        return {
            username: '',
            userhead: '',
            email: '',
            mobile: '',
            age: '',
            sex: '',
            intro: '',
        }
    },
    components: {
        Nav, Foot, Search
    },
    methods: {
        load() {
            this.username = this.$store.getters.getUserName,
                this.userhead = this.$store.getters.getUserHead,

                this.email = this.$store.getters.getEmail,
                this.mobile = this.$store.getters.getMobile,
                this.age = this.$store.getters.getAge,
                this.sex = this.$store.getters.getSex,
                this.intro = this.$store.getters.getIntro
        },
    },

    mounted() {
        this.load()
    }
}
</script>

<style lang="less" scoped>
.main {
    .home {
        padding-left: 5%;
        display: flex;

        /deep/ .el-card__body {
            padding: 0;
        }

        .home-left {

            width: 25% !important;
            float: left;
            height: 100%;

            .home-left-img {
                width: 100%;
                float: left;
            }

            .home-left-intro {
                float: left;

                .home-left-intro-about {
                    .home-left-intro-about-text {
                        margin-top: 10px;
                        font-family: YuYang_W02;
                        font-size: 0.5em;
                        color: gray;
                        float: left;
                        text-align: left;
                        margin-bottom: 15px;
                        margin-left: 6%;
                        margin-right: 6%;
                    }

                    .home-left-intro-about-title {
                        margin-left: 6%;
                        margin-top: 10px;
                        font-family: YuYang_W04;
                        font-size: 1em;
                        float: left;
                        clear: both;
                    }
                }
            }

            .home-left-intro-operation-followers {
                margin-bottom: 3%;
                margin-top: 5%;
                width: 100%;
                float: left;
                text-align: left;

                .home-left-intro-operation-followers-name {
                    margin-left: 6%;
                    float: left;
                    color: gray;
                    font-family: YuYang_W03;
                    font-size: 0.9em;
                }

                .home-left-intro-operation-followers-num {
                    margin-right: 6%;
                    float: right;
                    font-family: YuYang_W03;
                    font-size: 0.9em;
                }
            }
        }

        .home-right {
            padding-top: 15%;
            padding-left: 5%;
            float: left;
            text-align: left;
            width: 50%;

            .home-right-content {
                float: left;

                .home-right-content-operation {}

                .home-right-content-text {
                    float: left;
                }
            }

            .home-right-head {
                margin-left: 5%;

                .home-right-head-intro {
                    font-family: YuYang_W03;
                    font-size: 0.9em;
                    color: gray;
                }

                .home-right-head-name {
                    font-family: YuYang_W05;
                    font-size: 2em;
                }
            }

            .home-right-cards {
                margin-top: 7%;

                .home-right-card {
                    padding: 5%;

                    .home-right-card-head {
                        .home-right-card-head-auth {
                            font-family: YuYang_W04;
                            font-size: 0.8em;
                            color: gray;
                        }

                        .home-right-card-head-title {
                            font-family: YuYang_W05;
                            font-size: 1.5em;
                        }
                    }

                    .home-right-card-content {
                        float: left;
                        display: flex;
                        margin-top: 3%;
                        width: 100%;
                        
                        #frozen-btn {
                            display: flex;
                            align-items: center;
                            justify-content: center;
                           
                          }
                        .purple {
                            background-image: linear-gradient(to right, #6253e1, #852D91);
                            box-shadow: 0 4px 15px 0 rgba(236, 116, 149, 0.75);
                         }
                           
                         .purple:hover:before {
                           background-position: left bottom;
                         }

                        button {
                            
                            border: 0;
                            margin: 20px;
                            text-transform: uppercase;
                            font-size: 20px;
                            font-weight: bold;
                            padding: 15px 50px;
                            border-radius: 50px;
                            color: white;
                            outline: none;
                            position: relative;
                        }

                        button::before {
                            content: '';
                            display: block;
                            background: linear-gradient(to left, rgba(255, 255, 255, 0) 50%, rgba(255, 255, 255, 0.4) 50%);
                            background-size: 210% 100%;
                            background-position: right bottom;
                            height: 100%;
                            width: 100%;
                            position: absolute;
                            top: 0;
                            bottom: 0;
                            right: 0;
                            left: 0;
                            border-radius: 50px;
                            transition: all 1s;
                            -webkit-transition: all 1s;
                        }

                        .home-right-card-content-img {
                            width: 13%;
                        }

                        .home-right-card-content-word {
                            width: 90%;
                            margin-left: 5%;
                            margin-top: 3%;
                            font-family: YuYang_W04;
                            font-size: 0.85em;
                            color: rgb(182, 182, 182);

                        }
                    }
                }
            }
        }
    }

}</style>