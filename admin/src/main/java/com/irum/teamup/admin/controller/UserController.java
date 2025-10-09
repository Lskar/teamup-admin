package com.irum.teamup.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.irum.teamup.admin.common.convention.result.Result;
import com.irum.teamup.admin.common.convention.result.Results;
import com.irum.teamup.admin.common.enums.UserErrorCodeEnum;
import com.irum.teamup.admin.dto.req.UserLoginReqDTO;
import com.irum.teamup.admin.dto.req.UserRegisterReqDTO;
import com.irum.teamup.admin.dto.req.UserUpdateReqDTO;
import com.irum.teamup.admin.dto.resp.UserActualRespDTO;
import com.irum.teamup.admin.dto.resp.UserLoginResqDTO;
import com.irum.teamup.admin.dto.resp.UserRespDTO;
import com.irum.teamup.admin.service.UserService;
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
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username){
        UserRespDTO result = userService.getUserByUsername(username);
        if(result == null){
            return new Result<UserRespDTO>().setCode(UserErrorCodeEnum.USER_NULL.code()).setMessage(UserErrorCodeEnum.USER_NULL.message());
        }else {
            return Results.success(result);
        }
    }

    /**
     * 根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/team-up/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username){
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
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
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam){
        userService.Register(requestParam);
        return Results.success();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/api/team-up/v1/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam){
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 登录
     */
    @PostMapping("/api/team-up/v1/user/login")
    public Result<UserLoginResqDTO> login(@RequestBody UserLoginReqDTO requestParam){
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
