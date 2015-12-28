package kz.epam.quiz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static kz.epam.quiz.entity.enums.UserRoleEnum.ADMIN;
import static kz.epam.quiz.entity.enums.UserRoleEnum.USER;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("Team1").password("fatwhale16").roles(USER.name()).and()
                .withUser("Team2").password("jollywolf88").roles(USER.name()).and()
                .withUser("admin").password("itquest2015").roles(USER.name(), ADMIN.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasRole(ADMIN.name())
                .antMatchers("/maze", "/grammar", "/wordsearch", "/excess_image", "/association").hasRole(ADMIN.name())
                .antMatchers("/task/**").hasRole(USER.name());
        http
                .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/").successHandler(authSuccessHandler)
                .failureUrl("/login-error")
                .permitAll()
                .and()
                .logout();
    }
}
