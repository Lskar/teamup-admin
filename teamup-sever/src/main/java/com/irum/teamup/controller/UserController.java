package com.irum.teamup.controller;

import com.irum.teamup.convention.result.PageResult;
import com.irum.teamup.convention.result.Result;
import com.irum.teamup.dto.PageQueryDTO;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.dto.UserUpdateDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
public class UserController {

    /**
     * 获取用户列表
     * @param pageQueryDTO 分页参数
     * @return 用户列表
     */
    @GetMapping
    public Result<PageResult<UserDO>> getUserList(PageQueryDTO pageQueryDTO){
        return null;
    }

    /**
     * 获取用户详细信息
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public Result<UserDO> getUserDetail(@PathVariable Long id){
        return null;
    }

    /**
     * 启用禁用用户
     * @param id 用户id
     *
     */
    @GetMapping("/{id}/status")
    public Result<Void> updateUserStatus(@PathVariable Long id, @RequestParam Integer status){
        return null;
    }

    /**
     * 删除用户
     * @param id 用户id
     */
    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable Long id){
        return null;
    }

    /**
     * 修改用户信息
     * @param userUpdateDTO 用户信息
     */
    @PutMapping
    public Result<Void> updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
        return null;
    }

}
