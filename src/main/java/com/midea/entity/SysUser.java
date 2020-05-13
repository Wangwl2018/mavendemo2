package com.midea.entity;
public class SysUser {
    private Integer id;
    private String name;
    private String loginname;
    private String password;
    private String sex;
    private Integer age;
    public SysUser() {
        super();
    }
    public SysUser(Integer id,String name,String loginname,String password,String sex,Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.loginname = loginname;
        this.password = password;
        this.sex = sex;
        this.age = age;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginname() {
        return this.loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
