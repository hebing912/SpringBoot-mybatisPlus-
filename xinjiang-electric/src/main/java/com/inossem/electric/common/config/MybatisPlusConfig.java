package com.inossem.electric.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author fuhk
 * @Description 分页插件
 * @Date 2019/3/27 14:07
 * @Param
 * @return
 * @Version: 1.0
*/
@EnableTransactionManagement
@Configuration
@MapperScan("com.inossem.electric.modules.*.dao")
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
