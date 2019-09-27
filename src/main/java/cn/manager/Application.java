package cn.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@SpringBootApplication
@MapperScan("cn.manager.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
