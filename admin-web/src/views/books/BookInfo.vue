<template>
  <!--  书籍信息卡片-->
  <el-card shadow="always" class="card">
    <span>书籍信息</span>
    <el-button type="primary" plain>添加书籍</el-button>
  </el-card>
  <!--书籍信息表格-->
  <div class="book-info-table">
    <el-table
      :data="tableData"
      border
      stripe
      highlight-current-row
      select-on-indeterminate
      :header-cell-style="tableClass"
      :cell-style="tableClass"
      height="480"
    >
      <el-table-column type="selection" label="选择" />
      <el-table-column prop="id" label="编号" sortable width="80" />
      <el-table-column prop="name" label="名称" />
      <el-table-column prop="author" label="作者" />
      <el-table-column prop="press" label="出版社" />
      <el-table-column prop="price" label="定价(￥)" />
      <el-table-column prop="isbn" label="ISBN号码" />
      <el-table-column label="分类">
        <template v-slot="scope">
          <el-button type="text" @click="getrows(scope.row)"
            >{{ scope.row.category.categoryName }}
          </el-button>
        </template>
      </el-table-column>

      <el-table-column label="书籍位置">
        <el-table-column prop="location.bookshelf" label="书架" />
        <el-table-column prop="callNumber" label="索书号" />
      </el-table-column>
      <el-table-column
        prop="description"
        label="书籍描述"
        show-overflow-tooltip
      />
      <!--   书籍借阅信息组件   -->
      <book-status />
      <!--   书籍操作组件   -->
      <book-operation />
    </el-table>
  </div>
  <!--  分页-->
  <div class="pagination-block">
    <el-pagination
      v-model:currentPage="currentPage"
      background
      :page-sizes="[5, 10, 15, 20]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    >
    </el-pagination>
  </div>
</template>

<script>
import BookOperation from "@/views/books/components/BookOperation";
import BookStatus from "@/views/books/components/BookStatus";
import { getBookInfo } from "@/api/bookinfo";

export default {
  name: "BookInfo",
  components: { BookOperation, BookStatus },
  created() {
    this.load();
  },
  data() {
    return {
      currentPage: 1,
      total: 10,
      pageSize: 5,
      pageNum: 1,
      tableData: [],
    };
  },
  methods: {
    load() {
      // load()函数，页面加载时调用，用来加载页面数据
      let params = {
        pageNum: this.pageNum,
        pageSize: this.pageSize,
      };
      getBookInfo(params).then((res) => {
        console.log(res);
        this.tableData = res.data;
      });
    },
    handleSizeChange(pageSize) {
      // 改变当前每页的个数触发
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) {
      // 改变当前页码触发
      this.pageNum = pageNum;
      this.load();
    },
    tableClass() {
      // 表头居中显示
      return "text-align:center";
    },
    getrows(row) {
      console.log(row);
    },
  },
};
</script>

<style scoped>
.card {
  width: 100%;
  display: flex;
  justify-content: space-between;
}

.book-info-table {
  margin: 0;
  padding-top: 10px;
  width: 100%;
}

.pagination-block {
  text-align: right;
  margin-top: 30px;
  margin-bottom: 20px;
  margin-right: 50px;
}
</style>
