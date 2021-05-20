<template>
  <div class="wrapper" ref="wrapper">
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
  import BScroll from 'better-scroll'
  export default {
    name: "Scroll",
    data() {
      return {
        scroll: null
      }
    },
    props:{
      probeType: {
        type:Number,
        default: 0
      },
      pullUpLoad:{
        type: Boolean,
        default: false
      }
    },
    mounted(){
      // this.scroll = new BScroll(document.querySelector('.wrapper'))
      //创建bscroll对象
      this.scroll = new BScroll(this.$refs.wrapper,{
        click:true,
        probeType:this.probeType,
        pullUpLoad: this.pullUpLoad
      })
      // 监听滚动的位置
      if (this.probeType == 2 || this.probeType == 3) {
        this.scroll.on('scroll',(position)=>{
          // console.log(position);
          this.$emit('scroll',position)
        })
      }
      if (this.pullUpLoad) {
        //监听上拉
        this.scroll.on('pullingUp',()=>{
          // console.log("上拉加载");
          this.$emit('pullingUp')
        })
      }
    },
    methods:{
      //返回顶部默认300毫秒
      scrollTo(x,y,time=300){
        this.scroll && this.scroll.scrollTo(x,y,time)
      },
      //完成上拉,以便于重新加载新数据
      finishPullUp(){
        this.scroll && this.scroll.finishPullUp()
      },
      //刷新
      refresh(){
        this.scroll && this.scroll.refresh()
      }
    }
  }
</script>

<style scoped>

</style>
