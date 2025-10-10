package com.irum.teamup.controller;

import cn.hutool.core.bean.BeanUtil;
import com.irum.teamup.convention.result.Result;
import com.irum.teamup.convention.result.Results;
import com.irum.teamup.enums.UserErrorCodeEnum;
import com.irum.teamup.dto.UserLoginDTO;
import com.irum.teamup.dto.UserRegisterDTO;
import com.irum.teamup.dto.UserUpdateDTO;
import com.irum.teamup.vo.UserActualVO;
import com.irum.teamup.vo.UserLoginVO;
import com.irum.teamup.vo.UserVO;
import com.irum.teamup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理控制层
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/team-up/v1/user/{username}")
    public Result<UserVO> getUserByUsername(@PathVariable("username") String username){
        UserVO result = userService.getUserByUsername(username);
        if(result == null){
            return new Result<UserVO>().setCode(UserErrorCodeEnum.USER_NULL.code()).setMessage(UserErrorCodeEnum.USER_NULL.message());
        }else {
            return Results.success(result);
        }
    }

    /**
     * 根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/team-up/v1/actual/user/{username}")
    public Result<UserActualVO> getActualUserByUsername(@PathVariable("username") String username){
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualVO.class));
    }

    /**
     * 判断用户名是否存在
     */
    @GetMapping("/api/team-up/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username){
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 注册用户
     */
    @PostMapping("/api/team-up/v1/user")
    public Result<Void> register(@RequestBody UserRegisterDTO requestParam){
        userService.Register(requestParam);
        return Results.success();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/api/team-up/v1/user")
    public Result<Void> update(@RequestBody UserUpdateDTO requestParam){
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 登录
     */
    @PostMapping("/api/team-up/v1/user/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO requestParam){
        return Results.success(userService.login(requestParam));
    }

    /**
     * 检测登录状态
     */
    @GetMapping("/api/team-up/v1/user/check-login")
    public Result<Boolean> checklogin(@RequestParam("username") String username,@RequestParam("token") String token){
        return Results.success(userService.checklogin( username,token));
    }
}
