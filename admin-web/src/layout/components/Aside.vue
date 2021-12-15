<template>
  <el-menu
    default-active="books"
    router
    class="el-menu-vertical"
    :collapse="isCollapse"
    @open="handleOpen"
    @close="handleClose"
  >
    <el-menu-item index="home" class="home">
      <i class="el-icon-location"></i>
      <span class="el-submenu-title">首页</span></el-menu-item
    >
    <el-menu-item index="home" class="home">
      <i class="el-icon-location"></i>
      <span class="el-submenu-title">图书借阅</span></el-menu-item
    >
    <el-submenu class="el-submenu" index="books">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">图书管理</span>
      </template>
      <el-menu-item index="bookInfo">图书信息</el-menu-item>
      <el-menu-item index="addBook">添加图书</el-menu-item>
      <el-menu-item index="ca">图书分类</el-menu-item>
      <el-menu-item index="bookAdd">书架管理</el-menu-item>
    </el-submenu>
    <el-submenu class="el-submenu" index="3">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">借阅管理</span>
      </template>
      <el-menu-item index="1-1">用户列表</el-menu-item>
      <el-menu-item index="1-2">借阅信息</el-menu-item>
    </el-submenu>
    <el-submenu class="el-submenu" index="3">
      <template v-slot:title>
        <i class="el-icon-location"></i>
        <span class="el-submenu-title">权限管理</span>
      </template>
      <el-menu-item index="1-1">管理员列表</el-menu-item>
      <el-menu-item index="1-2">角色列表</el-menu-item>
      <el-menu-item index="1-2">菜单列表</el-menu-item>
      <el-menu-item index="1-2">资源列表</el-menu-item>
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
.el-submenu-title {
  font-size: 16px;
  font-weight: normal;
  color: #eeebe8;
}
.el-menu-vertical {
  min-height: 100vh;
}
.el-menu-vertical {
  background-color: #374a85;
}
.el-menu-item:not(.home) {
  background-color: #233972;
  color: #cccccc;
}
</style>
