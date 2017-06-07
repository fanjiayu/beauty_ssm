//package com.ysgj.ssm.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.ysgj.ssm.commons.Const;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
///**
// * TfsUtil TFS工具
// *
// * @author fanjiayu
// * @date 2015/12/18
// */
//public class TfsUtil {
//
//    private static final Logger LOG = LoggerFactory.getLogger(TfsUtil.class);
//
//    private static ApacheHttpClient httpClient = new ApacheHttpClient(1000, 6000);
//
//
//    /**
//     * 上传文件流至TFS服务器
//     * @return
//     */
//    public static JSONObject uploadFile(byte[] bytes){
//        JSONObject result = null;
//        try {
//            String executeAsyncString = httpClient.buildPost(Const.TFS_UPLOAD_URL).withHeader("accept-encoding", "gzip,deflate").withParam("pic", bytes).executeAsyncString();
//            result = JSON.parseObject(executeAsyncString);
//            LOG.info("result:" + result.toJSONString());
//            if(null == result.get("picid")){
//                LOG.info("save avatar to TFS error！data size:".concat(String.valueOf(bytes.length)).concat(",tfsUrl:").concat(Const.TFS_UPLOAD_URL));
//                return null;
//            }
//            return result;
//        } catch (Exception e) {
//            LOG.error("upload to TFS error!".concat(JSON.toJSONString(result)), e);
//            return null;
//        }
//    }
//
//    public static String getImageId(String url) {
//        try {
//            byte[] buffer = httpClient.buildGet(url).executeByte();
//            JSONObject object = uploadFile(buffer);
//            LOG.info("Monitor:TfsUtil.getImageId imageId " + object.toJSONString());
//            String imageId =  object.getString("picid");
//            return imageId;
//        } catch (Exception e) {
//            LOG.error("",e);
//            return "";
//        }
//    }
//
//
//}
