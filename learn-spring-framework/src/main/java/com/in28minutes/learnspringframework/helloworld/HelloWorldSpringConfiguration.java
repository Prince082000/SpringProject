package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//eliminate verbosity in creating java beans 
//public accessor methods,constructor
//equals ,hascode and toString are automatically created.
//Released in Jdk 16.

record Person(String name, int age,Address address) {
};

record Address(String address) {
};

@Configuration
public class HelloWorldSpringConfiguration {

	@Bean
	public String name() {
		return "Ranga";
	}

	@Bean
	public int age() {
		return 15;
	}

	@Bean
	public Person person() {
		return new Person("Prince",20, new Address("UttarPradesh") );
	}
		//creating a new bean with a relationship to a existing bean
	@Bean
	public Person person2methodcall() {
		return new Person(name(), age(),address()); // name,age
	}
    //alternate of person bean
	@Bean
	public Person person3Perameter(String name,int age,Address address3) {
		return new Person(name,age,address3); // name,age
	}
	
	@Bean
	@Primary
	public Person person4Perameter(String name,int age,Address address) {
		return new Person(name,age,address); // name,age
	}
	
	@Bean
	public Person person5Qualifier(String name,int age,@Qualifier("add3qualifier") Address address) {
		return new Person(name,age,address); // name,age
	}
	
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Banglore");
	}
	
	
	@Bean
	@Qualifier("add3qualifier")
	public Address address3() {
		return new Address("US");
	}
}
