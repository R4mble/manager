package cn.manager.util;

import org.springframework.util.Base64Utils;

import java.util.Arrays;
import java.util.Base64;

/**
 * @author Wangyl
 * @date 2019/9/27
 */
public class Base64Util {

    public static void main(String[] args) {
        String ph = "/ˌəuvəˈhwelmiŋ/";
        System.out.println(ph);
        String en1 = Base64.getEncoder().encodeToString(ph.getBytes());

        String de1 = new String(Base64.getDecoder().decode(en1));

        System.out.println(en1);
        System.out.println(de1);

    }
}
