# 项目介绍

本项目是入门Vue时，在B站看到的教学视频，根据教程一步步搭建完成，目前已达老师进度。

为了以后更好的拓展，根据老师的数据，爬取到数据库，搭建了自己的后端，数据库文件在resource里面。

后端的同学可以看一看。

# 前端展示

## 功能清单

主页展示：

<img src="D:%5CTyporaTempImages%5Cimage-20210523182248854.png" alt="image-20210523182248854" style="zoom:50%;" />

点击下方的商品可以进入详情页：

<img src="D:%5CTyporaTempImages%5Cimage-20210523182407489.png" alt="image-20210523182407489" style="zoom:50%;" />

加入购物车：

<img src="D:%5CTyporaTempImages%5Cimage-20210523182516466.png" alt="image-20210523182516466" style="zoom:50%;" />

# 后端接口文档

## home

### 主页轮播图

```txt
http://localhost:8080/home/getSwiperImage
```

```json
[
	 {
		"id": 1,
		"title": "焕新女装节",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180926_45fkj8ifdj4l824l42dgf9hd0h495_750x390.jpg"
	},
	{
		"id": 2,
		"title": "入秋穿搭指南",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180926_31eb9h75jc217k7iej24i2dd0jba3_750x390.jpg"
	},
	{
		"id": 3,
		"title": "秋季护肤大作战",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180919_3f62ijgkj656k2lj03dh0di4iflea_750x390.jpg"
	},
	{
		"id": 4,
		"title": "流行抢先一步",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180917_18l981g6clk33fbl3833ja357aaa0_750x390.jpg"
	}
]
```

### 主页推荐图

```txt
http://localhost:8080/home/getRecommendImage
```

```json
[
	{
		"id": 1,
		"title": "十点抢券",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180913_036dli57aah85cb82l1jj722g887g_225x225.png"
	},
	{
		"id": 2,
		"title": "好物特卖",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180913_25e804lk773hdk695c60cai492111_225x225.png"
	},
	{
		"id": 3,
		"title": "内购福利",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180913_387kgl3j21ff29lh04181iek48a6h_225x225.png"
	},
	{
		"id": 4,
		"title": "初秋上新",
		"image": "https://s10.mogucdn.com/mlcdn/c45406/180913_8d4e5adi8llg7c47lgh2291akiec7_225x225.png"
	}
]
```

### 商品列表（pop,new,sell）page

```txt
http://localhost:8080/home/goods?type=new&page=2
```

```json
[
        {
        "iid": "1m8ky96",
        "title": "【两件79元】半高领打底衫女2018新款秋冬白色加绒加厚紧身长袖t恤韩版ins超火的上衣",
        "image": "http://s11.mogucdn.com/mlcdn/c45406/180915_6d523b1i35c6873a212396j3c1652_800x800.jpg_320x999.jpg",
        "price": "49.00",
        "nfc": "85"
    },
    {
        "iid": "1m8vlly",
        "title": "2018秋新款飞鹰烫金印花字母纯棉潮牌情侣小脚裤男女同款",
        "image": "http://s11.mogucdn.com/mlcdn/c45406/180922_05jafg8g5k7flkj35icg400b0l4k7_800x1200.jpg_320x999.jpg",
        "price": "158.00",
        "nfc": "13"
    }
]
```

## 商品详情页

### 商品细节（iid）

```txt
http://localhost:8080/good/getGoodDetail?iid=1m70y5k
```

```json
{
    "iid": "1m70y5k",
    "title": "2018秋季新款韩版百搭格子长袖衬衫+前短后长针织气质开衫外套+高腰直筒九分牛仔裤三件套装",
    "desc": "2018秋季新款韩版百搭格子长袖衬衫+前短后长针织气质开衫外套+高腰直筒九分牛仔裤三件套装",
    "oldPrice": "¥84.29",
    "price": "¥59.00~¥178.00",
    "discountDesc": "7折",
    "sales": "销量 5013",
    "collections": "收藏49人",
    "deliveryMethod": "默认快递",
    "shopId": "1cp5kk"
}
```

