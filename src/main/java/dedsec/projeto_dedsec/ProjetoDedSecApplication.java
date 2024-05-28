package dedsec.projeto_dedsec;

import dedsec.projeto_dedsec.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@EnableJpaRepositories(basePackages = "dedsec.projeto_dedsec.domain")
@EntityScan(basePackages = "dedsec.projeto_dedsec.domain")
@ComponentScan(basePackages = {"dedsec.projeto_dedsec.domain", "dedsec.projeto_dedsec.controller", "dedsec.projeto_dedsec.security"})
@SpringBootApplication
public class ProjetoDedSecApplication{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDedSecApplication.class, args);
	}

}