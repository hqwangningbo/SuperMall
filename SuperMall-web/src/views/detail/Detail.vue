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
      <detail-goods-info :detail-info="detailInfo"
                         :desc="desc"
                         @loadImgEvent = "loadImgEvent"/>
      <detail-param-info :param-info="paramInfo"  ref="param"/>
      <detail-comment-info :comment= "commentInfo" ref="comment"/>
      <goods-list :goods-list="recommends" ref="recommend"/>
    </scroll>
    <back-top @click.native="backClick"
              v-show="isShowBackTop"/>
    <detail-bottom-bar @addToCart="addToCart"/>
    <Toast/>
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
  import DetailBottomBar from "@/views/detail/childrenComps/DetailBottomBar";
  import GoodsList from "@/components/content/goods/GoodsList";
  import {getSwiperImage,getGoodDetail,getShopInfo,getSellerShowImage,getProductInfo,getComments,getRecommend, Goods, Shop, GoodsParam} from "@/network/detail";
  import Scroll from "@/components/common/scroll/Scroll";
  import {debounce} from "@/common/utils";
  import {backTopMixin} from "@/common/mixin";
  import Toast from "@/components/common/toast/Toast";

  export default {
    name: "Detail",
    components: {
      Toast,
      DetailCommentInfo,
      DetailNavBar,
      DetailSwiper,
      DetailBaseInfo,
      DetailShopInfo,
      DetailGoodsInfo,
      DetailParamInfo,
      GoodsList,
      DetailBottomBar,
      Scroll
    },
    mixins:[backTopMixin],
    data() {
      return {
        iid: null,
        desc:null,
        topImages: [],
        goods: {},
        shop: {},
        detailInfo:[],
        paramInfo:[],
        commentInfo:{},
        recommends:[],
        themeTopYs:[]
      }
    },
    created() {
      this.iid = this.$route.params.iid
      getSwiperImage(this.iid).then(res=>{
        this.topImages = res.data
      })
      getGoodDetail(this.iid).then(res=>{
        this.goods = res.data
        this.desc = res.data.desc
      })
      getShopInfo(this.iid).then(res=>{
        this.shop = res.data
      })
      getSellerShowImage(this.iid).then(res=>{
        this.detailInfo= res.data
      })
      getProductInfo(this.iid).then(res=>{
        this.paramInfo = res.data
      })
      getComments(this.iid).then(res=>{
        this.commentInfo = res.data[0]
      })
      getRecommend(this.iid).then(res=>{
        this.recommends = res.data
      })
    },
    methods:{
      addToCart(){
        //获取购物车需要展示的信息
        const product = {}
        product.image = this.topImages[0].image
        product.title = this.goods.title
        product.desc = this.goods.desc
        product.price = this.goods.oldPrice.replace("¥","")
        product.count = 1
        product.iid = this.iid
        //将商品添加到购物车,通过mutations来改变state的值
        this.$store.dispatch("addCart",product).then(res=> {
          //   this.isShow = true
          //   this.message = res
          //
          //   setTimeout(()=>{
          //     this.isShow = false
          //   },1500)
          // })
          this.$toast.showTips(res, 1000)
        })
      },
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
        //判断是否显示回到顶部
        this.isShowBackTop = (-position.y) > 800

      },
      getThemeTops(){
        this.themeTopYs.push(0)
        this.themeTopYs.push(this.$refs.param.$el.offsetTop)
        this.themeTopYs.push(this.$refs.comment.$el.offsetTop)
        this.themeTopYs.push(this.$refs.recommend.$el.offsetTop)
        this.themeTopYs.push(Number.MAX_VALUE)
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
    height: calc(100% - 44px - 49px);
  }
</style>
