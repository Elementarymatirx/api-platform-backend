package com.zsw.client.controller;

import cn.hutool.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfaceController {
    /**
     * 测试demo
     * @param value
     * @return
     */
    @GetMapping("/demo")
    public String getDemo(String value) {
        return "demo获取到的value值为:" + value;
    }

    /**
     * 每日一言
     * @return
     */
    @GetMapping("/yiyan")
    public String yiYan() {
        String result = HttpRequest.get("https://v.api.aa1.cn/api/yiyan/index.php")
                .execute()
                .body();
        return result;
    }

    /**
     * 安慰文案
     * @return
     */
    @GetMapping("/anwei")
    public String anWei() {
        String result = HttpRequest.get("https://v.api.aa1.cn/api/api-wenan-anwei/index.php?type=json")
                .execute()
                .body();
        return result;
    }

    /**
     * 爬取网站静态资源
     * @return
     */
    @GetMapping("/bz")
    public String Bz(String url) {
        String result = HttpRequest.get("https://v.api.aa1.cn/api/api-bz/temp.php?url=" + url)
                .execute()
                .body();
        return result;
    }

    /**
     * 二次元壁纸
     * @return
     */
    @GetMapping("/erciyuan")
    public String erciyuanPicture() {
        String result = HttpRequest.get("http://api.btstu.cn/sjbz/api.php?lx=dongman&format=images")
                .contentType("json/images")
                .execute()
                .body();
        return result;
    }
}
