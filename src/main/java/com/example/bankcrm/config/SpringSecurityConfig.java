package com.example.bankcrm.config;


import com.example.bankcrm.Enum.Position;
import com.example.bankcrm.security.EmployeeDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmployeeDetailsImpl employeeDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin()
                .and().logout()
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").permitAll()
                .antMatchers(HttpMethod.GET,"/addCustomer").permitAll()
                .antMatchers(HttpMethod.POST,"/addCustomer").permitAll()
                .antMatchers(HttpMethod.GET,"/addAddress").permitAll()
                .antMatchers(HttpMethod.POST,"/addAddress").permitAll()
                .antMatchers(HttpMethod.GET,"/branch/add").permitAll()
                .antMatchers(HttpMethod.POST,"/branch/add").permitAll()
                .antMatchers(HttpMethod.GET,"/customers").permitAll()
                .antMatchers(HttpMethod.POST,"/customers").permitAll()
                .antMatchers(HttpMethod.GET,"/employees").permitAll()
                .antMatchers(HttpMethod.POST,"/employees").permitAll()
                .antMatchers(HttpMethod.POST,"/addEmployee").permitAll()
                .antMatchers(HttpMethod.GET,"/addEmployee").permitAll()
                 .anyRequest().authenticated();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeDetails)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
