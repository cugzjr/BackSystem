package com.xxxx.server.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "FeedBackParam对象",description = "")
public class FeedBackParam {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    private String username;

    private String content;

    private String time;
}
