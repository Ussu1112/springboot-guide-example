package com.springboot.api3.controller;

import com.springboot.api3.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //4.3 버전 이후부터는 각각 지정해서 사용 (ex. RequestMapping -> GetMapping)
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping(value = "/hello")
    public String getHello(){
        LOGGER.info("getHello 메서드가 호출 되었습니다.");
        return "Get Hello!";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    //localhost:8081/api/v1/get-api/variable2/test333
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    //localhost:8081/api/v1/get-api/request1?name=val1&email=val2&organization=val3
    /*
    @GetMapping(value = "/request1")
    public String getRequest1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return name + email + organization;
    }
     */
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
        @ApiParam(value = "이름", required = true) @RequestParam String name,
        @ApiParam(value = "이메일", required = true) @RequestParam String email,
        @ApiParam(value = "회사", required = true) @RequestParam String organization){
        return name + " " + email + " " + organization;
    }



    //쿼리 스트링이 일정하지 않는경우 (필수값이 없는경우) Map 객체로 받는게 안정적
    //GET http://localhost:8081/api/v1/get-api/request2?name=val1&email=val2
    @GetMapping(value = "/request2")
    public String getRequest2(@RequestParam Map<String, String> param){
        StringBuilder stringBuilder = new StringBuilder();

        param.entrySet().forEach(map -> {
            stringBuilder.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return stringBuilder.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
