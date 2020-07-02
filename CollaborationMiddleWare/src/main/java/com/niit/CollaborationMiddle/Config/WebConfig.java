package com.niit.CollaborationMiddle.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.niit")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter
{


}
