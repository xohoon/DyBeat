package Dy_beat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DyBeat extends JFrame{
	
	private Graphics screenGraphic;
	private Image screenImage;
	private Image background = new ImageIcon(Main.class.getResource("../imgs/introBg.jpg")).getImage();;
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../imgs/gameInfo.png")).getImage();;
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../imgs/judgementLine.png")).getImage();;
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../imgs/noteRoute.png")).getImage();;
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../imgs/noteRouteLine.png")).getImage();;
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../imgs/noteBasic.png")).getImage();;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/manuBar.png")));
	
	// exit button
	private ImageIcon exitButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/closeButtonEnter.png"));;
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/closeButtonBasic.png"));;
	
	// start button
	private ImageIcon startButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/startEnter.png"));;
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/startBasic.png"));;

	// left button
	private ImageIcon leftButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/leftEnter.png"));;
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/leftBasic.png"));;
	
	// right button
	private ImageIcon rightButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/rightEnter.png"));;
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/rightBasic.png"));;
	
	// quit button
	private ImageIcon quitButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/quitEnter.png"));;
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/quitBasic.png"));;
	
	// easy button
	private ImageIcon easyButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/easySelectButton.png"));;
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/easyBasicButton.png"));;
	
	// hard button
	private ImageIcon hardButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/hardSelectButton.png"));;
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/hardBasicButton.png"));;

	// back button
	private ImageIcon backButtonEnterImage = new ImageIcon(Main.class.getResource("../imgs/backEnterButton.png"));;
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../imgs/backBasicButton.png"));;

	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	Music introMusic = new Music("introMusic.mp3", true);
	
	private Image titleImage;// title img
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
	public DyBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		introMusic.start();
		
		trackList.add(new Track("titleImage01.png", "startImage01.png", "gameImage01.png", "music01_selected.mp3", "music01.mp3"));
		trackList.add(new Track("titleImage02.png", "startImage02.png", "gameImage02.png", "music02_selected.mp3", "music02.mp3"));
		trackList.add(new Track("titleImage03.png", "startImage03.png", "gameImage03.png", "music03_selected.mp3", "music03.mp3"));
		
		// close button //
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("bbb.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("close.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		// close button //

		// start button //
		startButton.setBounds(40, 220, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnterImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("iuo.mp3", false);
				buttonPressedMusic.start();
				// game start event
				enterMain();
			}
		});
		add(startButton);
		// start button //
		
		// quit button //
		quitButton.setBounds(40, 350, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnterImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("close.mp3", false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		// quit button //
		
		// left button //
		leftButton.setVisible(false);
		leftButton.setBounds(140, 400, 64, 64);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnterImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("ddr.mp3", false);
				buttonPressedMusic.start();
				// left button event
				selectLeft();
			}
		});
		add(leftButton);
		// left button //
	
		// right button //
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 400, 64, 64);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnterImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("ddr.mp3", false);
				buttonPressedMusic.start();
				// right button event
				selectRight();
			}
		});
		add(rightButton);
		// right button //
		
		// easy button //
		easyButton.setVisible(false);
		easyButton.setBounds(375, 650, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnterImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("ddr.mp3", false);
				buttonPressedMusic.start();
				// easy mode event
				gameStart(nowSelected, "easy");
			}
		});
		add(easyButton);
		// easy button //
				
		// hard button //
		hardButton.setVisible(false);
		hardButton.setBounds(655, 650, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnterImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("ddr.mp3", false);
				buttonPressedMusic.start();
				// hard mode event
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);
		// hard button //
		
		// back button //
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 32, 32);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnterImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("iuo.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("ddr.mp3", false);
				buttonPressedMusic.start();
				// main page move event
				backMain();
			}
		});
		add(backButton);
		// back button //
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x =  e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 340, 180, null);
			g.drawImage(titleImage, 340, 150, null);
		}
		if(isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null);
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);
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
			g.drawImage(noteBasicImage, 228, 120, null);
			g.drawImage(noteBasicImage, 332, 580, null);
			g.drawImage(noteBasicImage, 436, 500, null);
			g.drawImage(noteBasicImage, 540, 340, null);
			g.drawImage(noteBasicImage, 640, 340, null);
			g.drawImage(noteBasicImage, 744, 325, null);
			g.drawImage(noteBasicImage, 848, 305, null);
			g.drawImage(noteBasicImage, 952, 305, null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("IU - Love Poem", 20, 702);
			g.drawString("EASY", 1190, 702);
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
			
		}
		paintComponents(g);
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../imgs/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../imgs/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		}else {
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		}else {
			nowSelected++;
		}
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null) {
			selectedMusic.close();
		}
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../imgs/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
	}
	
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../imgs/gameBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}
	
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../imgs/gameBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}

}
