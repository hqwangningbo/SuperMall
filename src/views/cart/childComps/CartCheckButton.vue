<template>
  <div class="item-check" >
      <img src="~assets/img/cart/tick.svg" alt="" :class="{checked:isChecked}">
  </div>
</template>
<script>
  export default {
    name: "CartCheckButton",
    props: {
      isChecked:{
        type:Boolean,
        default(){
          return false
        }
      }
    },
    data() {
      return {}
    }
  }
</script>
<style scoped>
  .item-check {
    width: 1.2rem;
    padding-right: 0.4rem;
  }
  .item-check img {
    position: relative;
    top: calc(50% - 0.35rem);
    /*width: 0.7rem;*/
    /*height: 0.7rem;*/
    margin: 0 auto;

    border-radius: 50%;
    border: 0.04rem solid rgba(128, 128, 128, 0.4);
  }
  .checked{
    border-color: #ff8198;
    background-color: red;
  }
</style>
