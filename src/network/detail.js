import {request} from './request'

export function getSwiperImage(iid) {
  return request({
    url:'/good/getSwiperImage',
    params:{
      iid
    }
  })
}

export function getGoodDetail(iid) {
  return request({
    url:'/good/getGoodDetail',
    params:{
      iid
    }
  })
}
export function getShopInfo(iid) {
  return request({
    url:'/good/getShopInfo',
    params:{
      iid
    }
  })
}
export function getSellerShowImage(iid) {
  return request({
    url:'/good/getSellerShowImage',
    params:{
      iid
    }
  })
}
export function getProductInfo(iid) {
  return request({
    url:'/good/getProductInfo',
    params:{
      iid
    }
  })
}
export function getComments(iid) {
  return request({
    url:'/good/getComments',
    params:{
      iid
    }
  })
}

export function getRecommend() {
  return request({
    url: "/good/getRecommend",
    methods: "GET"
  });
}

// export class Goods {
//   constructor(goods) {
//     this.title = itemInfo.title;
//     this.desc = itemInfo.desc;
//     this.oldPrice = itemInfo.oldPrice;
//     this.lowNowPrice = itemInfo.lowNowPrice;
//     this.price = itemInfo.price;
//     this.discountBgColor = itemInfo.discountBgColor;
//     this.discountDesc = itemInfo.discountDesc;
//   }
// }
export class Shop {
  constructor(shopInfo) {
    this.logo = shopInfo.shopLogo; //字符串
    this.score = shopInfo.score; //数组
    //this.fans = shopInfo.cFans;
    this.goods = shopInfo.cGoods;
    this.sells = shopInfo.cSells;
    this.name = shopInfo.name;
  }
}
export class GoodsParam {
  constructor(info, rule) {
    this.image = info.images ? info.images[0] : "";
    this.infos = info.set;
    this.sizes = rule.tables;
  }
}
