package com.example.redisdemo.controller;
import com.example.redisdemo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private CacheService cache;

    @GetMapping("/add")
    public String writeCache(@RequestParam String key, @RequestParam String value) {
        cache.writeCache(key, value);
        return String.format("成功写入cache key:%s value:%s",key,value);
    }

    @GetMapping("/search")
    public Object readCache(@RequestParam String key) {
        return cache.readCache(key);
    }

    @PutMapping("/update")
    public String updateCache(@RequestParam String key, @RequestParam String value) {
        cache.updateCache(key, value);
        return String.format("成功更新cache key:%s value:%s",key,value);
    }
}
