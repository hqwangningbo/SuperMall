<template>
  <div class="recommend">
    <div v-for="item in recommends" class="recommend-item">
      <a href="#">
        <img :src="item.image" alt="" @load="recommendsImageLoad">
                <div>{{item.title}}</div>
      </a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "RecommendView",
    props: {
      recommends: {
        type: Array,
        default() {
          return [];
        }
      }
    },
    methods:{
      recommendsImageLoad(){
        this.$emit("recommendsImageLoad")
      }
    }
  }
</script>

<style scoped>
  .recommend {
    display: flex;
  }

  .recommend-item {
    flex: 1;
    text-align: center;
    padding: 10px 0 25px;

    border-bottom: 8px solid #eee;
  }

  .recommend-item img {
    width: 80px;
    height: 80px;
  }
</style>
