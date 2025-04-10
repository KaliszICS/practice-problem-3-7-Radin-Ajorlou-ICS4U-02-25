public class PracticeProblem {

	public static void main(String args[]) {
		String[][] maze = {
			{"i", "i", "i", "i", "i"},
			{"i", "i", "i", "i", "i"},
			{"i", "i", "*", "i", "i"},
			{"S", "*", "F", "i", "i"},
		  };
		  System.out.println(searchMazeMoves(maze));

	}



	public static int searchMazeMoves(String[][] arr){
		int row = arr.length - 1;
		int column = 0;
		int moves = 0;
		int leastMoves = 1000;
		leastMoves = mazeHelper(arr, row, column, moves, leastMoves);
		if (leastMoves == 1000){
			return -1;
		}
		return leastMoves;
	}


	public static int mazeHelper(String[][] arr, int row, int column, int moves, int leastMoves){
		if (row < 0 || row >= arr.length || column < 0 || column >= arr[row].length || arr[row][column] == "*"){
			moves--;
			return leastMoves;
		}
		else if (arr[row][column] == "F"){
			System.out.println("\nFOUND " + moves);
			if (moves <= leastMoves){
				leastMoves = moves;
				return leastMoves;
			}
			return leastMoves;
		}

		arr[row][column] = "*";

		moves++;
		leastMoves = mazeHelper(arr, row, column + 1, moves, leastMoves); //move right
		moves--;
		moves++;
		leastMoves = mazeHelper(arr, row - 1, column, moves, leastMoves); //move up 
		moves--;
		moves++;
		leastMoves = mazeHelper(arr, row, column - 1, moves, leastMoves); //move left
		moves--;
		moves++;
		leastMoves = mazeHelper(arr, row + 1, column, moves, leastMoves); //move down
		arr[row][column] = "";

		return leastMoves;


	}

}
