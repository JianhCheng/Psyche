<template>
    <div class="container">
        <el-container>
            <el-header>
                <Nav></Nav>
            </el-header>
            <el-main>

                <div class="main">

                    <el-card class="box-card">
                        <div class="detail-head">
                            <div class="detail-head-left">
                                <div class="detail-head-left-title">{{ paperDetail.title }}</div>
                                <div class="detail-head-left-info">
                                    <div class="detail-head-left-from">{{ paperDetail.auth }}</div>
                                    <div class="detail-head-left-time">{{ paperDetail.time }}</div>
                                </div>
                            </div>
                            <img :src="paperDetail.img" class="detail-head-right-img">
                        </div>
                        <div class="detail-body">
                            <div class="detail-body-operation">
                                <div class="detail-body-operation-icons">
                                    <el-button type="info" icon="el-icon-postcard" class="detail-body-operation-icon"
                                        circle></el-button>
                                </div>
                                <div class="detail-body-operation-icons">
                                    <el-button id="collect" icon="el-icon-star-off" :class="collectclass"
                                        circle @click="collectPaper"></el-button>
                                </div>
                                <div class="detail-body-operation-icons">
                                    <el-button id="like" icon="el-icon-thumb" :class="likeclass" circle
                                        @click="likePaper"></el-button>
                                </div>
                            </div>
                            <div class="detail-body-key">关键词：{{ paperDetail.keywords }}</div>
                            <div class="detail-body-contain-text" v-html="paperDetail.content"></div>

                        </div>
                    </el-card>

                    <div class="detail-readnext">
                        <div class="detail-readnext-title">Read Next</div>
                        <el-divider class="detail-readnext-divider"></el-divider>
                        <div class="paper-thesis">
                            <!-- 左 -->
                            <div class="paper-thesis-left">
                                <img :src="nextPaper[0].img" class="paper-thesis-left-img">
                                <div class="paper-thesis-left-title">
                                    <router-link target="_blank"
                                        :to="{ path: '/PaperDetail', query: { id: nextPaper[0].id } }">
                                        {{ nextPaper[0].title }}
                                    </router-link>
                                </div>
                                <div class="paper-thesis-left-intro">{{ nextPaper[0].intro }}</div>
                                <div class="paper-thesis-left-name">{{ nextPaper[0].srouce }}</div>
                            </div>
                            <!-- 右 -->
                            <div class="paper-thesis-right">
                                <div class="paper-thesis-right-item" v-for="item in nextPaper.slice(1)" :key="item.id">
                                    <img :src="item.img" class="paper-thesis-right-img">
                                    <div class="paper-thesis-right-in">
                                        <div class="paper-thesis-right-title">
                                            <router-link target="_blank"
                                                :to="{ path: '/PaperDetail', query: { id: item.id } }">
                                                {{ item.title }}
                                            </router-link>
                                        </div>
                                        <div class="paper-thesis-right-name">{{ item.srouce }}</div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </el-main>
            <el-footer>
                <Foot></Foot>
            </el-footer>
        </el-container>
        <router-view />
    </div>
</template>


<script>
import Nav from '@/components/front_end/template/Nav.vue';
import Foot from '@/components/front_end/template/Foot.vue';
import Tab from '@/components/front_end/common/Tab.vue';
import '@/assets/css/front_end_layout.css'

