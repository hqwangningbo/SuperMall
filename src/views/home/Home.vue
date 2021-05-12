<template>
  <div id="home">

    <nav-bar class="home-nav">
      <template v-slot:center>
        主页
      </template>
    </nav-bar>
    <tab-control class="tab-control"
                 :titles="['流行', '新款', '精选']"
                 @tabClick="tabClick"
                 ref="tabControl1"
                 v-show="isShowTabControl"></tab-control>
   <scroll class="content"
           ref="scroll"
           :probe-type="3"
           @scroll="scrollContent"
           :pull-up-load="true"
           @pullingUp="loadMore"> <!--
                                    pull-up-load="true" 是否监听加载到底部
                                    ref="scroll" 在父组件中使用子组件，通过this.$refs.scroll.数据 直接获取子组件中的数据
                                    :probe-type="3"
                                    @pullingUp="loadMore" 子组件发射过来的事件，scroll监听拉倒底部
                                    @scroll="scrollContent" 子组件发射过来的事件，scroll实时监听位置
                                    -->
     <home-swiper :banners="banners" @bannerImageLoaded="bannerImageLoaded"/> <!-- :banners="banners" 在父组件中网络请求到数据，发送给子组件props中的:banners -->
     <recommend-view :recommends="recommends"/> <!-- :recommends="recommends" 在父组件中网络请求到数据，发送给子组件props中的:recommends -->
     <feature-view/> <!-- 就加载个图片 -->
     <tab-control
                  :titles="['流行', '新款', '精选']"
                  @tabClick="tabClick" ref="tabControl2"></tab-control>
     <goods-list :goodsList="showGoodsList"></goods-list>
     <!--
     :titles="titles" 在父组件中网络请求到数据，发送给子组件props中的:titles
     :goodsList="showGoodsList"  this.goodsList[this.currentType].list把数据发送到子组件props goodsList。currentType通过这个来确定展示的数据
     @tabClick="tabClick" 子组件发送过来的index来动态确定currentType，从而展示的数据不同
     -->
   </scroll>
    <!--
    组件想要监听事件要加上.native
    v-show="isShowBackTop"是否展示
    -->
    <back-top @click.native="backClick"
              v-show="isShowBackTop"/>
  </div>
</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";
  import FeatureView from "@/views/home/childComps/FeatureView";
  import GoodsList from "@/components/content/goods/GoodsList";
  import GoodsListItem from "@/components/content/goods/GoodsListItem";
  import BackTop from "@/components/content/backTop/BackTop";
  import {getHomeMultidata, getHomeGoods} from "@/network/home";

  import {debounce} from "@/common/utils";

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
        currentType: 'pop',
        isShowBackTop:false,
        tabOffsetTop : 0,
        isShowTabControl:false
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
      Scroll,
      BackTop
    },
    created() {
      this.getHomeMultidata()
      this.getHomeGoods('pop')
      this.getHomeGoods('new')
      this.getHomeGoods('sell')
    },
    mounted(){

      const refresh = debounce(this.$refs.scroll.refresh,300)
      //事件总线，解决滑动划不动的bug
      //this.$refs.scroll在Created里面是可能拿不到的，在mounted就能拿到
      this.$bus.$on('itemImageLoad',()=>{
        //this.$refs.scroll先判断前面是否存在，再去执行下面的代码
        refresh()
      })

    },
    methods: {
      //轮播图加载完成，获取tabControl到顶部的距离
      bannerImageLoaded(){
        //所有的组件都有$el，获取组件中的模板元素
        this.tabOffsetTop = this.$refs.tabControl2.$el.offsetTop
      },
      loadMore(){
        this.getHomeGoods(this.currentType)
      },
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
        this.$refs.tabControl1.currentIndex = index
        this.$refs.tabControl2.currentIndex = index
      },

      /**
       * 跳转到顶部
       */
      backClick(){
        // console.log("backClick");
        //跳到顶部500毫秒
        this.$refs.scroll.scrollTo(0,0,500)
      },
      scrollContent(position){
        this.isShowBackTop = (-position.y) > 800
        this.isShowTabControl = this.tabOffsetTop < (-position.y)
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

          //完成上拉,以便于重新加载新数据,不然只能加载一次
          this.$refs.scroll.finishPullUp()
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

    /*position: fixed;*/
    /*left: 0;*/
    /*right: 0;*/
    /*top: 0;*/
    /*z-index: 9;*/
  }

  .tab-control {
    /*position: sticky;*/
    /*top: 44px;*/
    position: relative;
    z-index: 9;
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
