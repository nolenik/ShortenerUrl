package com.aily.shortener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StatisticController {
	 @Autowired
	 StatisticService statisticService;
     @GetMapping("/statistic")
     public String viewStatistic(Model model) {
    	 List<Statistic> stats = statisticService.getStatistic();
    	 model.addAttribute("stats",stats);
    	 model.addAttribute("find",new String());
    	 return "statistic";
     }
     @GetMapping("/search/{searchParam}/{id}")
     public String search(Model model, @PathVariable("searchParam") String searchParam,
    		 @PathVariable ("id") int id) {
    	 String header="";
    	 if (searchParam.equals("all"))
    		 header="Link";
    	 else if (searchParam.equals("browser"))
    		 header="Browser";
    	 else if (searchParam.equals("date"))
    		 header="Date";
    	 else if (searchParam.equals("referrer"))
    		 header="Referrer";
    	 model.addAttribute("head",header);
    	 model.addAttribute("map", statisticService.search(searchParam, id));
    	 return "search";
     }
}
