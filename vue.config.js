module.exports= {
    configureWebpack:{
        resolve:{
            alias:{
                'assets':'@/assets',
                'components':'@/components',
                'network':'@/network',
                'store':'@/store',
                'views':'@/views'
            }
        }
    },
  devServer: {
    proxy: {
      '/': {
        //代理api
        target: 'http://47.106.10.136:8888', // 代理接口(注意只要域名就够了)
        changeOrigin: true, //是否跨域
        ws: true, // proxy websockets
      }
    }
  }
}
