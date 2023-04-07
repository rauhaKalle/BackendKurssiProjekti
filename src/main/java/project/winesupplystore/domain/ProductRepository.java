package project.winesupplystore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{

	//näitä voi käyttää hyödyksi myöhemmin controllerissa, restissä tai poistaa
	List<Product> findByName(String name);
	List<Product> findByType(String type);
}
