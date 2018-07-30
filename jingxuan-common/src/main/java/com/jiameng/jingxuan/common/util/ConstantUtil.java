package com.jiameng.jingxuan.common.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class ConstantUtil {
	public static final String DOMAIN = "www.yinkejinrong.com";
	public static final String WILDCARD_DOMAIN = "yinkejinrong.com";
	public static final String BACK_SLASH = "\\";
	public static final String ASTERISK = "*";
	public static final String SHARP = "#";
	public static final String PERCENT = "%";
	public static final String DOLLAR = "$";
	public static final String SLASH = "/";
	public static final String DOUBLE_SLASH = "//";
	public static final String DOT =".";
	public static final String COMMA =",";
	public static final String MINUS = "-";
	public static final String UNDERLINE = "_";
	public static final String VERTICAL_BAR = "|";
	public static final String BLANK = "";
	public static final String SEMICOLON = ";";
	public static final String COLON = ":";
	public static final String EQUAL = "=";
	public static final String AND = "&";
	public static final String BR = "<br/>";
	public static final String EMPTY = "";
	public static final String SIX = "6";
	public static final String EIGHT = "8";
	public static final String THIRTY = "30";
	public static final String DEFAULT_PASSWORD = "e10adc3949ba59abbe56e057f20f883e";
	public static final String DEFAULT_SYSTEM_FONT = "Serif";
	public static final String REGEX_HEIGHT="height";
	public static final String REGEX_WIDTH="width";
	public static final String ENTER="\r\n";
	public static final String NEWLINE="<br/>";
	
	public static final int PROFIT_BIT = 2;
	public static final int DEFAULT_CHANNEL_CODE = 0;
	public static final int WCHAT_CHANNEL_CODE = 1;
	public static final int ANDROID_MARKET_CHANNEL_CODE = 2;
	public static final int ONE = 1;
	public static final int ZERO = 0;
	public static final int REPAYMENT = 1;
	public static final int THIRTY_SECONDS = 30;
	public static final int SIXTY_SECONDS = 60;
	public static final int FIVE_MINUTE = 300;
	public static final int TWENTY_THREE = 23;
	public static final int TWENTY_FIVE = 25;
	public static final int FIFTY_NINE = 59;
	public static final int ONE_THOUSAND = 1000;
	public static final String NINE_TIME = " 09:00:00";
	public static final String MAX_TIME = " 23:59:59";
	public static final String PAYBACK_DECIMAL_FORMAT = "##0.00";
	public static final String SINGLE_DAY_PROFIT_FORMAT = "##0.00000";
	public static final String YESTODAY_DECIMAL_FORMAT = "##0.000";
	public static final String DECIMAL_FORMAT = "#,##0.00";
	public static final String NUMBER_DATETIME_FORMAT = "yyyyMMddHHmmss";

	public static final String NORMAL_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String NORMAL_DATEMINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String NORMAL_DATEHOUR_FORMAT = "yyyy-MM-dd HH";
	public static final String NUMBER_DATE_FORMAT = "yyyyMMdd";
	public static final String NORMAL_DATE_FORMAT = "yyyy-MM-dd";
	public static final String SLASH_DATE_FORMAT = "yyyy/MM/dd";  
	public static final String NUMBER_MONTH_FORMAT = "yyyy-MM";
	public static final String NUMBER_DOUBLE_FORMAT = "############0.00";
	public static final String HOUR_FORMAT = "HH";
	public static final String CACHE_SMS_KEY = "cache:sms:key:";
	public static final String CACHE_SIGNIN_KEY = "cache:signin:key:";
	public static final String SMS_LIMIT_KEY = "cache:sms:24hour:key:";
	public static final String ORDER_NO_KEY = "cache:orderno:key:";
	public static final String FIRST_ORDER_KEY = "cache:first:order:key:";
	public static final String LAST_ORDER_KEY = "cache:last:order:key:";
	public static final String SHARE_COUPON_FLAG_KEY = "cache:share:coupon:flag:key:";
	public static final String PRODUCT_PROGRESS_KEY = "cache:product:progress:key:";
	public static final String PRODUCT_PROGRESS_LOCK_KEY = "cache:product:progress:lock:key:";
	public static final String PRODUCT_ORDER_LIST_KEY = "cache:order:list:key:";
	public static final String EXCHANGE_FEE_KEY = "cache:exchange:fee:key:";
	public static final String SAVE_ORDER_LOCK_KEY = "cache:save:order:lock:key:";
	public static final String REQUEST_BUY_KEY = "cache:request:buy:key";
	public static final String REQUEST_REPAY_KEY = "cache:request:repay:key";
	public static final String REQUEST_DEPOSIT_KEY = "cache:request:deposit:key";
	public static final String REQUEST_WITHDRAW_KEY = "cache:request:withdraw:key";
	public static final String REQUEST_ASYNC_WITHDRAW_FAIL_KEY = "cache:async:withdraw:fail:key";
	public static final String REQUEST_PUTIN_KEY = "cache:request:putin:key";
	public static final String REQUEST_PIGGYBANK_KEY = "cache:request:piggybank:key";
	public static final String REQUEST_TAKEOUT_KEY = "cache:request:takeout:key";
	public static final String ANDROID_DEVICE_KEY = "cache:and:dev:key:";
	public static final String ACTIVE_DEVICE_KEY = "cache:act:dev:key:";
	public static final String FUIOU_RESET_PWD_KEY = "cache:fuiou:reset:pwd:key:";
	public static final int ORDER_NO_TIMEOUT = 5;
	public static final int PASSWORD_MAX_ERROR_TIMES = 5;
	
	public static final int APP_PAGE_SIZE = 15;
	public static final int PAGE_SIZE = 10;
	public static final int WAP_PAGE_SIZE = 5;
	public static final String CUSTOMER = "customer";
	public static final String UNIONPAY = "unionPay";
	public static final String IMAGE_TYPE="image/jpeg";
	public static final String ISO8859 = "ISO-8859-1";
	public static final String UTF_8 = "utf-8";
	public static final String GBK = "gbk";
	public static final String RESULT = "result";
	public static final String CODE = "code";
	public static final String MSG = "msg";
	public static final String DATA = "data";
	public static final String KEY = "key";
	public static final String SIGN = "sign";
	public static final String SIGN_TYPE = "sign_type:signType";
	public static final String SMS_TEXT = "text";
	public static final String SMS_MOBILE = "mobile";
	public static final String RESOURCE_SERVER_NAME = "jiayuanbank-oauth2server";
	
	//for google authenticator
	public static final String PREFIX_AUTHORIZE = "/authorize/";
	public static final String PREFIX_AUTHENTICATION = "/authentication/";
	public static final String PREFIX_AUTHENTICATION_REFRESH = "/authentication/refresh/";
	public static final String PREFIX_USER_GAUTH_CREDENTIAL = "/gauth/credential/";
	public static final String USER_NAME = "name";
	public static final String SECRET_KEY = "secret";
	public static final String CREDENTIAL = "credential";
	public static final String VALIDATION_CODE = "validation";
	public static final String SCRATCH_CODES = "scratch";
	public static final String OTPAUTH = "otpauth";
	public static final String TOTP = "totp";
	public static final String ISSUER = "issuer";
	public static final String ALGORITHM = "algorithm";
	public static final String DIGITS = "digits";
	public static final String PERIOD = "period";
	public static final String REFERER = "referer";
	public static final String HOST ="host";
	public static final int APP_TOKEN_TTL =  259200;
	public static final int WEB_TOKEN_TTL =  1800;
	public static final int TOKEN_REFRESH_POINT = 129600;
	
	public static final String PUSH_ANDROID = "/push/android";
	public static final String PUSH_IOS = "/push/ios";
	public static final String PUSH_SINGLE = "/push/single";
	public static final String PUSH_BATCH = "/push/batch";
	public static final String PUSH_ALL = "/push/all";
	public static final String PUSH = "/jiguang/push";
	public static final String PUSH_CHANNEL_ID = "channel_id";
	public static final String PUSH_CHANNEL_IDS = "channel_ids";
	public static final String PUSH_MSG_TYPE = "msg_type";
	public static final String PUSH_MSG = "msg";
	public static final String PUSH_MSG_EXPIRES = "msg_expires";
	public static final String PUSH_DEPLOY_STATUS = "deploy_status";
	public static final String PUSH_SEND_TIME = "send_time";
	public static final String PUSH_TOPIC_ID = "topic_id";
	public static final String PUSH_DEVICE_TYPE = "device_type";
	public static final short PUSH_OS_TYPE_ANDROID = 1;
	public static final short PUSH_OS_TYPE_IOS = 2;
	public static final int PUSH_MESSAGE_TYPE = 1;
	public static final int PUSH_ANDROID_DEVICE = 3;
	public static final int PUSH_IOS_DEVICE = 4;
	public static final boolean PUSH_IOS_DEVELOP = true;
	public static final short PUSH_SEND_TARGET_ALL = 0; 
	public static final short PUSH_SEND_TARGET_SPECIFIED = 1; 
	public static final String PUSH_REGEX_CHANNEL_ID = ";";
	public static final String PUSH_MSG_TITLE = "title";
	public static final String PUSH_MSG_DESCRIPTION = "description";
	public static final String PUSH_MSG_OPEN_TYPE = "open_type";
	public static final String PUSH_MSG_PKG_CONTENT = "pkg_content";
	public static final String PUSH_MSG_CUSTOM_CONTENT = "custom_content";
	public static final String PUSH_MSG_CONTENT = "content";
	public static final String PUSH_MSG_SEND_TARGET = "sendTarget";
	public static final String PUSH_MSG_EQUIPMENTS = "equipments";
	public static final String PUSH_MSG_ALERT = "alert";
	public static final String PUSH_MSG_APS = "aps";
	public static final String PUSH_OS_TYPE = "osType";
	public static final String PUSH_MSG_SEND_TYPE = "sendType";
	public static final String PUSH_MSG_SEND_TIME = "sendTime";
	public static final String PUSH_MSG_ASSOCIATE_PRODUCT = "productId";
	public static final String PUSH_MSG_ASSOCIATE_NEWS = "newsId";
	public static final String STRTRUE = "true";
	public static final String STRFALSE = "false";
	public static final String EXCHANGE_ORDERID = "orderid";
	public static final String EXCHANGE_PHONENO = "phoneno";
	public static final String EXCHANGE_CARDNUM = "cardnum";
	
	public static final String USER_REBATE_ID = "userRebateId";
	public static final String CUMULATIVE = "cumulative";
	public static final String PAY_MONEY = "payMoney";
	public static final String CARD_NO = "cardNO";
	
	public static final String PROPERTY = "property";
	public static final String BANKNO = "bankNO";
//	public static final String RSAKEYLOCATION = "D://rsa/";
	public static final String RSAKEYLOCATION = "/usr/local/yinke/rsa";
	
	public static final String AES = "AES";
	public static final String RSA = "RSA";
	public static final String MD5 = "MD5";
	public static final String SHA1 = "SHA1";
	public static final String CBC_PADDING = "AES/CBC/PKCS5Padding";
	public static final String MD5_WITH_RSA = "MD5withRSA";
	public static final String BEARER = "Bearer";
	public static final String PAY_SUCCESS = "0000";
	public static final String PAY_IGNORE = "8901";
	
	public static final String MARKETING = "marketing";
	//public static final String FORMAT_UTF8 = "utf-8";
	public static final int[] INVESTMENT_AMOUNT = {300, 500, 700, 1000, 5000, 10000, 20000, 50000, 100000, 150000};
	public static final int FINANCE_PERIOD = 60;
	public static final int[] COUPON_AMOUNT = {1, 5, 10, 30, 55, 80, 90, 93, 96, 98, 100};
	
	public static final String[] TIME_POINT = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
	public static final String TIME_POINT_KEY = "timePoint";
	public static final String VALUE_KEY = "value";
	
	// added by wanghui 2017.3.7 for preDeposit
	public static final String FUNDINFO_SIGN_KEY = "21804102_tset345100000170804102";
	
	public static final ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors()*2, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});
}