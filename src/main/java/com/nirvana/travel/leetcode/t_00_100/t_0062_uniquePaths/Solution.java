package com.nirvana.travel.leetcode.t_00_100.t_0062_uniquePaths;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * @date 2022/3/27
 */
public class Solution {

    /**
     * 思路1：二维数组
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //二维数组表示到达当前位置的方案数量
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][n] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }


    /**
     * 思路1：一维数组
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        //二维数组表示到达当前位置的方案数量
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i] += dp[i-1];
            }
        }

        return dp[n-1];
    }


    public static void main(String[] args) {
        String orderStr = "{\"requestId\":\"1786821582614691840172455062\",\"bizType\":\"HELLO_HAOWU_MALL\",\"buyerInfo\":{\"userId\":1200002987,\"phoneNum\":\"18217055949\",\"userName\":\"朱洪成\",\"realName\":\"朱洪成\",\"extra\":{\"userGuid\":\"911e16b10d6747f1bd58dcc8eed0adab\"}},\"itemSplitCreateReqList\":[{\"itemId\":\"2897134455875436655288683778\",\"itemName\":\"食用油A\",\"itemType\":\"VIRTUAL\",\"itemSnapshotId\":\"2897137788799942816017244612\",\"itemAttribute\":{},\"itemInfo\":{\"skuId\":\"2897134455875436663288683778\",\"spuId\":\"2897134455875436655288683778\",\"picUrl\":\"https://easybike-image.oss-cn-hangzhou.aliyuncs.com/repertoryImg/1740143067010170880172456731.jpg?Expires=1654004207&OSSAccessKeyId=LTAIwDP3dFcdWEUd&Signature=p/8URck7bVaG7yA7jZu6grj8nl8%3D\",\"channelId\":\"1\"},\"num\":1,\"originUnitPrice\":1.00,\"currentUnitPrice\":1,\"subOrderExt\":{\"CATEGORY_ID\":\"2556\",\"PROMOTION_LIST\":\"[{\\\"promotionId\\\":\\\"0a475dcfl1l59s454nityadwxr24qrff\\\",\\\"promotionType\\\":\\\"COUPON\\\",\\\"worth\\\":1}]\",\"PROMO_GOODS_ID\":\"2897134455875436663288683778\",\"TRADE_FULFILL_INFO\":\"{\\\"fulfillScene\\\":1}\",\"PROMO_GOODS_ID_TYPE\":\"0\"},\"subOrderTag\":{\"JOINED_FILFUL\":true},\"sellerInfo\":{\"sellerId\":\"20000005443\",\"sellerType\":\"HELLO\",\"shopId\":\"30003703\",\"shopName\":\"哈啰好物商城测试\"},\"deliveryInfo\":{\"deliveryType\":\"MERCHANT\",\"receiverName\":\"花田里\",\"receiverAddress\":{\"country\":\"玉泉区\",\"province\":\"内蒙古自治区\",\"city\":\"呼和浩特市\",\"detail\":\"898号\",\"postalCode\":\"322423\",\"areaCode\":\"150104\"}}},{\"itemId\":\"2611660829866097705017243876\",\"itemName\":\"小羊的居家好物\",\"itemType\":\"VIRTUAL\",\"itemSnapshotId\":\"2708843742234163798017244669\",\"itemAttribute\":{},\"itemInfo\":{\"skuId\":\"2611660829866097718017243876\",\"spuId\":\"2611660829866097705017243876\",\"picUrl\":\"https://easybike-image.oss-cn-hangzhou.aliyuncs.com/repertoryImg/1616569615096217600172438196.webp?Expires=1648524129&OSSAccessKeyId=LTAIwDP3dFcdWEUd&Signature=nYgSdci4NBBKWW1EahHRSfe6Dq0%3D\",\"channelId\":\"1\"},\"num\":1,\"originUnitPrice\":999.00,\"currentUnitPrice\":0.01,\"subOrderExt\":{\"CATEGORY_ID\":\"2536\",\"PROMOTION_LIST\":\"[{\\\"promotionId\\\":\\\"0a475dcfl1l59s454nityadwxr24qrff\\\",\\\"promotionType\\\":\\\"COUPON\\\",\\\"worth\\\":0.01}]\",\"PROMO_GOODS_ID\":\"2611660829866097718017243876\",\"TRADE_FULFILL_INFO\":\"{\\\"fulfillScene\\\":1}\",\"PROMO_GOODS_ID_TYPE\":\"0\"},\"subOrderTag\":{\"JOINED_FILFUL\":true},\"sellerInfo\":{\"sellerId\":\"20000007631\",\"sellerType\":\"HELLO\",\"shopId\":\"30003625\",\"shopName\":\"小羊的哈啰好物店铺\"},\"deliveryInfo\":{\"deliveryType\":\"MERCHANT\",\"receiverName\":\"花田里\",\"receiverAddress\":{\"country\":\"玉泉区\",\"province\":\"内蒙古自治区\",\"city\":\"呼和浩特市\",\"detail\":\"898号\",\"postalCode\":\"322423\",\"areaCode\":\"150104\"}}},{\"itemId\":\"2665000990855930932017244892\",\"itemName\":\"果冻橙\",\"itemType\":\"VIRTUAL\",\"itemSnapshotId\":\"2665000990855930933017244892\",\"itemAttribute\":{},\"itemInfo\":{\"skuId\":\"2665000990855930939017244892\",\"spuId\":\"2665000990855930932017244892\",\"picUrl\":\"https://easybike-image.oss-cn-hangzhou.aliyuncs.com/repertoryImg/1598459986113986560172451581.jpeg?Expires=1654799401&OSSAccessKeyId=LTAIwDP3dFcdWEUd&Signature=8ykEbL4FQKYN4eqiZ2Tw%2BNJT6JU%3D\",\"channelId\":\"1\"},\"num\":1,\"originUnitPrice\":20.00,\"currentUnitPrice\":9.9,\"subOrderExt\":{\"CATEGORY_ID\":\"2587\",\"PROMOTION_LIST\":\"[{\\\"promotionId\\\":\\\"0a475dcfl1l59s454nityadwxr24qrff\\\",\\\"promotionType\\\":\\\"COUPON\\\",\\\"worth\\\":9.9}]\",\"PROMO_GOODS_ID\":\"2665000990855930939017244892\",\"TRADE_FULFILL_INFO\":\"{\\\"fulfillScene\\\":1}\",\"PROMO_GOODS_ID_TYPE\":\"0\"},\"subOrderTag\":{\"JOINED_FILFUL\":true},\"sellerInfo\":{\"sellerId\":\"20000005474\",\"sellerType\":\"HELLO\",\"shopId\":\"30003626\",\"shopName\":\"哈啰好物店铺\"},\"deliveryInfo\":{\"deliveryType\":\"MERCHANT\",\"receiverName\":\"花田里\",\"receiverAddress\":{\"country\":\"玉泉区\",\"province\":\"内蒙古自治区\",\"city\":\"呼和浩特市\",\"detail\":\"898号\",\"postalCode\":\"322423\",\"areaCode\":\"150104\"}}},{\"itemId\":\"2638974691600515664017245239\",\"itemName\":\"蟠桃\",\"itemType\":\"VIRTUAL\",\"itemSnapshotId\":\"2891248598300754436017245575\",\"itemAttribute\":{},\"itemInfo\":{\"skuId\":\"2638974691600515671017245239\",\"spuId\":\"2638974691600515664017245239\",\"picUrl\":\"https://easybike-image.oss-cn-hangzhou.aliyuncs.com/repertoryImg/1582574854870138880172451581.png?Expires=1654021802&OSSAccessKeyId=LTAIwDP3dFcdWEUd&Signature=0zc6g0QhZRc2DsYKmPM7leoaEzc%3D\",\"channelId\":\"1\"},\"num\":1,\"originUnitPrice\":18.00,\"currentUnitPrice\":18,\"subOrderExt\":{\"CATEGORY_ID\":\"2535\",\"PROMOTION_LIST\":\"[{\\\"promotionId\\\":\\\"0a475dcfl1l59s454nityadwxr24qrff\\\",\\\"promotionType\\\":\\\"COUPON\\\",\\\"worth\\\":18}]\",\"PROMO_GOODS_ID\":\"2638974691600515671017245239\",\"TRADE_FULFILL_INFO\":\"{\\\"fulfillScene\\\":1}\",\"PROMO_GOODS_ID_TYPE\":\"0\"},\"subOrderTag\":{\"JOINED_FILFUL\":true},\"sellerInfo\":{\"sellerId\":\"20000005474\",\"sellerType\":\"HELLO\",\"shopId\":\"30003626\",\"shopName\":\"哈啰好物店铺\"},\"deliveryInfo\":{\"deliveryType\":\"MERCHANT\",\"receiverName\":\"花田里\",\"receiverAddress\":{\"country\":\"玉泉区\",\"province\":\"内蒙古自治区\",\"city\":\"呼和浩特市\",\"detail\":\"898号\",\"postalCode\":\"322423\",\"areaCode\":\"150104\"}}},{\"itemId\":\"2964804277277604881017245002\",\"itemName\":\"小番茄\",\"itemType\":\"VIRTUAL\",\"itemSnapshotId\":\"2964804277277604882017245002\",\"itemAttribute\":{},\"itemInfo\":{\"skuId\":\"2964804277277604888017245002\",\"spuId\":\"2964804277277604881017245002\",\"picUrl\":\"https://easybike-image.oss-cn-hangzhou.aliyuncs.com/repertoryImg/1781445433030082560172456731.png?Expires=1655973561&OSSAccessKeyId=LTAIwDP3dFcdWEUd&Signature=DpK647xzngRCnFgzjzXxtL0JapE%3D\",\"channelId\":\"1\"},\"num\":1,\"originUnitPrice\":0.01,\"currentUnitPrice\":0.01,\"subOrderExt\":{\"CATEGORY_ID\":\"2587\",\"PROMOTION_LIST\":\"[{\\\"promotionId\\\":\\\"0a475dcfl1l59s454nityadwxr24qrff\\\",\\\"promotionType\\\":\\\"COUPON\\\",\\\"worth\\\":0.01}]\",\"PROMO_GOODS_ID\":\"2964804277277604888017245002\",\"TRADE_FULFILL_INFO\":\"{\\\"fulfillScene\\\":1}\",\"PROMO_GOODS_ID_TYPE\":\"0\"},\"subOrderTag\":{\"JOINED_FILFUL\":true},\"sellerInfo\":{\"sellerId\":\"20000005868\",\"sellerType\":\"HELLO\",\"shopId\":\"30003822\",\"shopName\":\"好物店铺\"},\"deliveryInfo\":{\"deliveryType\":\"MERCHANT\",\"receiverName\":\"花田里\",\"receiverAddress\":{\"country\":\"玉泉区\",\"province\":\"内蒙古自治区\",\"city\":\"呼和浩特市\",\"detail\":\"898号\",\"postalCode\":\"322423\",\"areaCode\":\"150104\"}}}],\"payType\":\"NORMAL\",\"source\":{\"systemCode\":\"61\"},\"locationDTO\":{\"cityCode\":\"021\",\"cityGuid\":\"021\",\"cityName\":\"021\"},\"orderExtension\":{\"orderSource\":\"0\",\"payOperateType\":\"ONLINE\",\"orderPort\":\"1\",\"useStatus\":\"1\"},\"orderTag\":{\"SHOPPING_CARD_BUY\":true,\"SUPERMARKET_PROMO_OPTIMIZE\":true,\"JOINED_UMP\":true},\"expectTimeout\":1648540314428,\"totalRealPayPrice\":28.92,\"bizExtension\":{}}";
        System.out.println(orderStr);
    }
}
