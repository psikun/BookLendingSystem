<template>
  <el-card shadow="always" class="card">
    <span>分类信息</span>
  </el-card>
  <el-table :data="categoryInfo" stripe style="width: 100%">
    <el-table-column prop="id" label="分类编号" width="180" />
    <el-table-column prop="bookInfo.name" label="分类名称" width="180" />
    <el-table-column prop="user.name" label="分类级别" />
    <el-table-column prop="borrowTime" label="上级分类" />
  </el-table>
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
import { getBorrowInfo } from "@/api/borrowinfo";

export default {
  name: "CategoryInfo",
  data() {
    return {
      categoryInfo: [],
      currentPage: 1,
      total: 10,
      pageSize: 5,
      pageNum: 1,
    };
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      let params = {
        pageNum: this.pageNum,
        pageSize: this.pageSize,
      };
      getBorrowInfo(params).then((res) => {
        this.borrowInfo = res.data;
        console.log(this.borrowInfo);
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
  },
};
</script>

<style scoped></style>
