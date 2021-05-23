import {request} from './request'

export function getSwiperImage() {
  return request({
    url: '/home/getSwiperImage'
  })
}
export function getRecommendImage() {
  return request({
    url: '/home/getRecommendImage'
  })
}
export function getHomeGoods(type, page) {
  return request({
    url: '/home/goods',
    params: {
      type,
      page
    }
  })
}
