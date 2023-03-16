package com.springboot.api3.controller;

import com.springboot.api3.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    //PUT http://localhost:8081/api/v1/put-api/member1
    //MemberDto{name='val1', email='val2', organization='val333'}
    //Content-Type: text/plain; -> 일반 문자열로만 전달
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    //PUT http://localhost:8081/api/v1/put-api/member2
    //    {
    //        "name": "val1",
    //            "email": "val2",
    //            "organization": "val333"
    //    }
    //
    //Content-Type: application/json -> json 형태로 전달
    //어노테이션이 지정된 클래스는 @RequestBody 생략가능 -> @RequestBody 는 자동으로 값을 JSON형식으로 변환하여 전달
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }

    //PUT http://localhost:8081/api/v1/put-api/member3
    //HTTP/1.1 202  응답값이 HttpStatus.ACCEPTED 202번으로 변경된다
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }

}
