package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


//@Api(value = "/", description = "这是我全部的get方法")
//@RestController
//@Api(tags = "所有的get方法")
@RestController
@Api(description = "测试用get方法")
public class MyGetMethod {

//    @RequestMapping(value = "getCookies",method = RequestMethod.GET)

    /**
     * 返回cookies给客户端
     * @param response
     * @return
     */
    @GetMapping("/getCookies")
    @ApiOperation(value = "返回cookies给客户端",httpMethod = "GET")
    public String test06(HttpServletResponse response){
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies成功";
    }

    /**
     * 拿到客户端发来的cookies
     * @param request
     * @return
     */
    @GetMapping("/get/with/cookies")
    @ApiOperation(value = "拿到客户端发来的cookies",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息才能访问get请求";
        }
        for (Cookie cookie: cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "携带cookies访问成功！";
            }
        }
        return "你必须携带cookies信息才能访问";
    }

    /**
     * 携带参数访问
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/get/with/param")
    @ApiOperation(value = "携带参数访问",httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("shoes",400);
        myList.put("Instant noodles",10);
        myList.put("shirt",300);
        return myList;
    }


    @GetMapping("/get/with/param/{start}/{end}")
    @ApiOperation(value = "携带参数访问第二种",httpMethod = "GET")
    public Map<String, Integer> getList2(@PathVariable Integer start,
                                        @PathVariable Integer end){
        Map<String, Integer> myList = new HashMap<>();
        myList.put("shoes",400);
        myList.put("Instant noodles",10);
        myList.put("shirt",300);
        return myList;
    }


}
