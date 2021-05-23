<template>
  <div id="cart">
    <nav-bar class="cart-nav">
      <template v-slot:center>
        购物车({{totalCount}})
      </template>
    </nav-bar>
    <scroll class="content" ref="scroll">
      <cart-list></cart-list>
    </scroll>
    <cart-button-bar/>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import CartList from "@/views/cart/childComps/CartList";
  import Scroll from "@/components/common/scroll/Scroll";
  import CartButtonBar from "@/views/cart/childComps/CartButtonBar";

  export default {
    name: "Cart",
    data(){
      return{
        cartList: []
      }
    },
    components:{
      CartButtonBar,
      Scroll,
      CartList,
      NavBar
    },
    computed:{
      totalCount(){
        return this.getTotalCount()
      }
    },
    activated(){
      this.$refs.scroll.refresh()
    },
    created(){
      this.cartList = this.$store.state.cartList
    },
    methods:{
      getTotalCount(){
        let totalCount = 0
        for (let i = 0;i<this.cartList.length;i++){
          totalCount+=this.cartList[i].count
        }
        return totalCount
      }
    }
  }
</script>

<style scoped>
  #cart{
    height: 100vh;
  }
  .cart-nav {
    background-color: var(--color-tint);
    color: #fff;
  }
  .content{
    height: calc(100% - 44px - 49px - 40px);
    overflow: hidden;
  }
</style>
