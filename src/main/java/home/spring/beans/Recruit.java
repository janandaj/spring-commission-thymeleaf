package home.spring.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jananda on 24/04/2018.
 */
@Entity
@Table(name = "tbl_recruit")
@XmlRootElement(name = "recruit")
public class Recruit
{
	public static final Integer JOB_MASON = 1;
	public static final Integer JOB_CARPENTER = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int jobType;
	private int hunterId;
	private String name;

	public Recruit()
	{
	}

	public Recruit( int id, int hunterId, int jobType, String name )
	{
		this.id = id;
		this.jobType = jobType;
		this.hunterId = hunterId;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public int getJobType()
	{
		return jobType;
	}

	public void setJobType( int jobType )
	{
		this.jobType = jobType;
	}

	public int getHunterId()
	{
		return hunterId;
	}

	public void setHunterId( int hunterId )
	{
		this.hunterId = hunterId;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}

