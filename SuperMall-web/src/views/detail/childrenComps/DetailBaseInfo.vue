<template>
  <div v-if="Object.keys(goods).length !==0" class="base-info">
    <div class="title-info">{{goods.title}}</div>
    <div class="price-info">
      <span class="price">{{goods.price}}</span>
      <span class="old-price">{{goods.oldPrice}}</span>
      <span v-if="goods.discountDesc" class="discountDesc">{{goods.discountDesc}}</span>
    </div>
    <div class="other-info">
      <span>{{goods.sales}}</span>
      <span>{{goods.collections}}</span>
      <span>{{goods.deliveryMethod}}</span>
    </div>
<!--    <div class="service-info">-->
<!--      <span class="service-info-item" v-for="index in goods.services.length-1">-->
<!--        <img :src="goods.services[index-1].icon" alt="">-->
<!--        <span>{{goods.services[index-1].name}}</span>-->
<!--      </span>-->
<!--    </div>-->
  </div>
</template>

<script>
  export default {
    name: "DetailBaseInfo",
    props:{
      goods:{
        type:Object,
        default(){
          return {}
        }
      }
    }
  }
</script>

<style scoped>
.base-info{
  margin-top: 15px;
  padding: 0 8px;
  color: #999;
  border-bottom: 5px solid #f2f5f8;
}
  .title-info{
    color: #222;
  }
  .price-info{
    margin-top: 10px;
  }
.price-info .price{
    font-size: 24px;
    color: var(--color-high-text);
  }
  .price-info .old-price{
    font-size: 13px;
    text-decoration: line-through;
    margin-left: 5px;
  }
  .price-info .discountDesc{
    font-size: 12px;
    padding: 2px 5px;
    color: #fff;
    background-color: var(--color-high-text);
    border-radius: 8px;
    margin-left: 5px;

  /*  让元素上浮一些,使用相对定位*/
    position: relative;
    top: -8px;
  }
  .other-info{
    margin-top: 15px;
    line-height: 30px;
    display: flex;
    font-size: 13px;
    border-bottom: 1px solid rgba(100,100,100,.1);
    justify-content: space-between;
  }
  .service-info{
    display: flex;
    justify-content: space-between;
    line-height: 60px;
  }
  .service-info img{
    width: 14px;
    height: 14px;
    position: relative;
    top: 2px;
  }
  .service-info-item span{
    font-size: 13px;
    color: #333;
  }
</style>
