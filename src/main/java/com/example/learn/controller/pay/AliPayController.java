package com.example.learn.controller.pay;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.learn.entity.R;
import com.example.learn.service.pay.AliPayService;

@Controller
@RequestMapping("/alipay")
public class AliPayController {
	
	@Autowired
	private AliPayService aliPayService;

	
	/**
	 * alipay.trade.wap.pay：H5手机网站支付接口2.0（外部商户创建订单并支付）
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayTradeWapPay")
	@ResponseBody
	public R alipayTradeWapPay(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayTradeWapPay(map);
	}
	
	
	/**
	 * alipay.trade.page.pay：统一收单下单并支付页面接口（PC场景下单并支付）
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayTradePagePay")
	@ResponseBody
	public R alipayTradePagePay(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayTradePagePay(map);
	}
	
	
	/**
	 * alipay.trade.app.pay：原生手机APP支付测试（外部商户APP唤起快捷SDK创建订单并支付）
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayTradeAppPay")
	@ResponseBody
	public R alipayTradeAppPay(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayTradeAppPay(map);
	}
	
	
	/**
	 * alipay.trade.precreate：统一收单线下交易预创建（扫码支付、收银员通过收银台或商户后台调用支付宝接口，生成二维码后，展示给用户，由用户扫描二维码完成订单支付。）
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayTradePrecreate")
	@ResponseBody
	public R alipayTradePrecreate(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayTradePrecreate(map);
	}
	
	
	/**
	 * alipay.trade.pay：统一收单交易支付接口（条码支付、声波支付、收银员使用扫码设备读取用户手机支付宝“付款码”/声波获取设备（如麦克风）读取用户手机支付宝的声波信息后，将二维码或条码信息/声波信息通过本接口上送至支付宝发起支付。）
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayTradePay")
	@ResponseBody
	public R alipayTradePay(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayTradePay(map);
	}
	
	
	/**
	 * alipay.fund.trans.toaccount.transfer：单笔转账到支付宝账户接口
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayFundTransToaccountTransfer")
	@ResponseBody
	public R alipayFundTransToaccountTransfer(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayFundTransToaccountTransfer(map);
	}
	
	
	/**
	 * alipay.fund.trans.order.query：单笔转账到支付宝账户接口
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/alipayFundTransOrderQuery")
	@ResponseBody
	public R alipayFundTransOrderQuery(@RequestParam Map<String, Object> map) {
		return aliPayService.alipayFundTransOrderQuery(map);
	}
	

	
	/**
	 * 支付宝中途退出跳转参数页面
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/aliPayQuitUrl")
	public String aliPayToOrderList(@RequestParam Map<String, String> map, Model model) {
		return "alipay/quit";
	}
	/**
	 * 跳转到扫码支付页面
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/toQrcode")
	public String toQrcode(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("map", map);
		return "alipay/qrcode";
	}

}
