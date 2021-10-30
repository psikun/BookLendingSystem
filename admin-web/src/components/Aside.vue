<template>
  <el-menu
    default-active="books"
    router
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
    </el-submenu>
    <el-submenu class="el-submenu" index="books">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">书籍管理</span>
      </template>
      <el-menu-item index="bookInfo">书籍信息</el-menu-item>
      <el-menu-item index="bookAdd">添加书籍</el-menu-item>
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
.el-menu-vertical:not(.el-menu--collapse) {
  width: 200px;
}
.el-menu-vertical {
  min-height: 100vh;
}
.el-menu-vertical {
  background-color: #53555b;
}
</style>
