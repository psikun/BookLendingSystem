<template>
  <el-table-column prop="operation" label="操作" width="140" fixed="right">
    <template v-slot="scope">
      <!--编辑按钮-->
      <el-button
        type="primary"
        icon="el-icon-edit"
        circle
        @click="updateBook(scope.row)"
      >
      </el-button>
      <!--确认删除按钮-->
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
// import { deleteBook } from "@/api/bookinfo";

import { deleteBook } from "@/api/bookinfo";

export default {
  name: "BookEditor",
  components: {},
  data() {
    return { dialogFormVisible: false };
  },
  methods: {
    // 处理删除
    handleDelete(id) {
      deleteBook(id).then();
    },
    updateBook(row) {
      this.$router.push({
        name: "updateBook",
        query: {
          id: row.id,
        },
      });
      this.dialogFormVisible = true;
    },
  },
};
</script>

<style scoped></style>
