<template>
<div class="cart-list" >
  <div class="cart-list-item"
       v-for="(item,index) in cartList"
       :key="index">
    <cart-check-button
      @click.native="checkClick(item)"
      :isChecked="item.isChecked"
      ref="checkButtonRef"
    />
    <div class="item-img" @click="checkClick(item)">
      <img :src="item.image" alt="" />
    </div>
    <div class="item-info" @click="infoClick(item)">
      <p class="item-title">{{ item.title }}</p>
      <p class="item-desc">{{ item.desc }}</p>
      <span class="item-price">￥{{ item.price }}</span>
      <span class="item-count">x{{ item.count }}</span>
    </div>
  </div>
</div>
</template>
<script>
  import CartCheckButton from "@/views/cart/childComps/CartCheckButton";
  export default {
    name: "CartList",
    components: {CartCheckButton},
    data(){
      return {
        itemCheck:false
      }
      },
    methods:{
      checkClick(item) {
        item.isChecked = !item.isChecked
      },
      //信息点击事件
      infoClick(item) {
        this.$router.push("/detail/" + item.iid);
      }
    },
    computed:{
      cartList(){
        return  this.$store.state.cartList
      }
    }
  }
</script>

<style scoped>
  .cart-list-item {
    width: 100%;
    height: 100px;
    border-bottom: 0.04rem solid rgba(128, 128, 128, 0.4);
    display: flex;
    padding: 0.2rem;
    /*padding-left: 0rem;*/
  }
  .item-img {
    /*width: 100px;*/
    /*height: 100%;*/
  }
  .item-img img {
    width: 4.5rem;
    height: 100%;
    border-radius: 10px;
  }
  .item-info {
    position: relative;
    width: calc(100% - 3.5rem - 1.2rem - 0.4rem);
    margin-left: 0.4rem;
  }
  .item-info p {
    display: inline-block;
    width: 100%;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
  }
  .item-title {
    font-size: 16px;
    padding-bottom: 0.5rem;
  }
  .item-desc {
    font-size: 10px;
    color: gray;
  }
  .item-price {
    position: absolute;
    left: 0;
    bottom: 0.4rem;
    font-size: 16px;
    color: orangered;
  }
  .item-count {
    position: absolute;
    right: 1.2rem;
    bottom: 0.4rem;
    font-size: 16px;
    font-weight: bold;
  }

</style>
