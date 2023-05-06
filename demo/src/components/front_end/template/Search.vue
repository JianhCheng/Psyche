<template>
    <div class="search">
        <el-input placeholder="请输入内容" v-model="input" class="input-with-select">
            <el-select v-model="select" slot="prepend" placeholder="请选择">
                <el-option label="标题" value="title"></el-option>
                <el-option label="内容" value="content"></el-option>
            </el-select>
            <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
        </el-input>
    </div>
</template>

<style>
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

<script>
export default {
    data() {
        return {
            input: '',
            select: ''
        }
    },
    methods: {
        search() {
            const params = {
                params: {
                    filed: this.select,
                    key:'%'+this.input+'%'
                },
            };
            this.$http.get("/zcxy/paperDetail/getByKeywords", params).then((res) => {
                console.log(res.data.data)

                

            });
        }
    }
}
</script>