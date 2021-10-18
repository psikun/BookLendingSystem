<template>
  <div class="book-info">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="name" label="书籍名称" />
      <el-table-column prop="name" label="Name" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="address" label="Address" />
    </el-table>
  </div>
</template>

<script>
export default {
  name: "BookInfo",
};
</script>

<style scoped></style>
