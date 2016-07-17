package com.campus.coupon.domain;

/**
 * Created by thinkpad on 2016/7/17.
 */
public class CouponVo {
    //查询优惠券要能返回优惠券的链接、类型（有券/券）
    private String link;
    private String name;
    private String type;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
