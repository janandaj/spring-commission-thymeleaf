package home.spring.beans;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jananda on 24/04/2018.
 */
public interface HeadHunterRepo extends CrudRepository<HeadHunter, Integer>
{
	public List<HeadHunter> findById( int id );
}
