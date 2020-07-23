package com.inossem.electric;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.inossem.electric.modules.*.dao")
public class XinjiangElectricApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinjiangElectricApplication.class, args);
    }

}
