<template>
    <div class="mod-role">
  
      <!--搜索栏-->
      <el-form :inline="true" :model="dataForm" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="dataForm.userName" clearable placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getDataList">查询</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="openDialog()">新增</el-button>
        </el-form-item>
      </el-form>
  
      <!--表格-->
      <el-table :data="dataList" border style="width: 100%">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="id" label="题库id" width="100">
        </el-table-column>
        <el-table-column prop="category" label="分类" width="100">
        </el-table-column>
        <el-table-column prop="title" label="标题" width="250">
        </el-table-column>
        <el-table-column prop="username" label="题库贡献者名字" width="150">
        </el-table-column>
        <el-table-column prop="isopen" label="题库是否公开" width="150">
        </el-table-column>
        <el-table-column prop="createtime" label="创建时间" width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope" width="200">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
  
      <!--分页-->
      <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
        :page-sizes="[5, 10, 20, 50, 100]" :page-size="pageSize" :total="totalPage"
        layout="total, sizes, prev, pager, next, jumper" style="margin-top: 30px">
      </el-pagination>
  
      <!--对话框  编辑-->
      <el-dialog title="题库列表编辑" :visible.sync="listDialogVisible">
        <el-form :model="Listform">
  
          <el-form-item label="题库名" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
          <el-form-item label="题库分类" :label-width="formLabelWidth">
            <el-select v-model="Listform.category" placeholder="请选择题库分类" style="float:left">
              <el-option label="习题" value="EXERCISE"></el-option>
              <el-option label="个人习题" value="PERSONAL_EXERCISE"></el-option>
            </el-select>
          </el-form-item>
  
          <el-form-item label="题库封面" :label-width="formLabelWidth">
            <el-input v-model="Listform.coverurl" :value="Listform.coverurl"></el-input>
            <img :src="Listform.coverurl" style="height:100px; width:100px; float:left; margin-top:20px">
          </el-form-item>
  
          <el-form-item label="是否公开" :label-width="formLabelWidth" style="float:left">
            <el-radio v-model="Listform.isopen" :label="1">是</el-radio>
            <el-radio v-model="Listform.isopen" :label="0">否</el-radio>
          </el-form-item>
  
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="listDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="listDialogVisible = false">确 定</el-button>
        </div>
      </el-dialog>
  
      <!--对话框  详情-->
      <el-dialog title="题库详情编辑" :visible.sync="listDialogVisible">
        <el-form :model="Listform">
  
          <el-form-item label="题目" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
          <el-form-item label="学科" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
          <el-form-item label="章节" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
          <el-form-item label="重点" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
          <el-form-item label="题目类型" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
            <el-select v-model="Listform.category" placeholder="请选择题库分类" style="float:left">
              <el-option label="习题" value="EXERCISE"></el-option>
              <el-option label="个人习题" value="PERSONAL_EXERCISE"></el-option>
            </el-select>
          </el-form-item>
  
          <el-form-item label="题目图片" :label-width="formLabelWidth">
            <el-input v-model="Listform.coverurl" :value="Listform.coverurl"></el-input>
            <img :src="Listform.coverurl" style="height:100px; width:100px; float:left; margin-top:20px">
          </el-form-item>
  
          <el-form-item label="题目选项and答案" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
          <el-form-item label="题目解析" :label-width="formLabelWidth">
            <el-input v-model="Listform.title" :value="Listform.title"></el-input>
          </el-form-item>
  
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="listDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="listDialogVisible = false">确 定</el-button>
        </div>
      </el-dialog>
  
    </div>
  </template>
  
  <script>
  export default {
    name: "QuestionBank",
    data() {
      return {
        dataForm: {
          userName: "",
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 5,
        totalPage: 0,
  
        listDialogVisible: false,
        DetailDialogVisible: false,
  
        Listform: {
          id: '',
          category: '',
          coverurl: '',
          createtime: '',
  
          isopen: 1,
  
          title: '',
          userhead: '',
          userid: 0,
          username: '',
        },
  
        Detailform:{
          qbid :'',  
          id:'',  
          subject:'',  
          point:'',  
          chapter:'',
          type:'',  
          title:'',  
          options:'',  
          img:'', 
        },
  
        formLabelWidth: '120px'
      };
    },
    methods: {
      //分页
      sizeChangeHandle(val) {
        this.pageSize = val;
        this.pageIndex = 1;
        this.getDataList();
      },
      currentChangeHandle(val) {
        this.pageIndex = val;
        this.getDataList();
      },
      //获取资源
      getDataList() {
        const params = {
          params: {
            pageIndex: this.pageIndex,
            pageSize: this.pageSize,
          },
        };
        this.$http.get("/zcxy/questionBankList/list", params).then((res) => {
          this.dataList = res.data.data.list;
          console.log(res.data.data.list)
          this.totalPage = res.data.data.totalCount;
        });
      },
      getDetailList(id) {
        const params = {
          params: {
            id: id,
          },
        };
        this.$http.get("/zcxy/questionBankDetail/getQBDetailById", params).then((res) => {
          this.dataList = res.data.data.list;
          console.log(res.data.data)
        });
      },
  
      handleEdit(item) {
        this.listDialogVisible = true
        console.log(item)
        this.handleListForm(item)
      },
      handleListForm(item) {
        this.Listform = {
          id: item.id,
          category: item.category,
          coverurl: item.coverurl,
          createtime: item.createtime,
  
          isopen: item.isopen,
  
          title: item.title,
          userhead: item.userhead,
          userid: item.userid,
          username: item.username,
        }
        console.log(this.Listform)
      },
      handleDetail(item) {
        console.log(item)
        this.getDetailList(item.id)
      }
  
    }, mounted() {
      this.getDataList();
  
    }
  };
  </script>