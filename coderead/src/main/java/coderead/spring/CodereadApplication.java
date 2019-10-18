package coderead.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("coderead.spring.mybaits.mapper")
public class CodereadApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodereadApplication.class, args);
    }

}
