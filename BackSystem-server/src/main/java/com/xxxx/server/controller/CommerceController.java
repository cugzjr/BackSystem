package com.xxxx.server.controller;


import com.xxxx.server.param.CommerceParam;
import com.xxxx.server.pojo.Commerce;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.ICommerceService;
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
@RequestMapping("/commerce")
public class CommerceController {
    @Autowired
    private ICommerceService commerceService;
    @ApiOperation(value = "查看所有交易信息")
    @GetMapping("/eight-commerces")
    public List<CommerceParam> getAllCommerces(@RequestParam(value = "page") Integer page){
        return commerceService.getAllCommerces(page);
    }

    @ApiOperation(value = "查看所有交易信息数量")
    @GetMapping("/num")
    public Integer getNumCommerces(){
        return commerceService.getNumCommerces();
    }
}
