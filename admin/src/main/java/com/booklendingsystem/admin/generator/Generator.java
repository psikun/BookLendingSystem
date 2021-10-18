package com.booklendingsystem.admin.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author SiKun
 * @date 2021/10/18/ 20:35
 */

public class Generator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/booklendingsystem", "root", "sikun")
                .globalConfig(builder -> {
                    builder.author("SiKun") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://Projects//Mine//BookLendingSystem//admin//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.booklendingsystem.admin.generator") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E://Projects//Mine//BookLendingSystem//admin//src//main//java")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("books_book_info").addTablePrefix("books_"); // 设置过滤表前缀; // 设置需要生成的表名
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板
                .execute();
    }
}
