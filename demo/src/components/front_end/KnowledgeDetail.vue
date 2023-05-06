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
                        <img :src="knowledge.coverurl" class="head-left-img">
                        <div class="head-right">
                            <div class="head-right-title">{{ knowledge.title }}</div>
                            <img :src="knowledge.userhead" class="head-right-userhead">
                            <div class="head-right-username">{{ knowledge.username }}</div>
                            <div class="head-right-operation">
                                <el-button plain :class="collectclass" @click="collectKnowledge">收藏</el-button>
                            </div>
                        </div>
                    </el-card>

                    <!--知识点详情-->
                    <div v-if="knowledgeDetailL.length !== 0">
                        <div class="detail">
                            <el-card shadow="hover" v-for="(item, index) in knowledgeDetailL" :key="index"
                                class="detail-card">
                                <div class="detail-card-title">{{ item.title }}</div>
                                <div class="detail-card-exp">{{ item.explanation }}</div>
                            </el-card>
                        </div>
                    </div>
                    <div v-else>
                        <div class="detail-card-title">暂无知识点</div>
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
    name: 'KnowledgeDetail',
    data() {
        return {
            knowledgeDetailID: '',
            knowledgeDetailL: [],
            knowledge: {},
            activeStep: 1,
            collect: 0,
            collectclass: 'head-right-operation-collect',
        }
    },
    components: {
        Nav, Foot
    },
    methods: {
        collectKnowledge() {
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
                    knowledgeid: this.knowledgeDetailID,
                    operation: this.collect,
                    username: localStorage.getItem("username")
                },
            };
            this.$http.get("/zcxy/UserCollectKnowledge/collect", params).then((res) => {
                console.log(res.data)
            });


            // 改变数据表
            const params1 = {
                params: {
                    id: this.knowledgeDetailID,
                    operation: this.collect
                },
            };
            this.$http.get("/zcxy/KnowledgeStatistic/collect", params1).then((res) => {
                console.log(res.data)
            });
        },
        getKnowledgeDetail() {
            const params = {
                params: {
                    id: this.knowledgeDetailID,
                },
            };
            this.$http.get("/zcxy/konwledgeDetail/getKnowledgeDetail", params).then((res) => {
                console.log(res.data.data)
                this.knowledgeDetailL = res.data.data;
            });
        },
        getKnowledge() {
            const params = {
                params: {
                    id: this.knowledgeDetailID,
                },
            };
            this.$http.get("/zcxy/konwledgeList/getKnowledge", params).then((res) => {
                console.log(res.data.data)
                this.knowledge = res.data.data;
            });
        },
        getIsCollect() {
            const params = {
                params: {
                    knowledgeid: this.knowledgeDetailID
                },
            };
            this.$http.get("/zcxy/UserCollectKnowledge/geIstCollect", params).then((res) => {
                this.collect = res.data.data;
                console.log('collect:' + res.data.data)

                if (this.collect == 1) {
                    this.collectclass = 'head-right-operation-collect-active'
                }
            });
        }
    },
    created() {
        this.knowledgeDetailID = this.$route.query.id
        this.getKnowledgeDetail()
        this.getKnowledge()
        this.getIsCollect()
        console.log('knowledgeDetailL:'+this.knowledgeDetailL.length)
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
                float: left;
                width: 100%;

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

    .detail {
        .detail-card {
            margin-bottom: 30px;

            .detail-card-title {
                float: left;
                text-align: left;
                font-family: YuYang_W04;
                font-size: 1.5em;
                color: #000000;
                margin-bottom: 10px;
                width: 100%;
            }

            .detail-card-exp {
                float: left;
                font-family: YuYang_W02;
                font-size: 1em;
                color: #000000;
                margin-bottom: 10px;
                text-align: left;
            }
        }
    }

}</style>
