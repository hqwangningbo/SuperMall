package com.wangningbo;

import com.wangningbo.dao.*;
import com.wangningbo.pojo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wangningbo
 * @Date 2021/5/21 10:28
 */

class ReadyData {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private GoodDao goodDao;
    @Autowired
    private GoodDetailDao goodDetailDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private ShopInfoDao shopInfoDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    void findByIid() {
        GoodDetail byIid = goodDetailDao.findByIid("1m7c6iu");
        System.out.println(byIid);
    }

    @Test
    void findByShopId() {
        ShopInfo byShopId = shopInfoDao.findByShopId("1172ua9c");
        System.out.println(byShopId);
    }

    @Test
    void updateGoodDetail() {
        GoodDetail goodDetail = new GoodDetail();
        goodDetail.setIid("1m901la");
        goodDetail.setDesc("99");
        goodDetailDao.updateGoodDetail(goodDetail);
    }


    @Test
    void getGoodData() {
        Good good = new Good();
        Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/home/data?type=pop&page=17", Map.class);
        Map data = (Map) map.get("data");
        List<Map> mapList = (List<Map>) data.get("list");
        for (Map m : mapList) {
            good.setIid((String) m.get("iid"));
            good.setTitle((String) m.get("title"));
            good.setPrice((String) m.get("price"));
            if (m.get("cfav") instanceof String) {
                good.setNfc((String) m.get("cfav"));
            } else {
                good.setNfc(m.get("cfav").toString());
            }
            Map show = (Map) m.get("show");
            good.setImage((String) show.get("img"));
//            goodDao.insertGood(good);
        }
    }

    @Test
    void getTopImage() {
        Good g = new Good();
        Map<String, Integer> selectMap = new HashMap<>();
        selectMap.put("startIndex", 199);
        selectMap.put("pageSize", 2);
        List<Good> popByPage = goodDao.findSellByPage(selectMap);
        for (Good good : popByPage) {
            Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + good.getIid(), Map.class);
            Map result = (Map) map.get("result");
            Map itemInfo = (Map) result.get("itemInfo");
//            System.out.println(itemInfo);
            List<String> topImages = (List) itemInfo.get("topImages");
            String iid = (String) itemInfo.get("iid");
            g.setIid(iid);
            for (String topImage : topImages) {
                g.setImage(topImage);
//                goodDao.insertGood(g);
//                System.out.println(g);
            }
        }

    }

    @Test
    void getGoodDetail() {
        GoodDetail goodDetail = new GoodDetail();
        Map<String, Integer> selectMap = new HashMap<>();
        selectMap.put("startIndex", 0);
        selectMap.put("pageSize", 201);
        List<Good> popByPage = goodDao.findSellByPage(selectMap);
        for (Good good : popByPage) {
            if (goodDetailDao.findByIid(good.getIid()) == null) {
                Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + good.getIid(), Map.class);
                Map result = (Map) map.get("result");
                Map itemInfo = (Map) result.get("itemInfo");
                String iid = (String) itemInfo.get("iid");
                String desc = (String) itemInfo.get("desc");
                String oldPrice = (String) itemInfo.get("oldPrice");
                String price = (String) itemInfo.get("price");
                String discountDesc = (String) itemInfo.get("discountDesc");
                goodDetail.setIid(iid);
                goodDetail.setDesc(desc);
                goodDetail.setOldPrice(oldPrice);
                goodDetail.setPrice(price);
                goodDetail.setDiscountDesc(discountDesc);
                List<String> columns = (List) result.get("columns");
                if (columns.size() == 3) {
                    goodDetail.setSales(columns.get(0));
                    goodDetail.setCollections(columns.get(1));
                    goodDetail.setDeliveryMethod(columns.get(2));
                } else if (columns.size() == 2) {
                    goodDetail.setSales(columns.get(0));
                    goodDetail.setCollections(columns.get(1));
                }
//                goodDetailDao.insertGoodDetail(goodDetail);
            }
        }
    }

    @Test
    void addShopIdForGoodDetail() {
        GoodDetail goodDetail1 = new GoodDetail();
        for (GoodDetail goodDetail : goodDetailDao.findAll()) {
            Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + goodDetail.getIid(), Map.class);
            Map result = (Map) map.get("result");
            Map itemInfo = (Map) result.get("itemInfo");
            String title = (String) itemInfo.get("title");
            goodDetail.setIid(goodDetail.getIid());
            goodDetail.setTitle(title);
//            goodDetailDao.updateGoodDetail(goodDetail);
        }
    }

