package com.neo.remote;

import com.neo.dto.PayWithdrawRecordDTO;
import com.xhg.core.web.vo.RequestBean;
import com.xhg.core.web.vo.ResponseBean;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/11.r
 */
@FeignClient(name= "xhg-provider")
@RequestMapping("/sorting/API")
public interface InsertFeignService {

    @RequestMapping(value = "/insert")
//    public ResponseBean<String> insert(@RequestBody  RequestBean<PayWithdrawRecordDTO> requestBean);
    public String insert(@RequestBody  RequestBean<PayWithdrawRecordDTO> requestBean);
    @RequestMapping(value = "/feignInsert")
    public Map<String,Object> feignInsert(@RequestParam("str") String str);


}
