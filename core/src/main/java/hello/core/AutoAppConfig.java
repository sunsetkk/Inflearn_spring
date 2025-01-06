package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // basePackages: 탐색할 패키지의 시작 위치를 지정    지정하지 않으면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치
        //basePackages = "hello.core.member",
        // ComponentScan을 사용하면 @Configuration이 붙은 설정 정보도 자동으로 등록됨
        // excludeFilters 를 이용해 Appconfig, TestConfig 등 앞서 만든 설정 정보가 함께 등록되지 않도록 방지,
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
