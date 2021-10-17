<template>
  <div class="layout">
    <el-container>
      <el-aside :width="asideWidth"><Aside /></el-aside>
      <el-container>
        <el-header class="el-header"><Header /></el-header>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "@/components/Aside";
import Header from "@/components/Header";
export default {
  name: "Layout",
  components: { Header, Aside },
  computed: {
    asideWidth() {
      let width;
      if (this.$store.state.opened) {
        width = "200px";
      } else {
        width = "auto";
      }
      return width;
    },
  },
};
</script>

<style scoped>
.layout {
}
.el-header {
  padding: 0;
}
</style>
