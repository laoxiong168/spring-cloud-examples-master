package com.neo.controller;

import com.neo.dto.PayWithdrawRecordDTO;
import com.neo.remote.HelloRemote;
import com.neo.remote.InsertFeignService;
import com.neo.util.RqRsUtil;
import com.xhg.core.web.vo.RequestBean;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloRemote HelloRemote;
    @Autowired
    InsertFeignService insertFeignService;

    @RequestMapping("/hello/{name}")
    public   Map<String,Object> index(@PathVariable("name") String name) {
        PayWithdrawRecordDTO requestData=new PayWithdrawRecordDTO();
        requestData.setAccountsReceivable("31");
        requestData.setCheckRemark("2");
        RequestBean<PayWithdrawRecordDTO> requestBean = RqRsUtil.getRequestBean(requestData);
        String content="hello";
        Map<String,Object> resultMap=new HashMap<>();
        String globleStr="";


        try {
           insertFeignService.insert(requestBean);
           insertFeignService.feignInsert("customer");
            String randomStr=generatorRandom3();
            System.out.println(randomStr);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(globleStr);
            throw e;
        }
        return resultMap;

    }


    private String generatorRandom3(){
        return null;
    }

}