package com.springboot.api3.controller;

import com.springboot.api3.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @PostMapping(value = "/domain")
    public String postExample(){
        return "Post Api";
    }

    @PostMapping(value = "/member")
    public String PostMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();

    }

    @PostMapping(value = "/member2")
    public String PostMemberDto(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }
}
