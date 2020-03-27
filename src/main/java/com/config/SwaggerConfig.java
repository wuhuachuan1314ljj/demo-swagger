package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * ClassName: SwaggerConfig
 * Package: com.config
 * Date: 2020/3/27 15:27
 * Author; 吴华川
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        // 设置要显示swagger的环境(当在dev,test环境下时显示swagger)
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是否处于该环境
        // 通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);
        return new Docket(DocumentationType.SWAGGER_2)
                //设置参数忽略
                .ignoredParameterTypes(HttpSession.class)
                //设置swagger开关
                .enable(b)
                .apiInfo(apiInfo())
                .select()
                //配置扫描接口的路径(写到controller的包名)
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("吴华川", "http//:www.hellocoders.cn", "1667546435@qq.com");
        return new ApiInfo(
                "swagger学习文档",//标题
                "这是学习swagger生成的文档信息", //描述
                "v1.0.0",//版本
                "http//:www.hellocoders.cn", //组织链接
                contact, //联系人信息
                "Apach 2.0 许可",//许可
                "http//:www.hellocoders.cn",//许可链接
                new ArrayList<>()// 扩展
        );
    }

}
