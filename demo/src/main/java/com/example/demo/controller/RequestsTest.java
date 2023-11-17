package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/dianji")
public class RequestsTest {
    // private ConcurrentHashMap<String, Integer> ipCounts = new ConcurrentHashMap<>();
    // private int maxRequests = 5; // 最大请求次数
    // private long interval = 60; // 时间间隔，单位：秒
    //
    // @GetMapping("/dian")
    // public void dianji(HttpServletRequest request){
    //     String ip = request.getHeader("X-Forwarded-For");
    //     if (ip == null || ip.length() == 0) {
    //         ip = request.getRemoteAddr();
    //     }
    //     System.out.println(ip);
    // }
    //
    // public boolean allowRequest(String ip) {
    //     String key = ip + "_" + System.currentTimeMillis() / 1000; // 使用当前时间戳作为key的一部分，防止同一IP的不同请求被误判为同一请求
    //     Integer count = ipCounts.get(key);
    //     if (count == null) {
    //         count = 0;
    //     }
    //     if (count >= maxRequests) {
    //         return false; // 达到最大请求次数，禁止访问
    //     } else {
    //         ipCounts.put(key, count + 1); // 更新计数器
    //         return true; // 允许访问
    //     }
    // }
    //
    // public void removeExpiredKeys() {
    //     long now = System.currentTimeMillis() / 1000; // 当前时间戳，单位：秒
    //     for (String key : ipCounts.keySet()) {
    //         long expireTime = Long.parseLong(key.split("_")[1]); // 解析出过期时间戳
    //         if (now - expireTime > interval) {
    //             ipCounts.remove(key); // 移除过期key
    //         }
    //     }
    // }

    HashMap<String,String> hashMap = new HashMap<>();
    List<String> list = new ArrayList<>();

    @GetMapping("/dian")
    public void dian(){
        // hashMap.put("1","2");

        list.add("1");
        System.out.println(list.size());
    }
}
