<template>
  <div class="layout">
    <el-container>
      <!--      <el-aside width="200px"></el-aside>-->
      <Aside />
      <el-container>
        <el-header class="el-header"><Header /></el-header>
        <el-main class="el-main"><router-view /></el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Header from "@/layout/components/Header";
import Aside from "@/layout/components/Aside";

export default {
  name: "Layout",
  components: { Header, Aside },
  computed: {},
};
</script>

<style scoped>
.el-header {
  padding: 0;
}
.el-main {
  padding: 0;
}
</style>
