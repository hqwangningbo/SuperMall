<template>
  <div id="goods-list">
    <goods-list-item v-for="(item,index) in goodsList" :key="index" :goodsItem="item"/>
  </div>
</template>

<script>
  import GoodsListItem from "@/components/content/goods/GoodsListItem";
  export default {
    name: "GoodsList",
    components:{
      GoodsListItem
    },
    props: {
      goodsList: Array,
      default() {
        return []
      }
    }
  }
</script>

<style scoped>
  #goods-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    padding: 2px;
  }
</style>
