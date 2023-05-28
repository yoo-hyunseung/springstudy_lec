package hello.hellospring;
// 패키지 하위 어노테이션을 자동으로 탐색 패키지 외부파일은 탐색하지 않는다. component scan 대상
import hello.hellospring.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
