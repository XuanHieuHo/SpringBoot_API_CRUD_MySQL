package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EntityScan(basePackageClasses = FinalWebSpringBootApiMySqlCrudApplication.class)
@EnableJpaAuditing
public class FinalWebSpringBootApiMySqlCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalWebSpringBootApiMySqlCrudApplication.class, args);
	}

}
