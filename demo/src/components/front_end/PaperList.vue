<template>
    <div class="container" v-infinite-scroll="load" infinite-scroll-disabled="disable" infinite-scroll-immediate="false"
        style="overflow:hidden; height:100%" infinite-scroll-distance="100" infinite-scroll-delay="2000">

        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>

                <div class="main">

                    <!-- 左侧 -->
                    <div class="main-left">
                        <div class="search">
                            <el-input placeholder="请输入内容" v-model="input" class="input-with-select">

                                <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
                            </el-input>
                        </div>
                        <div class="card">
                            <div>
                                <div class="card-items" v-for="item in paperList">
                                    <el-card class="card-item">
                                        <div class="card-title">
                                            <router-link :to="{ path: '/PaperDetail', query: { id: item.id } }">{{
                                                item.title
                                            }}</router-link>
                                        </div>
                                        <div class="card-in">
                                            <div class="card-word">
                                                <img :src="item.img" class="card-img">
                                                <div class="card-intro">
                                                    {{ item.intro }}
                                                </div>
                                            </div>

                                            <!-- <div class="card-operation">
                                                <div>
                                                    <el-button type="primary" plain class="card-opration-good"
                                                        icon="el-icon-thumb">
                                                        <div class="card-operation-good-text">点赞</div>
                                                    </el-button>
                                                </div>
                                                <i class="el-icon-star-off"></i>
                                            </div> -->
                                        </div>
                                    </el-card>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--右侧-->
                    <div class="main-right">
                        <el-card class="main-right-list">
                            <div class="main-right-list-title">
                                <div class="main-right-list-title-name">Popular</div>
                                <el-divider class="main-right-list-title-divider"></el-divider>
                            </div>
                            <div v-for="(item, i) in popularList" :key="i" class="main-right-list-intro">
                                <div class="main-right-list-intro-num">{{ '0' + i }}</div>
                                <div class="main-right-list-intro-name">
                                    <router-link :to="{ path: '/PaperDetail', query: { id: item.id } }">
                                        {{ item.title }}
                                    </router-link>
                                </div>
                            </div>
                        </el-card>
                    </div>

                    <!-- 回到顶部 -->
                    <!-- <el-backtop target=".page-component__scroll .el-scrollbar__wrap"  :bottom='500' :visibility-height="200" >
                        <div class="backToTop">
                            UP
                        </div>
                    </el-backtop> -->
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
import infiniteScroll from 'vue-infinite-scroll'
export default {
    directives: { infiniteScroll },
    name: 'PaperList',
    data() {
        return {
            paperlistLoading: false,
            paperList: [],
            popularList: [],
            pageIndex: 1,
            input: '',
            select: ''
        }
    },
    components: {
        Nav, Foot, Search
    },
    methods: {
        getMostLovedList() {
            setTimeout(500)
            this.$http.get("/zcxy/paperStatistic/mostLovedList").then((res) => {
                this.popularList = res.data.data;
                console.log(res.data.data)
            });
        },
        load() {
            console.log(this.pageIndex)
            this.pageIndex++
            this.getPaperList()
        },
        getPaperList() {
            const params = {
                params: {
                    pageIndex: this.pageIndex,
                    pageSize: 5,
                },
            };
            this.$http.get("/zcxy/paperList/list", params).then((res) => {
                // console.log(res.data.data.list)
                this.paperList = this.paperList.concat(res.data.data.list);
                console.log(this.paperList)
            });
        },        
        search() {
            const params = {
                params: {
                    filed: this.select,
                    key:'%'+this.input+'%'
                },
            };
            this.$http.get("/zcxy/paperDetail/getByKeywords", params).then((res) => {
                console.log(res.data.data)
                this.paperList=res.data.data
                

            });
        }
    },
    mounted() {
        this.getPaperList()
        this.getMostLovedList()
    }
}
</script>

<style lang="less" scoped>
.backToTop {
    height: 100%;
    width: 100%;
    background-color: #f2f5f6;
    box-shadow: 0 0 6px rgba(0, 0, 0, .12);
    text-align: center;
    line-height: 40px;
    color: #1989fa;
}

.main-right {
    width: 30%;
    float: left;
    margin-left: 15px;
    /* margin-top: 15px; */
    .main-right-list{
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

.card-items {
    margin-bottom: 10px;

}

.card-item {
    padding-bottom: 15px;
}

.el-icon-star-off {
    color: rgb(251, 200, 59);
    font-size: 1.5em;
    text-align: center;
    float: left;
    margin-left: 10px;
    margin-top: 5px;
}

.card-operation-good-text {
    font-family: YuYang_W04;
    font: 0.8em;
}

.card-opration-good {
    width: fit-content;
    display: flex;
    float: left;
}

.card-intro {
    padding-left: 20px;
    padding-bottom: 0px;
    /* margin-left: 10px; */
    font-family: YuYang_W02;
    font-size: 0.95em;
    float: left;
    /* height: 8.5em; */

    display: -webkit-box;
    /*作为弹性伸缩盒子模型显示*/
    -webkit-line-clamp: 6;
    /*显示的行数；如果要设置2行加...则设置为2*/
    overflow: hidden;
    /*超出的文本隐藏*/
    text-overflow: ellipsis;
    /* 溢出用省略号*/
    -webkit-box-orient: vertical;
    /*伸缩盒子的子元素排列：从上到下*/

}

.card {
    margin-top: 10px;

}

.card-operation {
    float: left;
    margin-top: 10px;
    display: flex;

}

.card-word {
    margin-top: 10px;
    display: flex;
    float: left;
    text-align: left;
    height: 7em;
}

.card-img {
    float: left;
    height: 100%;
    width: 30%;
    display: flex;

}

.card-title {
    font-family: YuYang_W05;
    font: 4em;
    float: left;
}

.main-left {
    width: 65%;
    float: left;
    /* margin-left: 50px; */
}
.search {
    /* margin-top: 15px; */
}

.el-select .el-input {
    width: 130px;
}

.input-with-select .el-input-group__prepend {
    background-color: #fff;
}
</style>