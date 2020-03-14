package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(description = "测试用post方法")
public class MyPostMethod {
    private static Cookie cookie;

    @PostMapping("/login")
    @ApiOperation(value = "登录接口，成功后获取cookies信息")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "passWord", required = true) String password
                        ){
        if (userName.equals("zs") && password.equals("123456")){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "login succes";
        }
        return "login fail";
    }

    @PostMapping("/getUserList")
    @ApiOperation(value = "返回user List")
    public String GetUserList(HttpServletRequest request,
                            @RequestBody User u
                            ){
        User user;
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies){
            if (c.getName().equals("login") & c.getValue().equals("true") & u.getUserName().equals("zs") & u.getPassWord().equals("123456")){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }

}
