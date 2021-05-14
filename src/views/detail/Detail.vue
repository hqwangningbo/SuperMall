<template>
  <div id="detail">
    <detail-nav-bar class="detail-nav"
                    @titleClick="titleClick"
                    ref="navBar"/>
    <scroll class="content"
            ref="scroll"
            @scroll="contentScroll"
            :probe-type="3">
      <detail-swiper :topImages="topImages"></detail-swiper>
      <detail-base-info :goods="goods" />
      <detail-shop-info :shop="shop"/>
      <detail-goods-info :detail-info="detailInfo" @loadImgEvent = "loadImgEvent"/>
      <detail-param-info :param-info="paramInfo"  ref="param"/>
      <detail-comment-info :comment= "commentInfo" ref="comment"/>
      <goods-list :goods-list="recommends" ref="recommend"/>
    </scroll>
  </div>
</template>

<script>
  import DetailNavBar from "@/views/detail/childrenComps/DetailNavBar";
  import DetailSwiper from "@/views/detail/childrenComps/DetailSwiper";
  import DetailBaseInfo from "@/views/detail/childrenComps/DetailBaseInfo";
  import DetailShopInfo from "@/views/detail/childrenComps/DetailShopInfo";
  import DetailGoodsInfo from "@/views/detail/childrenComps/DetailGoodsInfo";
  import DetailParamInfo from "@/views/detail/childrenComps/DetailParamInfo";
  import DetailCommentInfo from "@/views/detail/childrenComps/DetailCommentInfo";
  import GoodsList from "@/components/content/goods/GoodsList";
  import {getDetail, Goods, Shop, GoodsParam, getDetailRecommend} from "@/network/detail";
  import Scroll from "@/components/common/scroll/Scroll";
  import {debounce} from "@/common/utils";

  export default {
    name: "Detail",
    components: {
      DetailCommentInfo,
      DetailNavBar,
      DetailSwiper,
      DetailBaseInfo,
      DetailShopInfo,
      DetailGoodsInfo,
      DetailParamInfo,
      GoodsList,
      Scroll
    },
    data() {
      return {
        iid: null,
        topImages: [],
        goods: {},
        shop: {},
        detailInfo:{},
        paramInfo:{},
        commentInfo:{},
        recommends:[],
        themeTopYs:[]
      }
    },
    created() {
      this.iid = this.$route.params.iid
      getDetail(this.iid).then(res => {
        // console.log(res.data);
        this.topImages = res.data.result.itemInfo.topImages
        //获取商品信息
        this.goods = new Goods(res.data.result.itemInfo,
          res.data.result.columns,
          res.data.result.shopInfo.services)
        //获取商家信息
        this.shop = new Shop(res.data.result.shopInfo)

        //获取商品细节
        this.detailInfo = res.data.result.detailInfo

        //获取参数信息
        this.paramInfo = new GoodsParam(res.data.result.itemParams.info,res.data.result.itemParams.rule)

        //获取评论信息
        if (res.data.result.rate.cRate !== 0) {
          this.commentInfo = res.data.result.rate.list[0]
        }
      })
      getDetailRecommend().then(res=>{
        this.recommends = res.data.data.list
        // console.log(res.data.data.list);
      })
    },
    methods:{
      loadImgEvent(){
        this.$refs.scroll.refresh()
        this.getThemeTops()
      },
      contentScroll(position){
        const positionY = -position.y
        for (let i=0;i<this.themeTopYs.length-1; i++) {
          if (positionY > this.themeTopYs[i] && positionY < this.themeTopYs[i+1]){
            this.$refs.navBar.currentIndex = i
            // console.log(i);
          }
        }

      },
      getThemeTops(){
        this.themeTopYs.push(0)
        this.themeTopYs.push(this.$refs.param.$el.offsetTop)
        this.themeTopYs.push(this.$refs.comment.$el.offsetTop)
        this.themeTopYs.push(this.$refs.recommend.$el.offsetTop)
        this.themeTopYs.push(Number.MAX_VALUE)
        console.log(this.themeTopYs)
      },
      titleClick(index){
        this.$refs.scroll.scrollTo(0,-this.themeTopYs[index])
      }
    },
    mounted(){
      const refresh = debounce(this.$refs.scroll.refresh,300)
      //事件总线，解决滑动划不动的bug
      //this.$refs.scroll在Created里面是可能拿不到的，在mounted就能拿到
      this.$bus.$on('detailItemImageLoad',()=>{
        //this.$refs.scroll先判断前面是否存在，再去执行下面的代码
        refresh()
      })

    }
  }
</script>

<style scoped>
  #detail {
    position: relative;
    z-index: 9;
    background-color: #fff;
    height: 100vh;
  }

  .detail-nav {
    position: relative;
    z-index: 9;
    background-color: #fff;
  }

  .content {
    height: calc(100% - 44px);
  }
</style>
