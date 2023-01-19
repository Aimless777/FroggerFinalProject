
//https://github.com/domingodavid/froggerEclipse

package frog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class Driver extends JPanel implements ActionListener, KeyListener {

	int screen_width = 1000;
	int screen_height = 1000;
	Froggy froggy;
	static Music moosic = new Music("sweep.wav", true);
	// instantiate objct car
	Car[] car2 = new Car[10];
	Car[] car3 = new Car[10];
	Car[] car4 = new Car[10];
	Car[] car5 = new Car[10];
	Car[] car6 = new Car[10];
	Car[] car7 = new Car[10];
	Car[] car8 = new Car[10];
	Logs[] Logs1 = new Logs[10];
	Logs[] Logs2 = new Logs[10];
	Logs[] Logs3 = new Logs[10];
	Logs[] Logs4 = new Logs[10];
	Logs[] Logs5 = new Logs[10];

	Background bg;
	int my_variable = 3; // example

	String lose = "";
	String win = "";
	String lost = "";

	public void paint1(Graphics g) {
		super.paintComponent(g);
	Rectangle rFroggy = new Rectangle(froggy.getX(), froggy.getY(), froggy.getWidth(), froggy.getHeight());
	
	}
	
	public boolean Intersects() {
		
		
		
		
		
		
		
		
		return false;
		
	}
	
	// ****************************paint
	// method******************************************
	public void paint(Graphics g) {

		super.paintComponent(g);
		bg.paint(g);

		g.setFont(font);
		g.setColor(Color.white);
		g.drawString(("Lives:") + Integer.toString(my_variable), 0, 870);
		g.setFont(font2);

		// paint sprites for carss
		for (int i = 0; i < car2.length; i++) {
			car2[i].paint(g);
		}
		for(int i = 0; i < car3.length; i++) {
			car3[i].paint(g);
		}
		for(int i = 0; i < car4.length; i++) {
			car4[i].paint(g);
		}
		for(int i = 0; i < car5.length; i++) {
			car5[i].paint(g);
		}
		for(int i = 0; i < car6.length; i++) {
			car6[i].paint(g);
		}
		for(int i = 0; i < car7.length; i++) {
			car7[i].paint(g);
		}
		for(int i = 0; i < car8.length; i++) {
			car8[i].paint(g);
		}
		for(int i = 0; i < Logs1.length; i++) {
			Logs1[i].paint(g);
		}
		for(int i = 0; i < Logs2.length; i++) {
			Logs2[i].paint(g);
		}
		for(int i = 0; i < Logs3.length; i++) {
			Logs3[i].paint(g);
		}
		for(int i = 0; i < Logs4.length; i++) {
			Logs4[i].paint(g);
		}
		for(int i = 0; i < Logs5.length; i++) {
			Logs5[i].paint(g);
		}
		

		// paint and update froggy
		froggy.paint(g);

		// car one
		g.drawString(lost, 0, 50);
		if (my_variable == 0) {
			lose = " u lost";
			g.drawString(lose, 0, 50);
		}

		// resetting
		if (my_variable > 0 && froggy.getY() == 0) {
			lose = "";
			win = "u won!";
			g.drawString(win, 0, 50);
			froggy.setX(425);
			froggy.setY(825);
		}

	}

	Font font = new Font("Courier New", 1, 50);
	Font font2 = new Font("Courier New", 1, 30);

	//
	public void update() {

		froggy.move();

		// car two
		for (int i = 0; i < car2.length; i++) {

			car2[i].setVx(-7);
			car2[i].move();
			
			car3[i].setVx(-31);
			car3[i].move();
			
			car4[i].setVx(-4);
			car4[i].move();
			
			car5[i].setVx(-1);
			car5[i].move();
			
			car6[i].setVx(-6);
			car6[i].move();
			
			car7[i].setVx(-4);
			car7[i].move();
			
			car8[i].setVx(-9);
			car8[i].move();
			
			Logs1[i].setVx(-3);
			Logs1[i].move();

			Logs2[i].setVx(-2);
			Logs2[i].move();
			
			Logs3[i].setVx(-9);
			Logs3[i].move();
			
			Logs4[i].setVx(-2);
			Logs4[i].move();
			
			Logs5[i].setVx(-5);
			Logs5[i].move();
		}
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
		moosic.play();
	}

	/* *
	 * Used to setup all of the objects on the screen
	 */
	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("Frogger");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addKeyListener(this); //listen for keypresses on this frame

		// sprite instantiation
		froggy = new Froggy("farmer.png");

		for (int i = 0; i < car2.length; i++) {
			car3[i] = new Car("car.png", i * 250 + 400, 85);
		}
		
		for (int i = 0; i < car2.length; i++) {
			car4[i] = new Car("car.png", i * 250 + 400, 240);
		}
		
		for (int i = 0; i < car2.length; i++) {
			car2[i] = new Car("car.png", i * 250 + 400, 340);
		}
		for (int i = 0; i < car2.length; i++) {
			car5[i] = new Car("car.png", i * 250 + 400, 445);
		}
		for (int i = 0; i < car2.length; i++) {
			car6[i] = new Car("car.png", i * 250 + 400, 596);
		}
		for (int i = 0; i < car2.length; i++) {
			car7[i] = new Car("car.png", i * 250 + 400, 648);
		}
		
		for (int i = 0; i < car2.length; i++) {
			car8[i] = new Car("car.png", i * 250 + 400, 751);
		}
		
		
		for (int i = 0; i < Logs1.length; i++) {
			Logs1[i] = new Logs("logpic.png", i * 250 + 400, 780);
		}
		
		for (int i = 0; i < Logs1.length; i++) {
			Logs2[i] = new Logs("logpic.png", i * 250 + 400, 475);
		}
		
		for (int i = 0; i < Logs1.length; i++) {
			Logs3[i] = new Logs("logpic.png", i * 250 + 400, 375);
		}
		
		for (int i = 0; i < Logs1.length; i++) {
			Logs4[i] = new Logs("logpic.png", i * 250 + 400, 270);
		}
		
		for (int i = 0; i < Logs1.length; i++) {
			Logs5[i] = new Logs("logpic.png", i * 250 + 400, 115);
		}
		
		//0ijoij
		
		// Add background
		bg = new Background("background3.png");
		
		
		// do not add to frame, call paint on
		// these objects in paint method

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		// detect up, down, left, right arrow keypresses
		// call setters for volovety attributes accordingly
		// 37 <- ,
		// 38 up ,
		// 40 down,
		// 39 ->
		
		if(e.getKeyCode()==38) {
			froggy.setY(froggy.getY()-52);
		}
		if(e.getKeyCode()==40) {
			froggy.setY(froggy.getY()+52);
		}if(e.getKeyCode()==37) {
			froggy.setX(froggy.getX()-52);
		}if(e.getKeyCode()==39) {
			froggy.setX(froggy.getX()+52);
		}
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_W:		//up
			froggy.hop(10);
			break;
		
		case KeyEvent.VK_S:		//down
			break;
		
		// handle going left and right
		// A and D keys
			
			
		}
		
		
		
		

	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*
		 * turn off velocity for Frog if you don't want it moving when you have stopped
		 * pressing the keys
		 */
		if (e.getKeyCode() == 38) {
			froggy.setVy(0);
			froggy.setVx(0);
		}

		if (e.getKeyCode() == 40) {
			froggy.setVy(0);
			froggy.setVx(0);
		}

		// do the same thing for the other keys
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}