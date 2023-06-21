package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class A{
	
}
//lazy annotaion is indiacte the weather the bean is to be lazily initialized.
// you can use it lazy on any class which uses @component or any method which is annotated with @bean
@Component
@Lazy
class B{
	A classA;	
	public B(A classA) {
		//logic
		//after the all initialization is completed the bean is loaded
		System.out.println("Some Initialization");
		this.classA=classA;
	}
	public void doSomething()
	{
		System.out.println("Do Something");
		}
	}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

	
	public static void main(String[] args) {
		
		
		try(var context=
				new AnnotationConfigApplicationContext
				        (LazyInitializationLauncherApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		   context.getBean(B.class).doSomething();
		}

	}

}
