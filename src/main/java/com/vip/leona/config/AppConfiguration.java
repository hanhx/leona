package com.vip.leona.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class AppConfiguration {
    /**
     * swagger文档生成配置
     * @return
     */
    @SuppressWarnings("unchecked")
    @Bean
    public Docket rpcApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("rpcapi").genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false).forCodeGeneration(true).pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select().paths(or(regex("/.*")))// 过滤的接口
                .build().apiInfo(rpcApiInfo());
    }

    private ApiInfo rpcApiInfo() {
        return new ApiInfo("leona api", // 大标题
                "LEONA's REST API", // 小标题
                "1.0.0", // 版本
                "NO terms of service", new Contact("hyson.han", "", ""), // 作者
                "", // 链接显示文字
                ""// 网站链接
        );
    }
}
