package com.example.learn.service.pay.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.example.learn.config.RuoYiConfig;
import com.example.learn.entity.R;
import com.example.learn.service.pay.AliPayService;
import com.example.learn.utils.json.AliJsonUtils;
import com.example.learn.utils.pay.alipay.AliPayUtil;
import com.example.learn.utils.qrcode.QRCodeUtil;
import com.example.learn.utils.string.StringUtil;


/**
 * 支付
 * @author Administrator
 *
 */
@Service
public class AliPayServiceImpl implements AliPayService {

	
	/**
	 * alipay.trade.wap.pay：H5手机网站支付接口2.0（外部商户创建订单并支付），注意：total_amount单位是元
	 */
	@Override
	public R alipayTradeWapPay(Map<String, Object> map) {
		//===================这里你可以保存你的订单和支付宝订单信息（商户号和订单金额需要保存，支付宝异步回调时需要根据商户号处理业务逻辑）======================
		//（1）封装统一支付接口并调用
		String out_trade_no = StringUtil.getDateTimeAndRandomForID();//生成商户订单号
		String total_amount = "0.01";//交易金额
		String pay_result = AliPayUtil.alipayTradeWapPay(out_trade_no, total_amount);
		if(StringUtils.isNoneEmpty(pay_result)) {
			return R.ok("code_999999", "操作成功", pay_result);
		}else {
			return R.error("支付宝调取异常");
		}
	}
	
	
	/**
	 * alipay.trade.page.pay：统一收单下单并支付页面接口（PC场景下单并支付），注意：total_amount单位是元
	 */
	@Override
	public R alipayTradePagePay(Map<String, Object> map) {
		//===================这里你可以保存你的订单和支付宝订单信息（商户号和订单金额需要保存，支付宝异步回调时需要根据商户号处理业务逻辑）======================
		//（1）封装统一支付接口并调用
		String out_trade_no = StringUtil.getDateTimeAndRandomForID();//生成商户订单号
		String total_amount = "0.01";//交易金额
		String pay_result = AliPayUtil.alipayTradePagePay(out_trade_no, total_amount);
		if(StringUtils.isNoneEmpty(pay_result)) {
			return R.ok("code_999999", "操作成功", pay_result);
		}else {
			return R.error("支付宝调取异常");
		}
	}

	
	/**
	 * alipay.trade.app.pay：原生手机APP支付测试（外部商户APP唤起快捷SDK创建订单并支付），注意：total_amount单位是元
	 */
	@Override
	public R alipayTradeAppPay(Map<String, Object> map) {
		//===================这里你可以保存你的订单和支付宝订单信息（商户号和订单金额需要保存，支付宝异步回调时需要根据商户号处理业务逻辑）======================
		//（1）封装统一支付接口并调用
		String out_trade_no = StringUtil.getDateTimeAndRandomForID();//生成商户订单号
		String total_amount = "0.01";//交易金额
		String pay_result = AliPayUtil.alipayTradeAppPay(out_trade_no, total_amount);
		if(StringUtils.isNoneEmpty(pay_result)) {
			return R.ok("code_999999", "操作成功", pay_result);
		}else {
			return R.error("支付宝调取异常");
		}
	}


	/**
	 * alipay.trade.precreate：统一收单线下交易预创建（扫码支付、收银员通过收银台或商户后台调用支付宝接口，生成二维码后，展示给用户，由用户扫描二维码完成订单支付。）
	 */
	@Override
	public R alipayTradePrecreate(Map<String, Object> map) {
		//===================这里你可以保存你的订单和支付宝订单信息（商户号和订单金额需要保存，支付宝异步回调时需要根据商户号处理业务逻辑）======================
		//（1）封装统一支付接口并调用
		String out_trade_no = StringUtil.getDateTimeAndRandomForID();//生成商户订单号
		String total_amount = "0.01";//交易金额
		String pay_result = AliPayUtil.alipayTradePrecreate(out_trade_no, total_amount);
		System.out.println(pay_result);
		if(StringUtils.isNoneEmpty(pay_result)) {
			Map<String, Object> aliRequestResultMap =  (Map<String, Object>) AliJsonUtils.jsonStringToMap1(pay_result).get("alipay_trade_precreate_response");
			if("10000".equals(StringUtil.getMapValue(aliRequestResultMap, "code"))) {
				//收款二维码字符串
				String qr_code_text = aliRequestResultMap.get("qr_code").toString();
				String qr_code_url = "";
				try {
					qr_code_url = QRCodeUtil.encode(qr_code_text,"",RuoYiConfig.getUploadPath(),true);
					return R.ok("code_999999", "操作成功", qr_code_url);
				} catch (Exception e) {
					e.printStackTrace();
					return R.error("收款二维码生成异常");
				}
			}else {
				return R.error(aliRequestResultMap.get("msg").toString());
			}
		}else {
			return R.error("支付宝调取异常");
		}
	}


	/**
	 * alipay.trade.pay：统一收单交易支付接口（条码支付、声波支付、收银员使用扫码设备读取用户手机支付宝“付款码”/声波获取设备（如麦克风）读取用户手机支付宝的声波信息后，将二维码或条码信息/声波信息通过本接口上送至支付宝发起支付。）
	 */
	@Override
	public R alipayTradePay(Map<String, Object> map) {
		//===================这里你可以保存你的订单和支付宝订单信息（商户号和订单金额需要保存，支付宝异步回调时需要根据商户号处理业务逻辑）======================
		//（1）封装统一支付接口并调用
		String auth_code = map.get("auth_code").toString();//授权码（条码数字）
		String out_trade_no = StringUtil.getDateTimeAndRandomForID();//生成商户订单号
		String total_amount = "0.01";//交易金额
		String pay_result = AliPayUtil.alipayTradePay(auth_code, out_trade_no, total_amount);
		if(StringUtils.isNoneEmpty(pay_result)) {
			return R.ok("code_999999", "操作成功", pay_result);
		}else {
			return R.error("支付宝调取异常");
		}
	}


	/**
	 * alipay.fund.trans.toaccount.transfer：单笔转账到支付宝账户接口
	 */
	@Override
	public R alipayFundTransToaccountTransfer(Map<String, Object> map) {
		//===================这里你可以保存你的订单和支付宝订单信息（商户号和订单金额需要保存，支付宝异步回调时需要根据商户号处理业务逻辑）======================
		//（1）封装统一支付接口并调用
		String out_biz_no = StringUtil.getDateTimeAndRandomForID();//生成订单号
		String total_amount = "0.01";//交易金额
		String payee_type = "ALIPAY_LOGONID";//固定值
		String payee_account = "abpkvd0206@sandbox.com";//转账收款账户
		String payer_show_name = "测试退款";
		String payer_real_name = "沙箱环境";
		if(AliPayUtil.alipayFundTransToaccountTransfer(out_biz_no, total_amount, payee_type, payee_account, payer_show_name, payer_real_name)) {
			return R.ok("code_999999", "操作成功");
		}else {
			return R.error("转账失败");
		}
	}


	/**
	 * alipay.fund.trans.order.query：单笔转账到支付宝账户接口
	 */
	@Override
	public R alipayFundTransOrderQuery(Map<String, Object> map) {
		//（1）封装统一支付接口并调用
		String out_biz_no = StringUtil.getMapValue(map, "out_biz_no");
		String order_id = StringUtil.getMapValue(map, "order_id");
		if(AliPayUtil.alipayFundTransOrderQuery(out_biz_no, order_id)) {
			return R.ok("code_999999", "转账成功");
		}else {
			return R.error("转账失败");
		}
	}
	
	
	
}