//    @Test
//    void insertShopImage() {
//        Banner banner = new Banner();
//        for (GoodDetail goodDetail : goodDetailDao.findAll()) {
//            Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + goodDetail.getIid(), Map.class);
//            Map result = (Map) map.get("result");
//            Map detailInfo = (Map) result.get("detailInfo");
//            List<Map> detailImage = (List<Map>) detailInfo.get("detailImage");
//            banner.setIid(goodDetail.getIid());
//            List<String> list = (List<String>) detailImage.get(0).get("list");
//            for (String image : list) {
//                banner.setImage(image);
////                bannerDao.insertBanner(banner);
////                System.out.println(banner);
//            }
//        }
//    }

    @Test
    void insertShopInfo() {
        ShopInfo shop = new ShopInfo();
        for (GoodDetail goodDetail : goodDetailDao.findAll()) {
            Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + goodDetail.getIid(), Map.class);
            Map result = (Map) map.get("result");
            Map shopInfo = (Map) result.get("shopInfo");
            String shopId = (String) shopInfo.get("shopId");
            if (shopInfoDao.findByShopId(shopId) == null) {
                String name = (String) shopInfo.get("name");
                String shopLogo = (String) shopInfo.get("shopLogo");
                String shopUrl = (String) shopInfo.get("shopUrl");
                String cSells = shopInfo.get("cSells").toString();
                String cFans = shopInfo.get("cFans").toString();
                String cGoods = shopInfo.get("cGoods").toString();
                List<Map> score = (List<Map>) shopInfo.get("score");
                String descConsistentScore = score.get(0).get("score").toString();
                String priceReasonableScore = score.get(1).get("score").toString();
                String qualitySatisfiedScore = score.get(2).get("score").toString();
                shop.setShopId(shopId);
                shop.setName(name);
                shop.setShopLogo(shopLogo);
                shop.setShopUrl(shopUrl);
                shop.setCSells(cSells);
                shop.setCFans(cFans);
                shop.setCGoods(cGoods);
                shop.setDescConsistentScore(descConsistentScore);
                shop.setPriceReasonableScore(priceReasonableScore);
                shop.setQualitySatisfiedScore(qualitySatisfiedScore);
//                shopInfoDao.insertShopInfo(shop);
            }
        }
    }

    @Test
    void insertComment() {
        Comment comment = new Comment();
        for (GoodDetail goodDetail : goodDetailDao.findAll()) {
            Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + goodDetail.getIid(), Map.class);
            Map result = (Map) map.get("result");
            Map rates = (Map) result.get("rate");
            List<Map> list = (List<Map>) rates.get("list");
            if (list != null) {
                for (Map rate : list) {
                    String rateId = (String) rate.get("rateId");
                    String content = (String) rate.get("content");
                    String created = rate.get("created").toString();
                    String style = (String) rate.get("style");
                    Map user = (Map) rate.get("user");
                    String uname = (String) user.get("uname");
                    String avatar = (String) user.get("avatar");
                    comment.setCommentId(rateId);
                    comment.setContent(content);
                    comment.setCreated(created);
                    comment.setStyle(style);
                    comment.setUname(uname);
                    comment.setAvatar(avatar);
                    comment.setGoodId(goodDetail.getIid());
                    try {
//                        commentDao.insertComment(comment);
                    } catch (Exception e) {
                        continue;
                    }
                }
            }

        }
    }

    @Test
    void insertProductInfo(){
        ProductInfo productInfo = new ProductInfo();
        for (GoodDetail goodDetail : goodDetailDao.findAll()) {
            Map map = restTemplate.getForObject("http://152.136.185.210:7878/api/m5/detail?iid=" + goodDetail.getIid(), Map.class);
            Map result = (Map) map.get("result");
            Map rates = (Map) result.get("itemParams");
            Map info = (Map) rates.get("info");
            List<Map> sets = (List<Map>) info.get("set");
            for (Map set : sets) {
//                System.out.println((String) set.get("key"));
                switch ((String)set.get("key")){
                    case "图案" :
                        productInfo.setPattern((String) set.get("value"));
                        break;
                    case "厚薄" :
                        productInfo.setThickAndThin((String) set.get("value"));
                        break;
                    case "厂名" :
                        productInfo.setFactoryName((String) set.get("value"));
                        break;
                    case "厂址" :
                        productInfo.setFactoryAddress((String) set.get("value"));
                        break;
                    case "颜色" :
                        productInfo.setColor((String) set.get("value"));
                        break;
                    case "季节" :
                        productInfo.setSeason((String) set.get("value"));
                        break;
                    case "材质" :
                        productInfo.setMaterial((String) set.get("value"));
                        break;
                    case "领型" :
                        productInfo.setCollarType((String) set.get("value"));
                        break;
                    case "库型" :
                        productInfo.setPantsType((String) set.get("value"));
                        break;
                    case "袖长" :
                        String sleeveLength = (String) set.get("value");
                        productInfo.setSleeveLength(sleeveLength);
                        break;
                    case "衣长" :
                        String clothingLength = (String) set.get("value");
                        productInfo.setClothingLength(clothingLength);
                        break;
                    case "裤长" :
                        String pantsLength = (String) set.get("value");
                        productInfo.setPantsLength(pantsLength);
                        break;
                    case "风格" :
                        String style = (String) set.get("value");
                        productInfo.setStyle(style);
                        break;
                    case "款式" :
                        String styleForm = (String) set.get("value");
                        productInfo.setStyleForm(styleForm);
                        break;
                    case "尺码" :
                        String size = (String) set.get("value");
                        productInfo.setSize(size);
                        break;
                }

            }
            productInfo.setProductId(goodDetail.getIid());
//            productInfoDao.insertProductInfo(productInfo);
        }
    }
}
