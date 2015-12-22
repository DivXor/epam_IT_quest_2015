package kz.epam.quiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("Team1").password("password").roles("USER").and()
                .withUser("Team2").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/quest/**").hasRole("USER")
                .antMatchers("/task/**").hasRole("USER")
                .antMatchers("/maze/**").hasRole("USER")
                .antMatchers("/grammar/**").hasRole("USER")
                .antMatchers("/wordsearch/**").hasRole("USER")
                .antMatchers("/excess_image/**").hasRole("USER");
        http
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/").successHandler(authSuccessHandler)
                .failureUrl("/login-error")
                .permitAll();

    }
}
