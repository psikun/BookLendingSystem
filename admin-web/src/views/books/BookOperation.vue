<template>
  <el-table-column
    prop="operation"
    label="操作"
    @click="getRows"
    width="140"
    fixed="right"
  >
    <template v-slot="scope">
      <el-button
        type="primary"
        icon="el-icon-edit"
        circle
        @click="getRows(scope.row)"
      ></el-button>
      <el-popconfirm
        confirm-button-text="确定"
        cancel-button-text="不了，谢谢"
        icon="el-icon-info"
        icon-color="red"
        title="确定要删除吗?"
        @confirm="handleDelete(scope.row.id)"
      >
        <template #reference>
          <el-button type="danger" icon="el-icon-delete" circle></el-button>
        </template>
      </el-popconfirm>
    </template>
  </el-table-column>
</template>
<script>
import request from "@/utils/request";

export default {
  name: "BookEditor",
  methods: {
    handleDelete(id) {
      console.log(id);
      request.delete("/api/bookinfo/" + id).then();
    },
    getRows(row) {
      console.log(row);
    },
  },
};
</script>

<style scoped></style>
