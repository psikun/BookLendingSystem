<template>
  <el-table-column prop="borrowingStatus" label="书籍状态">
    <el-table-column label="借阅状态">
      <template v-slot="scope">
        <el-button
          type="success"
          size="small"
          round
          v-if="scope.row.borrowingStatus"
          >已借出
        </el-button>
        <el-button type="danger" v-else round size="small">未借出 </el-button>
      </template>
    </el-table-column>
    <el-table-column label="借阅信息">
      <template v-slot="scope">
        <el-button
          type="warning"
          size="mini"
          round
          :disabled="!scope.row.borrowingStatus"
          >借阅信息
        </el-button>
      </template>
    </el-table-column>
  </el-table-column>
</template>

<script>
export default {
  name: "BookStatus",
};
</script>

<style scoped></style>
