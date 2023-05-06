<template>
    <div>

        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>

                <div class="main">
                    <!-- 答题区 -->
                    <div class="main-left" v-if="question.length !== 0">
                        <el-form ref="ruleForm">

                            <el-card shadow="always" v-for="(item, index) in question" :key="item.id"
                                class="main-left-card">

                                <div class="main-left-tag">
                                    {{ item.type }}:
                                </div>
                                <div class="main-left-title">{{ item.title }}</div>
                                <div class="main-left-options">

                                    <div v-if="item.type == '单选题'">

                                        <el-form-item prop="option">
                                            <el-radio-group v-model="item.option">
                                                <div v-for="(i, index) in item.options" class="main-left-options-option">
                                                    <el-radio :label="i.option" border @change="saveAnwser($event)">{{
                                                        i.option }}</el-radio>
                                                </div>
                                            </el-radio-group>
                                        </el-form-item>

                                        <div v-if="isQuestion == true" class="main-left-options-anwsers">
                                            <div v-if="anwser!=undefined">
                                                <div class="main-left-options-anwser">
                                                    正确答案：{{ anwser }}
                                                </div>
                                                <div class="main-left-options-anwser">
                                                    您选择的答案： {{ ruleForm.choies }}
                                                </div>
                                                <div v-for="item in analze" class="main-left-options-analze">
                                                    解析:{{ item.analyze }}
                                                </div>
                                            </div>
                                            <div v-else class="main-left-options-analze">
                                                无
                                            </div>

                                        </div>

                                    </div>

                                    <div v-if="item.type == '多选题'">
                                        <el-form-item prop="option">
                                            <el-checkbox-group @input="change($event)" v-model="item.resource">
                                                <div v-for="(i, index) in item.options" class="main-left-options-option">
                                                    <el-checkbox :label="i.option" border @change="saveAnwser($event)">{{
                                                        i.option }}</el-checkbox>
                                                </div>
                                            </el-checkbox-group>
                                        </el-form-item>

                                        <div v-if="isQuestion == true" class="main-left-options-anwsers">
                                            <div class="main-left-options-anwser">
                                                正确答案：{{ anwser }}
                                            </div>
                                            <div class="main-left-options-anwser">
                                                您选择的答案： {{ ruleForm.choies }}
                                            </div>
                                            <div v-for="item in analze" class="main-left-options-analze">
                                                解析:{{ item.analyze }}
                                            </div>
                                        </div>


                                    </div>

                                    <!-- <div v-if="item.questionType == '简答题'">
                                        <el-form-item prop="option">
                                            <el-input type="textarea" v-model="item.option"  @click="saveAnwser($event)"></el-input>
                                        </el-form-item>
                                    </div> -->

                                </div>
                            </el-card>

                            <!-- 提交函数  -->
                            <div class="button">
                                <el-form-item style="text-align: center" class="main-left-submit">
                                    <el-button type="success" @click="getNextQuestion(-1)">上一题</el-button>
                                </el-form-item>
                                <el-form-item style="text-align: center" class="main-left-submit">
                                    <el-button type="primary" @click="submitForm()">提交</el-button>
                                </el-form-item>
                                <el-form-item style="text-align: center" class="main-left-submit">
                                    <el-button type="success" @click="getNextQuestion(1)">下一题</el-button>
                                </el-form-item>
                            </div>


                        </el-form>
                    </div>

                    <div v-else>
                        <div class="none" style="margin-left: 0px">
                            <div class="none_img"></div>
                            <h3>暂无试题</h3>
                        </div>
                    </div>

                    <!-- 右侧解析区 -->
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
    name: "AnwserQuestion",
    data() {
        return {
            isQuestion: false,
            qbid: '',
            id: '',
            chapter: '',
            question: [],
            analze: [],
            anwser: '',


            ruleForm: {
                choies: '',
                option: '',
                desc: '',

            },

        };
    },
    methods: {
        saveAnwser(e) {
            // console.log(e)
            this.ruleForm.choies = e
        },
        submitForm() {
            this.isQuestion = true
            this.getAnalzeList()
        },
        getAnalzeList() {
            const params = {
                params: {
                    id: this.id,
                },
            };
            this.$http.get("/zcxy/analzeList/getAnalzeList", params).then((res) => {
                this.analze = res.data.data;
                console.log(res.data.data)
            });
        },
        getQuestion() {
            const params = {
                params: {
                    id: this.id,
                },
            };
            this.$http.get("/zcxy/questionBankDetail/getQuestion", params).then((res) => {
                this.question = res.data.data;
                this.handleOptions();
                console.log(res.data.data)
            });
        },
        getTenQuestion() {

            const params = {
                params: {
                    qbid: this.qbid,
                    id: this.id,
                    chapter: this.chapter,
                },
            };
            this.$http.get("/zcxy/questionBankDetail/getTenQuestion", params).then((res) => {
                this.question = res.data.data;
                this.handleOptions();
                console.log(res.data.data)
            });
        },
        handleOptions() {
            this.question.forEach(q => {
                q.options = q.options.split("},")

                //将字符串转为json
                for (let i = 0; i < q.options.length - 1; i++) {
                    q.options[i] = q.options[i] + '}'
                    q.options[i] = q.options[i].replace('True', 'true')
                    q.options[i] = q.options[i].replace('None', 'null')
                    q.options[i] = q.options[i].replace('False', 'false')
                    q.options[i] = q.options[i].replace('\n', '')
                    q.options[i] = JSON.parse(q.options[i])
                }

                //处理json
                for (let i = 0; i < q.options.length; i++) {
                    if (q.options[i] == '') {
                        q.options.pop()
                    }
                    // console.log(q.options[i])
                    let flag = q.options[i]['isAnswer']
                    //增加正确答案键值对
                    if (flag == true) {
                        this.anwser = q.options[i]['option']
                    }
                }

                console.log(q.options)

            })

        },
        getNextQuestion(operation){
            const params = {
                params: {
                    qbid:this.qbid,
                    id: this.id,
                    chapter:this.chapter,
                    operation:operation,
                },
            };
            this.$http.get("/zcxy/questionBankDetail/getNextQuestion", params).then((res) => {
                this.question = res.data.data;
                this.handleOptions();
                console.log(res.data.data)
            });
            this.isQuestion=false
            if(operation==1){
                this.id=String(Number(this.id)+1)
            }else{
                this.id=String(Number(this.id)-1)
            }

        },

    },
    components: {
        Nav, Foot
    },
    created() {
        this.qbid = this.$route.query.qbid
        this.id = this.$route.query.id
        this.chapter = this.$route.query.chapter
        this.getQuestion()
    }
};
</script>
  
