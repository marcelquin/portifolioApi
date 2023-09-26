package baseAPI.API;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Portifólio API", version = "1", description = "API de manipulação de dados a ser consumida pelo portifólio angular"))
@SpringBootApplication
public class ApiApplication {



	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


}
