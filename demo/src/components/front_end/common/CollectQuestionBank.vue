<template>
    <div class="collect">
        <div class="collect-head">题库收藏</div>
        <el-divider></el-divider>
        <el-card class="collect-body" v-for="(item, i) in collectList" :key="i">

                <div class="collect-body-title">
                    <router-link :to="{ path: '/KnowledgeDetail', query: { id: item.id } }">
                        {{ item.title }}
                    </router-link>
                </div>
                <div class="collect-body-content">
                    <img :src="item.coverurl" class="collect-cody-img">
                    <!-- <div class="collect-body-intro">{{item.intro}}</div> -->
                </div>

        </el-card>
    </div>
</template>

<script>
import '@/assets/css/front_end_layout.css'

export default {
    name: 'Collect',
    data() {
        return {
            collectList: [],
        }
    },
    methods: {
        getCollectPaperList() {
            const params = {
                params: {
                    name: localStorage.getItem("username")
                },
            };
            this.$http.get("/zcxy/questionBankList/getCollectQuestionBankList", params).then((res) => {
                this.collectList =res.data.data
                console.log(res.data.data)
            });
        }
    },
    mounted(){
        this.getCollectPaperList()
    }
}
</script>

<style lang="less" scoped>
.collect{
    width: 100%;
    .collect-head{
        margin-top: 10px;
        font-family: YuYang_W04;
        font-size: 1.2em;
    }
    .collect-body{
        margin-top: 20px;
        width: 100%;
        float: left;
        padding: 10px;

        .collect-body-title{
            width: 100%;
            float: left;
            margin-top: 10px;
            font-family: YuYang_W03;
            font-size: 1em;


            display: -webkit-box;
            /*作为弹性伸缩盒子模型显示*/
            -webkit-line-clamp: 2;
            /*显示的行数；如果要设置2行加...则设置为2*/
            overflow: hidden;
            /*超出的文本隐藏*/
            text-overflow: ellipsis;
            /* 溢出用省略号*/
            -webkit-box-orient: vertical;
            /*伸缩盒子的子元素排列：从上到下*/
        }
        .collect-body-content{
            float: left;
            margin-top: 10px;
            .collect-cody-img{
                height: 80px;
                float: left;
            }
            .collect-body-intro{
                float: left;
                margin-top: 10px;
                font-family: YuYang_W04;
                font-size: 0.8em;
                color: gray;
                width: 70%;
                margin-left: 10px;
    
                display: -webkit-box;
                /*作为弹性伸缩盒子模型显示*/
                -webkit-line-clamp: 3;
                /*显示的行数；如果要设置2行加...则设置为2*/
                overflow: hidden;
                /*超出的文本隐藏*/
                text-overflow: ellipsis;
                /* 溢出用省略号*/
                -webkit-box-orient: vertical;
                /*伸缩盒子的子元素排列：从上到下*/
            }
        }

    }
}
</style>


