package com.example.learn.controller.payreturn;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.learn.entity.R;
import com.example.learn.service.payreturn.AliPayReturnService;


/**
 * 支付宝回调
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/api/aliReturnPay")
public class AliPayReturnController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AliPayReturnController.class);

    @Autowired
    private AliPayReturnService aliPayReturnService;

    
    /**
     * 支付宝 页面跳转同步通知页面路径
     * @param response
     * @param returnPay
     * @param req
     * @param model
     * @return
     */
	@RequestMapping("/returnPaySynchronization")
    public String returnPaySynchronizationRecharge(HttpServletResponse response, HttpServletRequest request, Model model){
		LOGGER.info("****************************************余额充值：支付宝的同步回调函数被调用******************************");
	    R synchronizationResult= aliPayReturnService.aliPaySynchronizationResult(request);
	    System.out.println("处理结果======="+synchronizationResult.toString());
	    if(!Boolean.valueOf(synchronizationResult.get(R.SUCCESS_TAG).toString())) {
	    	model.addAttribute("error_msg", synchronizationResult.get("msg"));
	    	return "alipay/error";
		}else {
			return "alipay/success";
		}
    }
	
	
	/**
     * 支付宝回调-服务器异步通知页面路径
     * @param response
     * @param returnPay
     * @param req
     * @throws IOException
     */
    @RequestMapping(value = "/returnPayAsynchronous", method = RequestMethod.POST)
    public void returnPayAsynchronousRecharge(HttpServletResponse response, HttpServletRequest request)
            throws IOException {
        response.setContentType("type=text/html;charset=UTF-8");
        LOGGER.info("****************************************余额充值：支付宝的异步回调函数被调用******************************");
        R asynchronousResult= aliPayReturnService.aliPayAsynchronousResult(request);
        if(!Boolean.valueOf(asynchronousResult.get(R.SUCCESS_TAG).toString())) {
        	response.getWriter().write("success");
            response.getWriter().close();
		}else {
			response.getWriter().write("failure");
	        response.getWriter().close();
		}
    }

}
