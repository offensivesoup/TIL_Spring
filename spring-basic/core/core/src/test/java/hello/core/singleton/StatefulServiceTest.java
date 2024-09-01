package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자가 10000원을 주문
        int price1 = statefulService1.order("userA", 10000);
        // ThreadB : B사용자가 20000원을 주문
        int price2 = statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A가 주문 금액을 조회한다.
        Assertions.assertThat(price1).isEqualTo(10000);
        Assertions.assertThat(price2).isEqualTo(20000);
        Assertions.assertThat(price1).isNotSameAs(price2);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}