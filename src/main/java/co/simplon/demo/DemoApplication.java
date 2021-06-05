package co.simplon.demo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
        System.err.println("!!!!!");
		testJPA();
		System.err.println("!!!!!");
		SpringApplication.run(DemoApplication.class, args);
	}
	public static void testJDBC(){
		CityDaoJDBC testDao= new CityDaoJDBC();
		System.out.println(testDao.findOne(10));
	}
public static void testJPA(){
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa");
	EntityManager entityManager = factory.createEntityManager();
	co.simplon.demo.model.City city = entityManager.find(co.simplon.demo.model.City.class, 10L);
	System.err.println(city);
	co.simplon.demo.model.City city2= new co.simplon.demo.model.City("Atlantis", 0, 0.5);
	System.out.println(city2);
	entityManager.getTransaction().begin();

	entityManager.persist(city2);
	System.out.println(city2);

	entityManager.getTransaction().commit();
	System.out.println(city2);

	entityManager.close();

}
}
