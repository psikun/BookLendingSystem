<template>
  <el-card shadow="always">添加书籍</el-card>
  <div class="add-form">
    <el-card shadow="always" style="display: flex; justify-content: center">
      <BookForm ref="bookForm"></BookForm>
      <el-button type="danger" @click="dialogVisible = true"
        >取消添加
      </el-button>
      <el-button type="primary" @click="addBook">确认添加</el-button>
      <el-dialog v-model="dialogVisible" title="确定取消吗？" width="30%">
        <span>这将会丢失所有数据</span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">继续添加</el-button>
            <el-button type="primary" @click="handleClose">确认取消</el-button>
          </span>
        </template>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
import BookForm from "@/views/books/components/BookForm";

export default {
  name: "BookAdd",
  components: { BookForm },
  data() {
    return {
      bookInfo: [],
      dialogVisible: false,
    };
  },
  methods: {
    // 确认添加
    addBook() {
      this.bookInfo = this.$refs.bookForm.validateForm();
      if (this.bookInfo != null) {
        console.log(this.bookInfo);
      }
    },
    // 关闭取消框
    handleClose() {
      // 清空表单
      this.$refs.bookForm.$refs["bookInfoForm"].resetFields();
      this.bookInfo.categoryId = null;
      this.bookInfo.locationId = null;
      this.dialogVisible = false;
    },
  },
};
</script>

<style scoped>
.add-form {
  padding-top: 30px;
  padding-left: 200px;
  padding-right: 200px;
}
</style>
