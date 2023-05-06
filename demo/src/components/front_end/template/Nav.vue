<template>
    <div>
        <div class="nav">
            <el-menu :default-active="$route.path" class="el-menu-demo" mode="horizontal" router>
                <el-menu-item class="nav-logo">Psycho</el-menu-item>
                <el-menu-item :index="item.path" v-for="item in menu" :key="item.id" class="nav-txt">{{ item.name
                }}</el-menu-item>

                <div>
                    <el-dropdown @command="handleCommand" class="nav-user">
                        <span class="el-dropdown-link">
                            <div v-if="userhead == ''">
                                <el-avatar> user </el-avatar>
                            </div>
                            <div v-if="userhead !=''">
                                <img :src="userhead" class="nav-userhead">
                            </div>

                        </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="home"><router-link to="/Home">我的主页</router-link></el-dropdown-item>
                            <!-- <el-dropdown-item command="b">统计信息</el-dropdown-item>
                            <el-dropdown-item command="c">收藏夹</el-dropdown-item> -->
                            <el-dropdown-item command="setting"><router-link
                                    to="/Setting">设置</router-link></el-dropdown-item>
                            <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                </div>
            </el-menu>
        </div>
        <div class="line"></div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            navActive: '1',
            menu: [

                {
                    'id': 1,
                    'name': '首页',
                    'path': '/',
                    'enable': 1
                },
                {
                    'id': 2,
                    'name': '文章',
                    'path': '/PaperShow',
                    'enable': 1
                },
                {
                    'id': 3,
                    'name': '学习',
                    'path': '/KnowledgeList',
                    'enable': 1
                },
                {
                    'id': 4,
                    'name': '题库',
                    'path': '/QuestionBankList',
                    'enable': 1
                }],
            userhead: '',

        };
    },
    methods: {
        handleCommand(command) {
            console.log(command)
            if (command == 'logout') {
                localStorage.clear();
                console.log(localStorage)
                if (localStorage.length == 0) {
                    this.$router.push("/FrontEndLogin");
                }

            }
        },
        goto(e) {
            // e=e.target
            console.log(e)
            console.log(e.target)
            console.log(e.currentTarget)
        },
        handleSelect(e, key, path) {
            // console.log(key, keyPath);
            console.log(e)
            console.log(key)
            console.log(path)

        },
        load(){
            this.userhead=this.$store.getters.getUserHead
        }

    },
    mounted() {
        this.load()
    }
}



</script>

<style lang="less" scoped>
.nav {
    .nav-logo {
        font-family: YuYang_W05;
        font-size: 1.7em;
        float: left;
        color: rgb(0, 0, 0);
    }

    .nav-txt {
        font-family: YuYang_W02;
        font-size: 1em;
        float: left;
    }

    .nav-user {
        float: right;
        margin-top: 10px;
    }

    .nav-userhead {
        border-radius: 50%;
        display: inline-block;

        box-sizing: border-box;
        text-align: center;
        overflow: hidden;

        width: 40px;
        height: 40px;

    }
}
</style>