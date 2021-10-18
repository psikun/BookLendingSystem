import { createRouter, createWebHistory } from "vue-router";

import Layout from "@/layout/Layout";
import Home from "@/views/Home";
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
