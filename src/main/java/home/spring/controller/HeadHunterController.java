package home.spring.controller;

import home.spring.beans.HeadHunter;
import home.spring.beans.Recruit;
import home.spring.service.HeadHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by jananda on 24/04/2018.
 */
@RestController
public class HeadHunterController
{
	@Autowired
	private HeadHunterService headHunterService;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/hello")
	public String hello()
	{
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/head-hunters")
	public List<HeadHunter> getHeadHunters()
	{
		return headHunterService.getAllHeadHunters();
	}

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/head-hunters/{id}")
	public List<HeadHunter> getHeadHuntersById( @PathVariable int id )
	{
		return headHunterService.getHeadHunter( id );
	}

//	@RequestMapping("/recruits")
//	public List<Recruit> getRecruits()
//	{
//		return headHunterService.getAllRecruits();
//	}

//	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/recruits/{hunterId}")
//	public List<Recruit> getRecruitsForHunter( @PathVariable int hunterId )
//	{
//		return headHunterService.getRecruitsForHunter( hunterId );
//	}

//	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST }, value = "/commission/{hunterId}")
//	public double calculateCommission( @PathVariable int hunterId )
//	{
//		return headHunterService.calculateCommission( hunterId );
//	}
}

