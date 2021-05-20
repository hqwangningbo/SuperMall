import Vue from 'vue'
import Vuex from 'vuex'

//安装插件
Vue.use(Vuex)

//创建store对象
const store = new Vuex.Store({
  state:{
    cartList:[]
  },
  mutations:{
    addCounter(state,payload){
      payload.count++
    },
    addCart(state,payload){
      payload.isChecked = true
      state.cartList.push(payload)
    }
  },
  actions:{
    addCart(context,payload){
      // for (let item of state.cartList) {
      //   if (item.iid === payload.iid) {
      //     item.count++
      //   }
      // }
      // if (state.cartList.indexOf(payload) !== -1) {
      //   payload.count++
      // }
      //返回一个promise来确定添加成功，后执行什么
     return new Promise((resolve, reject) => {
       let olderProduct = context.state.cartList.find(item => item.iid === payload.iid)
       if (olderProduct) {
         context.commit("addCounter",olderProduct)
         resolve("商品数目加1")
       }else {
         context.commit("addCart",payload)
         resolve("添加到购物车")
       }
     })
    }
  }
})

export default store
