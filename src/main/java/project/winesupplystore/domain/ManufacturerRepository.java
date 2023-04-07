package project.winesupplystore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long>{
	//näitä voi käyttää hyödyksi myöhemmin controllerissa, restissä tai poistaa
	List<Manufacturer> findByName(String name);

}
