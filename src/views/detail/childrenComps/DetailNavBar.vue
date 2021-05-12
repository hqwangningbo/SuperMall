<template>
  <div>
    <nav-bar>
      <div slot="left" class="back" @click="backClick">
        <img src="~assets/img/common/back.svg" alt="">
      </div>
      <div slot="center" class="title">
        <div v-for="(item,index) in titles"
             class="title-item"
             :class="{active:currentIndex ===index}"
             @click="titleClick(index)">
          {{item}}
        </div>
      </div>
    </nav-bar>
  </div>

</template>

<script>
  import NavBar from "@/components/common/navbar/NavBar";

  export default {
    name: "DetailNavBar",
    data(){
      return{
        currentIndex:0,
        titles:['商品','参数','评论','推荐']
      }
    },
    methods:{
      titleClick(index){
        this.currentIndex = index
      },
      backClick(){
        this.$router.back()
      }
    },
    components:{
      NavBar
    }
  }
</script>

<style scoped>
  .title{
    display: flex;
  }
.title-item{
  flex: 1;
}
  .active{
    color: var(--color-high-text);
  }
  .back img{
    margin-left: 2px;
    margin-top: 12px;
  }
</style>
