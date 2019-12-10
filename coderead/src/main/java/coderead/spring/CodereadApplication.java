package coderead.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("coderead.spring.mybaits.mapper")
@EnableCaching
public class CodereadApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodereadApplication.class, args);
    }

}
