package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }


    static class TestBean {

        @Autowired(required = false)    // 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member) {   // 자동 주입할 대상이 없으면 null이 입력
            System.out.println("setNoBean2 = " + member);
        }

        @Autowired
        public void setNoBean3(Optional<Member> member) {   // 자동 주입할 대상이 없으면 Optional.empty 입력
            System.out.println("setNoBean3 = " + member);
        }


    }
}
