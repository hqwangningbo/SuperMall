<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center>
        主页
      </template>
    </nav-bar>
    <home-swiper :message="message"/>
    <recommend-view :recommend="recommend"/>
    <tab-control class="tab-control"
                 :titles="['时尚女装','户外活动','箱包配饰']"
                 @tabClick="tabClick"></tab-control>
    <goods-list :goods="goods[currentType]"></goods-list>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import GoodsList from "@/components/content/goods/GoodsList";
  import GoodsListItem from "@/components/content/goods/GoodsListItem";
  import {getSwiperData,getCatitems,getFloorData} from "@/network/home";

  import HomeSwiper from "@/views/home/childComps/HomeSwiper";

  import RecommendView from "@/views/home/childComps/RecommendView";

  import TabControl from "@/components/content/tabControl/TabControl";

  export default {
    name: "Home",
    data() {
      return {
        message: [],
        recommend: [],
        goods:{
          good1:[],
          good2:[],
          good3:[]
        },
        currentType:'good1'
      }
    },
    components: {
      NavBar,
      HomeSwiper,
      RecommendView,
      TabControl,
      GoodsListItem,
      GoodsList
    },
    methods:{
      tabClick(index){
        switch (index) {
          case 0 :
            this.currentType= 'good1'
            break
          case 1:
            this.currentType='good2'
            break
          case 2 :
            this.currentType= 'good3'
            break
        }
      }
    },
    created() {
      getSwiperData().then(res => {
        // console.log(res.data.message[0].image_src)
        this.message = res.data.message
      })
      getCatitems().then(res=>{
        this.recommend=res.data.message
      })

      getFloorData().then(res=>{
        this.goods.good1 = res.data.message[0].product_list
        this.goods.good2 = res.data.message[1].product_list
        this.goods.good3 = res.data.message[2].product_list
      })

    }
  }
</script>

<style scoped>
  #home{
    padding-top: 44px;
  }
  .home-nav {
    background-color: var(--color-tint);
    color: #fff;

    position: fixed;
    left: 0;
    right: 0;
    top: 0;
    z-index: 9;
  }
  .tab-control{
    position: sticky;
    top: 44px;
  }
</style>
