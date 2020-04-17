package com.example.secdemo.utils;

import com.example.secdemo.model.dto.LoginUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author sharplee
 * @version 1.0.0
 * @ClassName com.example.secdemo.utils.UserUtil
 * @Description
 * @createTime 2020/1/6
 */
public class UserUtil {

    public static LoginUser getLoginUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return (LoginUser) authentication.getPrincipal();
            }

            if (authentication instanceof RememberMeAuthenticationToken) {
                System.out.println("RememberMeAuthenticationToken");
                return (LoginUser) authentication.getPrincipal();
            }
        }

        return null;
    }


    /**
     * 生成随机盐
     */
    public static String randomSalt() {

        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        String hex ="ruoyi";
//        try {
//            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
//            hex = new String(random.generateSeed(8));
//        }catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }
        return hex;
    }

    public static void main(String[] args) {
        System.out.println(randomSalt());
        String password ="admin";
        System.out.println(new BCryptPasswordEncoder().encode(password));
    }
}
