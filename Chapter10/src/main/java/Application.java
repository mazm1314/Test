import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("course.com")   //扫描哪个包下的类
public class Application {
    public static void main(String[] args) throws Exception {
//        这里调用我这个HelloController(类名).class文件
        SpringApplication.run(Application.class, args);
    }
}
