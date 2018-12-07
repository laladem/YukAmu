package fr.amu.models;

public class Food {
	public enum TAG {NONE, EXCELLENT, GOOD, MEDIOCRE, BAD};
	

	private int id;
	private String name;
	private TAG tag;
	private boolean done;
	private String imgUrl;
	
	
	public String getImg() {
		return imgUrl;
	}
	public void setImg(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public TAG getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = TAG.valueOf(tag); ;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
	
}

