package com.midea.controller;

import com.midea.entity.SysUser;
import com.midea.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login.jsp";
    }

    @RequestMapping("login")
    public String login(SysUser user, Model model) {
        String loginname = user.getLoginname();
        String password = user.getPassword();
        Map<String, Object> map = sysUserService.login(loginname, password);
        if (map.get("status").equals("200")) {
            return "success.jsp";
        } else {
            model.addAttribute("error", map.get("msg"));
            return "login.jsp";
        }
    }

}
