package com.asynch.talix;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = "com.asynch.talix")
public class AppConfig extends WebMvcConfigurerAdapter{

	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	
	@Bean(name = "asynchExecutor")
    public Executor asyncExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsynchThread-");
        executor.initialize();
        return executor;
    }
	
/*	@Bean(name = "asynExecutor")
    public Executor asynExecutor()
    {
        ThreadPoolTaskExecutor executor1 = new ThreadPoolTaskExecutor();
        executor1.setCorePoolSize(2);
        executor1.setMaxPoolSize(2);
        executor1.setQueueCapacity(100);
        executor1.setThreadNamePrefix("AsynThread-");
        executor1.initialize();
        return executor1;
    }*/
	
	 @Bean
	    public Executor taskExecutor() {
	        return new SimpleAsyncTaskExecutor();
	    }
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
