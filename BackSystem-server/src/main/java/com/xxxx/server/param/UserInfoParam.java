package com.xxxx.server.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户信息实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "UserInfoParam对象",description = "")
public class UserInfoParam {
    @ApiModelProperty(value="用户id",required = true)
    private Integer userId;
    @ApiModelProperty(value="用户名",required = true)
    private String userName;
    @ApiModelProperty(value="年龄",required = true)
    private Integer userAge;
    @ApiModelProperty(value="性别",required = true)
    private String userGender;
    @ApiModelProperty(value="个性签名",required = true)
    private String userSignature;
    @ApiModelProperty(value="状态",required = true)
    private String userState;
}
