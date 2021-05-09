import {request} from './request'

export function getSwiperData() {
  return request({
    url: '/home/swiperdata'
  })
}

export function getCatitems() {
  return request({
    url: '/home/catitems'
  })
}

export function getFloorData() {
  return request({
    url:'/home/floordata'
  })
}
