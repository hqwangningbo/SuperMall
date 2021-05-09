<template>
  <swiper>
    <swiper-item v-for="item in message">
      <a :href="item.navigator_url">
        <img :src="item.image_src" alt="">
      </a>
    </swiper-item>
  </swiper>
</template>

<script>
  import Swiper from "@/components/common/swiper/Swiper";
  import SwiperItem from "@/components/common/swiper/SwiperItem";

  export default {
    name: "HomeSwiper",
    props:{
      message:{
        type:Array,
        default(){
          return []
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
