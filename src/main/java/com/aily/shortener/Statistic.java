package com.aily.shortener;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "statistic")
public class Statistic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="r_id")
    private int rId;
    
    @Column(name = "l_id")
    private int lId;
    
    @Column(name = "short_url")
    private String shortUrl;
    
    @Column(name = "long_url")
    private String longUrl;

    @Temporal(TemporalType.DATE)
    @Column(name = "dateR")
    private Date date;
    

    @Column(name = "referer")
    private String referer;

    @Column(name = "ip")
    private String ip;

    @Column(name = "browser")
    private String browser;
    
    @Column(name = "number_redirection")
    private int numOfRed;
    
    public int getNumOfRed() {
		return numOfRed;
	}


	public void setNumOfRed(int numOfRed) {
		this.numOfRed = numOfRed;
	}


	public Statistic() {
    }


	public int getrId() {
		return rId;
	}


	public void setrId(int rId) {
		this.rId = rId;
	}


	public int getlId() {
		return lId;
	}


	public void setlId(int lId) {
		this.lId = lId;
	}


	public String getShortUrl() {
		return shortUrl;
	}


	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}


	public String getLongUrl() {
		return longUrl;
	}


	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getReferer() {
		return referer;
	}


	public void setReferer(String referer) {
		this.referer = referer;
	}


	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getBrowser() {
		return browser;
	}


	public void setBrowser(String browser) {
		this.browser = browser;
	}
    
    
}
