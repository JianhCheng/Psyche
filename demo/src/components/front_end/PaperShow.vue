<template>
    <div class="container">
        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>

                <div class="mybody">
                    <!-- 最新文章 -->
                    <div class="main-head">
                        <el-tabs :tab-position="tabPosition" class="main-head-tabs">
                            <el-tab-pane v-for="item in latestPaperList" :key="item.id" :label="item.title">
                                <div class="main-head-tab-left">
                                    <div class="main-head-tab-left-src">{{ item.srouce }} ————</div>
                                    <div class="main-head-tab-left-title">{{ item.title }}</div>
                                    <div class="main-head-tab-left-intro">{{ item.intro }}</div>
                                    <div class="main-head-tab-left-bnt">
                                        <router-link :to="{ path: '/PaperDetail', query: { id: item.id } }">
                                            View More
                                        </router-link>
                                    </div>
                                </div>
                                <div class="main-head-tab-right">
                                    <img :src="item.img" class="main-head-tab-right-img">
                                </div>
                            </el-tab-pane>
                        </el-tabs>
                    </div>

                    <!-- 主编推荐 -->
                    <div class="main-recommend">
                        <div class="main-recommend-title">
                            Recommend
                        </div>
                        <div class="main-recommend-content">
                            <div class="main-recommend-content-left" ref="getLeftHeight">
                                <el-card shadow="hover" v-for="item in recommendList" :key="item.id"
                                    class="main-recommend-content-left-card">
                                    <div class="main-recommend-content-left-src">{{ item.srouce }}</div>
                                    <div class="main-recommend-content-left-title">
                                        <router-link :to="{ path: '/PaperDetail', query: { id: item.id } }">
                                            {{ item.title }}
                                        </router-link>
                                    </div>
                                    <div class="main-recommend-content-left-statisttic">
                                        <i class="icon el-icon-view">{{ item.readnum }}</i>
                                        <i class="icon el-icon-edit">{{ item.likenum }}</i>
                                        <i class="icon el-icon-star-on">{{ item.collectnum }}</i>
                                    </div>
                                    <div class="main-recommend-content-left-intro">{{ item.intro }}</div>
                                </el-card>
                            </div>
                            <div class="main-recommend-content-right">
                                <img src="https://ts1.cn.mm.bing.net/th/id/R-C.c4e564f0a5501fc9a255c22718dd755f?rik=09sVQp4FAkReBg&riu=http%3a%2f%2fimg.sj33.cn%2fuploads%2fallimg%2f201203%2f20120301163938847.jpg&ehk=2mXxEwn3PKw26yopcyKp1%2fDk5TRRBqoeYL86A46TYz0%3d&risl=&pid=ImgRaw&r=0"
                                    class="main-recommend-content-right-img" :style="{ 'min-height': minHeight }">
                            </div>
                        </div>

                    </div>

                    <!-- 阅读最多 -->
                    <div class="main-list">
                        <div class="main-list-head">
                            <div class="main-list-head-title">Most Read</div>
                            <div class="main-list-head-view">
                                <router-link to="/PaperList">
                                    View More
                                </router-link>
                            </div>
                        </div>
                        <div class="main-list-body">
                            <el-card shadow="hover" class="main-list-body-card" v-for="i in mostReadList" :key="i.id">
                                <div>
                                    <img :src="i.img" class="main-list-body-card-img">
                                </div>
                                <div class="main-list-body-card-source">{{ i.source }}</div>
                                <div class="main-list-body-card-title">
                                    <router-link :to="{ path: '/PaperDetail', query: { id: i.id } }">{{
                                        i.title
                                    }}</router-link>
                                </div>
                                <div class="main-list-body-card-intro">{{ i.intro }}</div>
                            </el-card>
                        </div>
                    </div>

                    <!-- 喜欢最多 -->
                    <div class="main-list">
                        <div class="main-list-head">
                            <div class="main-list-head-title">Most Loved</div>
                            <div class="main-list-head-view">
                                <router-link to="/PaperList">
                                    View More
                                </router-link>
                            </div>
                        </div>
                        <div class="main-list-body">
                            <el-card shadow="hover" class="main-list-body-card" v-for="i in mostCollectedList" :key="i.id">
                                <div>
                                    <img :src="i.img" class="main-list-body-card-img">
                                </div>
                                <div class="main-list-body-card-source">{{ i.source }}</div>
                                <div class="main-list-body-card-title"> <router-link
                                        :to="{ path: '/PaperDetail', query: { id: i.id } }">{{
                                            i.title
                                        }}</router-link></div>
                                <div class="main-list-body-card-intro">{{ i.intro }}</div>
                            </el-card>
                        </div>
                    </div>

                    <!-- 收集最多 -->
                    <div class="main-list">
                        <div class="main-list-head">
                            <div class="main-list-head-title">Most Collected</div>
                            <div class="main-list-head-view">
                                <router-link to="/PaperList">
                                    View More
                                </router-link>
                            </div>
                        </div>
                        <div class="main-list-body">
                            <el-card shadow="hover" class="main-list-body-card" v-for="i in mostCollectedList" :key="i.id">
                                <div>
                                    <img :src="i.img" class="main-list-body-card-img">
                                </div>
                                <div class="main-list-body-card-source">{{ i.source }}</div>
                                <div class="main-list-body-card-title"> <router-link
                                        :to="{ path: '/PaperDetail', query: { id: i.id } }">{{
                                            i.title
                                        }}</router-link></div>
                                <div class="main-list-body-card-intro">{{ i.intro }}</div>
                            </el-card>
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
import 'element-ui/lib/theme-chalk/base.css';

