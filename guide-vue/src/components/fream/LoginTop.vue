<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-02 16:37:35
 * @LastEditTime: 2024-04-06 16:55:24
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @Description: 
 * @FilePath: /guide-vue/src/components/fream/LoginTop.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<!--
    name
-->
<template>
  <div id="top">
    <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false"
      aria-labelledby="modal-cookies" aria-hidden="true">
      <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
        <div class="modal-content bg-dark-dark">
          <div class="modal-body">
            <!-- Text -->
            <p class="text-sm text-white mb-3">
              We use cookies so that our themes work for you. By using our
              website, you agree to our use of cookies.
            </p>
            <!-- Buttons -->
            <a class="btn btn-sm btn-white" target="_blank">Learn more</a>
            <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">
              OK
            </button>
          </div>
        </div>
      </div>
    </div>

    <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block"
      style="z-index: 1000; color: aliceblue" target="_blank">
      <strong>哈尔滨广厦学院</strong> 向导系统 V0.1 By TLM Team
    </a>

    <div>
      <nav class="navbar navbar-expand-lg navbar-light bg-white">
        <div class="container">
          <!-- Brand -->
          <!-- <a class="navbar-brand"  href="/h">
                        <img alt="Image placeholder" style="height:3.4rem" src="123123" id="navbar-logo">
                    </a> -->
          <!-- Toggler -->
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <!-- Collapse -->
          <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mt-4 mt-lg-0 ml-auto">
              <li class="nav-item">
                <a @click="toGuideList()" class="nav-link" href="">导航列表</a>
              </li>
              <li class="nav-item">
                <a @click="toUserList()" class="nav-link" href="">用户信息列表</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="">退出账号</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",

  components: {},

  data() {
    return {};
  },

  methods: {
    toGuideList() {
      this.$router.push({ path: "/guideList" });
    },

    toUserList() {
      this.$router.push({ path: "/userList" });
    },
  },
};
</script>
