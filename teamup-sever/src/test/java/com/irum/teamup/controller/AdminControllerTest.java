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
        dto.setUsername("testUser");
        dto.setPassword("testPass");
        dto.setRealName("Test User");
        dto.setPhone("12345678901");
        dto.setMail("<EMAIL>");

        doNothing().when(adminService).Register(any(AdminRegisterDTO.class));

        ResponseResult<Void> result = adminController.register(dto);

        assertNotNull(result);
        assertEquals("200", result.getCode());
        verify(adminService, times(1)).Register(dto);
    }

    /**
     * 测试 update 方法 - 正常更新成功
     */
    @Test
    void update_Success() {
        AdminUpdateDTO dto = new AdminUpdateDTO();
        dto.setUsername("testUser");
        dto.setPassword("<PASSWORD>");
        dto.setRealName("Updated User");
        dto.setPhone("12345678902");
        dto.setMail("<EMAIL>");

        doNothing().when(adminService).updateByUsername(any(AdminUpdateDTO.class));

        ResponseResult<Void> result = adminController.update(dto);

        assertNotNull(result);
        assertEquals("200", result.getCode());
        verify(adminService, times(1)).updateByUsername(dto);
    }

    /**
     * 测试 login 方法 - 登录成功
     */
    @Test
    void login_Success() {
        AdminLoginDTO dto = new AdminLoginDTO();
        dto.setUsername("testUser");
        dto.setPassword("<PASSWORD>");

        AdminLoginVO vo = new AdminLoginVO();
        vo.setUserId(1L);
        vo.setUsername("testUser");
        vo.setToken("testToken");

        when(adminService.login(any(AdminLoginDTO.class))).thenReturn(vo);

        ResponseResult<AdminLoginVO> result = adminController.login(dto);

        assertNotNull(result);
        assertEquals("200", result.getCode());
        assertEquals(vo, result.getData());
        verify(adminService, times(1)).login(dto);
    }
}
