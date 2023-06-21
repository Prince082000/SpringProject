package com.in28minutes.learnspringframework.examples.g1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
//in jakarta CDI @Component replaced by @Named and @Autowired replaced by @Inject
@Named
class BusinessService{
	private DataService dataService;

	
    //@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}

	
	
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

	
	public static void main(String[] args) {
		
		
		try(var context=
				new AnnotationConfigApplicationContext
				        (CdiContextLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		   System.out.println(context.getBean(BusinessService.class).getDataService());
		}

	}

}
