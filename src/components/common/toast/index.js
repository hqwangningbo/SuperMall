import Toast from "@/components/common/toast/Toast";
const obj ={}

obj.install = function (Vue) {
  //1.创建组件构造器
  const toastContruster = Vue.extend(Toast);

  //根据组件构造器创建一个对象
  const toast = new toastContruster();

  //将组件手动挂载到某一个元素上
  toast.$mount(document.createElement('div'))

  document.body.appendChild(toast.$el)
  Vue.prototype.$toast = toast

}

export default obj