### 商品详情页轮播图

```txt
http://localhost:8080/good/getSwiperImage?iid=1m70y5k
```

```json
[
    {
        "id": 491,
        "iid": "1m70y5k",
        "image": "//s11.mogucdn.com/mlcdn/c45406/180808_600abce0g8dc8i4f6ic7k27i7837l_640x960.jpg"
    },
    {
        "id": 492,
        "iid": "1m70y5k",
        "image": "//s11.mogucdn.com/mlcdn/c45406/180808_41gdji7a4d3cigcf71li711kg3d5c_750x1000.jpg"
    },
    {
        "id": 493,
        "iid": "1m70y5k",
        "image": "//s11.mogucdn.com/mlcdn/c45406/180808_6jc08lbjjg61gecif7c04292b57ah_750x1000.jpg"
    }
]
```

### 商品详情页卖家秀

```txt
http://localhost:8080/good/getSellerShowImage?iid=1m70y5k
```

```json
[
    {
        "id": 2583,
        "iid": "1m70y5k",
        "image": "//s3.mogucdn.com/mlcdn/c45406/180808_0ef92c2hkg8e57lkj8098ek8ikj32_750x1024.jpg"
    },
    {
        "id": 2584,
        "iid": "1m70y5k",
        "image": "//s11.mogucdn.com/mlcdn/c45406/180808_0eh1f9gfgkalgjg488b7efda457bh_750x1024.jpg"
    },
    {
        "id": 2585,
        "iid": "1m70y5k",
        "image": "//s5.mogucdn.com/mlcdn/c45406/180808_3li3e7j0b329i3279ce06h4af322f_750x1024.jpg"
    }
]
```

### 商铺信息

```txt
http://localhost:8080/good/getShopInfo?iid=1m70y5k
```

```json
{
    "shopId": "1cp5kk",
    "name": "艾芳女装屋",
    "shopLogo": "//s3.mogucdn.com/mlcdn/c45406/180616_08024j2g76l4552k5550fi73k5f3f_200x200.jpg",
    "shopUrl": "http://m.meilishuo.com/shop/index/1cp5kk",
    "descConsistentScore": "4.66",
    "priceReasonableScore": "5",
    "qualitySatisfiedScore": "4.65",
    "cfans": "98577",
    "cgoods": "339",
    "csells": "384791"
}	
```

### 产品参数

```txt
http://localhost:8080/good/getProductInfo?iid=1m70y5k
```

```json
{
    "styleForm": "衣裤套装",
    "productId": "1m70y5k",
    "color": "三件套,衬衣+开衫,衬衣,开衫,裤子",
    "pattern": "条纹",
    "factoryName": "广州风彩贸易有限公司",
    "factoryAddress": "广州市天河区沙太南路银利茶叶城E栋1042",
    "collarType": "其他领型",
    "pantsLength": "九分裤",
    "material": "其他",
    "size": "S,L,M",
    "season": "秋季",
    "style": "简约",
    "sleeveLength": "长袖",
    "thickAndThin": "普通",
    "clothingLength": "常规款（51-65cm）"
}
```

### 商品详情页推荐数据

```txt
http://localhost:8080/good/getRecommend
```

### 评论信息

```txt
http://localhost:8080/good/getComments?iid=1m70y5k
```

```json
[
    {
        "commentId": "11625csq",
        "uname": "静萱Gill",
        "avatar": "//s3.mogucdn.com/p2/161214/103488673_65bf62g5e98f4g9b8dk1j5le13e34_140x140.png",
        "created": "1535697272",
        "style": "颜色:衬衣 尺码:M ",
        "content": "衣服收到了，质量很好没有色差做工精细，款式时尚大方穿在身上大小合适价格实惠",
        "goodId": "1m70y5k"
    }
]
```

