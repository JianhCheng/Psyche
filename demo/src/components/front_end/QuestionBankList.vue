<template>
    <div class="container">
        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>
                <div class="main">

                    <!-- 头部 -->
                    <div class="QuestionBank-head">
                        <div class="QuestionBank-head-i">
                            <div class="QuestionBank-head-i-title">Start your exercise</div>
                            <div class="QuestionBank-head-i-intro">Instant success</div>

                        </div>
                    </div>

                    <div class="QuestionBank-body">
                        <!-- 左侧分类栏 -->
                        <div class="QuestionBank-left">
                            <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen"
                                @close="handleClose" background-color="#170c29" text-color="#808080"
                                active-text-color="#fff">
                                <el-submenu :index="item.id" v-for="item in classify" :key="item.id">
                                    <template slot="title">
                                        <span>{{ item.name }}</span>
                                    </template>
                                    <el-menu-item :index="`${i.id}-${item.id}`" :key="i.id" v-for="i in item.choies"
                                        @click="getQuestionBank(1,i.key)">{{ i.name
                                        }}</el-menu-item>
                                </el-submenu>
                            </el-menu>
                        </div>

                        <!-- 右侧题库 -->
                        <div class="QuestionBank-right">

                            <div class="QuestionBank-right-cards">
                                <el-card shadow="hover" class="QuestionBank-right-card" v-for="item in QBlist"
                                    :key="item.id">
                                    <div class="QuestionBank-right-card-left">
                                        <img :src="item.coverurl" class="QuestionBank-right-card-left-img">
                                    </div>
                                    <div class="QuestionBank-right-card-right">
                                        <div class="QuestionBank-right-card-right-title">
                                            <router-link target="_blank" rel="opener" :to="{ path: '/QuestionBankDetail', query: { id: item.id } }">{{
                                                item.title
                                            }}</router-link></div>
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
                                <el-pagination  @current-change="handleCurrentChange"
                                    :current-page.sync="pageForm.currPage" layout="total, prev, pager, next"
                                    :total="pageForm.totalCount">
                                </el-pagination>
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
import '@/assets/css/front_end_layout.css'

export default {
    name: 'QuestionBankList',
    data() {
        return {
            classify: [
                {
                    id: 1,
                    name: '科目',
                    choies: [
                        {
                            id: 1,
                            name: '全部',
                            key: '%',
                        },
                        {
                            id: 2,
                            name: '普通心理学',
                            key: '%普%心%',
                        },
                        {
                            id: 3,
                            name: '发展心理学',
                            key: '%发%心%',
                        },
                        {
                            id: 4,
                            name: '社会心理学',
                            key: '%社%心%',
                        },
                        {
                            id: 5,
                            name: '教育心理学',
                            key: '%教%心%',
                        },
                        {
                            id: 6,
                            name: '心理统计学',
                            key: '%统计%',
                        },
                        {
                            id: 7,
                            name: '测量心理学',
                            key: '%测量%',
                        },
                        {
                            id: 8,
                            name: '实验心理学',
                            key: '%实验%',
                        },
                        {
                            id: 9,
                            name: '变态心理学',
                            key: '%变态%',
                        },
                    ]
                },
                {
                    id: 2,
                    name: '主题',
                    choies: [
                        {
                            id: 1,
                            name: '全部',
                            key: '%',
                        },
                        {
                            id: 2,
                            name: '练习题',
                            key: '练习',
                        },
                        {
                            id: 3,
                            name: '历年真题',
                            key: '真题',
                        },
                        {
                            id: 4,
                            name: '模拟卷',
                            key: '模拟',
                        },
                        {
                            id: 5,
                            name: '课后习题',
                            key: '习题',
                        },
                    ]
                },
                {
                    id: 3,
                    name: '学校',
                    key: 'school',
                    choies: [
                        {
                            id: 1,
                            name: '全部',
                            key: '%',
                        },
                        {
                            id: 2,
                            name: '312统考',
                            key: '%312%',
                        },
                        {
                            id: 3,
                            name: '湖南师范大学',
                            key: '%湖师',
                        },
                        {
                            id: 4,
                            name: '浙江师范大学',
                            key: '%浙师大%',
                        },
                        {
                            id: 5,
                            name: '华东师范大学',
                            key: '%华东%',
                        },
                        {
                            id: 6,
                            name: '复旦大学',
                            key: '%复旦%',
                        },
                        {
                            id: 7,
                            name: '华南师范大学',
                            key: '%华南%',
                        },
                        {
                            id: 8,
                            name: '浙江大学',
                            key: '%浙大%',
                        },
                    ]
                },
            ],
            pageForm:{
                totalCount:1,
                pageSize:1,
                totalPage:1,
                currPage:1
            },

            QBlist: [],
            key: '%',
            bnt: 0,



        }
    },
    components: {
        Nav, Foot
    },
    methods: {
        handleCurrentChange(val){
            console.log(`当前页: ${val}`);
            this.pageForm.currPage=val;
            this.getQuestionBank(val,this.key)
            
        },
        getQuestionBank(index,key) {
            const params = {
                params: {
                    pageIndex: index,
                    pageSize: 10,
                    key: key,
                },
                
            };
            this.$http.get("/zcxy/questionBankList/getCategoryPaperList", params).then((res) => {
                var r=res.data.data
                this.QBlist = r.list;

                this.pageForm.currPage=r.currPage
                this.pageForm.totalCount=r.totalCount
                this.pageForm.pageSize=r.pageSize
                this.pageForm.totalPage=r.totalPage

                console.log(res.data.data.list)
            });
        }
    },
    created() {
        this.getQuestionBank(this.pageForm.currPage)
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

    .QuestionBank-body {
        width: 100%;

        .QuestionBank-left {
            width: 15%;
            margin-top: 20px;
            margin-left: 10%;
            float: left;

            /deep/ .el-menu-vertical-demo {
                color: #808080;
                height: 800px;

                /deep/ .el-submenu__title {
                    padding: 0px;
                    padding-left: 0;
                }

                /deep/ .el-menu-item {
                    padding: 0px;
                    padding-left: 0;

                }
            }
        }

        .QuestionBank-right {
            margin-top: 10px;
            margin-left: 5%;
            width: 70%;
            float: left;

            .QuestionBank-right-cards {
                .QuestionBank-right-card {
                    margin: 10px;
                    width: 40%;
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
            float: right;
            margin-top: 50px;
            margin-right: 200px;
        }
    }



}
</style>