<template>
  <div id="shop-info" v-if="Object.keys(shop).length != 0">
    <div class="shop_name">
      <img :src="shop.shopLogo" alt="" />
      <span>{{ shop.name }}</span>
    </div>

    <div class="score_info">
      <div class="score_left">
        <div class="score_sell">
          <div>{{ sellValue }}万</div>
          <div style="font-size: 0.6rem;">总销量</div>
        </div>
        <div class="score_fans">
          <div>{{ shop.cfans }}</div>
          <div style="font-size: 0.6rem;">粉丝数</div>
        </div>
        <div class="score_item">
          <div>{{ shop.cgoods }}</div>
          <div style="font-size: 0.6rem;">全部宝贝</div>
        </div>

      </div>
      <div class="score_right">
        <table>
          <tr>
            <td>描述相符</td>
            <td :style="{ color: isBetter(shop.descConsistentScore) ? 'red' : 'green' }">
              {{shop.descConsistentScore}}
            </td>
            <td
              style="color: white;"
              :style="{ backgroundColor: isBetter(shop.descConsistentScore) ? 'red' : 'green' }"
            >
              {{ isBetter(shop.descConsistentScore) ? "高" : "低" }}
            </td>
          </tr>
          <tr>
            <td>价格合理</td>
            <td :style="{ color: isBetter(shop.priceReasonableScore) ? 'red' : 'green' }">
              {{shop.priceReasonableScore}}
            </td>
            <td
              style="color: white;"
              :style="{ backgroundColor: isBetter(shop.priceReasonableScore) ? 'red' : 'green' }"
            >
              {{ isBetter(shop.priceReasonableScore) ? "高" : "低" }}
            </td>
          </tr>
          <tr>
            <td>质量满意</td>
            <td :style="{ color: isBetter(shop.qualitySatisfiedScore) ? 'red' : 'green' }">
              {{shop.qualitySatisfiedScore}}
            </td>
            <td
              style="color: white;"
              :style="{ backgroundColor: isBetter(shop.qualitySatisfiedScore) ? 'red' : 'green' }"
            >
              {{ isBetter(shop.qualitySatisfiedScore) ? "高" : "低" }}
            </td>
          </tr>
        </table>
      </div>
    </div>
    <div class="come-shop">
      <a :href="shop.shopUrl"> 进店逛逛</a>

    </div>
  </div>
</template>

<script>
  export default {
    props: {
      shop: {
        type: Object,
        default() {
          return {};
        }
      }
    },
    computed: {
      sellValue() {
        /* parseFloat(this.shop.sells / 10000).toFixed(1) */
        return Math.round((this.shop.csells / 10000) * 10) / 10;
      }
    },
    methods:{
      isBetter(descConsistentScore){
        return descConsistentScore>=5
      }
    }
  };
</script>

<style scoped>
  #shop-info {
    padding: 25px 8px;
    border-bottom: 5px solid #f2f5f8;
    font-size: 0.75rem;
  }
  .shop_name img {
    width: 1.7rem;
    height: 1.7rem;
    border: 0.042rem solid rgba(128, 128, 128, 0.5);
    border-radius: 0.85rem;
  }
  .shop_name span {
    margin-left: 0.34rem;
    position: relative;
    top: -0.64rem;
    font-size: 0.768rem;
  }
  /**
    * 商店信息左右两侧的样式，整个商店信息是弹性盒子，
    * 可左边用弹性盒子做，右边用table做
    */
  .score_info {
    padding: 0px 0.512rem;
    display: flex;
  }
  .score_left,
  .score_right {
    flex: 1;
  }
  /* 给score_left也做弹性盒子，且其子元素以侧轴中心对齐 */
  .score_left {
    display: flex;
    align-items: center;
  }
  .score_left > div {
    flex: 1;
  }
  .score_sell,
  .score_fans,
  .score_item {
    text-align: center;
  }
  .score_item {
    border-right: 0.042rem solid gray;
  }
  /**
    * 右边用table做的
    */
  .score_right > table {
    margin: 0 auto;
    font-size: 0.64rem;
    border-spacing: 0.42rem;
  }
  /**
    * 进店逛逛的样式
    */
  .come-shop {
    width: 80px;
    height: 20px;
    line-height: 20px;
    text-align: center;
    border-radius: 8px;
    background-color: rgba(128, 128, 128, 0.3);
    margin: 12px auto;
  }
</style>
