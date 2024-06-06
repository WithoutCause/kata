package me.sjl.controller;

import me.sjl.entity.MemberEntity;
import me.sjl.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloController {

    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping("/hello")
    public ResponseEntity<?> hello() throws InterruptedException {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println("线程暂时间:" + i);
        TimeUnit.SECONDS.sleep(i);
        return ResponseEntity.ok("Hello, World!"); // 200 OK
    }

    @RequestMapping("/findById")
    public ResponseEntity<?> findById(String id) {
        MemberEntity memberEntity = memberMapper.selectById(id);
        return ResponseEntity.ok(memberEntity);
    }
}
