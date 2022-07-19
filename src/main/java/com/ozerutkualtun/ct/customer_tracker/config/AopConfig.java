package com.ozerutkualtun.ct.customer_tracker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.ozerutkualtun.ct.customer_tracker")
public class AopConfig {

}
