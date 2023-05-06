package com.zcxy.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MyFastGeneratorConfiguration {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://192.168.121.141:3306/Psyche?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true"
                , "root", "123456")
                .globalConfig(builder -> {
                    builder.author("suhe") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\temp"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com") // 设置父包名
                            .moduleName("zcxy.psyche") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml,
                                    "E:\\temp")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("UserCollectKnowledge");


                    // 设置需要生成的表名
                    //.addTablePrefix("act_fo_")
                    ; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模 板，默认的是Velocity引擎模板
                .execute();
    }
}