<style lang="less" scoped>
.main {
    width: 90%;
    margin: auto;

    .main-left {
        margin: auto;
        width: 60%;

        .main-left-card {
            margin-top: 30px;

            .main-left-tag {
                width: 100%;
                float: left;
                font-family: YuYang_W02;
                font: 0.5em;
                text-align: left;
                margin-left: 10px;
            }

            .main-left-title {
                width: 100%;
                margin-top: 20px;
                margin-bottom: 20px;
                float: left;
                font-family: YuYang_W05;

                font: 1em;
                text-align: left;
                margin-left: 10px;
            }

            .main-left-options {
                float: left;

                .main-left-options-anwsers {
                    .main-left-options-anwser {
                        margin-bottom: 10px;
                        float: left;
                        font-family: YuYang_W02;
                        font: 0.8em;
                        color: black;
                        text-align: left;
                        width: 100%;
                    }

                    .main-left-options-analze {
                        margin-bottom: 10px;
                        float: left;
                        font-family: YuYang_W03;
                        font: 0.8em;
                        color: black;
                        text-align: left;
                    }
                }

                .main-left-options-option {
                    width: 100%;
                    float: left;
                    font-family: YuYang_W02;
                    font: 0.8em;
                    color: black;
                    text-align: left;



                    /deep/ .el-radio {
                        margin-top: 30px;

                        //从这里开始 就是更改颜色的代码，将你的颜色           改掉我的颜色就可以了
                        .el-radio__label {
                            color: #000 !important;
                            min-width: 300px;

                        }

                        .el-radio__input {
                            margin-bottom: px(5);

                            .el-radio__inner {
                                background-color: #ffffff00;
                                border-color: #ffffff00;
                            }

                            &.is-checked {
                                .el-radio__inner {
                                    background-color: #ffffff00;
                                    border-color: #ffffff00;
                                }
                            }

                            .el-radio__inner {
                                &:hover {
                                    border-color: #1c3f3b;
                                }
                            }

                        }

                        .el-radio__label {
                            float: left;
                            font-family: YuYang_W05;
                            font: 2em;
                            color: black;
                            text-align: left;
                        }

                    }
                }

            }
        }
        .button{
            float: left;
            margin-left: 30%;
            .main-left-submit {
                margin-top: 40px;
                float: left;
                margin-right: 20px;
            }
        }
    }


}

.el-form-item__content {
    margin-left: 0px;
}</style>