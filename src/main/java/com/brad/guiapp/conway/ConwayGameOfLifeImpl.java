package com.brad.guiapp.conway;

import pl.aetas.gameoflife.Board;
import pl.aetas.gameoflife.Cell;
import scala.collection.JavaConversions;
import scala.collection.Seq;

import java.awt.*;
import java.util.Set;
import java.util.stream.Collectors;

public class ConwayGameOfLifeImpl implements ConwayGameOfLife {

	private int dimension;
	private Board board;
	
	public ConwayGameOfLifeImpl(int dimension, Set<Point> seed) {
		this.dimension = dimension;
		Set<Cell> cellsSet = seed.stream().map(point -> new Cell(point.x, point.y)).collect(Collectors.toSet());
		Seq<Cell> cells = JavaConversions.asScalaSet(cellsSet).toSeq();
		this.board = new Board(cells);
	}
	
	public int getWorldDimension() {
		return dimension;
	}

	@Override
	public Set<Point> incrementAndGetWorld() {
		board = board.next();
		Set<Cell> cells = JavaConversions.setAsJavaSet(board.liveCells());
		return cells.stream().map(cell -> new Point(cell.x(), cell.y()))
				.filter(p -> p.getX() > 0 && p.getY() > 0).collect(Collectors.toSet());
	}

}
