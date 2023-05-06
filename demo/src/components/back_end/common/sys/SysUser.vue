<template>
  <div>
    <el-card class="box-card">
      <div class="mod-role">

        <!--搜索-->
        <el-form :inline="true" :model="searchForm" class="demo-form-inline">
          <el-form-item>
            <el-input v-model="searchForm.userName" clearable placeholder="用户名"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="searchByName">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="openAddDialog">新增</el-button>
          </el-form-item>
        </el-form>

        <!--信息列表-->
        <el-table :data="dataList" border style="width: 100%">
          <el-table-column type="selection" width="55"> </el-table-column>
          <el-table-column prop="username" label="用户名" width="130">
          </el-table-column>
          <el-table-column prop="age" label="年龄" width="55">
          </el-table-column>
          <el-table-column prop="sex" label="性别" width="55">
          </el-table-column>
          <el-table-column prop="birth" label="生日" width="180">
          </el-table-column>
          <el-table-column prop="email" label="邮箱" width="180">
          </el-table-column>
          <el-table-column prop="mobile" label="电话" width="180">
          </el-table-column>
          <el-table-column prop="liketodo" label="爱好" width="180">
          </el-table-column>
          <!-- <el-table-column prop="status" label="状态" width="280">
            <template slot-scope="scope">
              <span>{{ scope.row.status == 1 ? '正常' : '禁用' }}</span>
            </template>
          </el-table-column> -->
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click="deleteUser(scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>

        <!--分页-->
        <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
          :page-sizes="[5, 10, 20, 50, 100]" :page-size="pageSize" :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper" style="margin-top: 30px">
        </el-pagination>

      </div>

      <!--新增角色-->
      <el-dialog title="新增用户" width="35%" :visible.sync="addVisible" @close="closeDialog()">
        <el-form :model="addUserForm" :rules="rules" ref="ruleForm">
          <el-form-item label="角色名" label-width="120px" prop="username">
            <el-input v-model="addUserForm.username" placeholder="用户名" style="width: 300px"></el-input>
          </el-form-item>
          <el-form-item label="密码" label-width="120px" prop="password">
            <el-input type="password" v-model="addUserForm.password" placeholder="密码" style="width: 300px"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="addUser">确 定</el-button>
        </div>
      </el-dialog>

      <!--编辑角色-->
      <el-dialog title="修改用户信息" width="50%" :visible.sync="editVisible" @close="closeDialog()">
        <el-form :model="detailForm" :rules="rules" ref="ruleForm">

          <el-form-item label="用户名" label-width="120px" prop="username">
            <el-input v-model="detailForm.username" placeholder="用户名"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="密码" label-width="120px" prop="password">
            <el-input v-model="detailForm.password" placeholder="密码"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="邮箱" label-width="120px" prop="email">
            <el-input v-model="detailForm.email" type="email" placeholder="邮箱"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="电话" label-width="120px" prop="mobile">
            <el-input v-model="detailForm.mobile" placeholder="电话"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>

          <el-form-item label="年龄" label-width="120px" prop="age">
            <el-input v-model="detailForm.age" placeholder="年龄" textarea
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>

          <el-form-item label="性别" label-width="120px" prop="sex">
            <el-radio v-model="detailForm.sex" label="男" style="float:left;margin:10px 10px 0px 10px;"></el-radio>
            <el-radio v-model="detailForm.sex" label="女" style="float:left;margin:10px 10px 0px 10px;"></el-radio>
          </el-form-item>
          <el-form-item label="生日" label-width="120px" prop="birth">
            <el-date-picker value-format="yyyy-MM-dd" placeholder="选择日期" v-model="detailForm.birth"
              style="float:left;margin-left:10px;"></el-date-picker>
          </el-form-item>
          <el-form-item label="爱好" label-width="120px" prop="liketodo">
            <el-input v-model="detailForm.liketodo" placeholder="爱好"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>

          <el-form-item label="头像" label-width="120px">
            <el-upload ref="upload" :on-preview="handlePictureCardPreview" :on-remove="handleRemove"
              :on-change="UploadImage" :limit="1" action="#" list-type="picture-card" :auto-upload="false"
              :file-list="fileList" style="float:left;margin-left:10px;">
              <i slot="default" class="el-icon-plus"></i>
              <template #tip>
                <div style="font-size: 12px;color: #919191;">
                  单次限制上传一张图片
                </div>
              </template>
              <div slot="file" slot-scope="{file}">
                <img class="el-upload-list__item-thumbnail" :src="file.url" alt="">
                <span class="el-upload-list__item-actions">
                  <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                    <i class="el-icon-zoom-in"></i>
                  </span>
                  <span v-if="!disabled" class="el-upload-list__item-delete" @click="handleRemove(file)">
                    <i class="el-icon-delete"></i>
                  </span>
                </span>
              </div>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img width="100%" :src="dialogImageUrl" alt="">
            </el-dialog>
          </el-form-item>

          <el-form-item label="个性签名" label-width="120px" prop="sign">
            <el-input v-model="detailForm.sign" placeholder="个性签名"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="个人简介" label-width="120px" prop="intro">
            <el-input v-model="detailForm.intro" type="textarea" placeholder="个人简介"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>

        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateUser">确 定</el-button>
        </div>
      </el-dialog>

    </el-card>
  </div>
