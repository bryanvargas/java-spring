package com.shingo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// obtiene el archivo de configuracion de xml
		ApplicationContext applicacionContext = new ClassPathXmlApplicationContext("spring.config.xml");

		Administrador administrador = (Administrador) applicacionContext.getBean("admin");

		System.out.println(administrador);
		
		// administrador.imprimirDireccion()

		((ClassPathXmlApplicationContext) applicacionContext).close();
	}

}
