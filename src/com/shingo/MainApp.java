package com.shingo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.shingo.dao.AdminDao;
import com.shingo.pojo.Admin;

public class MainApp {
	public static void main(String[] args) {
		// obtiene el archivo de configuracion de xml
		ApplicationContext applicacionContext = new ClassPathXmlApplicationContext("spring.config.xml");

		// AdministradorPrueba administrador = (AdministradorPrueba)
		// applicacionContext.getBean("admin");
		// System.out.println(administrador);
		// administrador.imprimirDireccion()

		AdminDao adminDao = (AdminDao) applicacionContext.getBean("adminDao");

		Timestamp ts = new Timestamp(new Date().getTime());

//		Admin admin = new Admin();
//		admin.setNombre("Martin");
//		admin.setFechaCreacion(ts);
//		admin.setCargo("Developer Mobil");

		try {
//			adminDao.save(admin);
//			List<Admin> admins = adminDao.findAll();
//			for (Admin admin2 : admins) {
//				System.out.println(admin2);
//			}			
//			System.out.println("Busqueda por nombre: " + adminDao.findByNombre("a"));
//			System.out.println("Busqueda por Id o Nombre" + adminDao.finByIdNombre(2, "Josue"));
//			System.out.println("Busqueda por Id" + adminDao.findById(3));
//			System.out.println("Busqueda por Nombre" + adminDao.findByNombre("Bryan"));
//			Admin a = adminDao.findById(6);
//			a.setCargo("Developer Android");
//			a.setNombre("Emmanuel");
//			a.setFechaCreacion(new Timestamp(new Date().getTime()));
//			if (adminDao.update(a))
//				System.out.println("Se ha Actualizado conrrectacment");
			
			List<Admin> admins = new ArrayList<Admin>();
			admins.add(new Admin(16, "Victoria", "Representante Legal", ts));
			admins.add(new Admin(17, "Miguel", "Subjefe de Ingenieria", ts));
			admins.add(new Admin(13, "Julian", "Jefe de Ingenieria", ts));
			
			int[] vals = adminDao.saveAll(admins);
			for (int i : vals ) {
				System.out.println("Filas afectadas para esta operacion: " + i);
			}
						
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Error Cannot: " + ex);
		} catch (DataAccessException ex) {
			System.out.println("Error Cannot: " + ex);
		}

		((ClassPathXmlApplicationContext) applicacionContext).close();
	}

}
