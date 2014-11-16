package com.brad.guiapp;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Set;

public class ConwayGuiApp extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private final int PIXEL_WIDTH = 4;

	private int worldDimension;
	
	private int generationCount;
	
	private Set<Point> world = Collections.emptySet();
	
	
	public ConwayGuiApp(int worldDimension) {
		this.worldDimension = worldDimension;
	}

	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(worldDimension * PIXEL_WIDTH, worldDimension * PIXEL_WIDTH);
	};

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Color gColor = g.getColor();
		paintBoard(g);
		paintCells(g);
		g.setColor(gColor);
	};
	
    private void paintCells(Graphics g) {
    	for(Point p : world) {
    		g.fillRect(p.x * PIXEL_WIDTH, p.y * PIXEL_WIDTH, PIXEL_WIDTH, PIXEL_WIDTH);
    	}
	}

	private void paintBoard(Graphics g) {
		g.drawString("Generation: " + generationCount, 0, g.getFontMetrics().getHeight());
		this.setBackground(Color.WHITE);		
	}

	protected void setWorld(Set<Point> gameState) {
		world = gameState;
		generationCount++;
	}
}
