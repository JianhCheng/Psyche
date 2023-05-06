<template>
    <div class="foot">
        <el-divider></el-divider>
        <div>
            <div class="foot-left">
                <div class="foot-left-logo">Psycho</div>
                <div class="foot-left-intro"> Copyright © 2023 . All rights reserved.</div>
            </div>
            <div class="foot-right">Now it's just a mediocre website, and nobody knows if I'll update it in the future</div>
        </div>
    </div>
</template>

<style lang="less" scoped>
.foot {
    margin-top: 150px;
    padding-bottom: 100px;
    .foot-left {
        .foot-left-logo {
            font-family: YuYang_W05;
            font-size: 1.7em;
            float: left;
            color: rgb(95, 95, 95);
        }

        .foot-left-intro {
            font-family: YuYang_W03;
            font-size: 0.8em;
            float: left;
            color: rgb(163, 163, 163);
            padding-top: 10px;
            margin-left: 20px;
        }
    }

    .foot-right {
        font-family: YuYang_W03;
        font-size: 0.8em;
        float: right;
        color: rgb(163, 163, 163);
        padding-top: 10px;
        margin-left: 20px;
    }
}
</style>

  