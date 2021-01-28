package com.demo.malls2basic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis配置类
 */
@Configuration
@MapperScan({"com.demo.malls2basic.mbg.mapper","com.demo.malls2basic.dao"})
public class MybatisConfig {

}
