<template>
  <el-menu
    default-active="2"
    class="el-menu-vertical"
    :collapse="isCollapse"
    @open="handleOpen"
    @close="handleClose"
  >
    <el-submenu class="el-submenu" index="1">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">首页</span>
      </template>
      <el-menu-item index="1-1">功能一</el-menu-item>
      <el-menu-item index="1-2">功能二</el-menu-item>
    </el-submenu>
    <el-submenu class="el-submenu" index="2">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">图书管理</span>
      </template>
      <el-menu-item index="1-1">功能一</el-menu-item>
      <el-menu-item index="1-2">功能二</el-menu-item>
    </el-submenu>
    <el-submenu class="el-submenu" index="3">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">人员管理</span>
      </template>
      <el-menu-item index="1-1">功能一</el-menu-item>
      <el-menu-item index="1-2">功能二</el-menu-item>
    </el-submenu>
  </el-menu>
</template>

<script>
export default {
  name: "Aside",
  methods: {
    handleOpen: (key, keyPath) => {
      console.log(key, keyPath);
    },
    handleClose: (key, keyPath) => {
      console.log(key, keyPath);
    },
  },
  computed: {
    // 使用计算属性判断侧边栏是否开启
    isCollapse() {
      return !this.$store.state.opened;
    },
  },
};
</script>

<style scoped>
.el-menu-vertical:not(.el-menu--collapse){
  min-height: 100vh;
  background-color: #2868a9;
  width: 200px;
}
</style>
