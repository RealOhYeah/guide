import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

var VueCookie = require('vue-cookie');
Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(VueCookie);

// 设置全局属性
Vue.prototype.$cookie = VueCookie;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
