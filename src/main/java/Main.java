import config.WebConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.impl.MiniTwitterService;


@Configuration
@ComponentScan()
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        new WebConfig(ctx.getBean(MiniTwitterService.class));
        ctx.registerShutdownHook();

    }
}
