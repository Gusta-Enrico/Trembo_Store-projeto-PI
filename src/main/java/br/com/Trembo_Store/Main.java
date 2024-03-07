package br.com.Trembo_Store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }
    @Bean
    public CommandLineRunner iniciando(){
        return args -> {
            System.out.println("Hello Word");
        };

    }
    }



