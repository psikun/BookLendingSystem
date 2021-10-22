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
import Aside from "@/components/Aside";
import Header from "@/components/Header";
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
}
</style>
