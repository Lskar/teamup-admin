package com.irum.teamup.controller;

import com.irum.teamup.convention.result.ResponseResult;
import com.irum.teamup.dto.user.UserUpdateDTO;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.query.UserPageQuery;
import com.irum.teamup.service.UserService;
import com.irum.teamup.vo.user.UserDetailVO;
import com.irum.teamup.vo.user.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
@Api(tags = "用户管理")
@Validated
@AllArgsConstructor
public class UserController {


    private final UserService userService;


    /**
     * 获取用户列表
     * @param userPageQuery 分页参数
     * @return 用户列表
     */
    @ApiOperation(value = "获取用户列表")
    @ApiImplicitParam(name = "pageQueryDTO", value = "分页参数", required = true, dataType = "PageQueryDTO", paramType = "body")
    @GetMapping
    public ResponseResult<PageDTO<UserVO>> getUserList(UserPageQuery userPageQuery){
        System.out.println("✅ 收到用户列表请求，参数：" );
        return ResponseResult.success(userService.getUserList(userPageQuery));
    }

    /**
     * 获取用户详细信息
     * @param id 用户id
     * @return 用户信息
     */
    @ApiOperation(value = "获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public ResponseResult<UserDetailVO> getUserDetail(@PathVariable Long id){
        return ResponseResult.success(userService.getUserDetail(id));
    }

    /**
     * 启用禁用用户
     * @param id 用户id
     *
     */
    @ApiOperation(value = "启用禁用用户")
    @ApiImplicitParams( {
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "用户状态", required = true, dataType = "Integer", paramType = "query")
    })
    @PutMapping("/{id}/status")
    public ResponseResult<Void> updateUserStatus(@PathVariable Long id, @RequestParam Integer status){
        userService.updateUserStatus(id, status);
        return ResponseResult.success();
    }

    /**
     * 删除用户
     * @param id 用户id
     */
    @ApiOperation(value = "删除用户")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("/{id}")
    public ResponseResult<Void> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseResult.success();
    }

    /**
     * 修改用户信息
     * @param userUpdateDTO 用户信息
     */
    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParam(name = "userUpdateDTO", value = "用户信息", required = true, dataType = "UserUpdateDTO", paramType = "body")
    @PutMapping
    public ResponseResult<Void> updateUser(@RequestBody @Valid UserUpdateDTO userUpdateDTO){

        userService.updateUser(userUpdateDTO);
        return ResponseResult.success();
    }

}
