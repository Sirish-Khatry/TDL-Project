package com.qa.tdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.tdl.TdlJavaApplication;

@SpringBootApplication
public class TdlJavaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TdlJavaApplication.class, args);
	}

}
