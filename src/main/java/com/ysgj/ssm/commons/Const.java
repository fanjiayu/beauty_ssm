//package com.ysgj.ssm.commons;
//
//
///**
// * Created by yanglian on 2016/2/18.
// */
//public class Const {
//
//
//    public static final String USER_SEARCH_MODEL = "zb_user_V1";//搜索数据
//    public static final String SEARCH_DATA;//搜索数据
//    public static final String SEARCH_INDEX;//新建索引
//    public static final String SEARCH_UPDATE;//更新数据
//    public static final String SEARCH_DELETE;//删除搜索数据
//
//    public static final String TFS_UPLOAD_URL;//图片服务器地址
//    public static final String DEFAULT_AVATAR;//默认头像地址
//    public static final String DEFAULT_AVATAR0;//默认头像地址
//    public static final String DEFAULT_AVATAR1;//默认头像地址
//    public static final String DEFAULT_AVATAR2;//默认头像地址
//    public static final String DEFAULT_AVATAR3;//默认头像地址
//
//    public static final String LEJU_IDENTIFY_SOURCE;//调用乐居认证source参数
//    public static final String LEJU_IDENTIFY_KEY;//调用乐居认证privateKey参数
//
//    public static final String WEIBO_CALLBACK_URL;//H5提现授权登录使用
//    public static final String H5_REDIRECT_URL;//H5授权成功重定向地址
//    public static final String EX_H5_REDIRECT_URL;//异常情况H5重定向地址
//    public static final String NEVER_LOGIN_REDIRECT_URL;//兼容老帐号无法刷回unionId情况,提示用户使用微信帐号登录首播平台再公众号授权提现
//
//    public static final String PUSH_GW_URL;//冻结帐号向网关推消息
//
//    static {
//        EnvUtil.Env env = EnvUtil.getEnv();
//        switch (env) {
//            case prod:
//                SEARCH_DATA = "http://search.intra.hiwemeet.com/search/data";
//                SEARCH_INDEX = "http://search.intra.hiwemeet.com/search/index";
//                SEARCH_UPDATE = "http://search.intra.hiwemeet.com/search/update";
//                SEARCH_DELETE = "http://search.intra.hiwemeet.com/search/delete";
//                TFS_UPLOAD_URL = "http://img.intra.51zb.cn/weiphoto/upload_pic";
//                DEFAULT_AVATAR = "150-150-33df7eb0aa857b1d88846356336bb4ad";
//                DEFAULT_AVATAR0 = "240-240-afed9e774a3bcc66d7917186b42783c9";
//                DEFAULT_AVATAR1 = "240-240-bb12cc0aae979ea290988ab100408a32";
//                DEFAULT_AVATAR2 = "240-240-177141a02233677fdf4679a7d230f8b5";
//                DEFAULT_AVATAR3 = "240-240-1961bb741bb643893fcf8069402cd02e";
//                LEJU_IDENTIFY_SOURCE = "ugc";
//                LEJU_IDENTIFY_KEY = "ae762aec4c35c95e55ef8a25dd87c72e";
//                WEIBO_CALLBACK_URL = "http://api.51zb.cn/v2/user/weiboCallBack";
//                H5_REDIRECT_URL = "http://h5.51zb.cn/withdraw.html";
//                EX_H5_REDIRECT_URL = "http://h5.51zb.cn/withdraw_enter.html";
//                NEVER_LOGIN_REDIRECT_URL = "http://h5.51zb.cn/noaccount.html";
//                PUSH_GW_URL = "http://gw.51zb.cn/forceLogout";
//                break;
//            case test:
//                SEARCH_DATA = "http://search.intra.hiwemeet.com/search/data";
//                SEARCH_INDEX = "http://search.intra.hiwemeet.com/search/index";
//                SEARCH_UPDATE = "http://search.intra.hiwemeet.com/search/update";
//                SEARCH_DELETE = "http://search.intra.hiwemeet.com/search/delete";
//                TFS_UPLOAD_URL = "http://10.0.8.31:2080/weiphoto/upload_pic";
//                DEFAULT_AVATAR = "150-150-71f98c390c33386893a6cc56c49efdb8";
//                DEFAULT_AVATAR0 = "240-240-e59153b6d6a91c6ca1d3503f252ee310";
//                DEFAULT_AVATAR1 = "240-240-c9b6e3ec5b71c3a43f60f843db82a249";
//                DEFAULT_AVATAR2 = "240-240-2e71be0404362ef2d8866e09fd2e39f0";
//                DEFAULT_AVATAR3 = "240-240-317ed6cd30e3b08576c947b514b51c5c";
//                LEJU_IDENTIFY_SOURCE = "test";
//                LEJU_IDENTIFY_KEY = "20b9950a3334104c60288cc32e4420ae";
//                WEIBO_CALLBACK_URL = "http://test.api.51zb.cn/v2/user/weiboCallBack";
//                H5_REDIRECT_URL = "http://test.h5.51zb.cn/withdraw.html";
//                EX_H5_REDIRECT_URL = "http://test.h5.51zb.cn/withdraw_enter.html";
//                NEVER_LOGIN_REDIRECT_URL = "http://test.h5.51zb.cn/noaccount.html";
//                PUSH_GW_URL = "http://test.gw.51zb.cn/forceLogout";
//                break;
//            default:
//                SEARCH_DATA = "http://search.intra.hiwemeet.com/search/data";
//                SEARCH_INDEX = "http://search.intra.hiwemeet.com/search/index";
//                SEARCH_UPDATE = "http://search.intra.hiwemeet.com/search/update";
//                SEARCH_DELETE = "http://search.intra.hiwemeet.com/search/delete";
//                TFS_UPLOAD_URL = "http://10.0.8.174:2080/weiphoto/upload_pic";
//                DEFAULT_AVATAR = "150-150-3a18a579c80f04e63a492c7f632b9334";
//                DEFAULT_AVATAR0 = "";
//                DEFAULT_AVATAR1 = "";
//                DEFAULT_AVATAR2 = "";
//                DEFAULT_AVATAR3 = "";
//                LEJU_IDENTIFY_SOURCE = "test";
//                LEJU_IDENTIFY_KEY = "20b9950a3334104c60288cc32e4420ae";
//                WEIBO_CALLBACK_URL = "http://test.api.51zb.cn/v2/user/weiboCallBack";
//                H5_REDIRECT_URL = "http://test.h5.51zb.cn/withdraw.html";
//                EX_H5_REDIRECT_URL = "http://test.h5.51zb.cn/withdraw_enter.html";
//                NEVER_LOGIN_REDIRECT_URL = "http://test.h5.51zb.cn/noaccount.html";
//                PUSH_GW_URL = "http://test.gw.51zb.cn/forceLogout";
//                break;
//        }
//    }
//
//}
