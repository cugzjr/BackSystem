package com.xxxx.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
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
@ApiModel(value="Pricing对象", description="")
public class Pricing implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer commodityid;

    private Integer userid;

    private Double price;

    private LocalDateTime time;

    @TableId(value = "pricingid", type = IdType.AUTO)
    private Integer pricingid;


}
