package com.xxxx.server.param;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "CommerceParam对象",description = "")
public class CommerceParam {
    private Integer commodityid;

    private Integer sellerid;

    private Integer buyerid;

    private String place;

    private String time;

    private Double price;

}
