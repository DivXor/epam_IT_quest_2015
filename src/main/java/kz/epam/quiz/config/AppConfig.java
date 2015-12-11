package kz.epam.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AuthSuccessHandler getAuthSuccessHandler(){
        return new AuthSuccessHandler();
    }

}
