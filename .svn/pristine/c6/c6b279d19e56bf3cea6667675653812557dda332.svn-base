package com.example.learn.service.pay;

import java.util.Map;

import com.example.learn.entity.R;

public interface AliPayService {

	
	/**
	 * alipay.trade.wap.pay：H5手机网站支付接口2.0（外部商户创建订单并支付）
	 * @param map
	 * @return
	 */
	R alipayTradeWapPay(Map<String, Object> map);

	
	/**
	 * alipay.trade.page.pay：统一收单下单并支付页面接口（PC场景下单并支付）
	 * @param map
	 * @return
	 */
	R alipayTradePagePay(Map<String, Object> map);
	
	
	/**
	 * alipay.trade.app.pay：原生手机APP支付测试（外部商户APP唤起快捷SDK创建订单并支付）
	 * @param map
	 * @return
	 */
	R alipayTradeAppPay(Map<String, Object> map);


	/**
	 * alipay.trade.precreate：统一收单线下交易预创建（扫码支付、收银员通过收银台或商户后台调用支付宝接口，生成二维码后，展示给用户，由用户扫描二维码完成订单支付。）
	 * @param map
	 * @return
	 */
	R alipayTradePrecreate(Map<String, Object> map);

	
	/**
	 * alipay.trade.pay：统一收单交易支付接口（条码支付、声波支付、收银员使用扫码设备读取用户手机支付宝“付款码”/声波获取设备（如麦克风）读取用户手机支付宝的声波信息后，将二维码或条码信息/声波信息通过本接口上送至支付宝发起支付。）
	 * @param map
	 * @return
	 */
	R alipayTradePay(Map<String, Object> map);


	/**
	 * alipay.fund.trans.toaccount.transfer：单笔转账到支付宝账户接口
	 * @param map
	 * @return
	 */
	R alipayFundTransToaccountTransfer(Map<String, Object> map);


	/**
	 * alipay.fund.trans.order.query：单笔转账到支付宝账户接口
	 * @param map
	 * @return
	 */
	R alipayFundTransOrderQuery(Map<String, Object> map);


	

}
