package home.spring.controller;

import home.spring.beans.HeadHunter;
import home.spring.beans.Recruit;
import home.spring.config.ApplicationProperties;
import home.spring.service.HeadHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jananda on 25/04/2018.
 */
@Controller
public class WelcomeController
{
	@Autowired
	private HeadHunterService headHunterService;

	@Autowired
	private ApplicationProperties applicationProperties;

	@RequestMapping("/")
	public String welcome( Model model )
	{
		model.addAttribute( "message", this.applicationProperties.getHhMessage() );
		model.addAttribute( "hhid", this.applicationProperties.getHhId() );
		model.addAttribute( "hhname", this.applicationProperties.getHhName() );

		List<HeadHunter> headHunters = headHunterService.getAllHeadHunters();
		model.addAttribute( "headHunters", headHunters );

		return "welcome";
	}

	@RequestMapping("/recruits/{hunterId}")
	public String recruits( Model model, @PathVariable int hunterId )
	{
		model.addAttribute( "message", this.applicationProperties.getRtMessage() );
		model.addAttribute( "rtid", this.applicationProperties.getRtId() );
		model.addAttribute( "rtname", this.applicationProperties.getRtName() );
		model.addAttribute( "rtjobtype", this.applicationProperties.getRtJobType() );
		model.addAttribute( "hhid", this.applicationProperties.getHhId() );

		List<Recruit> recruits = headHunterService.getRecruitsForHunter( hunterId );
		model.addAttribute( "recruits", recruits );
		model.addAttribute( "hunterId", hunterId );

		return "recruit";
	}

	@RequestMapping("/commission/{hunterId}")
	public String calculateCommission( Model model, @PathVariable int hunterId )
	{
		double commission = headHunterService.calculateCommission( hunterId );
		model.addAttribute( "commission", commission );
		return recruits( model, hunterId );
	}
}
