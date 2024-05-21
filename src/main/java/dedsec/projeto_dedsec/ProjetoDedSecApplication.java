package dedsec.projeto_dedsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "dedsec.projeto_dedsec.domain")
@EntityScan(basePackages = "dedsec.projeto_dedsec.domain")
@ComponentScan(basePackages = {"dedsec.projeto_dedsec.domain", "dedsec.projeto_dedsec.controller"})
public class ProjetoDedSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDedSecApplication.class, args);
	}

}
