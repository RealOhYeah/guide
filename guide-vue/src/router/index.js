/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-04-01 16:30:20
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-05-20 13:09:54
 * @FilePath: \guide-vue\src\router\index.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import Vue from "vue";
import VueRouter from "vue-router";
var VueCookie = require("vue-cookie"); 
import LoginTwo from "@/components/Login.vue";
import UserReg from "@/components/UserReg.vue";
import Login from  "@/views/user/Login.vue"; 

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Login,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/login",
    name: "login",
    // 登录页面一
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: Login,
  },
  {
    // 注册页面一
    path: "/register",
    name: "register",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/user/Register.vue"),
  },
  {
    // 导航列表
    path: "/guideList",
    name: "guideList",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/guide/GuideList.vue"),
  },
  {
    // 导航信息修改列表
    path: "/guideUpdate",
    name: "guideUpdate",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/guide/GuideUpdate.vue"),
  },
  {
    // 导航信息添加
    path: "/guideAdd",
    name: "guideAdd",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/guide/GuideAdd.vue"),
  },

  {
    // 登录页面二
    path: "/LoginTwo",
    name: "LoginTwo",
    component: LoginTwo,
  },
  // 注册页面二
  {
    path: "/UserReg",
    name: "UserReg",
    component: UserReg,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

//路由前置守卫
router.beforeEach((to, from, next) => {
  const isLogin = VueCookie.get("token") ? true : false;
  if (to.path == "/login" || to.path == "/register" || to.path == "/UserReg" || to.path == "/LoginTwo" ) {
    next();
  } else {
    isLogin ? next() : next("/login");
  }
});

export default router;
