<template>
    <div id="cart-button-bar">
      <div class="all-checked"
           @click="allChecked">
        <cart-check-button :is-checked="isSelectAll"/>
        <span>全选</span>
      </div>
      <div class="total-price">
        合计:￥{{totalPrice}}
      </div>
      <div class="calculate" @click="toCalculate">
        去结算({{totalCount}})
      </div>
    </div>
</template>

<script>
    import CartCheckButton from "@/views/cart/childComps/CartCheckButton";
    export default {
      name: "CartButtonBar",
      components: {CartCheckButton},
      computed:{
        totalPrice(){
          return this.$store.state.cartList.filter(item=>{
            return item.isChecked
          }).reduce((previousValue,item)=>{
            return previousValue + item.price * item.count
          },0).toFixed(2)
        },
        totalCount(){
          return this.$store.state.cartList.filter(item=>{
            return item.isChecked
          }).reduce((previousValue, item) =>{
            return previousValue + item.count
          },0)
        },
        //find一旦查到就停止返回true
        isSelectAll(){
          return this.$store.state.cartList.length !==0 ?
            !this.$store.state.cartList.find(item=>!item.isChecked) :
            false
        }
      },
      methods:{
        allChecked(){
          if (this.isSelectAll) {
            this.$store.state.cartList.forEach(item=>item.isChecked = false)
          }else{
            this.$store.state.cartList.forEach(item=>item.isChecked = true)
          }
        },
        toCalculate(){
          //find：如果也有被选中的返回true，没有选中的返回false，所以取反就是他全都没选，我要执行的东西
          if (!this.$store.state.cartList.find(item=>item.isChecked)) {
            this.$toast.showTips("请选择一件商品",1500)
          }
        }
      }
    }
</script>

<style scoped>
#cart-button-bar{
  height: 40px;
  width: 100%;
  background-color: #eee;
  display: flex;
  justify-content:space-between;
  align-items: center;
}
  .all-checked{
    margin-left: 20px;
    height: 40px;
    display: flex;
    align-items: center;
  }
  .all-checked span{
    padding-left: 5px;
  }
  .total-price{
    margin-left: 10px;
  }
  .calculate{
    text-align: center;
    height: 40px;
    width: 100px;
    line-height: 40px;
    background-color: orange;
  }
</style>
