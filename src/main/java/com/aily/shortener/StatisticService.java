package com.aily.shortener;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.bitwalker.useragentutils.UserAgent;

@Service
public class StatisticService {
	@Autowired
    private StatisticRepository statisticRepository;
	
	public void add (Link link, HttpServletRequest req) throws URISyntaxException, ParseException
	{
		Statistic stat = new Statistic();
		stat.setlId(link.getId());
		stat.setShortUrl(link.getShortUrl());
		stat.setLongUrl(link.getLongUrl());
		stat.setNumOfRed(statisticRepository.countByLId(link.getId())+1);
		stat.setDate(new Date());
		try {
			// stat.setReferer(req.getParameter("referer"));
		    stat.setReferer(new URI(req.getHeader("Referer")).getPath());
		} catch (NullPointerException e) {
			stat.setReferer("about:blank");
		}
		
		stat.setIp(req.getRemoteAddr());
		stat.setBrowser(UserAgent.parseUserAgentString(req.getHeader("User-Agent")).getBrowser().getName());
		statisticRepository.save(stat);
	}
	
	public List<Statistic> getStatistic() {
		return statisticRepository.findAll();
	}
	public HashMap<String, Integer> search(String searchParam,int id){
    	HashMap<String,Integer> result = new HashMap<>();
    	List<Statistic> tmp = statisticRepository.findAllByLId(id);
    	for (Statistic stat:tmp)
    	{
    		if (searchParam.equals("all")) {
    			if (!result.containsKey(stat.getShortUrl()))
    				result.put(stat.getShortUrl(), 0);
    			result.put(stat.getShortUrl(), result.get(stat.getShortUrl())+1);
    		}
    		else if (searchParam.equals("browser")) {
    			if (!result.containsKey(stat.getBrowser()))
    				result.put(stat.getBrowser(), 0);
    			result.put(stat.getBrowser(), result.get(stat.getBrowser())+1);
    		}
    		else if (searchParam.equals("date")) {
    			if (!result.containsKey(stat.getDate().toString()))
    				result.put(stat.getDate().toString(), 0);
    			result.put(stat.getDate().toString(), result.get(stat.getDate().toString())+1);
    		}
    		else if (searchParam.equals("referrer")) {
    			if (!result.containsKey(stat.getReferer()))
    				result.put(stat.getReferer(), 0);
    			result.put(stat.getReferer(), result.get(stat.getReferer())+1);
    		}
    	}
    	return result;
    }
}
