package com.aily.shortener;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;
    
    public int getCountPages(int limit) {
    	return (int) Math.ceil(((int) linkRepository.count())*1.0/limit);
    }
    
    public List<Link> getLinks(int limit,int page) {
    	check();
    	List<Link> result = new ArrayList<>();
    	for (int i=0;i<limit;i++)
    	    try {
    	        result.add(linkRepository.findAll().get((page-1)*limit+i));
    	    }
    	        catch(Exception e)
    	    {}
    	
    	return result;
    }
    
    public void check() {
    	for(Link link:linkRepository.findAll()) {
    	    if(new Date().after(link.getLiveTo()) || new Date().equals(link.getLiveTo()))
    		    link.setStatus(0);
    	    linkRepository.save(link);
    	}
    }
    
    public void check(Link link)
    {
    	if(new Date().after(link.getLiveTo()) || new Date().equals(link.getLiveTo()))
    		link.setStatus(0);
    	linkRepository.save(link);
    }
    
    public Link redirect(HttpServletRequest req) throws URISyntaxException
    {
    	URI uri = new URI (req.getRequestURL().toString());
    	for (Link tmp : linkRepository.findAll())
    	    if((uri.getHost()+uri.getPath()).equals(tmp.getShortUrl())) 
    		{
    			check(tmp);
    	        if(tmp.getStatus()!=0)
    	    	 return tmp;
    	        else
    	        	break;
    		}
    	return null;
    	    	
    }
    public Link find (int id)
    {
    	return linkRepository.findById(id).get();
    }
    public void add(Link link, HttpServletRequest req) throws URISyntaxException
    {   
    	
    	Date dt = new Date();
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(dt); 
    	c.add(Calendar.DATE, Integer.parseInt(link.getDate()));
    	dt = c.getTime();
    	link.setLiveTo(dt);;
    	URI uri = new URI(req.getRequestURL().toString());
    	link.setShortUrl(uri.getHost()+"/"+RandomStringUtils.random(7, true, true));
    	link.setStatus(1);
    	linkRepository.save(link);
    	
    	
    }
    public void edit (Link link, int id)
    {
        Link tmpLink = linkRepository.getOne(id);
        tmpLink.setLongUrl(link.getLongUrl());
        linkRepository.save(tmpLink);
    }
    
    public void save(int id) {
        Link tmpLink = linkRepository.getOne(id);
        tmpLink.setStatus(1);
        linkRepository.save(tmpLink);
    }
    
    public void save(Link link, int id) {
    	Date dt = new Date();
    	Calendar c = Calendar.getInstance(); 
    	c.setTime(dt); 
    	c.add(Calendar.DATE, Integer.parseInt(link.getDate()));
    	dt = c.getTime();
    	
        Link tmpLink = linkRepository.getOne(id);
        tmpLink.setLiveTo(dt);
        tmpLink.setStatus(1);
        linkRepository.save(tmpLink);
    }
    
    public void destroy(int id) {
    	Link tmpLink = linkRepository.getOne(id);
        tmpLink.setStatus(0);
        linkRepository.save(tmpLink);
    }
    public void delete (int id)
    {
    	linkRepository.deleteById(id);
    }
    
}
