<template>
  <div id="tab-control">
    <div v-for="(item,index) in titles"
         class="tab-control-item"
         :class="{active:index===currentIndex}"
         @click="tabClick(index)">
      <span class="title-item">{{item}}</span>
    </div>
  </div>
</template>

<script>
  export default {
    name: "TabControl",
    data(){
      return{
        currentIndex:0
      }
    },
    methods:{
      tabClick(index){
        this.currentIndex = index
        this.$emit('tabClick',index)
      }
    },
    props: {
      titles: {
        type: Array,
        default() {
          return [];
        }
      }
    }
  }
</script>

<style scoped>
  #tab-control {
    display: flex;
    text-align: center;
    line-height: 40px;
    background-color: #fff;
    z-index: 9;
    /*position: fixed;*/
  }

  .tab-control-item {
    flex: 1;
  }
  .active{
    color: var(--color-tint);
  }

  .active span{
    padding: 5px;
    border-bottom: 3px solid var(--color-tint);
  }
</style>
