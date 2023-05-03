package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Commerce对象", description="")
public class Commerce implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer commodityid;

    private Integer sellerid;

    private Integer buyerid;

    private String place;

    private LocalDateTime time;

    private Double price;

    @ApiModelProperty(value = "0关闭，1等待付款，2已付款，等待交易，3完成")
    private Integer state;

    @TableId(value = "commerceid", type = IdType.AUTO)
    private Integer commerceid;


}
