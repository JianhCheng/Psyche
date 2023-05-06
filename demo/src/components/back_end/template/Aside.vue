<template>
  <div>
    <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
      :collapse="isCollapse" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
      
      <h3 style="color: white;">{{isCollapse?'P':'Psyche'}}</h3>
      <!-- 无子选项 -->
      <el-menu-item v-for="item in noChildren" :key="item.name" :index="item.name" @click="clickMenu(item)">
        <i :class="`el-icon-${item.icon}`"></i>
        <span slot="title">{{ item.label }}</span>
      </el-menu-item>
      <!-- 有子选项 -->
      <el-submenu v-for="item in hasChildren" :key="item.name" :index="item.name">
        <template slot="title">
          <i :class="`el-icon-${item.icon}`"></i>
          <span slot="title">{{ item.label }}</span>
        </template>

        <el-menu-item-group v-for="sub in item.children" :key="sub.name">
          <el-menu-item :index="sub.name" @click="clickMenu(sub)">
            {{ sub.label }}
          </el-menu-item>
        </el-menu-item-group>

      </el-submenu>

    </el-menu>
  </div>
</template>

<style lang="less" scoped>

.el-menu {
  min-height: 100vh;
  display: block;
  border-right: none;
  bottom: 0;

  h3 {
    color: #fff;
    text-align: center;
    line-height: 48px;
    font-size: 22px;
    font-weight: 400;
    padding: 0 20px;
  }
}
</style>

<script>
export default {
  data() {
    return {
      // isCollapse: false,
      menuData: [
        {
          path: "/Admin/Index",
          name: "Index",
          label: "首页",
          icon: "s-home",
          url: "/Admin/Index",
        },
        {
          label: "功能管理",
          icon: "s-cooperation",
          name: "Function",
          children: [
            {
              path: "/Admin/QuestionBankManage",
              name: "QuestionBankManage",
              label: "题库管理",
              icon: "s-grid",
              url: "/Admin/QuestionBankManage",
            },
            {
              path: "/Admin/PaperManage",
              name: "PaperManage",
              label: "文章管理",
              icon: "s-management",
              url: "/Admin/PaperManage",
            },
            {
              path: "/Admin/KnowledgeManage",
              name: "KnowledgeManage",
              label: "知识点管理",
              icon: "s-order",
              url: "/Admin/KnowledgeManage",
            },
            // {
            //   path: "/Admin/StatisticManage",
            //   name: "StatisticManage",
            //   label: "统计信息管理",
            //   icon: "s-marketing",
            //   url: "/Admin/StatisticManage",
            // },
          ],
        },
        {
          label: "系统管理",
          icon: "s-tools",
          name: "System",
          children: [
            {
              path: "/Admin/SysUserManage",
              name: "SysUserManage",
              label: "用户管理",
              icon: "setting",
              url: "/Admin/SysUserManage",
            },
            {
              path: "/Admin/SysRoleManage",
              name: "SysRoleManage",
              label: "角色管理",
              icon: "setting",
              url: "/Admin/SysRoleManage",
            },
            // {
            //   path: "/Admin/SysMenuManage",
            //   name: "SysMenuManage",
            //   label: "菜单管理",
            //   icon: "setting",
            //   url: "/Admin/SysMenuManage",
            // },
            // {
            //   path: "/Admin/SysLogManage",
            //   name: "SysLogManage",
            //   label: "日志管理",
            //   icon: "setting",
            //   url: "/Admin/SysLogManage",
            // }
          ],
        },


      ],
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
    clickMenu(item) {
      this.$router.push(item.path)
    }
  },
  computed: {
    hasChildren() {
      return this.menuData.filter(item => item.children)
    },
    noChildren() {
      return this.menuData.filter(item => !item.children)
    },
    isCollapse(){
      // console.log(this.$store.state.tab.isCollapse)
      return this.$store.state.tab.isCollapse
    }
  }
}
</script>