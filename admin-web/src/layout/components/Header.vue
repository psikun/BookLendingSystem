<template>
  <div class="header">
    <div class="header-icon">
      <el-icon :size="30" @click="toggleClick">
        <menu-icon />
      </el-icon>
    </div>
    <div class="header-title">首页</div>
    <div class="header-center"></div>
    <div class="header-dropdown">
      <el-dropdown>
        <span class="el-dropdown-link">
          张三<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
// 引入全局变量
import { Menu as MenuIcon } from "@element-plus/icons";
export default {
  name: "Header",
  components: {
    MenuIcon,
  },
  methods: {
    toggleClick() {
      this.$store.commit("openAside");
      console.log(this.$store.state.opened);
    },
  },
};
</script>

<style scoped>
.header {
  background-color: aquamarine;
  height: 50px;
  line-height: 50px;
  border-bottom: 1px solid #ccc;
  display: flex;
}
.header-icon {
  margin: 0;
  padding-top: 10px;
  padding-left: 5px;
}
.header-title {
  width: 200px;
  padding-left: 30px;
  font-weight: bold;
  color: dodgerblue;
}
.header-center {
  flex: 1;
}
.header-dropdown {
  width: 100px;
}
</style>
