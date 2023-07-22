package com.example.springdataadvancedqueringexercise.Configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
