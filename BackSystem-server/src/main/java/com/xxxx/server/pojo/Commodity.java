package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Commodity对象", description="")
public class Commodity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    private String description;

    @ApiModelProperty(value = "图片网址")
    private String url1;

    @ApiModelProperty(value = "视频网址")
    private String url2;

    private Float price;

    private LocalDateTime time;

    private Boolean state;

    @ApiModelProperty(value = "分类")
    private String category;

    @ApiModelProperty(value = "成色")
    private String quality;

    @ApiModelProperty(value = "购买渠道")
    private String purchasechannel;

    private String brand;

    private Float originalprice;


}
