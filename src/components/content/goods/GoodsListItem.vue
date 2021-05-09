<template>
  <div class="goods-item">
    <img :src="goodsItem.image_src"  alt="">
    <div class="goods-info">
      <p>{{goodsItem.name}}</p>
      <span class="price">{{goodsItem.image_width}}</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "GoodsListItem",
    props: {
      goodsItem: {
        type: Object,
        default() {
          return null
        }
      }
    }
  }
</script>

<style scoped>
  .goods-item {
    padding-bottom: 40px;
    position: relative;
    width: 40%;
  }
  .goods-item img {
    width: 100%;
    height: 150px;
    border-radius: 5px;
  }
  .goods-info {
    font-size: 12px;
    position: absolute;
    bottom: 5px;
    left: 0;
    right: 0;
    overflow: hidden;
    text-align: center;
  }
  .goods-info p {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    margin-bottom: 3px;
  }
  .goods-info .price {
    color: var(--color-high-text);
    margin-right: 20px;
  }
  /*.goods-info .collect {*/
  /*  position: relative;*/
  /*}*/
  /*.goods-info .collect::before {*/
  /*  content: '';*/
  /*  position: absolute;*/
  /*  left: -15px;*/
  /*  top: -1px;*/
  /*  width: 14px;*/
  /*  height: 14px;*/
  /*  !*background: url("~assets/img/common/collect.svg") 0 0/14px 14px;*!*/
  /*}*/
</style>
