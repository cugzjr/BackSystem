package com.xxxx.server.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 商品实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ProductParam对象",description = "")
public class ProductParam {
    @ApiModelProperty(value="商品id",required = true)
    private Integer productId;
    @ApiModelProperty(value="发布者 id",required = true)
    private Integer userId;
    @ApiModelProperty(value="商品类别",required = true)
    private String productCategory;
    @ApiModelProperty(value="商品品牌",required = true)
    private String productBrand;
    @ApiModelProperty(value="商品质量",required = true)
    private String productQuality;
    @ApiModelProperty(value="商品描述",required = true)
    private String productDescription;
    @ApiModelProperty(value="商品价格",required = true)
    private float productPrice;
    @ApiModelProperty(value="发布时间",required = true)
    private String productTime;
}
