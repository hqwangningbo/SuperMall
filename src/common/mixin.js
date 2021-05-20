import BackTop from "@/components/content/backTop/BackTop";
export const backTopMixin = {
  components:{
    BackTop
  },
  data(){
    return{
      isShowBackTop:false
    }
  },
  methods:{
    backClick(){
      // console.log("backClick");
      //跳到顶部500毫秒
      this.$refs.scroll.scrollTo(0,0,500)
    }
  }
}
