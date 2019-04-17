package com.aily.shortener;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="link")
public class Link {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="id")
     private int id;
     
     @Column(name = "long_url")
     private String longUrl;
     
     @Column(name = "short_url")
     private String shortUrl;
     
     @Column(name = "status")
     private int status;
     
     @Column(name = "live_to")
     private Date liveTo;
     
     @Transient
     private String date;
     
     public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getLiveTo() {
		return liveTo;
	}
	public void setLiveTo(Date liveTo) {
		this.liveTo = liveTo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Link() {
     }
     public int getId() {
    	 return id;
     }
     public void setId(int id) {
    	 this.id=id;
     }
     
     public String getLongUrl() {
    	 return longUrl;
     }
     public void setLongUrl(String longUrl) {
    	 this.longUrl=longUrl;
     }
     public String getShortUrl() {
    	 return shortUrl;
     }
     public void setShortUrl(String shortUrl) {
    	 this.shortUrl=shortUrl;
     }
}
