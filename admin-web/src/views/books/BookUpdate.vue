<template>
  <BookForm ref="bookForm"></BookForm>
  <el-button @click="updateBook" type="danger">取消修改</el-button>
  <el-button @click="updateBook" type="primary">确认修改</el-button>
</template>

<script>
import BookForm from "@/views/books/components/BookForm";
import { getBookById, updateBook } from "@/api/bookinfo";

export default {
  name: "BookUpdate",
  components: { BookForm },
  mounted() {
    this.getBookInfo();
  },
  methods: {
    getBookInfo() {
      let id = this.$route.query.id;
      getBookById(id).then((res) => {
        this.$refs.bookForm.getBookInfo(res.data);
      });
    },
    updateBook() {
      updateBook(this.$refs.bookForm.bookInfo).then();
    },
  },
};
</script>

<style scoped></style>
