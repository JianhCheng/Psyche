<template>
  <el-card class="box-card">
    <div class="mod-role">
      <!--搜索-->
      <el-form :inline="true" :model="searchForm" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="searchForm.name" clearable placeholder="角色名称"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getDataListByName">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="openDialog()">新增</el-button>
        </el-form-item>
      </el-form>

      <!--信息展示-->
      <el-table :data="dataList" border style="width: 100%">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="id" label="ID" width="150">
        </el-table-column>
        <el-table-column prop="name" label="角色名称" width="180">
        </el-table-column>
        <el-table-column prop="remark" label="备注" width="280">
        </el-table-column>
        <el-table-column prop="createTime" label="创建时间" width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope" width="180">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      
      <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
        :page-sizes="[5, 10, 20, 50, 100]" :page-size="pageSize" :total="totalPage"
        layout="total, sizes, prev, pager, next, jumper" style="margin-top: 30px">
      </el-pagination>
    </div>

    <!--新增角色-->
    <el-dialog title="新增角色" width="35%" :visible.sync="addVisible"
      @close="closeDialog()">
      <el-form :model="dataDialogForm" :rules="rules" ref="ruleForm">
        <el-form-item label="角色名称" label-width="120px" prop="name">
          <el-input v-model="dataDialogForm.name" placeholder="角色名称" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="描述信息" label-width="120px" prop="remark">
          <el-input type="textarea" v-model="dataDialogForm.remark" style="width: 300px"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="addRole">确 定</el-button>
      </div>
    </el-dialog>

    <!--更新角色信息-->
    <el-dialog title="更新角色" width="35%" :visible.sync="updateVisible" @close="closeDialog()">
      <el-form :model="dataDialogForm" :rules="rules" ref="ruleForm">
        <el-form-item label="角色名称" label-width="120px" prop="name">
          <el-input v-model="dataDialogForm.name" placeholder="角色名称" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="描述信息" label-width="120px" prop="remark">
          <el-input type="textarea" v-model="dataDialogForm.remark" style="width: 300px"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleUpdateSysRole">确 定</el-button>
      </div>
    </el-dialog>

  </el-card>
</template>
<script>
export default {
  name: "sysRole",
  data() {
    var checkRoleName = (rule, value, callback) => {
      if (this.dataDialogForm.roleId !== 0) {
        if (value === "") {
          callback(new Error("请输入角色名称"));
        }
        // 说明是更新操作
        callback();
      } else if (value === "") {
        callback(new Error("请输入角色名称"));
      } else {
        // 调用后端接口 检查 角色名称是否存在
        this.$http
          .get("/sys/sysRole/checkRoleName?roleName=" + value)
          .then((res) => {
            //console.log(res)
            if (res.data.data === "fail") {
              // 说明角色名不存在，可以使用
              callback();
            } else {
              callback(new Error("角色名称重复"));
            }
          });
        //callback();
      }
    };
    return {
      searchForm: {
        name: "",
      },
      dataDialogForm: {
        roleid: 0,
        name: "",
        remark: "",
      },

      dataList: [],
      pageIndex: 1,
      pageSize: 5,
      totalPage: 0,

      updateVisible: false,
      addVisible:false,
      dataListLoading: false,
      dialogFormVisible: false,
      dialogFormSubmitVisible: false,

      rules: {
        roleName: [{ validator: checkRoleName, trigger: "blur" }],
        remark: [
          { required: true, message: "请输入描述信息", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    //更新角色信息
    handleUpdateSysRole() {
      const params = {
        params: {
          name: this.dataDialogForm.name,
          remark: this.dataDialogForm.remark,
          roleid: this.dataDialogForm.roleid,
        }
      };
      this.$http.get("/zcxy/sysRole/UpdateRole", params).then((res) => {
        console.log(res.data.data)
        if (res.data.data == 1) {
          this.getDataList()
        }
        this.updateVisible = false
      });
    },
    //新增角色
    addRole(){
      const params = {
        params: {
          name: this.dataDialogForm.name,
          remark: this.dataDialogForm.remark,
        }
      };
      this.$http.get("/zcxy/sysRole/addRole", params).then((res) => {
        console.log(res.data.data)
        if (res.data.data == 1) {
          this.getDataList()
        }
        this.addVisible = false
      });
    },
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    //根据角色名称获取角色
    getDataListByName(){
      const params = {
        params: {
          pageIndex: this.pageIndex,
          pageSize: this.pageSize,
          name: this.searchForm.name,
        },
      };
      console.log(this.searchForm.name,)
      this.$http.get("/zcxy/sysRole/getRoleById", params).then((res) => {
        this.dataList = res.data.data.list;
        this.totalPage = res.data.data.totalCount;
        console.log(res.data.data)
      });
    },
    getDataList() {
      const params = {
        params: {
          pageIndex: this.pageIndex,
          pageSize: this.pageSize,
          // roleName: this.dataForm.roleName,
        },
      };
      this.$http.get("/zcxy/sysRole/list", params).then((res) => {
        this.dataList = res.data.data.list;
        this.totalPage = res.data.data.totalCount;
        console.log(res.data.data)
      });
    },
    //列表内点击编辑操作所响应的方法
    handleEdit(item) {
      this.updateVisible = true;

      this.dataDialogForm.roleid = item.id;
      this.dataDialogForm.name = item.name;
      this.dataDialogForm.remark = item.remark;
      console.log(this.dataDialogForm)
    },
    // 删除角色信息
    handleDelete(item) {
      const params = {
        params: {
          roleid: item.id
        },
      };

      this.$http.get("/zcxy/sysRole/deleteRole",params).then((res) => {
        console.log(res)
        if (res.data.data == 1) {
          this.$message({
            type: "success",
            message: "删除成功!",
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败!",
          });
        }
        this.dialogFormSubmitVisible = false;
        // 刷新数据
        this.getDataList();
      });

    },
    // 打开新增窗口
    openDialog() {
      this.addVisible = true;

      this.dataDialogForm.roleid = 0;
      this.dataDialogForm.name = "";
      this.dataDialogForm.remark = "";
    },
    closeDialog() {
      // 清空添加数据的表单
      this.dataDialogForm = {
        roleId: 0,
        roleName: "",
        remark: "",
      };
    },
    handleSubmitFormData(formName) {
      this.updateRole(formName);
    },
    updateRole(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          if (this.dialogFormSubmitVisible) {
            return;
          }
          this.dialogFormSubmitVisible = true;

          this.$http
            .post("/sys/sysRole/list", this.dataDialogForm)
            .then((res) => {
              this.dialogFormVisible = false; // 关闭窗口
              // 清空添加数据的表单
              this.dataDialogForm = {
                roleId: 0,
                roleName: "",
                remark: "",
              };
              this.dialogFormSubmitVisible = false;
              // 刷新数据
              this.getDataList();
            });
        } else {
          // console.log('error submit!!');
          return false;
        }
      });
    },
  },
  mounted() {
    this.getDataList();
  },
};
</script>