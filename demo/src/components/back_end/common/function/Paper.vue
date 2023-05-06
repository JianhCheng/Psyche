<template>
  <div class="mod-role">
    <!--搜索框-->
    <el-form :inline="true" :model="dataForm" class="demo-form-inline">
      <el-form-item>
        <el-input v-model="dataForm.name" clearable placeholder="文章名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList">查询</el-button>
      </el-form-item>
    </el-form>

    <!--信息列表-->
    <el-table :data="dataList" border style="width: 100%">
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="title" label="标题" width="250">
      </el-table-column>
      <el-table-column prop="keywords" label="关键词" width="250">
      </el-table-column>
      <el-table-column prop="time" label="出版日期" width="130">
      </el-table-column>
      <el-table-column prop="auth" label="文章作者" width="180">
      </el-table-column>
      <el-table-column prop="url" label="阅读链接" width="280">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope" width="300">
          <el-button size="mini" type="primary" @click="handleEdit(scope.row)">详情</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--分页-->
    <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
      :page-sizes="[5, 10, 20, 50, 100]" :page-size="pageSize" :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper" style="margin-top: 30px">
    </el-pagination>

    <!--对话框  文章编辑-->
      <el-dialog title="文章编辑" width="50%" :visible.sync="editVisible" @close="editVisible=false">
        <el-form :model="detailForm" :rules="rules" ref="ruleForm">

          <el-form-item label="文章标题" label-width="120px" prop="title">
            <el-input v-model="detailForm.title" placeholder="文章标题" :disabled="true"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="作者" label-width="120px" prop="auth">
            <el-input v-model="detailForm.auth" placeholder="作者" :disabled="true"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="关键词" label-width="120px" prop="keywords">
            <el-input v-model="detailForm.keywords" placeholder="关键词" :disabled="true"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="文章链接" label-width="120px" prop="url">
            <el-input v-model="detailForm.url" placeholder="文章链接" :disabled="true"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>
          <el-form-item label="文章内容" label-width="120px" prop="content">
            <el-input v-model="detailForm.content" type="textarea" placeholder="个人简介" :disabled="true"
              style="width: 500px;float:left;margin-left:10px;"></el-input>
          </el-form-item>

        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="updatePaper">确 定</el-button>
        </div>
      </el-dialog>

  </div>
</template>

<script>
export default {
  name: "Paper",
  data() {
    return {
      dataForm: {
        name: "",
      },
      dataList: [],
      detailForm:{},
      pageIndex: 1,
      pageSize: 5,
      totalPage: 0,

      editVisible:false,
    };
  },
  methods: {
    //删除文章
    handleDelete(item){
      const params = {
        params: {
          id: item.id,
        },
      };
      console.log(params)
      this.$http.get("/zcxy/paperList/deletePaper", params).then((res) => {
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
    //编辑
    handleEdit(item) {
      console.log(item)
      this.editVisible=true

      const params = {
        params: {
          id:item.id
        },
      };
      this.$http.get("/zcxy/paperDetail/getPaperDetailById", params).then((res) => {
        console.log(res.data)
        if(res.data.code=="SUCCESS"){
          this.detailForm = res.data.data;
        }else{
          this.detailForm ={};
        }

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
    getDataList() {
      const params = {
        params: {
          pageIndex: this.pageIndex,
          pageSize: this.pageSize,
          title: this.dataForm.name,
        },
      };
      this.$http.get("/zcxy/paperDetail/list", params).then((res) => {
        this.dataList = res.data.data.list;
        this.totalPage = res.data.data.totalCount;
      });
    },
  }, mounted() {
    this.getDataList();
  }
};
</script>