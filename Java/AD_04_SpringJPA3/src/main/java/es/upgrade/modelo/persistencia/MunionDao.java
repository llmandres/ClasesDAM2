package es.upgrade.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.upgrade.modelo.entidad.Munion;
 // JpaRepository <(QUE CLASE SE VA A USAR COMO ENTIDAD) , (DE QUE TIPO ES SU ID)>
@Repository
public interface MunionDao extends JpaRepository<Munion, Integer> {
	// Este objeto en el contexto de Spring se llama -> "munionDao"
	
	// Tienes que seguir la convencion de los metodos y se hace automaticamente.
	
	public List<Munion> findByPuntosVida(int puntosVida);
	public Munion findByNombre(String nombre);
	public Munion findByNombreContains(String nombre);
	public Munion findByNombreAndTipo(String nombre, String tipo);

}
