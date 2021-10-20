<template>
  <el-card shadow="always" class="card">
    <span>书籍信息</span><el-button type="primary" plain>添加书籍</el-button>
  </el-card>

  <div class="book-info-table">
    <el-table :data="tableData" border stripe highlight-current-row>
      <el-table-column type="selection" label="选择" />
      <el-table-column prop="name" label="名称" />
      <el-table-column prop="author" label="作者" />
      <el-table-column prop="press" label="出版社" />
      <el-table-column prop="isbn" label="ISBN号码" />
      <el-table-column prop="category" label="分类" />
      <el-table-column prop="borrowingStatus" label="借阅状态" />
      <el-table-column prop="location" label="书籍位置" />
      <el-table-column
        prop="description"
        label="书籍描述"
        show-overflow-tooltip
      />
      <el-table-column prop="operation" label="操作">
        <el-button type="primary" icon="el-icon-edit" circle></el-button>
        <el-popconfirm
          confirm-button-text="确定"
          cancel-button-text="不了，谢谢"
          icon="el-icon-info"
          icon-color="red"
          title="确定要删除吗?"
        >
          <template #reference>
            <el-button type="danger" icon="el-icon-delete" circle></el-button>
          </template>
        </el-popconfirm>
      </el-table-column>
    </el-table>
  </div>
  <div class="pagination-block">
    <el-pagination
      v-model:currentPage="currentPage"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="20"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    >
    </el-pagination>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "BookInfo",
  created() {
    this.load();
  },
  data() {
    return {
      currentPage: 1,
      total: 10,
      tableData: [],
    };
  },
  methods: {
    load() {
      request.get("/api/bookinfo").then((res) => {
        console.log(res);
        this.tableData = res.data;
      });
    },
    handleSizeChange() {},
    handleCurrentChange() {},
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
</style>
