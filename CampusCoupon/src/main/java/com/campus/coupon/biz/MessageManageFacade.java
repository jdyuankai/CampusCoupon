package com.campus.coupon.biz;

import com.campus.coupon.domain.CouponVo;

import java.util.List;

/**
 * Created by thinkpad on 2016/7/17.
 */
public interface MessageManageFacade {

    public List<CouponVo> findAllCoupons();

}
