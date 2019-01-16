/*
package co.simplon.livrokaz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@EnableWebSecurity
public class InMemoryWebSecurity extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		System.out.println(bcrypt.encode("simplon"));
	}

  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication()
		.withUser("user").password("{noop}simplon").roles("USER")
		.and()
		.withUser("developper").password("{noop}simplon").roles("DEVELOPPER")
		.and()
		.withUser("manager").password("{noop}simplon").roles("MANAGER")
		.and()
		.withUser("admin").password("{bcrypt}$2a$10$OhwFVfhBW0Rv2TUtS4UFSOtvMFbGnPPEFkFcKnXif9bBAfWFnKm16").roles("ADMIN");
}


  @Override
  protected void configure(HttpSecurity http) throws Exception {
	 
	  http.csrf().disable().authorizeRequests()
	  
	    .antMatchers(HttpMethod.POST, "/**").permitAll().and();
	    
	  
	
  }
}
*/