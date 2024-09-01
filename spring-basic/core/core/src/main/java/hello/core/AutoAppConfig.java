package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 지정하지 않으면 컴포넌트 스캔이 붙은 클래스의 패키지가 시작점이 된다.
// 설정정보를 프로젝트의 최상단에 둔다.
@ComponentScan(
        basePackages  = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // AppConfig를 유지하기 위해 추가 (Configuration Annotation이 붙은걸 제외시킨다.)
public class AutoAppConfig {
    // @Bean으로 등록한 클래스가 하나도 없다.
}
