package es.upgrade.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.upgrade.modelo.entidad.Munion;
 // JpaRepository <(QUE CLASE SE VA A USAR COMO ENTIDAD) , (DE QUE TIPO ES SU ID)>
@Repository
public interface MunionDao extends JpaRepository<Munion, Integer> {
	// Este objeto en el contexto de Spring se llama -> "munionDao"

}
