package com.atguigu.common.to;

import lombok.Data;
import org.w3c.dom.Attr;

import java.math.BigDecimal;
import java.util.List;

@Data
public class SkuEsModel {
    private Long skuId;
    private Long spuId;
    private String skuTitle;
    private BigDecimal skuPrice ;
    private String skuImg ;
    private Long saleCount ; // 产品的销量
    private boolean hasStock ; //产品的库存
    private Long hotScore ;  // 热度评分
    private Long brandId;  // 品牌Id
    private  Long catalogId ; // 分类的名字
    private List<Attr> attrs ;

    @Data
    public static class Attr
    {
        private Long attrId ;
        private String attrName;

    }


}