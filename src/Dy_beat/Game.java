package Dy_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../imgs/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../imgs/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../imgs/gameInfo.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
	
	private Image flareImage;
	private Image judgeImage;
	
	private Image keySImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keyDImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keyFImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keySpace1Image = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keySpace2Image = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keyJImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keyKImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	private Image keyLImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgeMiss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);;
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
		g.drawImage(flareImage, 410, 280, null);
		g.drawImage(judgeImage, 460, 420, null);
		
		g.drawImage(keySImage, 228, 580, null);
		g.drawImage(keyDImage, 332, 580, null);
		g.drawImage(keyFImage, 436, 580, null);
		g.drawImage(keySpace1Image, 540, 580, null);
		g.drawImage(keySpace2Image, 640, 580, null);
		g.drawImage(keyJImage, 744, 580, null);
		g.drawImage(keyKImage, 848, 580, null);
		g.drawImage(keyLImage, 952, 580, null);
		
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keySImage = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("small01.mp3", false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keySImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keyDImage = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("small02.mp3", false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keyDImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keyFImage = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("small03.mp3", false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keyFImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keySpace1Image = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keySpace2Image = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("big03.mp3", false).start();
	}
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keySpace1Image = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keySpace2Image = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keyJImage = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("big01.mp3", false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keyJImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keyKImage = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("big02.mp3", false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keyKImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoutePressed.png")).getImage();
		keyLImage = new ImageIcon(Main.class.getResource("../imgs/keySelectImage.png")).getImage();
		new Music("big01.mp3", false).start();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();
		keyLImage = new ImageIcon(Main.class.getResource("../imgs/keyBasicImage.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("IU - Love Poem") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime * 1, "Space"),
					new Beat(startTime + gap * 3, "S"),
					new Beat(startTime + gap * 5, "D"),
					new Beat(startTime + gap * 7, "F"),
					new Beat(startTime + gap * 9, "J"),
					new Beat(startTime + gap * 13, "K"),
					new Beat(startTime + gap * 16, "L"),
					new Beat(startTime * 19, "Space"),
					new Beat(startTime + gap * 20, "S"),
					new Beat(startTime + gap * 25, "D"),
					new Beat(startTime + gap * 30, "F"),
					new Beat(startTime + gap * 35, "J"),
					new Beat(startTime + gap * 40, "K"),
					new Beat(startTime + gap * 45, "L"),
					new Beat(startTime * 50, "Space"),
					new Beat(startTime + gap * 50, "S"),
					new Beat(startTime + gap * 55, "D"),
					new Beat(startTime + gap * 60, "F"),
					new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 70, "K"),
					new Beat(startTime + gap * 75, "L"),
					new Beat(startTime * 80, "Space"),
					new Beat(startTime + gap * 100, "S"),
					new Beat(startTime + gap * 120, "D"),
					new Beat(startTime + gap * 135, "F"),
					new Beat(startTime + gap * 140, "J"),
					new Beat(startTime + gap * 150, "K"),
					new Beat(startTime + gap * 160, "L"),
			};
		}else if(titleName.equals("IU - Love Poem") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}else if(titleName.equals("CHANGMO - Meteor") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}else if(titleName.equals("CHANGMO - Meteor") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}else if(titleName.equals("JBJ - shaking flowers") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}else if(titleName.equals("JBJ - shaking flowers") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			flareImage = new ImageIcon(Main.class.getResource("../imgs/flareImage.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgeMiss.png")).getImage();
		}else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgeLate.png")).getImage();
		}else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgeGood.png")).getImage();
		}else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgeGreat.png")).getImage();
		}else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgePerfect.png")).getImage();
		}else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../imgs/judgeEarly.png")).getImage();
		} 
	}
}
