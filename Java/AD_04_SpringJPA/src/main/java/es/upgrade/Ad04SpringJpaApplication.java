package es.upgrade;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import es.upgrade.modelo.entidad.Munion;
import es.upgrade.modelo.persistencia.MunionDao;

@SpringBootApplication
public class Ad04SpringJpaApplication {
	
	// Importante mencionar que si no le pones ninguna base de datos este te creara
	// virtualmente una base de datos en memoria para las pruebas, aunque esta
	// obviamente no persistira tras reinicios

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Ad04SpringJpaApplication.class, args);
		
		MunionDao mdao = context.getBean("munionDao", MunionDao.class);
		Munion m = new Munion();
		m.setNombre("Bulbasaur");
		m.setPuntosVida(20);
		m.setTipo("Planta");
		
		mdao.save(m);
		
		Optional<Munion> optional = mdao.findById(1);
		if(optional.isPresent()) {
			Munion m2 = optional.get();
			System.out.println(m2);
		}
		
	}

}
