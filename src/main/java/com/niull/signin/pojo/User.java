package com.niull.signin.pojo;


import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.convert.ReadingConverter;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author niull
 * @Date 2020/10/26 20:36
 * @Description 牛立露你就写点注释吧
 */
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "账号不能为空")
    @ApiModelProperty(value = "账号",example = "c-niull")
    private String account;
    @Column(name = "create_time")
    private Date createTime;
    @NotNull(message = "用户邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱",example = "lelement@1263.com")
    private String email;
    @NotNull(message = "用户密码不能为空")
    @ApiModelProperty(value = "密码",example = "qwe123..")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;
    @ApiModelProperty(value = "性别",example = "1")
    private Short sex;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return sex
     */
    public Short getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

}