export default {
    name: 'PaperDetail',
    data() {
        return {
            text: [
                { id: 1, txt: '许多家长都有一种“不能让孩子输在起跑线上”的观念，不管是学钢琴，练跳舞，还是学外语，都觉得越早越好。尤其是现在需要用到外语的地方越来越多，日常交流，出国旅游留学，甚至工作中都不免需要和外语打交道。与此相对应的是各种各类的外语学习培训课程的火爆，有线上APP，线下外教，也有培训班，家教等等方式。同时，这一现象也在传达着一种焦虑，那就是外语学习越早越好，甚至已经出现了针对孕妇的外语胎教。' },
                { id: 2, txt: '外语学习真的是越早越好吗？人们是否在某个年龄阶段对外语学习更有优势呢？如果有，存在这种优势的原因是什么呢？作为一个外语基础薄弱的成人，能够学好外语吗？' },
                { id: 3, txt: '上述这些问题不仅家长、学生关心，研究语言问题的心理学家们同样关注这一问题，对这类问题的研究主要考察的是语言的关键期问题。接下来，我们将从关键期是什么，第二语言学习是否存在关键期，这一关键期的年龄段，为什么存在关键期，以及我们应该如何对待关键期等问题展开介绍。' },
                { id: 4, txt: '（一） 什么是关键期？ ' },
                { id: 5, txt: '“关键期”是指在个体成长过程中，存在某个时间段个体会对某种技能或行为方式非常敏感，如果在这一时期没有针对这种技能进行适宜的学习或给予恰当的刺激，这种技能会很难形成[1]。1910年，德国行为学家海因罗特在实验中发现一个十分有趣的现象：刚刚破壳而出的小鹅，会本能地跟随在它第一眼见到的自己的母亲后面。但是，如果它第一眼见到的不是自己的母亲，而是其他活动物体，如一只狗、一只猫或者一只玩具鹅，它也会自动地跟随其后。尤为重要的是，一旦这只小鹅形成了某个物体的跟随反应后，它就不可能再形成对其他物体的跟随反应了。这种后来被另一位德国行为学家洛伦兹称之为“印刻效应”的现象。洛伦兹认为，能够产生印刻现象的这个时间窗口是关键期。对于小鹅来说，一旦过了关键期，就不会再产生印刻现象，同时已经产生的印刻现象也将不能改变了。' },
                { id: 6, txt: '（二） 第二语言学习的关键期是否存在？' },
                { id: 7, txt: '1967年，Lenneberg首先提出了关键期假设（Critical Period Hypothesis）[2]。关键期假设认为，青春期以前，学习者由于年龄小，生理和心理处于发育期，大脑的可塑性较强，因此比较容易学会地道的第二语言，而成人发育完全成熟，大脑逐渐失去可塑性，错过了二语学习的最佳年龄，因此较难学会第二语言。这个观点对语言学研究产生了巨大的影响。此后，语言学习是否存在关键期就一直是二语习得研究领域中一个长期争论的焦点[3]。' },
                { id: 8, txt: '让我们看一下支持关键期假设的有趣发现吧！' },
                { id: 9, txt: '美国的政治家基辛格对于我们来说并不陌生，他是中美外交的“活化石”。基辛格12岁从德国移民来到美国，他的英语中有严重的德语口音，而仅仅年小他两岁的弟弟的英语却很纯正，这被认为是第二语言关键期存在的一个很好的例证。' },
                { id: 10, txt: '在第二语言关键期的研究中，对于语音和句法的研究都发现了关键期存在的证据。第二语言的学习年龄可以显著的预测最终的口语水平[4]。有研究者发现，6岁之前开始学习二语的儿童，口语都较为纯正；6到12岁的学习者，有的口语纯正，有的存在口音问题；12岁以后的学习者一般都会存在口音问题[5]。对于语法的学习来说，研究发现，7岁之后语法习得的正确率开始逐渐下降[6] [7]。有研究进一步发现10—12岁开始学习二语的儿童在复杂句法结构掌握上差于7-9岁开始学习二语的儿童，不过在简单的句法结构上，两组儿童不存在差异[8]。从这些证据中可以看出，无论是语音还是句法方面，的确存在语言习得的优势年龄。二语学习存在最佳关键期，一旦超过了这一时段，很难达到二语学习的最佳效果；二语学习的关键期一般在青春期之前[9]。' },
                { id: 11, txt: '（三） 为什么存在第二语言学习的关键期？' },
                { id: 12, txt: '1.大脑可塑性的解释。大脑可塑性是指先天预成的结构或功能具有一定的可变性。人从出生到成年，脑的可塑性处在不断的变化过程中。年龄较小者，脑的可塑性非常强，但随着年龄的增长，大脑可塑性逐渐降低。这种观点认为大脑可塑性的降低导致了语言学习的成效[10]。' },
                { id: 13, txt: '2.普遍语法的解释。著名的语言学家乔姆斯基提出了普遍语法理论。普遍语法是由一些条件和规则所构成的人类语言中共性的成分[11]，同时这种普遍语法是先天的。成年人和儿童使用普遍语法的方式是不一样的：对于儿童来讲，第二语言习得过程中可以直接使用普遍语法；而对于成年人来讲，只能间接通过母语或者部分的使用甚至不能使用普遍语法来进行第二语言的学习[12]。因为普遍语法在语言学习中重要的作用，所以对于成人来说学习第二语言比儿童更吃力。' },
                { id: 14, txt: '3.输入与情绪过滤假说的解释。输入假说认为，儿童的第二语言学习能力比成人更好得益于满足以下几个语言输入的条件：一是数量条件上，学习第二语言的内容越多，经验越多，学的也就越好。儿童由于活动范围广，所以可以获得更多语言经验。在质量条件上，如果学习材料过难或者过于简单，都达不到好的学习效果，学习材料的难度略高于学习者已有的学习水平时，学习效果最好。对于儿童来说，周围人更可能使用更慢的语速和更简单的句子与其交流，儿童获得的输入质量更高，学习效果也就更好。在学习方式上，儿童在自然的日常交流中学习外语，而成人一般在课堂学习，书面阅读更多，口语交流相对较少。在情感条件上，情绪起着过滤的作用，在焦虑较低的情况下，才能更好的吸收所学知识[13]。情绪过滤假说认为，焦虑，动机，自信对于第二语言学习至关重要，最佳的学习状态就是动机适中，自信水平较强，焦虑情绪较弱[14]。' },
                { id: 15, txt: '4.除此之外，还有一些理论也对关键期问题进行了解释，例如：文化适应理论[15]（认为如果所学二语的社会文化与自身越接近，文化适应越好，二语学习也就越好），成熟理论[16]（不成熟的时候学习第二语言反而效果更好，因为学习更简单集中），进化假说[17]（伴随着语言的获得，语言学习能力逐渐失去）等。' },
                { id: 16, txt: '（四） 作为儿童家长/老师应该怎样利用二语学习关键期？' },
                { id: 17, txt: '1.建立适宜的语言环境。对于儿童来说，比较好的交流是语速较慢，句型简单，具体形象的对话，这样儿童学习的效率会更高。也可以充分利用一些周围的资源促进学习，例如和孩子一起读外语绘本，看电视的时候可以选择外语动画片，常常哼儿歌，甚至生活场景中遇到了什么新鲜的东西，可以用外语来表达，总而言之，就是创建一种外语情境，培养儿童的语感。因为这一阶段的儿童基本在具体形象思维阶段，对一些抽象概念还不理解，所以可以利用这一点，把知识形象化，从而促进儿童的外语学习。' },
                { id: 18, txt: '2.注重面对面的有效交流。研究表明，“共同注意（joint attention）”对于早期儿童的语言学习有促进作用[18]，面对面的交流可以增加共同注意的机会。共同注意通俗来说就是儿童与大人通过眼神的交流，共同注视第三者物体，知道彼此想说的是什么。面对面的自然交流过程中，需要儿童去倾听，去积极表达，即使说错了也不怕，可以及时纠正过来，即时反馈对于学习效果有促进作用[19]，以及可以增加与儿童的“共同注意”，来提高学习的效率。' },
                { id: 19, txt: '3.帮助儿童树立自信与兴趣。根据“情感过滤”的假说，在第二语言学习过程中，动机，自信与焦虑水平至关重要。因此，可以通过设立合适的小目标，给予小红花等奖励，恰当的鼓励表扬，把外语学习和孩子感兴趣的活动结合，比方看动画片，玩游戏等方式来促进儿童学习动机的提高，以及对外语能力的自信，也不要操之过急，给儿童过大压力，引发儿童的焦虑情绪。' },
                { id: 20, txt: '（五）作为二语学习过程中的成年人应怎样看待关键期？' },
                { id: 21, txt: '1.认识到成人也能够学好外语。根据普遍语法的假说，成人无法直接完全的利用普遍语法进行第二语言学习。但成年人有抽象思维能力，可以通过抽象总结的方式来学习语法知识，从而可以代偿先天的普遍语法，同样可以获得较好的学习效果。成人有体系化的知识和丰富的经验，可以通过把新知识纳入已有的知识体系的方式更快的学习第二语言。因此，在学习外语时，将学习内容条理化，体系化，把零散的知识放入自己的知识树中。' },
                { id: 22, txt: '2.树立良好的学习心态。根据情感过滤的假说，成年人在学习时，动机复杂，对自己能否学好外语的信心不足，同时自尊心较强，对外语存在恐惧焦虑的心理，都会影响外语的学习[20]。心理学有关成就动机的研究表明，动机与学习或者工作效率之间呈倒“U”型曲线的关系，与过高和过低的动机水平相比，中等水平动机下，人们的学习表现更好（耶克斯-多德森定律）。因此学习时要有学习的动机，但也不要过于看重结果，急于求成。应主动调整自己的学习心态，可以通过设置一些自己可以通过努力达成的小目标，每次目标都可以看到自己的进步，来增强对自己外语能力的自信。积极参加英语角等活动，主动开口交流，不要畏惧说错。' },
                { id: 23, txt: '3.多学多用，形成习惯。在学外语时，不要三天打鱼，两天晒网，要一直坚持学下去，形成一种习惯。如果一段时间不学习外语，外语能力就会逐渐退化，产生语言磨蚀的情况[21]。尤其是对于成人来说相对薄弱的听说方面，更要在日常生活中多加练习，刻意的制造外语的环境，让外语学习生活化。现在的一些手机APP上面的每日打卡，番茄钟等原理就是通过自我或者他人监督，帮助我们去更好的形成习惯，可以有选择的使用这些策略，形成适合自己的学习方法。' },
            ],
            paperId: '',
            like: 0,
            collect: 0,
            likeclass:'detail-body-operation-icon',
            collectclass:'detail-body-operation-icon',

            paperDetail: {},
            nextPaper: [],
        }
    },
    components: {
        Nav, Foot, Tab
    },
    methods: {
        collectPaper() {
            //控制收藏操作
            if (this.collect == 0) {
                this.collect++
                this.collectclass='collect-active'
            } else {
                this.collect--
                this.collectclass='detail-body-operation-icon'
            }
            console.log(this.collect)
            // 改变用户收藏表
            const params = {
                params: {
                    paperid:this.paperId,
                    operation: this.collect,
                    username:localStorage.getItem("username")
                },
            };
            this.$http.get("/zcxy/UserCollectPaper/like", params).then((res) => {
                console.log(res.data)
            });

            // 改变文章数据表
            const params1 = {
                params: {
                    id: this.paperId,
                    operation: this.like
                },
            };
            this.$http.get("/zcxy/paperStatistic/collect", params1).then((res) => {
                console.log(res.data)
            });
        },
        likePaper() {
            //控制点赞操作
            if (this.like == 0) {
                this.like++
                this.likeclass='like-active'
                
            } else {
                this.like--
                this.likeclass='detail-body-operation-icon'
            }
            console.log(this.like)

            //改变文章数据表
            const params = {
                params: {
                    id: this.paperId,
                    operation: this.like
                },
            };
            this.$http.get("/zcxy/paperStatistic/like", params).then((res) => {
                console.log(res.data)
            });

            //改变用户点赞数据表
            const params1 = {
                params: {
                    paperid:this.paperId,
                    operation: this.like,
                    username:localStorage.getItem("username")
                },
            };
            this.$http.get("/zcxy/UserLikePaperController/like", params1).then((res) => {
                console.log(res.data)
            });

        },
        getPaperById() {
            const params = {
                params: {
                    id: this.paperId
                },
            };
            this.$http.get("/zcxy/paperDetail/getPaperDetailById", params).then((res) => {
                this.paperDetail = res.data.data;
                console.log(res.data.data)
            });
        },
        getNextPaper() {
            const params = {
                params: {
                    id: this.paperId
                },
            };
            this.$http.get("/zcxy/paperDetail/getNextFivePaper", params).then((res) => {
                this.nextPaper = res.data.data;
                console.log(res.data.data)
            });
        },
        getCollect(){
            const params = {
                params: {
                    paperid: this.paperId
                },
            };
            this.$http.get("/zcxy/UserCollectPaper/geIstCollect", params).then((res) => {
                this.collect = res.data.data;
                console.log('collect:'+res.data.data)

                if(this.collect==1){
                    this.collectclass='collect-active'
                }
            });
        },
        getLike(){
            const params = {
                params: {
                    paperid: this.paperId
                },
            };
            this.$http.get("/zcxy/UserLikePaperController/geIstLike", params).then((res) => {
                this.like = res.data.data;
                console.log('like:'+res.data.data)

                if(this.like==1){
                    this.likeclass='like-active'
                }
            });
        },
    },
    created() {
        //获取路由参数
        this.paperId = this.$route.query.id
        this.getPaperById()
        this.getNextPaper()
        this.getCollect()
        this.getLike()
        this.getCollect()
    }
}
</script>

