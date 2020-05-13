package com.midea.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.midea.dao.SysUserDao;
import com.midea.entity.SysUser;
import com.midea.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public Map<String, Object> login(String loginname, String password) {
        HashMap<String, Object> mm = new HashMap<>();
      /*  UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginnameEqualTo(loginname);*/
        List<SysUser> users = sysUserDao.queryUserByname(loginname);//根据用户名在数据库查找对应的用户
        String msg = "";
        if ((users.size() == 0)) {//如果size=0就是没找到这个用户
            mm.put("status", "401");
            mm.put(msg, "用户不存在!");
        }
        if ((users.size() > 1)) {//如果size>1就是这数据有问题了，不应该存在两个一样的用户名
            mm.put("status", "401");
            mm.put(msg, "error!");
        }

        SysUser user = users.get(0);//取集合里第一个
        if (!password.equals(user.getPassword())) {
            mm.put("status", "401");
            mm.put(msg, "密码错误！");
        } else {
            mm.put("status", "200");
            mm.put(msg, "登陆成功!");
        }
        return mm;//把map集合里的状态码和信息提示返回给controller
    }

    @Override
    public long getSysUserRowCount(){
        return sysUserDao.getSysUserRowCount();
    }
    @Override
    public List<SysUser> selectSysUser(){
        return sysUserDao.selectSysUser();
    }
    @Override
    public SysUser selectSysUserByObj(SysUser obj){
        return sysUserDao.selectSysUserByObj(obj);
    }
    @Override
    public SysUser selectSysUserById(Integer id){
        return sysUserDao.selectSysUserById(id);
    }
    @Override
    public int insertSysUser(SysUser value){
        return sysUserDao.insertSysUser(value);
    }
    @Override
    public int insertNonEmptySysUser(SysUser value){
        return sysUserDao.insertNonEmptySysUser(value);
    }
    @Override
    public int deleteSysUserById(Integer id){
        return sysUserDao.deleteSysUserById(id);
    }
    @Override
    public int updateSysUserById(SysUser enti){
        return sysUserDao.updateSysUserById(enti);
    }
    @Override
    public int updateNonEmptySysUserById(SysUser enti){
        return sysUserDao.updateNonEmptySysUserById(enti);
    }

    public SysUserDao getSysUserDao() {
        return this.sysUserDao;
    }

    public void setSysUserDao(SysUserDao sysUserDao) {
        this.sysUserDao = sysUserDao;
    }

}