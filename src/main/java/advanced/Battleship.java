package advanced;

import java.util.*;

/**
 * Given a board with ships assigned on the cells.
 * Ships can be on a single row or column. 4 ships together make a big Battleship, 2 ships together make a big Destroyer.
 * design a single player game in which a player plays some x, y cordinates to shoot down the ship
 * and the outcome for each attempt is either MISS, HIT, SHIP_SUNK, or WINNER.
 * 
 * WINNER: all ships on the board are destroyed
 * SHIP_SUNK: Destroyer or Battleship is destroyed (i..e., all cordinates of the ship are destroyed) 
 * HIT: player destroyed the ship at the cell.
 * MISS: player completely missed the shot
 * 
 * LegalZoom : PE interview (04/21/2022)
 * */
public class Battleship
{
	enum TurnResult {
		MISS, HIT, SHIP_SUNK, WINNER;
	}
	static class Board {
		Set<Ship> ships;

		Board(Set<Ship> ships) {
			this.ships = ships;
		}
	}

	static class Ship {
		Set<Cordinates> cordinates;

		Ship(Set<Cordinates> cordinates) {
			this.cordinates = cordinates;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Ship ship = (Ship) o;
			return Objects.equals(cordinates, ship.cordinates);
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(cordinates);
		}
	}

	static class Cordinates {
		int x, y;

		Cordinates(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o)
		{
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Cordinates that = (Cordinates) o;
			return x == that.x && y == that.y;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(x, y);
		}
	}

	static class Player {
		Board board;
		Player(Board board) {
			this.board = board;
		}

		TurnResult play(int x, int y) {
			Cordinates search = new Cordinates(x, y);
			TurnResult result = TurnResult.MISS;
			Ship ship = null;
			for(Ship s : board.ships) {
				if (s.cordinates.remove(search)) {
					result = TurnResult.HIT;
					ship = s;
					break;
				}
			}

			if(ship != null && ship.cordinates.isEmpty()) {
				board.ships.remove(ship);
				result = TurnResult.SHIP_SUNK;
			}


			if(board.ships.isEmpty())
				result = TurnResult.WINNER;

			return result;
		}
	}

	public static void main(String[] args) {
		Set<Cordinates> d = new HashSet<>(Arrays.asList(new Cordinates(3, 2), new Cordinates(3, 3)));
		Set<Cordinates> b = new HashSet<>(Arrays.asList(new Cordinates(7, 2), new Cordinates(6, 2), new Cordinates(5, 2), new Cordinates(4, 2)));

		Board board = new Board(new HashSet<>(Arrays.asList(new Ship(d), new Ship(b))));

		Player p1 = new Player(board);
		System.out.println(p1.play(3, 2));
		System.out.println(p1.play(3, 1));
		System.out.println(p1.play(7, 2));
		System.out.println(p1.play(3, 3));
		System.out.println(p1.play(6, 2));
		System.out.println(p1.play(5, 2));
		System.out.println(p1.play(4, 2));
	}
}
