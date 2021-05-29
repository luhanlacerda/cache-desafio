package lacerda.luhan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UserApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		int vale = digitoUnicoService.calcularDigitoUnico("1010",2);
//		System.out.println(vale);
    }
}
