package home.spring.service;

import home.spring.beans.HeadHunter;
import home.spring.beans.HeadHunterRepo;
import home.spring.beans.Recruit;
import home.spring.beans.RecruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jananda on 24/04/2018.
 */
@Service
public class HeadHunterService
{
	private static final int GROUP_SIZE = 5;

	@Autowired
	private HeadHunterRepo headHunterRepo;

	@Autowired
	private RecruitRepo recruitRepo;

	public List<HeadHunter> getAllHeadHunters()
	{
		List<HeadHunter> headHunters = new ArrayList<>();
		headHunterRepo.findAll().forEach( headHunters::add );
		return headHunters;
	}

	public List<HeadHunter> getHeadHunter( int id )
	{
		return headHunterRepo.findById( id );
	}

	public List<Recruit> getAllRecruits()
	{
		List<Recruit> recruits = new ArrayList<>();
		recruitRepo.findAll().forEach( recruits::add );
		return recruits;
	}

	public List<Recruit> getRecruitsForHunter( int hunterId )
	{
		return recruitRepo.findByHunterId( hunterId );
	}

	public double calculateCommission( int hunterId )
	{
		List<Recruit> recruits = recruitRepo.findByHunterId( hunterId );

		if ( recruits.size() > 0 )
		{
			int masonSize = ( int ) recruits.stream().filter( t -> t.getJobType() == Recruit.JOB_MASON ).count();
			int carpenterCount = recruits.size() - masonSize;

			int mazonGroup = masonSize / GROUP_SIZE;
			int carpGroup = carpenterCount / GROUP_SIZE;

			return masonSize * 200 + ( GROUP_SIZE * 200 * 0.1 ) * mazonGroup + carpenterCount * 250 + ( GROUP_SIZE * 250 * 0.1 ) * carpGroup;
		}
		return 0;
	}
}

