import axios from 'axios'

export function request(config) {

  const instance = axios.create({
    baseURL:'https://api-hmugo-web.itheima.net/api/public/v1',
    timeout:5000
  })

  //请求拦截
  instance.interceptors.request.use(config=>{
    //请求之前来到这里，进行一些加工
    // console.log(config)
    // 1. 加一些请求的判断，加一些header

    // 2. 发送请求时，展示加载图标

    // 3. 某些请求要携带token,要是不符合让他跳转到指定地方，让他赶紧登录

    //处理完毕还要返回，不然请求失败
    return config
  },error => {
    //当请求都发送失败，才会来到这里
    // console.log(error)
  })

  //响应拦截
  instance.interceptors.response.use(result=>{
    //拦截到的响应
    // console.log(result)
    //拦截完毕你还要返回出去,那边就能接收到
    return result
    },error=>{
    //响应失败
    console.log(error)
  })
  return instance(config)
}
