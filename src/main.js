import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from "@/store";
import obj from "@/components/common/toast";
import FastClick from 'fastclick'
import VueLazyload from "vue-lazyload";
Vue.config.productionTip = false
Vue.prototype.$bus = new Vue()

//使用自定义插件
Vue.use(obj)

Vue.use(VueLazyload,{
  //加载时使用的图片
  loading:require("./assets/img/home/timi.png")
})

//解决移动端延迟300ms问题
FastClick.attach(document.body)

new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
