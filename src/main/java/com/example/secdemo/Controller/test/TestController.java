package com.example.secdemo.Controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.Controller.test.TestController
 * @Description
 * @createTime 2020/1/13
 */
@Controller
@RequestMapping("/test")
public class TestController  {

    private final static String prefix = "/test";

    @RequestMapping(value = "/t1",method = RequestMethod.GET)
    public String test(){
        return prefix+"/t1";
    }

    @RequestMapping(value = "/t1",method = RequestMethod.POST)
    public void t1(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile file) throws IOException {
        //File file1 = new File("test.txt");
        String path="f:\\web\\";
        try {
            //写入到磁盘中
            file.transferTo(new File(path,file.getOriginalFilename()));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        res.getWriter().write("success");
    }
}
