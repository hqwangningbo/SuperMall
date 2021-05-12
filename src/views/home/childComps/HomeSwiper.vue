<template>
  <swiper>
    <swiper-item v-for="item in banners">
      <a :href="item.link">
        <img :src="item.image" alt="" @load="bannerImageLoaded">
      </a>
    </swiper-item>
  </swiper>
</template>

<script>
  import Swiper from "@/components/common/swiper/Swiper";
  import SwiperItem from "@/components/common/swiper/SwiperItem";

  export default {
    name: "HomeSwiper",
    data(){
      return{
        isLoaded:false
      }
    },
    props:{
      //父组件传过来的banners
      banners:{
        type:Array,
        default(){
          return []
        }
      }
    },
    methods:{
      bannerImageLoaded(){
        if (!this.isLoaded) {
          this.$emit("bannerImageLoaded")
          this.isLoaded=true
        }
      }
    },
    components: {
      Swiper,
      SwiperItem
    }
  }
</script>

<style scoped>
</style>