</template>

<script>
export default {
  name: "SysUser",
  data() {
    return {
      searchForm: {
        userName: "",
      },
      addUserForm: {
        username: '',
        password: '',
      },

      detailForm: {},
      dataList: [],
      pageIndex: 1,
      pageSize: 5,
      totalPage: 0,
      dialogImageUrl: '',
      fileList: [],

      dialogVisible: false,
      addVisible: false,
      editVisible: false,

    };
  },
  methods: {
    //上传图片的方法
    UploadImage(file) {
      // console.log(file);
      let fd = new FormData()
      fd.append('file', file.raw) //传给后台接收的名字 file

      this.$http.post('/upload/image', fd, { headers: { 'Content-Type': 'multipart/form-data' } }).then(res => {
        //上传成功后返回的数据,
        console.log(res.data)
        // 将图片地址给到表单.
        this.detailForm.userhead = 'http://192.168.121.1:8086/psyche' + res.data.data
        console.log(this.detailForm.userhead)
      })

    },
    //预览图像
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    //移除图片功能
    handleRemove(file) {
      console.log(file)
      this.fileList = []
    },

    //更新用户信息
    updateUser() {
      const params = {
        body: {
          "userid": this.detailForm.userid,
          "username": this.detailForm.username,
          "password": this.detailForm.password,
          "age": this.detailForm.age,
          "birth": this.detailForm.birth,
          "email": this.detailForm.email,
          "intro": this.detailForm.intro,
          "liketodo": this.detailForm.liketodo,
          "mobile": this.detailForm.mobile,
          "userhead": this.detailForm.userhead,
          "passwd": this.detailForm.passwd,
          "sex": this.detailForm.sex,
          "sign": this.detailForm.sign,
        },
      };
      console.log('update body')
      console.log(params.body)
      this.$http.post("/sys/sysUser/UpdateUser", params.body).then((res) => {
        console.log(res.data.data)
        if (res.data.data == 1) {
          this.$message({
            type: "success",
            message: "修改成功!",
          });
          this.getDataList()
          this.editVisible = false
        } else {
          this.$message({
            type: "error",
            message: "修改失败!",
          });
        }

      })
    },
    //编辑
    handleEdit(item) {
      console.log(item)
      this.editVisible = true
      this.detailForm = item

      let i = {
        name: item.userhead,
        url: item.userhead
      }
      this.fileList = []
      this.fileList.push(i)

    },
    //新增用户 
    addUser() {
      const params = {
        params: {
          username: this.addUserForm.username,
          passwd: this.addUserForm.password,
        },
      };
      this.$http.get("/sys/sysUser/addUser", params).then((res) => {
        console.log(res.data)
        if (res.data.data == 1) {
          this.getDataList()
          this.addVisible = false
        }

      });
    },
    //删除用户
    deleteUser(item) {
      console.log(item)
      this.$http.get("/sys/sysUser/deleteUser?userid=" + item.userid).then((res) => {
        console.log(res.data)
        if (res.data.data == 1) {
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          this.getDataList()
        } else {
          this.$message({
            type: "error",
            message: "删除失败!",
          });
        }

      });
    },
    //打开新增用户对话框
    openAddDialog() {
      this.addVisible = true
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
    getDataList() {
      const params = {
        params: {
          pageIndex: this.pageIndex,
          pageSize: this.pageSize,
        },
      };
      this.$http.get("/sys/sysUser/list", params).then((res) => {
        this.dataList = res.data.data;
        this.totalPage = res.data.data.totalCount;

        console.log(res.data)
      });
    },
    //根据输入的用户名搜索用户
    searchByName() {
      const params = {
        params: {
          pageIndex: this.pageIndex,
          pageSize: this.pageSize,
          username: this.searchForm.userName,
        },
      };
      this.$http.get("/sys/sysUser/getUserByName", params).then((res) => {
        this.dataList = res.data.data.list;
        this.totalPage = res.data.data.totalCount;

        console.log(res.data.data.list)
      });
    },
  },
  mounted() {
    this.getDataList();
  }
};
</script>

<style scoped></style>