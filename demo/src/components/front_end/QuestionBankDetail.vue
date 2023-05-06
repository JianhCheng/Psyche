<template>
    <div class="container">
        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>
                <div class="main">

                    <!-- 知识点信息 -->
                    <el-card shadow="always" class="head">
                        <img :src="qbList.coverurl" class="head-left-img">
                        <div class="head-right">
                            <div class="head-right-title">{{ qbList.title }}</div>
                            <img :src="qbList.userhead" class="head-right-userhead">
                            <div class="head-right-username">{{ qbList.username }}</div>
                            <div class="head-right-operation">
                                <el-button plain :class="collectclass" @click="collectQB">收藏</el-button>
                            </div>
                        </div>
                    </el-card>

                    <!-- 题目详情 -->
                    <div v-if="structrueDetail.length !== 0">
                        <div class="question">
                            <el-collapse class="question-collapse" accordion>
                                <el-collapse-item :title="`${item.struct}——${item.QBDetailLenghth}题`" :name="item.struct"
                                    v-for="item in structrueDetail" :key="item.struct">
                                    <el-card shadow="hover" v-for="i in item.QBDetail" :key="i.id" class="question-collapse-card">
                                        <div class="question-collapse-card-title">
                                            <router-link target="_blank" rel="opener" :to="{
                                                path: '/AnwserQuestion',
                                                query: { qbid: questionBankDetailID, id: i.id, chapter: i.chapter }
                                            }">
                                                {{ i.title }}
                                            </router-link>

                                        </div>
                                        <div class="question-collapse-card-point">考点：{{ i.point }}</div>
                                    </el-card>
                                </el-collapse-item>
                            </el-collapse>
                        </div>
                    </div>
                    <div v-else>
                        暂无内容
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
    name: 'QuestionBankDetail',
    data() {
        return {
            questionBankDetailID: '',
            questionBankDetail: [],
            pageIndex: 1,
            structrue: [],
            structrueDetail: [],
            qbList: {},
            collect: 0,
            collectclass: 'head-right-operation-collect'

        }
    },
    components: {
        Nav, Foot
    },
    methods: {
        collectQB() {
            //控制收藏操作
            if (this.collect == 0) {
                this.collect++
                this.collectclass = 'head-right-operation-collect-active'
            } else {
                this.collect--
                this.collectclass = 'head-right-operation-collect'
            }
            console.log(this.collect)

            // 改变用户收藏表
            const params = {
                params: {
                    qbid: this.questionBankDetailID,
                    operation: this.collect,
                    username: localStorage.getItem("username")
                },
            };
            this.$http.get("/zcxy/UserCollectQuestionBank/collect", params).then((res) => {
                console.log(res.data)
            });


            // 改变数据表
            const params1 = {
                params: {
                    id: this.questionBankDetailID,
                    operation: this.collect
                },
            };
            this.$http.get("/zcxy/QuestionBankStatistic/collect", params1).then((res) => {
                console.log(res.data)
            });
        },
        //根据相应结构获取题目内容
        getQBDetail(s) {
            const params = {
                params: {
                    id: this.questionBankDetailID,
                    struct: s
                },
            };
            this.$http.get("/zcxy/questionBankDetail/getQBDetail", params).then((res) => {
                var str = {
                    'struct': s,
                    'QBDetailLenghth': res.data.data.length,
                    'QBDetail': res.data.data
                }
                this.structrueDetail = this.structrueDetail.concat(str)
                console.log(this.structrueDetail)
            });
        },
        //获取题库结构
        getQuestionBankStructrue() {
            const params = {
                params: {
                    id: this.questionBankDetailID,
                },
            };
            this.$http.get("/zcxy/questionBankDetail/getQBDetailStructure", params).then((res) => {
                this.structrue = res.data.data;
                console.log(res.data.data)

                this.structrue.forEach((s) => {
                    this.getQBDetail(s)
                });
            });
        },
        getQBList() {
            const params = {
                params: {
                    id: this.questionBankDetailID,
                },
            };
            this.$http.get("/zcxy/questionBankList/getListById", params).then((res) => {
                this.qbList = res.data.data;
                console.log(res.data.data)

                this.structrue.forEach((s) => {
                    this.getQBDetail(s)
                });
            });
        },
        getIsCollect() {
            const params = {
                params: {
                    qbid: this.questionBankDetailID
                },
            };
            this.$http.get("/zcxy/UserCollectQuestionBank/geIstCollect", params).then((res) => {
                this.collect = res.data.data;
                console.log('collect:' + res.data.data)

                if (this.collect == 1) {
                    this.collectclass = 'head-right-operation-collect-active'
                }
            });
        }
    },
    created() {
        this.questionBankDetailID = this.$route.query.id
        this.getQuestionBankStructrue()
        this.getQBList()
        this.getIsCollect()
    }
}
</script>

<style lang="less" scoped>
.main {
    width: 90%;

    .head {
        margin-bottom: 50px;
        float: left;
        width: 80%;
        margin-right: 20%;

        .head-left-img {
            height: 120px;
            float: left;
            margin-bottom: 20px;
        }

        .head-right {
            float: left;
            margin-left: 10px;

            .head-right-title {
                font-family: YuYang_W04;
                font-size: 1.5em;
                color: #000000;
                margin-bottom: 10px;
            }

            .head-right-userhead {
                float: left;
                height: 30px;
                border-radius: 10px;
            }

            .head-right-username {
                float: left;
                font-family: YuYang_W02;
                font-size: 1em;
                color: #000000;
                margin-left: 5px;
            }

            .head-right-operation {
                clear: both;
                float: left;
                margin-top: 10px;

                .head-right-operation-collect {
                    float: left;
                    margin-top: 10px;
                }

                .head-right-operation-collect-active {
                    float: left;
                    margin-top: 10px;
                    background-color: #e6a23c;
                    border-color: #e6a23c;
                    color: white;
                }

            }
        }
    }

    .question {
        float: left;
        width: 80%;

        .question-collapse {
            .question-collapse-card {
                margin-bottom: 20px;

                .question-collapse-card-title {
                    margin-top: 20px;
                    font-family: YuYang_W04;
                    font-size: 1.5em;
                    margin-bottom: 10px;
                    color: #000000;
                    text-align: left;
                }

                .question-collapse-card-point {
                    margin-top: 10px;
                    font-family: YuYang_W02;
                    font-size: 1em;
                    margin-bottom: 10px;
                    color: #6d6d6d;
                    text-align: left;
                }
            }
        }
    }

}</style>