package com.ideabook.controller;

import com.ideabook.entity.Address;
import com.ideabook.util.result.BaseResp;
import com.ideabook.util.result.ResultStatus;
import io.swagger.annotations.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzh
 * @Description: swaggerAPI :  127.0.0.1:8080/swagger-ui.html
 * @Date: Created in 2017/8/1 11:33
 */
@RestController
@RequestMapping("/api")
@Api(value = "api",description = "TestSwaggerApiController 测试swagger在线文档") // Swagger UI 对应api的标题描述
public class TestSwaggerApiController {

    @ApiOperation("获取传入的地址信息") // 单个接口的描述
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="province",dataType="String",required=true,value="省",defaultValue="广东省"),// 每个参数的类型，名称，数据类型，是否校验，描述，默认值(这些在界面上有展示)
            @ApiImplicitParam(paramType="query",name="area",dataType="String",required=true,value="地区",defaultValue="南山区"),
            @ApiImplicitParam(paramType="query",name="street",dataType="String",required=true,value="街道",defaultValue="桃园路"),
            @ApiImplicitParam(paramType="query",name="num",dataType="String",required=true,value="门牌号",defaultValue="666")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"), // 响应对应编码的描述
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/address",method = RequestMethod.POST)
    public BaseResp<Address> getAddressInfo(@RequestParam(value = "province")String province,
                                            @RequestParam(value = "area")String area,
                                            @RequestParam(value = "street")String street,
                                            @RequestParam(value = "num")String num){

        if(StringUtils.isEmpty(province)||StringUtils.isEmpty(area)||StringUtils.isEmpty(street)||StringUtils.isEmpty(num)){
            return new BaseResp(ResultStatus.error_invalid_argument);
        }
        Address address = new Address();
        address.setProvince(province);
        address.setArea(area);
        address.setStreet(street);
        address.setNum(num);
        return new BaseResp(ResultStatus.SUCCESS,address);
    }

    @ApiOperation("获取地址信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query",name="province",dataType="String",required=true,value="省",defaultValue="广东省"),
            @ApiImplicitParam(paramType="query",name="area",dataType="String",required=true,value="地区",defaultValue="南山区"),
            @ApiImplicitParam(paramType="query",name="street",dataType="String",required=true,value="街道",defaultValue="桃园路"),
            @ApiImplicitParam(paramType="query",name="num",dataType="String",required=true,value="门牌号",defaultValue="666")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/address/list",method = RequestMethod.POST)
    public BaseResp<List<Address>> getAddressList(@RequestParam(value = "province")String province,
                                                  @RequestParam(value = "area")String area,
                                                  @RequestParam(value = "street")String street,
                                                  @RequestParam(value = "num" )String num){

        if(StringUtils.isEmpty(province)||StringUtils.isEmpty(area)||StringUtils.isEmpty(street)||StringUtils.isEmpty(num)){
            return new BaseResp(ResultStatus.error_invalid_argument);
        }
        Address address = new Address();
        address.setProvince(province);
        address.setArea(area);
        address.setStreet(street);
        address.setNum(num);
        List<Address> lists = new ArrayList<>();
        lists.add(address);
        lists.add(address);
        lists.add(address);
        return new BaseResp(ResultStatus.SUCCESS,lists);
    }

    @ApiOperation("获取地址信息(路径传参)")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="path",name="area",dataType="String",required=true,value="区域",defaultValue="南山区"),
            @ApiImplicitParam(paramType="path",name="number",dataType="String",required=true,value="门牌号",defaultValue="9527")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/address/{area}/{number}",method = RequestMethod.GET)
    public BaseResp<String> getAddress(@PathVariable("area")String area,@PathVariable("number")String number){
        Address address = new Address();
        address.setProvince("广东省");
        address.setArea(area);
        address.setStreet("桃园街道");
        address.setNum(number);
        return new BaseResp(ResultStatus.SUCCESS,address.toString());
    }

}
