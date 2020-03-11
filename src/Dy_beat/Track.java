package Dy_beat;

public class Track {
	
	private String titleImage; // title imgae
	private String startImage; // game select page image
	private String gameImage; // music start page image
	private String startMusic; // game select page music
	private String gameMusic; // game start music
	
	public String getTitleImage() {
		return titleImage;
	}


	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}


	public String getStartImage() {
		return startImage;
	}


	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}


	public String getGameImage() {
		return gameImage;
	}


	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}


	public String getStartMusic() {
		return startMusic;
	}


	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}


	public String getGameMusic() {
		return gameMusic;
	}


	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}

	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
	}
	
	

}
