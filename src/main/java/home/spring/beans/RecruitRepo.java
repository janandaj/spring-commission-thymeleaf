package home.spring.beans;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by jananda on 24/04/2018.
 */
public interface RecruitRepo extends CrudRepository<Recruit, Integer>
{
	public List<Recruit> findByHunterId( int hunterId );
}