export default {
    name: 'PaperList',
    data() {
        return {
            minHeight: 0,
            tabPosition: 'bottom',
            pageIndex: 1,

            latestPaperList: [],
            mostReadList: [],
            mostCollectedList: [],
            mostLovedList: [],
            recommendList: [],

        }
    },
    components: {
        Nav, Foot,
    },
    methods: {

        getLatestThreePaper() {
            this.$http.get("/zcxy/paperList/latestThreePaper").then((res) => {
                this.latestPaperList = res.data.data;
                console.log(res.data.data)
            });
        },
        getMostRead() {
            setTimeout(500)
            this.$http.get("/zcxy/paperStatistic/mostReadList").then((res) => {
                this.mostReadList = res.data.data;
                console.log(res.data.data)
            });
        },
        getRecommend() {
            this.$http.get("/zcxy/paperStatistic/recommendList").then((res) => {
                this.recommendList = res.data.data;
                console.log(res.data.data)
            });
        },
        getMostCollected() {
            setTimeout(500)
            this.$http.get("/zcxy/paperStatistic/mostCollectedList").then((res) => {
                this.mostCollectedList = res.data.data;
                console.log(res.data.data)
            });
        },
        getMostLovedList() {
            setTimeout(500)
            this.$http.get("/zcxy/paperStatistic/mostLovedList").then((res) => {
                this.mostLovedList = res.data.data;
                console.log(res.data.data)
            });
        },
        loadIniteData() {
            this.getLatestThreePaper()
            this.getRecommend()
            this.getMostRead()
            this.getMostCollected()
            this.getMostLovedList()
        }
    },
    mounted() {
        this.loadIniteData()

    }
}
</script>

