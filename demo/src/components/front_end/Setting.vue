<template>
    <div>

        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>


                <div class="contain">
                    <el-card shadow="always" class="contain-card">
                        <el-form ref="userform" :model="userform" label-width="80px">
                            <el-form-item label="用户名">
                                <el-input v-model="userform.name"></el-input>
                            </el-form-item>
                            <el-form-item label="邮箱">
                                <el-input v-model="userform.email"></el-input>
                            </el-form-item>
                            <el-form-item label="电话">
                                <el-input v-model="userform.mobile"></el-input>
                            </el-form-item>
                            <el-form-item label="年龄">
                                <el-input v-model="userform.name"></el-input>
                            </el-form-item>
                            <el-form-item label="性别" style="text-align:left">
                                <el-radio-group v-model="userform.sex">
                                    <el-radio label="男"></el-radio>
                                    <el-radio label="女"></el-radio>
                                </el-radio-group>
                            </el-form-item>
                            <el-form-item label="生日">
                                <el-col :span="11">
                                    <el-date-picker value-format="yyyy-MM-dd" placeholder="选择日期" v-model="userform.birth"
                                        style="width: 100%;"></el-date-picker>
                                </el-col>
                            </el-form-item>
                            <el-form-item label="爱好">
                                <el-input v-model="userform.liketodo"></el-input>
                            </el-form-item>
                            <el-form-item label="个性签名">
                                <el-input v-model="userform.sign"></el-input>
                            </el-form-item>
                            <el-form-item label="个人介绍">
                                <el-input type="textarea" v-model="userform.intro"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="primary" @click="updateUser">确认修改</el-button>
                                <el-button>取消</el-button>
                            </el-form-item>
                        </el-form>
                    </el-card>

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
import '@/assets/css/front_end_layout.css'

export default {
    name: "Setting",
    data() {
        return {
            userform: {
                name: this.$store.getters.getUserName,
                email: '',
                mobile: '',
                age: '',
                sex: '',
                birth: '',
                liketodo: '',
                sign: '',
                intro: '',
                passwd: '',
            }
        };
    },
    methods: {
        getUser() {
            const params = {
                params: {
                    name: this.userform.name,
                },
            };
            this.$http.get("/sys/sysUser/getUserInfo", params).then((res) => {
                console.log(res.data.data)
                var userInfo = res.data.data[0];

                this.userform['userhead'] = userInfo['userhead']
                this.userform['email'] = userInfo['email']
                this.userform['mobile'] = userInfo['mobile']
                this.userform['age'] = userInfo['age']
                this.userform['sex'] = userInfo['sex']
                this.userform['intro'] = userInfo['intro']
                this.userform['birth'] = userInfo['birth']
                this.userform['liketodo'] = userInfo['liketodo']
                this.userform['sign'] = userInfo['sign']

                console.log(this.userform)
            })
        },
        updateUser() {
            const params = {
                body: {
                    "username":this.userform.name,
                    "age": this.userform.age,
                    "birth": this.userform.birth,
                    "email": this.userform.email,
                    "intro": this.userform.intro,
                    "liketodo": this.userform.liketodo,
                    "mobile": this.userform.mobile,
                    "userhead": this.userform.userhead,
                    "passwd": this.userform.passwd,
                    "sex": this.userform.sex,
                    "sign": this.userform.sign
                },
            };
            this.$http.post("/sys/sysUser/UpdateUser", params.body).then((res) => {
                console.log(res.data.data)

            })
        },
        onSubmit() {
            console.log(this.userform);
        }
    },
    components: {
        Nav, Foot
    },
    mounted() {
        this.getUser()
    }
};
</script>

<style lang="less" scoped>
.contain {

    .contain-card {
        width: 60%;
        margin: auto;
        padding: 10px;
        padding-top: 20px;

    }
}
</style>






