package com.irum.teamup.controller;

import cn.hutool.core.bean.BeanUtil;
import com.irum.teamup.convention.result.Result;
import com.irum.teamup.convention.result.Results;
import com.irum.teamup.dto.admin.AdminLoginDTO;
import com.irum.teamup.dto.admin.AdminRegisterDTO;
import com.irum.teamup.dto.admin.AdminUpdateDTO;
import com.irum.teamup.enums.AdminErrorCodeEnum;
import com.irum.teamup.service.AdminService;
import com.irum.teamup.vo.admin.AdminActualVO;
import com.irum.teamup.vo.admin.AdminLoginVO;
import com.irum.teamup.vo.admin.AdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 管理员控制层
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "管理员接口")
public class AdminController {

    private final AdminService adminService;



    /**
     * 注册用户
     */
    @ApiOperation(value = "注册用户", notes = "",httpMethod = "POST")
    @ApiImplicitParam(name = "requestParam", value = "用户注册参数", required = true, dataType = "UserRegisterDTO", paramType = "body")
    @PostMapping("/api/team-up/v1/user")
    public Result<Void> register(@RequestBody AdminRegisterDTO requestParam){
        adminService.Register(requestParam);
        return Results.success();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/api/team-up/v1/user")
    @ApiOperation(value = "修改用户信息", notes = "",httpMethod = "PUT")
    @ApiImplicitParam(name = "requestParam", value = "用户修改参数", required = true, dataType = "UserUpdateDTO", paramType = "body")
    public Result<Void> update(@RequestBody AdminUpdateDTO adminUpdateDTO){
        adminService.updateByUsername(adminUpdateDTO);
        return Results.success();
    }

    /**
     * 登录
     */
    @ApiOperation(value = "登录", notes = "",httpMethod = "POST")
    @ApiImplicitParam(name = "requestParam", value = "用户登录参数", required = true, dataType = "UserLoginDTO", paramType = "body")
    @PostMapping("/api/team-up/v1/user/login")
    public Result<AdminLoginVO> login(@RequestBody AdminLoginDTO requestParam){
        return Results.success(adminService.login(requestParam));
    }


}