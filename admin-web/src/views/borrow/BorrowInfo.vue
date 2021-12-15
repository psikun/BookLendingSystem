<template>
  <el-card shadow="always" class="card">
    <span>借阅信息</span>
  </el-card>
  <el-table :data="borrowInfo" stripe style="width: 100%">
    <el-table-column prop="id" label="借阅编号" width="180" />
    <el-table-column prop="bookInfo.name" label="图书名称" width="180" />
    <el-table-column prop="user.name" label="用户姓名" />
    <el-table-column prop="borrowTime" label="借阅时间" />
    <el-table-column prop="returnTime" label="应还时间" />
    <el-table-column prop="beyondTime" label="逾期时间(天)" />
    <el-table-column prop="beyondCost" label="逾期费用" />
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
  name: "borrowInfo",
  data() {
    return {
      borrowInfo: [],
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
