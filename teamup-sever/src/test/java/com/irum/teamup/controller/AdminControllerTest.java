package com.irum.teamup.controller;

import com.irum.teamup.convention.result.ResponseResult;
import com.irum.teamup.dto.admin.AdminLoginDTO;
import com.irum.teamup.dto.admin.AdminRegisterDTO;
import com.irum.teamup.dto.admin.AdminUpdateDTO;
import com.irum.teamup.service.AdminService;
import com.irum.teamup.vo.admin.AdminLoginVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * AdminController 单元测试类
 */
class AdminControllerTest {

    @InjectMocks
    private AdminController adminController;

    @Mock
    private AdminService adminService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * 测试 register 方法 - 正常注册成功
     */
    @Test
    void register_Success() {
        AdminRegisterDTO dto = new AdminRegisterDTO();
        doNothing().when(adminService).Register(any(AdminRegisterDTO.class));

        ResponseResult<Void> result = adminController.register(dto);

        assertNotNull(result);
        assertTrue(result.isSuccess());
        verify(adminService, times(1)).Register(dto);
    }

    /**
     * 测试 register 方法 - 注册失败（抛出异常）
     */
    @Test
    void register_Failure() {
        AdminRegisterDTO dto = new AdminRegisterDTO();
        doThrow(new RuntimeException("注册失败")).when(adminService).Register(any(AdminRegisterDTO.class));

        assertThrows(RuntimeException.class, () -> {
            adminController.register(dto);
        });

        verify(adminService, times(1)).Register(dto);
    }

    /**
     * 测试 update 方法 - 正常更新成功
     */
    @Test
    void update_Success() {
        AdminUpdateDTO dto = new AdminUpdateDTO();
        doNothing().when(adminService).updateByUsername(any(AdminUpdateDTO.class));

        ResponseResult<Void> result = adminController.update(dto);

        assertNotNull(result);
        assertTrue(result.isSuccess());
        verify(adminService, times(1)).updateByUsername(dto);
    }

    /**
     * 测试 update 方法 - 更新失败（抛出异常）
     */
    @Test
    void update_Failure() {
        AdminUpdateDTO dto = new AdminUpdateDTO();
        doThrow(new RuntimeException("更新失败")).when(adminService).updateByUsername(any(AdminUpdateDTO.class));

        assertThrows(RuntimeException.class, () -> {
            adminController.update(dto);
        });

        verify(adminService, times(1)).updateByUsername(dto);
    }

    /**
     * 测试 login 方法 - 登录成功
     */
    @Test
    void login_Success() {
        AdminLoginDTO dto = new AdminLoginDTO();
        AdminLoginVO vo = new AdminLoginVO();
        when(adminService.login(any(AdminLoginDTO.class))).thenReturn(vo);

        ResponseResult<AdminLoginVO> result = adminController.login(dto);

        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertEquals(vo, result.getData());
        verify(adminService, times(1)).login(dto);
    }

    /**
     * 测试 login 方法 - 登录失败（抛出异常）
     */
    @Test
    void login_Failure() {
        AdminLoginDTO dto = new AdminLoginDTO();
        when(adminService.login(any(AdminLoginDTO.class))).thenThrow(new RuntimeException("登录失败"));

        assertThrows(RuntimeException.class, () -> {
            adminController.login(dto);
        });

        verify(adminService, times(1)).login(dto);
    }
}
