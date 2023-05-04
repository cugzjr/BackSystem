package com.xxxx.server.controller;


import com.xxxx.server.param.ProductParam;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.ICommodityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zjr
 * @since 2023-05-03
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private ICommodityService commodityService;
    @ApiOperation(value = "查看所有商品信息")
    @GetMapping("/eight-products")
    public List<ProductParam> getAllProducts(@RequestParam(value = "page") Integer page){
        return commodityService.getAllProducts(page);
    }
    @ApiOperation(value = "查看所有商品数量")
    @GetMapping("/num")
    public Integer getNumProducts(){
        return commodityService.getNumProducts();
    }
}
