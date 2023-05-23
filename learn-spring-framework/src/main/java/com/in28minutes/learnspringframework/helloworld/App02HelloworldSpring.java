package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PackmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App02HelloworldSpring {

	public static void main(String[] args) {
		// Launch spring context

		try (var context = 
				new AnnotationConfigApplicationContext
				         (HelloWorldSpringConfiguration.class)) {
			
			// configure the things that we want spring to manage -@configuration
			// HelloWorldConfiguration --@Configuration
			// name - @Bean

			// Retrieving bean manage by the spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2methodcall"));
			System.out.println(context.getBean("person3Perameter"));

			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean(Address.class));

			System.out.println(context.getBean("address2"));
			System.out.println(context.getBean("address3"));

			System.out.println(context.getBean("person5Qualifier"));

			// for bean count and get all bean name
			// System.out.println(context.getBeanDefinitionCount());
			// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}

	}

}
