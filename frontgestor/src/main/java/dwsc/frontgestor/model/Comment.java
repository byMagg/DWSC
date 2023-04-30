package dwsc.frontgestor.model;

public class Comment {

    private Long id;
    private Long trackid;
    private String author;
    private String content;
    private int score;
	private String date;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Long getTrackid() {
		return trackid;
	}
	public void setTrackid(Long trackid) {
		this.trackid = trackid;
	}
}
