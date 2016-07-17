package com.campus.coupon.biz.impl;

import com.campus.coupon.biz.MessageManageFacade;
import com.campus.coupon.domain.CouponVo;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2016/7/17.
 */
@Component("messageManageFacade")
public class MessageManageFacadeImpl implements MessageManageFacade {

    private org.slf4j.Logger l = LoggerFactory.getLogger(MessageManageFacadeImpl.class);


    private List<CouponVo> couponVoList;

    @PostConstruct
    public void init(){
        //查询一个初始值，每隔10s扫一次数据库
        System.out.println("初始化线程操作类。");
        couponVoList = new ArrayList<CouponVo>();

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(new UpdateCoupon(couponVoList),0l,10l, TimeUnit.SECONDS);

    }

    public List<CouponVo> findAllCoupons() {
        return couponVoList;
    }

    class UpdateCoupon implements Runnable{
        private List<CouponVo> couponVoList;

        public UpdateCoupon(List<CouponVo> list){
            this.couponVoList = list;
        }

        public void run() {
            CouponVo c = new CouponVo();
            c.setLink("https://www.baidu.com/t="+System.currentTimeMillis());
            c.setName("毕业大彩蛋");
            c.setType("NoCoupon");
            couponVoList.add(c);
            System.out.println("增加列表长度。size:"+couponVoList.size());
        }
    }
}