<style lang="less" scoped>
.main {
    .box-card {
        .detail-head {
            width: 100%;
            margin-top: 50px;

            .detail-head-left {
                width: 45%;
                float: left;

                .detail-head-left-title {
                    margin: 30px;
                    font-family: YuYang_W05;
                    font-size: 4em;
                }

                .detail-head-left-info {
                    margin-top: 15px;

                    .detail-head-left-from {
                        font-family: YuYang_W04;
                        font-size: 1em;
                    }

                    .detail-head-left-time {
                        font-family: YuYang_W02;
                        font-size: 0.2em;
                    }
                }
            }

            .detail-head-right-img {
                width: 45%;
                height: 500px;
            }
        }

        .detail-body {


            text-align: left;
            margin-top: 20px;
            margin-left: 5px;
            margin-right: 10px;

            .detail-body-operation {
                float: left;
                width: 25%;
                flex-direction: column;

                /* margin-left: 20%; */
                .detail-body-operation-icons {
                    margin-top: 9px;
                    margin-right: 20%;
                    float: right;
                    margin-left: 50%;

                    .like-active {
                        background-color: #f56c6c;
                        color: rgb(255, 255, 255);
                        border: 1px solidr #f56c6c;

                        height: 50px;
                        width: 50px;
                        float: left;
                    }

                    .collect-active {
                        background-color: #e6a23c;
                        color: rgb(255, 255, 255);
                        border: 1px solidr #e6a23c;

                        height: 50px;
                        width: 50px;
                        float: left;
                    }

                    .detail-body-operation-icon {
                        height: 50px;
                        width: 50px;
                        float: left;
                    }


                }
            }

            .detail-body-key {
                font-family: YuYang_W04;
                font-size: 1em;
                margin-bottom: 30px;
            }

            .detail-body-contain-text {
                float: left;
                width: 70%;
                margin-bottom: 100px;
                font-family: YuYang_W02;
                font-size: 1.2em;

            }
        }
    }

    .detail-readnext {
        margin-top: 50px;
        float: left;

        .detail-readnext-title {
            font-family: YuYang_W05;
            font-size: 2em;
            float: left;
        }

        .detail-readnext-divider {
            float: left;
        }

        .paper-thesis {
            float: left;

            .paper-thesis-left {
                width: 47.5%;
                margin-left: 5px;
                margin-right: 2.5px;
                float: left;

                .paper-thesis-left-img {
                    height: 300px;
                    width: 100%;
                }

                .paper-thesis-left-title {
                    text-align: left;
                    font-family: YuYang_W05;
                    font-size: 1.25em;
                    padding-top: 3px;
                    padding-bottom: 3px;
                }

                .paper-thesis-left-intro {
                    text-align: left;
                    font-family: YuYang_W02;
                    font-size: 0.95em;
                    padding-top: 3px;
                    padding-bottom: 0px;

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

                .paper-thesis-left-name {
                    text-align: left;
                    font-family: YuYang_W03;
                    font-size: 0.5em;
                    color: rgb(96, 95, 95);
                    padding-top: 5px;
                }

                .paper-thesis-left-time {
                    text-align: left;
                    font-family: YuYang_W03;
                    font-size: 0.5em;
                    color: rgb(130, 129, 129);
                    padding-top: 3px;
                }


            }

            .paper-thesis-right {
                width: 47%;
                margin-left: 2.5px;
                margin-right: 5px;
                float: right;

                .paper-thesis-right-item {
                    float: left;
                    margin-bottom: 10px;

                    .paper-thesis-right-img {
                        height: 90px;
                        width: 120px;
                        float: left;
                    }

                    .paper-thesis-right-in {
                        float: left;
                        margin-left: 10px;
                        padding-left: 10px;

                        .paper-thesis-right-title {
                            text-align: left;
                            font-family: YuYang_W04;
                            font-size: 1em;
                            padding-top: 3px;
                            padding-bottom: 3px;
                        }

                        .paper-thesis-right-name {
                            text-align: left;
                            font-family: YuYang_W03;
                            font-size: 0.5em;
                            color: rgb(96, 95, 95);
                            padding-top: 9px;
                        }

                        .paper-thesis-right-time {
                            text-align: left;
                            font-family: YuYang_W03;
                            font-size: 0.5em;
                            color: rgb(130, 129, 129);
                            padding-top: 7px;
                        }
                    }
                }
            }
        }
    }
}






















.detail-body {}
</style>