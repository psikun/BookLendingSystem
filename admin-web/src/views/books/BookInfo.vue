<template>
  <div class="card" style="display: flex">
    <el-card shadow="always" style="width: 100%">
      书籍信息
      <el-button type="primary" plain align-self: flex-end
        >添加书籍</el-button
      ></el-card
    >
  </div>

  <div class="book-info">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="name" label="名称" />
      <el-table-column prop="author" label="作者" />
      <el-table-column prop="press" label="出版社" />
      <el-table-column prop="category" label="分类" />
      <el-table-column prop="borrowing_status" label="借阅状态" />
      <el-table-column prop="description" label="书籍描述" />
      <el-table-column prop="create_time" label="创建时间" />
      <el-table-column prop="update_time" label="修改时间" />
      <el-table-column prop="operation" label="操作">
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
export default {
  name: "BookInfo",
  data() {
    return {
      currentPage: 1,
      total: 10,
      tableData: [],
    };
  },
  methods: {
    handleSizeChange() {},
    handleCurrentChange() {},
  },
};
</script>

<style scoped>
.book-info {
  margin: 0;
  padding-top: 10px;
}
</style>
