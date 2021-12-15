import { createRouter, createWebHistory } from "vue-router";

import Layout from "@/layout/Layout";
import Home from "@/views/Home";
import BookAdd from "@/views/books/BookAdd";
import CategoryInfo from "@/views/category/CategoryInfo";
import BookUpdate from "@/views/books/BookUpdate";
import BookInfo from "@/views/books/BookInfo";
import BorrowInfo from "@/views/borrow/BorrowInfo";

const routes = [
  {
    path: "/",
    name: "Layout",
    component: Layout,
    redirect: "/home",
    children: [
      {
        path: "home",
        name: "Home",
        component: Home,
        meta: {
          title: "首页", //菜单名称
          roles: ["user", "admin"], //当前菜单哪些角色可以看到
          icon: "el-icon-info", //菜单左侧的icon图标
        },
      },
    ],
  },
  {
    path: "/books",
    name: "Books",
    component: Layout,
    redirect: "/books/bookInfo",
    meta: {
      title: "图书管理",
      roles: ["user", "admin"],
      icon: "el-icon-info",
    },
    children: [
      {
        path: "bookInfo",
        name: "bookInfo",
        component: BookInfo,
        meta: {
          title: "图书信息", //菜单名称
          roles: ["user", "admin"], //当前菜单哪些角色可以看到
          icon: "el-icon-info", //菜单左侧的icon图标
        },
      },
      {
        path: "addBook",
        name: "addBook",
        component: BookAdd,
        meta: {
          title: "添加图书", //菜单名称
          roles: ["user", "admin"], //当前菜单哪些角色可以看到
          icon: "el-icon-info", //菜单左侧的icon图标
        },
      },
      {
        path: "updateBook",
        name: "updateBook",
        component: BookUpdate,
        meta: {
          title: "编辑图书", //菜单名称
          roles: ["user", "admin"], //当前菜单哪些角色可以看到
          icon: "el-icon-info", //菜单左侧的icon图标
        },
      },
    ],
  },
  {
    path: "/category",
    name: "Category",
    component: Layout,
    redirect: "/books/categoryInfo",
    meta: {
      title: "分类管理", //菜单名称
      roles: ["user", "admin"], //当前菜单哪些角色可以看到
      icon: "el-icon-info", //菜单左侧的icon图标
    },
    children: [
      {
        path: "categoryInfo",
        name: "categoryInfo",
        component: CategoryInfo,
        meta: {
          title: "分类信息", //菜单名称
          roles: ["user", "admin"], //当前菜单哪些角色可以看到
          icon: "el-icon-info", //菜单左侧的icon图标
        },
      },
    ],
  },
  {
    path: "/borrow",
    name: "borrow",
    component: Layout,
    redirect: "/borrow/borrowInfo",
    meta: {
      title: "借阅管理", //菜单名称
      roles: ["user", "admin"], //当前菜单哪些角色可以看到
      icon: "el-icon-info", //菜单左侧的icon图标
    },
    children: [
      {
        path: "borrowInfo",
        name: "borrowInfo",
        component: BorrowInfo,
        meta: {
          title: "借阅信息", //菜单名称
          roles: ["user", "admin"], //当前菜单哪些角色可以看到
          icon: "el-icon-info", //菜单左侧的icon图标
        },
      },
    ],
  },

  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