<style lang="less" scoped>
.mybody {

    .main-head {
        //居中
        display: flex;
        justify-content: center;
        align-items: center;

        margin-left: 100px;
        margin-right: 100px;
        margin-top: 50px;

        .main-head-tabs {

            .main-head-tab-left {
                float: left;
                width: 50%;

                .main-head-tab-left-src {
                    margin-bottom: 20px;
                    text-align: left;
                    clear: both;
                    font-family: YuYang_W03;
                    font-size: 1em;
                    color: #b82c20;
                }

                .main-head-tab-left-title {
                    margin-bottom: 40px;
                    text-align: left;
                    font-family: YuYang_W04;
                    font-size: 2em;
                    color: #000000;
                }

                .main-head-tab-left-intro {
                    width: 90%;
                    margin-bottom: 20px;
                    text-align: left;
                    font-family: YuYang_W02;
                    font-size: 1em;
                    color: #d4d4d4;

                    display: -webkit-box;
                    /*作为弹性伸缩盒子模型显示*/
                    -webkit-line-clamp: 4;
                    /*显示的行数；如果要设置2行加...则设置为2*/
                    overflow: hidden;
                    /*超出的文本隐藏*/
                    text-overflow: clip;
                    /* 溢出用省略号*/
                    -webkit-box-orient: vertical;
                    /*伸缩盒子的子元素排列：从上到下*/
                }

                .main-head-tab-left-bnt {
                    margin-bottom: 10px;
                    text-align: left;
                    font-family: YuYang_W04;
                    font-size: 0.8em;
                    color: #000000;
                    text-decoration: 1.5px underline #b82c20;
                    cursor: pointer;
                }
            }

            .main-head-tab-right {
                float: left;
                width: 50%;

                .main-head-tab-right-img {
                    width: 80%;
                    border-radius: 10px;
                    float: right;
                }
            }
        }
    }

    .main-recommend {
        margin-top: 100px;
        margin-left: 150px;
        margin-right: 150px;

        .main-recommend-title {
            margin-bottom: 50px;
            text-align: center;
            font-family: YuYang_W04;
            font-size: 2em;
            color: #000000;
        }

        .main-recommend-content {
            .main-recommend-content-left {
                width: 50%;
                float: left;

                .main-recommend-content-left-card {
                    margin-bottom: 5px;

                    .main-recommend-content-left-src {
                        margin-bottom: 10px;
                        text-align: left;
                        font-family: YuYang_W03;
                        font-size: 0.8em;
                        color: #faaaaa;
                    }

                    .main-recommend-content-left-title {
                        margin-bottom: 10px;
                        text-align: left;
                        font-family: YuYang_W03;
                        font-size: 1.2em;
                        color: #000000;
                    }

                    .main-recommend-content-left-statisttic {
                        text-align: left;

                        .icon {
                            margin-right: 3px;
                            margin-bottom: 10px;
                            text-align: left;
                            font-family: YuYang_W01;
                            font-size: 0.5em;
                            color: #888888;
                        }
                    }

                    .main-recommend-content-left-intro {
                        margin-bottom: 10px;
                        text-align: left;
                        font-family: YuYang_W01;
                        font-size: 1em;
                        color: #7d7d7d;
                        display: -webkit-box;
                        /*作为弹性伸缩盒子模型显示*/
                        -webkit-line-clamp: 3;
                        /*显示的行数；如果要设置2行加...则设置为2*/
                        overflow: hidden;
                        /*超出的文本隐藏*/
                        text-overflow: clip;
                        /* 溢出用省略号*/
                        -webkit-box-orient: vertical;
                        /*伸缩盒子的子元素排列：从上到下*/
                    }
                }


            }

            .main-recommend-content-right {
                width: 50%;
                float: left;

                .main-recommend-content-right-img {
                    margin-left: 10px;
                    width: 97%;
                }
            }
        }


    }

    .main-list {
        float: left;
        margin-top: 150px;

        .main-list-head {
            width: 100%;
            float: left;
            margin-bottom: 50px;

            .main-list-head-title {

                float: left;
                font-family: YuYang_W04;
                font-size: 2em;
                color: #000000;
                margin-left: 100px;
            }

            .main-list-head-view {
                margin-right: 100px;
                float: right;

                font-family: YuYang_W04;
                font-size: 0.8em;
                color: #000000;
                text-decoration: 1.5px underline #b82c20;
                cursor: pointer;
            }
        }

        .main-list-body {
            margin-left: 50px;
            float: left;

            .main-list-body-card {
                width: 30%;
                float: left;
                margin: 0.9%;

                .main-list-body-card-img {
                    width: 100%;
                }

                .main-list-body-card-source {
                    font-family: YuYang_W04;
                    font-size: 0.8em;
                    color: #eea3a3;
                }

                .main-list-body-card-title {
                    margin-top: 5px;
                    font-family: YuYang_W03;
                    font-size: 1em;
                    color: #000000;

                    display: -webkit-box;
                    /*作为弹性伸缩盒子模型显示*/
                    -webkit-line-clamp: 1;
                    /*显示的行数；如果要设置2行加...则设置为2*/
                    overflow: hidden;
                    /*超出的文本隐藏*/
                    text-overflow: clip;
                    /* 溢出用省略号*/
                    -webkit-box-orient: vertical;
                    /*伸缩盒子的子元素排列：从上到下*/
                }

                .main-list-body-card-intro {
                    font-family: YuYang_W01;
                    font-size: 0.8em;
                    color: #a6a6a6;
                    margin-top: 10px;

                    display: -webkit-box;
                    /*作为弹性伸缩盒子模型显示*/
                    -webkit-line-clamp: 3;
                    /*显示的行数；如果要设置2行加...则设置为2*/
                    overflow: hidden;
                    /*超出的文本隐藏*/
                    text-overflow: clip;
                    /* 溢出用省略号*/
                    -webkit-box-orient: vertical;
                    /*伸缩盒子的子元素排列：从上到下*/
                }
            }
        }
    }
}

.main-head-tabs /deep/ .el-tabs__header {
    margin-top: 100px
}

.main-head-tabs /deep/ .el-tabs__nav {
    float: none;
}

.main-head-tabs /deep/ .el-tabs__item {
    text-align: center;
    font-family: YuYang_W02;
    font-size: 1em;
    color: #787878;
    margin: 1px;
}

.main-head-tabs /deep/ .el-tabs__item.is-active {
    color: #000000;
    font-family: YuYang_W04;

}

.main-head-tabs /deep/ .el-tabs__active-bar {
    background-color: transparent !important;
}

.main-head-tabs /deep/ .el-tabs__nav-wrap::after {
    position: static !important;
}
</style>