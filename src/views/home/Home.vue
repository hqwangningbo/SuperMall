<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center>
        主页
      </template>
    </nav-bar>

   <scroll class="content">
     <home-swiper :banners="banners"/>
     <recommend-view :recommends="recommends"/>
     <feature-view/>
     <tab-control class="tab-control"
                  :titles="['流行', '新款', '精选']"
                  @tabClick="tabClick"></tab-control>
     <goods-list :goodsList="showGoodsList"></goods-list>
   </scroll>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import FeatureView from "@/views/home/childComps/FeatureView";
  import GoodsList from "@/components/content/goods/GoodsList";
  import GoodsListItem from "@/components/content/goods/GoodsListItem";
  import {getHomeMultidata, getHomeGoods} from "@/network/home";

  import HomeSwiper from "@/views/home/childComps/HomeSwiper";

  import RecommendView from "@/views/home/childComps/RecommendView";

  import TabControl from "@/components/content/tabControl/TabControl";
  import Scroll from "@/components/common/scroll/Scroll";

  export default {
    name: "Home",
    data() {
      return {
        banners: [],
        recommends: [],
        goodsList: {
          'pop': {page: 1, list: []},
          'new': {page: 1, list: []},
          'sell': {page: 1, list: []}
        },
        currentType: 'pop'
      }
    },
    computed: {
      showGoodsList() {
        return this.goodsList[this.currentType].list
      }
    },
    components: {
      NavBar,
      HomeSwiper,
      RecommendView,
      TabControl,
      GoodsListItem,
      GoodsList,
      FeatureView,
      Scroll
    },
    created() {
      this.getHomeMultidata()
      this.getHomeGoods('pop')
      this.getHomeGoods('new')
      this.getHomeGoods('sell')
    },
    methods: {
      tabClick(index) {
        switch (index) {
          case 0 :
            this.currentType = 'pop'
            break
          case 1:
            this.currentType = 'new'
            break
          case 2 :
            this.currentType = 'sell'
            break
        }
      },
      /**
       * 封装网络请求
       */
      getHomeMultidata() {
        getHomeMultidata().then(res => {
          this.banners = res.data.data['banner'].list
          this.recommends = res.data.data['recommend'].list
        })
      },
      getHomeGoods(type) {
        getHomeGoods(type, this.goodsList[type].page).then(res => {
          const goodsList = res.data.data.list;
          this.goodsList[type].list.push(...goodsList)
          this.goodsList[type].page += 1
        })
      }
    }

  }
</script>

<style scoped>
  #home {
    /*padding-top: 44px;*/
    height: 100vh;

    position: relative;
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

  .tab-control {
    position: sticky;
    top: 44px;
  }
  /*.content{*/
  /*  height: calc(100% - 49px);*/
  /*  overflow: hidden;*/
  /*}*/
  .content{
    overflow: hidden;

    position: absolute;
    top: 44px;
    bottom: 49px;
    left: 0;
    right:0;
  }
</style>
