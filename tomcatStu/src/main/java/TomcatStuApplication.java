import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.yc.fen")
@SpringBootApplication
public class TomcatStuApplication {
	public static void main(String[] args) {
		SpringApplication.run(TomcatStuApplication.class, args);
	}
}
