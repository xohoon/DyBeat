package Dy_beat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		if(DyBeat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			DyBeat.game.pressS();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			DyBeat.game.pressD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DyBeat.game.pressF();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DyBeat.game.pressSpace();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DyBeat.game.pressJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DyBeat.game.pressK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DyBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(DyBeat.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			DyBeat.game.releaseS();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			DyBeat.game.releaseD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DyBeat.game.releaseF();
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			DyBeat.game.releaseSpace();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DyBeat.game.releaseJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DyBeat.game.releaseK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DyBeat.game.releaseL();
		}
	}
}
