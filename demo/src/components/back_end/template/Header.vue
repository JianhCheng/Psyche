<template>
  <div class="container">
    <div class="l-content">
      <el-button icon="el-icon-menu" size="medium" @click="handleMenu"></el-button>
    </div>
    <div class="r-content">
      <el-dropdown>
        <span class="el-dropdown-link">
          <img class="user_img" :src="userhead" />
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>注销</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>

export default {
  name: "Header",
  data() {
    return {
      page:this.$store.state.page,
      userhead:localStorage.getItem("userhead"),
    };
  },
  methods:{
    handleMenu(){
      // console.log(111)
      this.$store.commit('collapseChange')
    }
  }
};
</script>

<style lang="less" scoped>
.container {
  padding: 0 20px;
  background-color: #242f42;
  height: 70px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 96.5%;

  .firstPage {
    color: #fff;
    font-size: 16px;
    margin-left: 10px;
  }

  .r-content {
    margin-right: 20px;
    .user_img {
      width: 40px;
      height: 40px;
      border-radius: 50%;
    }
  }

}
</style>