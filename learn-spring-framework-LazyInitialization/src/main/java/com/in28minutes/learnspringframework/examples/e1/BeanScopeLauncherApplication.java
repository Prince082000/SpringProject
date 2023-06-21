package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//basically, whenever you asked for a bean the same instance would be returned back
@Component
class NormalClass{
	
}
//every time you asked for bean from spring container ,it would create a new instance of that specific.
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ProtoTypeClass{
		
	
}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

	
	public static void main(String[] args) {
		
		
		try(var context=
				new AnnotationConfigApplicationContext
				        (BeanScopeLauncherApplication.class)){
			
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			 System.out.println(context.getBean(NormalClass.class));
			 System.out.println(context.getBean(NormalClass.class));
			 System.out.println(context.getBean(NormalClass.class));
			
		   System.out.println(context.getBean(ProtoTypeClass.class));
		   System.out.println(context.getBean(ProtoTypeClass.class));
		   System.out.println(context.getBean(ProtoTypeClass.class));
		   System.out.println(context.getBean(ProtoTypeClass.class));
		}

	}

}
