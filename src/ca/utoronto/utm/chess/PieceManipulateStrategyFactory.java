package ca.utoronto.utm.chess;

public class PieceManipulateStrategyFactory {
	static PieceManipulateStrategy create(String strategyName, Model model) {
		PieceManipulateStrategy strategy = null;
		// TODO: create different strategy depending on given name
		switch (strategyName) {
			default:
				strategy = new PieceManipulateStrategy(model);
		}
		return strategy;
	}
}
