package dwsc.frontuser.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
	
    private int id;
    private int trackid;
    private String author;
    private String content;
    private int score;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTrackid() {
		return trackid;
	}
	public void setTrackid(int trackid) {
		this.trackid = trackid;
	}
}
