package module9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SolarSystem {

	public static void main(String[] args) {

	}

}

class AnimationPanel extends JPanel implements ActionListener {
	private Polygon shape; // shape to be displayed
	private final int delay = 50; // delay in ms between steps
	private final double delta; // angle to rotate in each step
	private double angle = 0.0; // current angle of shape on screen
	private Timer animationTimer; // timer controlling frame rate

	@Override
	public void actionPerformed(ActionEvent event) {
		angle += delta;
		repaint();
	}

	AnimationPanel(int width, int height, double rotationTime) {
		setPreferredSize(new Dimension(width,height));
		int size = Math.min(width, height) / 4;
		int[] xpts = {size,-size,-size,size};
		int[] ypts = {size, size,-size,-size};
		shape = new Polygon(xpts,ypts,4);
		delta = 2*Math.PI*delay/(rotationTime*1000);
		animationTimer = new Timer(delay,this);
		animationTimer.start();
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		// Fill in background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		// Now move origin to centre of panel
		g.translate(width/2, height/2);
		// Rotate and draw shape
		g.setColor(Color.YELLOW);
		Polygon rotatedShape = rotatePolygon(shape, angle);
		g.fillPolygon(rotatedShape);
	}

	private static Polygon rotatePolygon(Polygon poly, double angle) {
		Polygon newPoly = new Polygon();
		for (int i = 0; i < poly.npoints; i++) {
			double x = poly.xpoints[i]*Math.cos(angle)+poly.ypoints[i]*Math.sin(angle);
			double y = poly.ypoints[i]*Math.cos(angle)-poly.xpoints[i]*Math.sin(angle);
			newPoly.addPoint((int) x, (int) y);
		}
		return newPoly;
	}
	/** Start the animation */
	public void start() {animationTimer.start();}
	/** Stop the animation */
	public void stop() {animationTimer.stop();}

}

class AnimationGuiPanel extends JPanel implements ActionListener {

	private AnimationPanel animPanel; // panel containing animation
	private JButton startButton;
	private JButton stopButton;
	private JButton exitButton;

	/** Create JPanel containing animation panel and buttons. */
	public AnimationGuiPanel() {
		super();
		setPreferredSize(new Dimension(250,300));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		animPanel = new AnimationPanel(200,200,10.0);
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		exitButton = new JButton("Exit");
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
		buttonPanel.add(startButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(exitButton);
		add(animPanel);
		add(buttonPanel);
	}
	/** Respond to button clicks */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButton) start();
		else if (e.getSource()==stopButton) stop();
		else if (e.getSource()==exitButton) System.exit(0);
	}

	/** Start animation when applet is started */
	public void start() {animPanel.start();}
	/** Stop animation when applet is stopped */
	public void stop() {animPanel.stop();}


	/** Create and display JFrame containing animation GUI panel */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Animation demo");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(250,300);
				JPanel panel = new AnimationGuiPanel();
				frame.add(panel);
				frame.setVisible(true);
			}
		});
	}
}