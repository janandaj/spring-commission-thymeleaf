package home.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationProperties
{
	@Value("${hh.message}")
	private String hhMessage;
	@Value("${hh.id}")
	private String hhId;
	@Value("${hh.name}")
	private String hhName;

	@Value("${rt.message}")
	private String rtMessage;
	@Value("${rt.id}")
	private String rtId;
	@Value("${rt.name}")
	private String rtName;
	@Value("${rt.jobtype}")
	private String rtJobType;

	public String getHhMessage()
	{
		return hhMessage;
	}

	public void setHhMessage( String hhMessage )
	{
		this.hhMessage = hhMessage;
	}

	public String getHhId()
	{
		return hhId;
	}

	public void setHhId( String hhId )
	{
		this.hhId = hhId;
	}

	public String getHhName()
	{
		return hhName;
	}

	public void setHhName( String hhName )
	{
		this.hhName = hhName;
	}

	public String getRtMessage()
	{
		return rtMessage;
	}

	public void setRtMessage( String rtMessage )
	{
		this.rtMessage = rtMessage;
	}

	public String getRtId()
	{
		return rtId;
	}

	public void setRtId( String rtId )
	{
		this.rtId = rtId;
	}

	public String getRtName()
	{
		return rtName;
	}

	public void setRtName( String rtName )
	{
		this.rtName = rtName;
	}

	public String getRtJobType()
	{
		return rtJobType;
	}

	public void setRtJobType( String rtJobType )
	{
		this.rtJobType = rtJobType;
	}
}
