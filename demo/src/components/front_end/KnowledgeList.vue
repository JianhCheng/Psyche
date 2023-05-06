<template>
    <div class="container">
        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>

                <div class="main">
                    <!--头部-->
                    <div class="QuestionBank-head">
                        <div class="QuestionBank-head-i">
                            <div class="QuestionBank-head-i-title">Start your exercise</div>
                            <div class="QuestionBank-head-i-intro">Instant success</div>
                        </div>
                    </div>

                    <div class="main-body">

                        <!-- 知识点库 -->
                        <div class="QuestionBank-right">

                            <div class="QuestionBank-right-cards">
                                <el-card shadow="hover" class="QuestionBank-right-card" v-for="item in knowledgeList"
                                    :key="item.id">
                                    <div class="QuestionBank-right-card-left">
                                        <img :src="item.coverurl" class="QuestionBank-right-card-left-img">
                                    </div>
                                    <div class="QuestionBank-right-card-right">
                                        <div class="QuestionBank-right-card-right-title">
                                            <router-link target="_blank"
                                             :to="{ path: '/KnowledgeDetail', query: { id: item.id } }">{{
                                                item.title
                                            }}</router-link>
                                        </div>
                                        <div class="QuestionBank-right-card-right-intro">
                                            <img :src="item.userhead" class="QuestionBank-right-card-right-user-head">
                                            <div class="QuestionBank-right-card-right-user-name">{{ item.username }}</div>
                                            <div class="QuestionBank-right-card-right-user-num"></div>
                                        </div>
                                    </div>
                                </el-card>
                            </div>
                        </div>

                        <!-- 底部分页控件 -->
                        <div class="QuestionBank-bottom">
                            <div class="block">
                                <el-pagination @current-change="handleCurrentChange" :current-page.sync="pageForm.currPage"
                                    layout="total, prev, pager, next" :total="pageForm.totalCount">
                                </el-pagination>
                            </div>
                        </div>
                    </div>


                    <!--最热知识点库-->
                    <div class="main-right">
                        <el-card class="main-right-list">
                            <div class="main-right-list-title">
                                <div class="main-right-list-title-name">Popular</div>
                                <el-divider class="main-right-list-title-divider"></el-divider>
                            </div>
                            <div v-for="(item, i) in popularList" :key="i" class="main-right-list-intro">
                                <div class="main-right-list-intro-num">{{ '0' + i }}</div>
                                <div class="main-right-list-intro-name">
                                    <router-link target="_blank"
                                     :to="{ path: '/PaperDetail', query: { id: item.id } }">
                                        {{ item.title }}
                                    </router-link>
                                </div>
                            </div>
                        </el-card>
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
import '@/assets/css/front_end_layout.css'

export default {
    name: 'KnowledgeList',
    data() {
        return {
            knowledgeList: [],
            popularList: [],
            popularList: [],
            pageForm: {
                totalCount: 1,
                pageSize: 1,
                totalPage: 1,
                currPage: 1
            },
        }
    },
    components: {
        Nav, Foot
    },
    methods: {
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
            this.pageForm.currPage = val;
            this.getQuestionBank(val)

        },
        getKnowledgeList() {
            const params = {
                params: {
                    pageIndex: this.pageForm.currPage,
                    pageSize: 10,
                },

            };
            this.$http.get("/zcxy/konwledgeList/list", params).then((res) => {
                console.log(res.data.data)
                var r = res.data.data

                this.knowledgeList = r.list;

                this.pageForm.currPage = r.currPage
                this.pageForm.totalCount = r.totalCount
                this.pageForm.pageSize = r.pageSize
                this.pageForm.totalPage = r.totalPage


            });
        },
        getPopularKnowledgList() {
            this.$http.get("/zcxy/KnowledgeStatistic/mostLovedList").then((res) => {
                console.log(res.data.data)
                var r = res.data.data

                this.popularList = r;
            });
        },
    },
    created() {
        this.getKnowledgeList()
        this.getPopularKnowledgList()
    }

}
</script>

<style lang="less" scoped>
.main {
    width: 100%;
    padding: 0;
    margin: 0;

    .QuestionBank-head {
        background-image: url("../../assets/imges/static/head.jpg");
        margin: auto;
        width: 90%;
        height: 480px;

        .QuestionBank-head-i {

            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.463);

            .QuestionBank-head-i-title {
                float: left;
                margin-top: 200px;
                font-family: YuYang_W05;
                font-size: 2em;
                width: 100%;
                margin-bottom: 30px;
                color: #ffffff;
            }

            .QuestionBank-head-i-intro {
                float: left;
                width: 100%;

                font-family: YuYang_W01;
                font-size: 1em;
                margin-bottom: 30px;
                color: #ffffff;


            }

        }
    }

    .main-body{
        margin-top: 10px;
        float: left;
        width: 60%;
        .QuestionBank-right {
            margin-left: 24%;
            float: left;
    
            .QuestionBank-right-cards {
                .QuestionBank-right-card {
                    margin: 10px;
                    width: 45%;
                    float: left;
    
                    .QuestionBank-right-card-left {
                        float: left;
    
                        .QuestionBank-right-card-left-img {
                            height: 100px;
                            width: 100px;
                        }
    
                    }
    
                    .QuestionBank-right-card-right {
                        margin-left: 8px;
    
                        float: left;
    
                        .QuestionBank-right-card-right-title {
                            font-family: YuYang_W04;
                            font-size: 1em;
                            color: #000000;
    
                            display: -webkit-box;
                            /*作为弹性伸缩盒子模型显示*/
                            -webkit-line-clamp: 1;
                            /*显示的行数；如果要设置2行加...则设置为2*/
                            overflow: hidden;
                            /*超出的文本隐藏*/
                            text-overflow: ellipsis;
                            /* 溢出用省略号*/
                            -webkit-box-orient: vertical;
                            /*伸缩盒子的子元素排列：从上到下*/
                        }
    
                        .QuestionBank-right-card-right-intro {
                            margin-top: 15px;
    
                            .QuestionBank-right-card-right-user-head {
                                border-radius: 10px;
                                height: 20px;
                                float: left;
                            }
    
                            .QuestionBank-right-card-right-user-name {
                                margin-left: 5px;
                                float: left;
                                margin-top: 5px;
                                font-family: YuYang_W03;
                                font-size: 0.5em;
                                color: #717171;
                            }
    
                            .QuestionBank-right-card-right-user-num {}
                        }
                    }
                }
    
            }
        }
    
        .QuestionBank-bottom {
            float: left;
            margin-top: 50px;
            margin-left: 300px;
        }
    }

    .main-right {
        width: 30%;
        float: left;

        margin-top: 30px;

        /* margin-top: 15px; */
        .main-right-list {
            width: 70%;
            .main-right-list-title {
                clear: both;
                float: left;
                width: 100%;

                .main-right-list-title-name {
                    font-family: YuYang_W05;
                    font-size: 1.3em;
                    float: left;
                }

                .main-right-list-title-divider {
                    float: left;
                }
            }

            .main-right-list-intro {
                float: left;
                display: flex;
                width: 100%;

                .main-right-list-intro-name {
                    
                    font-family: YuYang_W02;
                    font: 0.2em;
                    float: left;
                    text-align: left;
                    margin-left: 10px;
                }

                .main-right-list-intro-num {
                    font-family: YuYang_W04;
                    font-size: 1.4em;
                    float: left;
                    margin-left: 10px;
                    margin-bottom: 25px;
                }

            }
        }
    }



}</style>
