package com.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "跟慕课网廖师兄学spring boot" + id + limitConfig.getMinMoney();
    }
}

//    @RequestMapping("/hello")
//    @GetMapping("say/{id}")
//    @PostMapping("say")
//    @RequestMapping("say")
//    public String say(@PathVariable("id") Integer id){
//    public String say(@RequestParam("id") Integer id){

//        return "跟慕课网廖师兄学spring boot" + limitConfig.getDescription();
//        return "index";