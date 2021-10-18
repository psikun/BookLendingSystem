<template>
  <div class="layout">
    <el-container>
      <el-aside width="auto"><Aside /></el-aside>
      <el-container>
        <el-header class="el-header"><Header /></el-header>
        <el-main class="el-main"><router-view /></el-main>
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
  computed: {},
};
</script>

<style scoped>
.layout {
}
.el-header {
  padding: 0;
}
</style>
