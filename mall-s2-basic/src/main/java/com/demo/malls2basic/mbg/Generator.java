package com.demo.malls2basic.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 */
public class Generator {
    public static void main(String[] args) throws  Exception {

        // mbg告警信息
        List<String> warnings = new ArrayList<>();
        // 生成代码重读时，覆盖原代码
        boolean overwrite = true;
        // 读取配置文件
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        // 创建mbg。生成代码
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator generator = new MyBatisGenerator(config,callback,warnings);
        generator.generate(null);
        // 输出警告
        for (String warn : warnings){
            System.out.println(warn);
        }

    }
}
