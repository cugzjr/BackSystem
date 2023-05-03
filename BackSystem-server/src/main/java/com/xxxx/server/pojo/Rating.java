package com.xxxx.server.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@ApiModel(value="Rating对象", description="")
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private Integer commodityid;

    private Double score;

    private Integer timestamp;


}
