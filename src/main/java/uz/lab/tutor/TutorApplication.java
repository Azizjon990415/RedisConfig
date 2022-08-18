package uz.lab.tutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class TutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutorApplication.class, args);
    }

}
