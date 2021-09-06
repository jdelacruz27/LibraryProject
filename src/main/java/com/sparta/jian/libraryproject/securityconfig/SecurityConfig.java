package com.sparta.jian.libraryproject.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;
    private BCryptPasswordEncoder encoder;

    @Autowired
    private CustomLoginSuccessHandler successHandler;

    @Autowired
    public SecurityConfig(DataSource dataSource, BCryptPasswordEncoder encoder) {
        this.dataSource = dataSource;
        this.encoder = encoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT user_name, user_password, user_enabled FROM user_entity where user_name=?")
                .authoritiesByUsernameQuery("SELECT user_name,user_role FROM user_entity WHERE user_name=?")
                .passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/welcomeAdmin").hasAuthority("ADMIN")
                .antMatchers("/bookPage").hasAuthority("ADMIN")
                .antMatchers("/authorPage").hasAnyAuthority("ADMIN")
                .antMatchers("/genrePage").hasAnyAuthority("ADMIN")
                .antMatchers("/addAuthor").hasAnyAuthority("ADMIN")
                .antMatchers("/addBook").hasAnyAuthority("ADMIN")
                .antMatchers("/addGenre").hasAnyAuthority("ADMIN")
                .antMatchers("/editAuthor").hasAnyAuthority("ADMIN")
                .antMatchers("/editGenre").hasAnyAuthority("ADMIN")
                .antMatchers("/editBook").hasAnyAuthority("ADMIN")
                .antMatchers("/welcomeUser").hasAuthority("USER")


                .anyRequest().authenticated()

                .and().formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(successHandler)
                .and().exceptionHandling().accessDeniedPage("/accessDenied")
                .and().logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies());

    }
}
