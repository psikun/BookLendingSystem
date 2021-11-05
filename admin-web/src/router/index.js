import { createRouter, createWebHistory } from "vue-router";

import Layout from "@/layout/Layout";
import Home from "@/views/Home";
import BookAdd from "@/views/books/BookAdd";
import CategoryInfo from "@/views/category/CategoryInfo";
import BookUpdate from "@/views/books/BookUpdate";
import BookInfo from "@/views/books/BookInfo";

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
    children: [
      {
        path: "bookInfo",
        name: "bookInfo",
        component: BookInfo,
      },
      {
        path: "addBook",
        name: "addBook",
        component: BookAdd,
      },
      {
        path: "updateBook",
        name: "updateBook",
        component: BookUpdate,
      },
    ],
  },
  {
    path: "/category",
    name: "Category",
    component: Layout,
    redirect: "/books/categoryInfo",
    children: [
      {
        path: "categoryInfo",
        name: "categoryInfo",
        component: CategoryInfo,
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
