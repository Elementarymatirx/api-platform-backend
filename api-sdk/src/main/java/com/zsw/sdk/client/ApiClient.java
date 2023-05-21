package com.zsw.sdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    private String accessKey;

    private String secretKey;

    private static final String GATEWAY_HOST = "http://localhost:8102";

    public ApiClient(String accessKey,String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private Map<String, String> getHeaderMap(String body) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
//        hashMap.put("secretKey",secretKey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("body", body);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public static String genSign(String body, String secretKey) {
        Digester digester = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey;
        return digester.digestHex(content);
    }

    /**
     * 测试接口
     * @return
     */
    public String getDemo(String value) {
        String result = HttpRequest.get(GATEWAY_HOST + "/interface/demo?value=" + value)
                .addHeaders(getHeaderMap(""))
                .execute()
                .body();
        return result;
    }

    /**
     * 每日一言
     * @return
     */
    public String yiYan() {
        String result = HttpRequest.get(GATEWAY_HOST + "/interface/yiyan")
                .addHeaders(getHeaderMap(""))
                .execute()
                .body();
        return result;
    }

    /**
     * 安慰文案
     * @return
     */
    public String anWei() {
        String result = HttpRequest.get(GATEWAY_HOST + "/interface/anwei")
                .addHeaders(getHeaderMap(""))
                .execute()
                .body();
        return result;
    }

    /**
     * 爬取网站静态资源
     * @return
     */
    public String Bz(String url) {
        String result = HttpRequest.get(GATEWAY_HOST + "/interface/bz?url=" + url)
                .addHeaders(getHeaderMap(""))
                .execute()
                .body();
        return result;
    }

    /**
     * 二次元壁纸
     * @return
     */
    public String erciyuanPicture() {
        String result = HttpRequest.get(GATEWAY_HOST + "/interface/erciyuan")
                .addHeaders(getHeaderMap(""))
                .contentType("json/images")
                .execute()
                .body();
        return result;
    }
}
