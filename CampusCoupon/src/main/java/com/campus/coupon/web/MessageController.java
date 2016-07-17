package com.campus.coupon.web;

import com.campus.coupon.biz.MessageManageFacade;
import com.campus.coupon.domain.CouponVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by thinkpad on 2016/7/17.
 */
@Controller
@RequestMapping(value = "message")
public class MessageController {

    private Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageManageFacade messageManageFacade;

    public String addCoupon(){
        logger.info("通过指定用户微信添加优惠券");


        return "success";
    }

    @ResponseBody
    @RequestMapping("findCoupons")
    public String findCoupons(){
        System.out.println("开始请求优惠券列表。");
        List<CouponVo> couponVos = messageManageFacade.findAllCoupons();
        System.out.println("========couponList:{}"+couponVos.size());
        //返回优惠券列表
        return "success";
    }

}
