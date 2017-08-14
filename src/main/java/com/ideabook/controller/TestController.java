package com.ideabook.controller;

import com.ideabook.dao.BlackIpMapper;
import com.ideabook.entity.BlackIp;
import com.ideabook.util.IPAddressUtil;
import com.ideabook.util.result.BaseResp;
import com.ideabook.util.result.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: lzh
 * @Description:  1、mysql_mybatis demo,并整合阿里云的druid监控功能
 *                2、swagger 在线文档
 *                3、养成返回完整数据{访问状态 + 返回参数}的习惯
 *                4、系统异常捕获
 *                5、系统日志模块
 * @Date: Created in 2017/7/25 18:19
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private BlackIpMapper blackIpMapper;

    @Autowired
    public TestController(BlackIpMapper blackIpMapper) {
        this.blackIpMapper = blackIpMapper;
    }

    @RequestMapping("/addIp")
    public BaseResp<String> addIps(HttpServletRequest request){
        String ip = IPAddressUtil.getClientIpAddress(request);
        BlackIp newIp = new BlackIp();
            newIp.setIp(ip);
            newIp.setIpTime(new Date());
        return new BaseResp(ResultStatus.SUCCESS,blackIpMapper.insert(newIp));
    }

}
