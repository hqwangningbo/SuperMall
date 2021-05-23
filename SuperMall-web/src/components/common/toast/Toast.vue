<template>
  <div id="toast">
    <div v-show="isShow">{{message}}</div>
  </div>
</template>

<script>
  export default {
    name: "Toast",
    props: {},
    data() {
      return{
        message:"",
        isShow:false
      }
    },
    methods:{
      //es6默认值
      showTips(message="默认文字",time=1500){
        this.isShow = true
        this.message = message
        setTimeout(()=>{
          this.isShow = false
        },time)
      }
    }
  }
</script>

<style scoped>
  #toast {
    position: fixed;
    top: 45%;
    left: 45%;
    background-color: rgba(0, 0, 0, .8);
    color: #fff;
    z-index: 999;
    /*padding: 8px 10px;*/
    /*transform: translate(-50%,-50%);*/
  }
</style>
