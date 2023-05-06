<template>
  <div class="contain">

    <el-scrollbar class="scrollbar-wrapper">

      <!--搜索栏-->
      <el-form :inline="true" :model="searchForm">
        <el-form-item>
          <el-input v-model="searchForm.key" placeholder="请输入内容" clearable class="input-with-select">
            <el-select v-model="searchForm.category" slot="prepend" placeholder="请选择" width="50px">
              <el-option label="题库ID" value="id"></el-option>
              <el-option label="标题" value="title"></el-option>
              <el-option label="分类" value="category"></el-option>
              <el-option label="贡献者名字" value="username"></el-option>
            </el-select>
          </el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="searchData">查询</el-button>
        </el-form-item>
        <!-- <el-form-item>
          <el-button type="primary" @click="openAddDialog">新增</el-button>
        </el-form-item> -->
      </el-form>

      <!--表格-->
      <el-table :data="dataList" border style="width: 95%">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="id" label="题库id" width="100">
        </el-table-column>
        <el-table-column prop="category" label="分类" width="100">
        </el-table-column>
        <el-table-column prop="title" label="标题" width="200">
        </el-table-column>
        <el-table-column prop="username" label="题库贡献者名字" width="150">
        </el-table-column>
        <el-table-column prop="isopen" label="题库是否公开" width="150">
        </el-table-column>
        <el-table-column prop="createtime" label="创建时间" width="180">
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope" width="200">
            <el-button size="mini" type="primary" @click="handleDetail(scope.row)">详情</el-button>
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row, 'QuestionBankList')">删除</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!--分页-->
      <el-pagination @size-change="sizeChangeHandle" @current-change="currentChangeHandle" :current-page="pageIndex"
        :page-sizes="[5, 10, 20, 50, 100]" :page-size="pageSize" :total="totalPage"
        layout="total, sizes, prev, pager, next, jumper" style="margin-top: 30px">
      </el-pagination>
    </el-scrollbar>



    <!--对话框  编辑-->
    <el-dialog title="题库列表编辑" :visible.sync="editVisible">
      <el-form :model="Listform" ref="ruleF">

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
          <el-upload ref="upload" :on-preview="handlePictureCardPreview" :on-remove="handleRemove"
            :on-change="UploadImage" :limit="1" action="#" list-type="picture-card" :auto-upload="false"
            :file-list="fileList" style="float:left;">
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

        <!-- <el-form-item label="题库封面" :label-width="formLabelWidth">
          <el-input v-model="Listform.coverurl" :value="Listform.coverurl"></el-input>
          <img :src="Listform.coverurl" style="height:100px; width:100px; float:left; margin-top:20px">
        </el-form-item> -->

        <el-form-item label="是否公开" :label-width="formLabelWidth" style="float:left">
          <el-radio v-model="Listform.isopen" :label="1">是</el-radio>
          <el-radio v-model="Listform.isopen" :label="0">否</el-radio>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="listDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submitQBList()">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 对话框  详情 -->
    <el-dialog title="题库详细题目" :visible.sync="outerVisible" width="1300px">

      <!-- 编辑 -->
      <el-dialog title="题目编辑" :visible.sync="innerVisible" width="60%">
        <el-form :model="Detailform">

          <el-form-item label="题目" :label-width="formLabelWidth">
            <el-input v-model="Detailform.title" :value="Detailform.title"></el-input>
          </el-form-item>

          <el-form-item label="学科" :label-width="formLabelWidth">
            <el-input v-model="Detailform.subject" :value="Detailform.title"></el-input>
          </el-form-item>

          <el-form-item label="章节" :label-width="formLabelWidth">
            <el-input v-model="Detailform.chapter" :value="Detailform.title"></el-input>
          </el-form-item>

          <el-form-item label="重点" :label-width="formLabelWidth">
            <el-input v-model="Detailform.point" :value="Detailform.title"></el-input>
          </el-form-item>

          <el-form-item label="题目类型" :label-width="formLabelWidth">
            <el-select v-model="Detailform.type" placeholder="请选择题库分类" style="float:left">
              <el-option label="多选题" value="EXERCISE"></el-option>
              <el-option label="单选题" value="PERSONAL_EXERCISE"></el-option>
              <el-option label="名词解释" value="PERSONAL_EXERCISE"></el-option>
            </el-select>
          </el-form-item>

          <!-- <el-form-item label="题目图片" :label-width="formLabelWidth">
            <el-input v-model="Detailform.img" :value="Detailform.img"></el-input>
            <img :src="Detailform.img" v-if="Detailform.img != '/'"
              style="height:100px; width:100px; float:left; margin-top:20px">
          </el-form-item> -->

          <el-form-item label="题目图片" :label-width="formLabelWidth">
            <el-upload ref="upload" :on-preview="handlePictureCardPreview" :on-remove="handleRemove"
              :on-change="UploadImage" :limit="1" action="#" list-type="picture-card" :auto-upload="false"
              :file-list="fileList" style="float:left;">
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

          <el-form-item label="题目选项" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="Detailform.options" :value="Detailform.title"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="innerVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateQBDetail">确 定</el-button>
        </div>
      </el-dialog>

      <!--对话框  解析-->
      <el-dialog title="题目解析" :visible.sync="analzeVisible" width="60%">
        <el-form :model="analzeList">
          <el-form-item label="题目解析" :label-width="formLabelWidth">
            <el-input type="textarea" v-model="analzeList.analyze" :value="Detailform.title"></el-input>
          </el-form-item>
          <el-form-item label="解析图片" :label-width="formLabelWidth">
            <el-upload ref="upload" :on-preview="handlePictureCardPreview" :on-remove="handleRemove"
              :on-change="UploadAnalzeImage" :limit="1" action="#" list-type="picture-card" :auto-upload="false"
              :file-list="fileList" style="float:left;">
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
        </el-form>

        <div slot="footer" class="dialog-footer">
          <el-button @click="analzeVisible = false">取 消</el-button>
          <el-button type="primary" @click="updateAnalze">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 外层 -->
      <el-scrollbar class="scrollbar-wrapper" style="overflow-x: hidden;">
        <el-table :data="detailList" style="width: 100%">
          <el-table-column prop="qbid" label="题库id" width="100">
          </el-table-column>
          <el-table-column prop="id" label="题目id" width="100">
          </el-table-column>
          <el-table-column prop="title" label="题目标题">
          </el-table-column>
          <el-table-column prop="subject" label="题目学科" width="120">
          </el-table-column>
          <el-table-column prop="point" label="题目重点">
          </el-table-column>
          <el-table-column prop="chapter" label="题目章节" width="100">
          </el-table-column>
          <el-table-column prop="type" label="题目类型" width="100">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope" width="200">
              <el-button size="mini" type="primary" @click="handleAnalze(scope.row)">解析</el-button>
              <el-button size="mini" type="primary" @click="handleDetailEdit(scope.row)">编辑</el-button>
              <el-button size="mini" type="danger" @click="handleDelete(scope.row, 'QuestionBankDetail')">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination @size-change="sizeChangeHandleDetail" @current-change="currentChangeHandleDetail"
          :current-page="detailPageIndex" :page-sizes="[5, 10, 20, 50, 100]" :page-size="detailPageSize"
          :total="detailTotalPage" layout="total, sizes, prev, pager, next, jumper" style="margin-top: 30px">
        </el-pagination>
      </el-scrollbar>
    </el-dialog>

    <!--对话框  增加-->
    <el-dialog title="增加题库" :visible.sync="addVisible">
      <el-form :model="addform">

        <el-form-item label="题库名" :label-width="formLabelWidth">
          <el-input v-model="addform.title" :value="addform.title"></el-input>
        </el-form-item>

        <el-form-item label="题库分类" :label-width="formLabelWidth">
          <el-select v-model="addform.category" placeholder="请选择题库分类" style="float:left">
            <el-option label="习题" value="EXERCISE"></el-option>
            <el-option label="个人习题" value="PERSONAL_EXERCISE"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="题库封面" :label-width="formLabelWidth">
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

        <el-form-item label="是否公开" :label-width="formLabelWidth" style="float:left">
          <el-radio v-model="addform.isopen" :label="1">是</el-radio>
          <el-radio v-model="addform.isopen" :label="0">否</el-radio>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="listDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addQBList">确 定</el-button>
      </div>
    </el-dialog>

    <!--对话框  删除成功-->
    <el-dialog title="提示" :visible.sync="deleteSuccessVisible" width="20%">
      <span>删除成功</span>
    </el-dialog>


  </div>
