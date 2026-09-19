package in.bean.day01springbootcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
// Exclude isiliye use hua kyunki maine sql driver add kiya dependency me jo mujhe nhi cahhiye abbhi
//so i exclude this
public class Day01SpringbootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day01SpringbootCrudApplication.class, args);

        System.out.println("Hello World");
    }
}
