import { createRouter, createWebHistory } from "vue-router";

import Layout from "@/layout/Layout";
import Home from "@/views/Home";
import BookInfo from "@/views/books/BookInfo";
import BookAdd from "@/views/books/BookAdd";
import CategoryInfo from "@/views/category/CategoryInfo";

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
        path: "bookAdd",
        name: "bookAdd",
        component: BookAdd,
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