</template>

<script>
export default {
  name: "QuestionBank",
  data() {
    return {
      searchForm: {
        key: '',
        category: '',

      },
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
      addform: {
        category: '',
        coverurl: '',
        isopen: 1,
        title: '',
        username: localStorage.getItem("username"),
      },
      Detailform: {
        qbid: '',
        id: '',
        subject: '',
        point: '',
        chapter: '',
        type: '',
        title: '',
        options: '',
        img: '',
      },

      dialogImageUrl: '',
      dialogVisible: false,
      disabled: false,
      fileList: [],
      dataList: [],
      detailList: [],
      analzeList: {},

      formLabelWidth: '120px',

      pageIndex: 1,
      pageSize: 5,
      totalPage: 0,

      detailPageIndex: 1,
      detailPageSize: 5,
      detailTotalPage: 0,
      qbDetailID: '',
      isDelete: 0,

      addVisible: false,
      editVisible: false,
      outerVisible: false,
      innerVisible: false,
      addVisible: false,
      analzeVisible: false,
      deleteSuccessVisible: false,

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
        let url = 'http://192.168.121.1:8086/psyche' + res.data.data
        this.addform.coverurl = url
      })
    },
    UploadAnalzeImage(file) {
      // console.log(file);
      let fd = new FormData()
      fd.append('file', file.raw) //传给后台接收的名字 file

      this.$http.post('/upload/image', fd, { headers: { 'Content-Type': 'multipart/form-data' } }).then(res => {
        //上传成功后返回的数据,
        console.log(res.data)
        // 将图片地址给到表单.
        let url = 'http://192.168.121.1:8086/psyche' + res.data.data
        this.analzeList.img = url
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

    //修改解析
    updateAnalze() {
      const params = {
        body: {
          id:this.analzeList.id,
          analyze: this.analzeList.analyze,
          img: this.analzeList.img,
        },
      };
      console.log(params)
      this.$http.post("/zcxy/analzeList/updateAnalze", params.body).then((res) => {
        console.log(res.data.data)
        this.analzeVisible = false
      });
    },
    //修改题库详情
    updateQBDetail() {
      const params = {
        body: {
          id: this.Detailform.id,
          subject: this.Detailform.subject,
          point: this.Detailform.point,
          chapter: this.Detailform.chapter,
          type: this.Detailform.type,
          title: this.Detailform.title,
          options: this.Detailform.options,
          img: this.Detailform.img,
        },
      };
      console.log(params)
      this.$http.post("/zcxy/questionBankDetail/updateQBDetail", params.body).then((res) => {
        // this.dataList = res.data.data.list;
        console.log(res.data.data)
        this.getDetailList()
        // this.totalPage = res.data.data.totalCount;
        this.innerVisible = false
      });
    },
    //修改题库列表
    submitQBList() {

      const params = {
        body: {
          id: this.Listform.id,
          category: this.Listform.category,
          coverurl: this.Listform.coverurl,

          isopen: this.Listform.isopen,
          title: this.Listform.title,
        },
      };
      console.log(params)
      this.$http.post("/zcxy/questionBankList/updateQBList", params.body).then((res) => {
        // this.dataList = res.data.data.list;
        console.log(res.data.data)
        this.getDataList()
        // this.totalPage = res.data.data.totalCount;
        this.editVisible = false
      });
    },
    //提交后重置上传界面表单
    resetForm(formName) {
      this.$refs.upload.clearFiles()
      this.$refs[formName].resetFields()
    },

    //分页
    addSrcList() {
      this.srcList
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
    //对话框 分页
    sizeChangeHandleDetail(val) {
      this.detailPageSize = val;
      this.detailPageIndex = 1;
      this.getDetailList();
    },
    currentChangeHandleDetail(val) {
      this.detailPageIndex = val;
      this.getDetailList();
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
    getDetailList() {

      const params = {
        params: {
          pageIndex: this.detailPageIndex,
          pageSize: this.detailPageSize,
          qbid: this.qbDetailID,
        },
      };
      console.log(this.qbDetailID)
      this.$http.get("/zcxy/questionBankDetail/getQBDetailById", params).then((res) => {
        this.detailList = res.data.data.list;
        console.log(res.data.data.list)
        this.detailTotalPage = res.data.data.totalCount;
      });
    },
    getSearchData() {
      this.pageIndex = 1;
      this.pageSize = 5;
      const params = {
        params: {
          pageIndex: this.pageIndex,
          pageSize: this.pageSize,
          key: this.searchForm.key,
          category: this.searchForm.category,
        },
      };
      console.log(params)
      this.$http.get("/zcxy/questionBankList/getDataByKeyAndCategory", params).then((res) => {
        this.dataList = res.data.data.list;
        this.totalPage = res.data.data.totalCount;
      });
    },
    getAnalze(id) {
      const params = {
        params: {
          id: id
        },
      };
      this.$http.get("/zcxy/analzeList/getAnalzeList", params).then((res) => {
        this.analzeList = res.data.data[0];
        console.log(res.data.data[0])
      });
    },
    deleteItem(table, id) {
      const params = {
        params: {
          id: id,
          table: table,
        },
      };
      this.$http.get("/zcxy/questionBankList/deleteItem", params).then((res) => {
        this.isDelete = res.data.data
        console.log('res:' + res.data.data)

        if (this.isDelete == 1) {
          this.deleteSuccessVisible = true
          console.log(true)
        }

        if (table == 'QuestionBankList') {
          this.getDataList()
        }
        else {
          this.getDetailList()
        }
      });
    },

    //编辑-处理
    handleDelete(item, table) {
      this.deleteItem(table, item.id)
    },
    handleAnalze(item) {
      this.analzeVisible = true
      this.getAnalze(item.id);
      this.fileList = []
      console.log(item)
      if (this.analzeList.img != '' && this.analzeList.img != '/') {
        let i = {
          name: this.analzeList.img,
          url: this.analzeList.img
        }
        this.fileList.push(i)
      }
    },
    //打开新增题库对话框
    openAddDialog() {
      this.addVisible = true
    },
    searchData() {
      this.getSearchData();
    },
    handleDetailEdit(item) {
      this.innerVisible = true
      this.detailID = item.id
      this.fileList = []
      console.log(item)
      if (item.img != '' && item.img != '/') {
        let i = {
          name: item.img,
          url: item.img
        }
        this.fileList.push(i)
      }

      this.Detailform = {
        qbid: item.qbid,
        id: item.id,
        subject: item.subject,
        point: item.point,
        chapter: item.chapter,
        type: item.type,
        title: item.title,
        options: item.options,
        img: item.img,
      }
      // this.getQuestion()

    },
    handleEdit(item) {
      this.fileList = []
      console.log(item)

      let i = {
        name: item.coverurl,
        url: item.coverurl
      }
      this.fileList.push(i)
      console.log(this.fileList)
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
      this.editVisible = true

    },
    handleDetail(item) {
      console.log(item)
      this.outerVisible = true
      this.qbDetailID = item.id
      this.getDetailList()
    }

  }, mounted() {
    this.getDataList();

  }
};
</script>

<style lang="less" scoped>
.contain {
  height: 100%;

  /deep/ .el-select .el-input {
    width: 130px;
  }


  /deep/ .el-textarea__inner {
    height: 100px;
  }

  /deep/ .el-scrollbar__wrap {
    overflow-x: hidden;
  }

  .scrollbar-wrapper {
    height: calc(100vh - 70px);
  }
}
</style>