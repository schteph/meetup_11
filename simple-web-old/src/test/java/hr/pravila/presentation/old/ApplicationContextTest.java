package hr.pravila.presentation.old;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/hr/pravila/presentation/context/application-ctx.xml");
        System.out.println(ctx);
    }
}
