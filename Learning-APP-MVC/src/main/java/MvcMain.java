import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@ComponentScan({"org.learning.controller","org.learning.service"})
public class MvcMain {

    public static void main(String[] args) {
        SpringApplication.run(MvcMain.class,args);
    }


}
