package com.aily.shortener;


import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
     @Autowired
     private LinkService linkService;
     @Autowired
     private StatisticService statisticService;
     @GetMapping("/**") 
     public String redirect(HttpServletRequest req) throws URISyntaxException, ParseException {
    	 Link lnk = linkService.redirect(req);
    	 if (lnk!=null) {
    		 statisticService.add(lnk, req);
    		 String str = lnk.getLongUrl();
    		 if (!str.contains("http"))
    			 str = "http://"+str;
    	     return "redirect:"+str;
    	 }
    	 return "redirect:/error";
     }
     @GetMapping("/")
     public String listLink(Model model,@Nullable @RequestParam("id") Integer currentPage) {
    	 int limit=5;
    	 int page;
    	 if (currentPage==null)
    		 page=1;
    	 else
    		 page=currentPage.intValue();
    	 List<Link> links = linkService.getLinks(limit,page);
    	 model.addAttribute("curPag", page);
    	 model.addAttribute("links", links);
    	 model.addAttribute("pages", linkService.getCountPages(limit));
    	 return "index";
     }
     @GetMapping("/add")
     public String addLink(Model model) {
    	 model.addAttribute("link", new Link());
    	 return "add";
     }
     @PostMapping("/add")
     public String submitAdd(@ModelAttribute ("link") Link link, HttpServletRequest req) throws URISyntaxException {
    	 linkService.add(link, req);
    	 return "redirect:/";
     }
     @GetMapping("/edit/{id}") 
     public String editLink(Model model, @PathVariable("id") String id) {
    	 try {
    	 model.addAttribute("link", linkService.find(Integer.parseInt(id)));
    	 return "edit";
    	 } catch (Exception e) {return "redirect:/error";} 
     }
     @PostMapping("/edit/{id}")
     public String submitEdit(@ModelAttribute ("link") Link link, @PathVariable("id") String id) {
    	 try {
    		 linkService.edit(link, Integer.parseInt(id));
    		 return "redirect:/";
    	 } catch (Exception e) {return "redirect:/error";} 
     }
     
     @GetMapping("/deactivate/{id}")
     public String deactivateLink(Model model, @PathVariable("id") String id) {
    	try {	 
    	     linkService.destroy(Integer.parseInt(id));
    		 return "redirect:/";
	    } catch (Exception e) {return "redirect:/error";} 
     }
     
     @GetMapping("/activate/{id}")
     public String activateLink(Model model, @PathVariable("id") String id) {
    	 try {
    		 if (linkService.find(Integer.parseInt(id)).getLiveTo().after(new Date())) {
    		 	linkService.save(Integer.parseInt(id));
    		 	return "redirect:/";
    	 	}
    	 	else
    	 	{
    		 	model.addAttribute("link", linkService.find(Integer.parseInt(id)));
    		 	return "activate";
    	 	}
    	 } catch (Exception e) {return "redirect:/error";} 
     }
     @PostMapping("/activate/{id}")
     public String submitActivate(@ModelAttribute ("link") Link link, @PathVariable("id") String id) {
         try {	
        	 linkService.save(link, Integer.parseInt(id));
        	 return "redirect:/";
         } catch (Exception e) {return "redirect:/error";} 
     }
     @GetMapping ("/delete/{id}")
     public String delete(@PathVariable ("id") String id)
     {
    	 try {
    		 linkService.delete(Integer.parseInt(id));
    		 return "redirect:/";
    	} catch (Exception e) {return "redirect:/error";} 
     }
     @GetMapping ("/error")
     public String error()
     {
    	 return "error";
     }
}
