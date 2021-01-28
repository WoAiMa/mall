package com.demo.malls2basic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 */
@Configuration
@MapperScan("com.demo.malls1basic.mbg.mapper")
public class MybatisConfig {

}
