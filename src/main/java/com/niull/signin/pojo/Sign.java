package com.niull.signin.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "t_sign")
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @ApiModelProperty(value = "签到时间")
    @Column(name = "sign_time")
    private Date signTime;
    @ApiModelProperty(value = "签到地址")
    @Column(name = "sign_address")
    private String signAddress;
    @NotNull
    @Column(name = "sign_id")
    @ApiModelProperty(value = "签到用户id")
    private Integer signId;

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
     * @return sign_time
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * @param signTime
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    /**
     * @return sign_address
     */
    public String getSignAddress() {
        return signAddress;
    }

    /**
     * @param signAddress
     */
    public void setSignAddress(String signAddress) {
        this.signAddress = signAddress == null ? null : signAddress.trim();
    }

    /**
     * @return signId
     */
    public Integer getSignId() {
        return signId;
    }

    /**
     * @param signId
     */
    public void setSignId(Integer signId) {
        this.signId = signId == null ? null : signId;
    }
}
