package ca.utoronto.utm.chess;

import java.util.*;

public abstract class PieceCommand extends Observable{
	
	// TODO: You may add basic information about pieces
	
	abstract void accept(Visitor visitor);
}
