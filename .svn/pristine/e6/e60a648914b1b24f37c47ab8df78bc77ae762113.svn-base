package com.example.learn.service.payreturn.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alipay.api.internal.util.AlipaySignature;
import com.example.learn.config.properties.AliPayProperties;
import com.example.learn.entity.R;
import com.example.learn.service.async.AsyncPayDealTaskService;
import com.example.learn.service.payreturn.AliPayReturnService;
import com.example.learn.utils.string.RequestMap;


/**
 * 支付宝回调
 * @author Administrator
 *
 */
@Service
public class AliPayReturnServiceImpl implements AliPayReturnService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AliPayReturnServiceImpl.class);
	
	@Autowired
	private AliPayProperties aliPayProperties;
	@Autowired
	private AsyncPayDealTaskService asyncPayDealTaskService;
	
	
	/**
	 * 支付宝同步支付回调结果处理
	 */
	@Override
	public R aliPaySynchronizationResult(HttpServletRequest request) {
		Map<String,String> params = new HashMap<>();
	    try {
	    	params = RequestMap.getParameterMap(request);
	    	LOGGER.info("支付宝的返回参数信息" + params.toString());
	    	if (!AlipaySignature.rsaCheckV1(params, aliPayProperties.getAli_alipay_public_key(), aliPayProperties.getAli_charset(), aliPayProperties.getAli_sign_type())) {
				LOGGER.info("****************************************验签失败*******************************************");
				return R.error("code_999277", "验签失败");
			}
		    return R.ok("code_999999", "操作成功");
	    } catch (Exception e) {
	    	e.printStackTrace();
			LOGGER.error("AliPayReturnServiceImpl -- aliPaySynchronizationResultRecharge方法执行异常");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return R.error("code_999283", "支付宝同步通知处理异常");
		}
	}
	
	
	/**
	 * 支付宝异步支付回调结果处理
	 */
	@Override
	public R aliPayAsynchronousResult(HttpServletRequest request) {
		Map<String,String> params = new HashMap<>();
		try {
			params = RequestMap.getParameterMap(request);
			LOGGER.info("支付宝的返回参数信息" + params.toString());
			if (!AlipaySignature.rsaCheckV1(params, aliPayProperties.getAli_alipay_public_key(), aliPayProperties.getAli_charset(), aliPayProperties.getAli_sign_type())) {
				LOGGER.info("****************************************验签失败*******************************************");
				return R.error("code_999277", "验签失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("AliPayReturnServiceImpl -- aliPayAsynchronousResultRecharge方法执行异常");
			return R.error("code_999283", "支付宝异步通知处理异常");
		}
	    if(params!=null) {
	    	LOGGER.info("****************************************验签成功，处理支付结果*******************************************");
	    	asyncPayDealTaskService.dealAliPayAsynchronous(params, aliPayProperties.getAli_pid());
	    }
	    return R.ok("code_999999", "操作成功");
	}
	
}
