package p1;


public class sudoko {
private static final int GRID_SIZE = 9;

public static void main(String[] args) {
	
	 int[][] board = {
			 {7,0,2,0,5,0,6,0,0},
			 {0,0,0,0,0,3,0,0,0},
			 {1,0,0,0,0,9,5,0,0},
			 {8,0,0,0,0,0,0,9,0},
			 {0,4,3,0,0,0,7,5,0},
			 {0,9,0,0,0,0,0,0,8},
			 {0,0,9,7,0,0,0,0,5},
			 {0,0,0,2,0,0,0,0,0},
			 {0,0,7,0,4,0,2,0,3}
	 };
	 
	 printBoard(board);
	 
	if(SolverBoard(board))
	{
		System.out.println("solved sucessfully");
	}else {
		System.out.println("not solved sucessfully");
	}
	printBoard(board);
}
	

private static void printBoard(int[][] board)
{
	for(int i = 0 ; i < GRID_SIZE; i++) {
		if(i%3==0 && i!=0)
		{
			System.out.println("-----------");
		}
		for(int j = 0 ; j <GRID_SIZE; j++)
		{
			if(j%3==0 && j!=0) {
				System.out.print("|");
			}
			System.out.print(board[i][j]);
		}
		System.out.println();
	}
}
 
private static boolean inrow(int[][] board, int number, int row) {
	for(int i=0; i < GRID_SIZE ; i++)
	{
	if(board[row][i] == number) {
	return true;
	}
}
	return false;
	
}

private static boolean incolumn(int[][] board, int number, int column)
{
	for(int i=0 ; i < GRID_SIZE ; i++) {
		if(board[i][column] == number) {
			return true;
		}
	}
	return false;
}

private static boolean inbox(int[][] board, int number, int row, int column ) {
	int lBoxRow = row - row % 3;
	int lBoxColumn = column - column % 3;
	
	for(int i = lBoxRow ; i < lBoxRow + 3 ; i++) {
		for(int j = lBoxColumn ; j < lBoxColumn + 3; j++) {
			if(board[i][j] == number) {
				return true;
			}
		}
	}
	return false;
}

private static boolean ifValidPlacement(int[][] board, int number, int row, int column)
{
	return !inrow(board, number, row) &&
			!incolumn(board, number, column) &&
			!inbox(board, number, row, column);
}

private static boolean SolverBoard(int[][] board) {
	for(int row = 0 ; row < GRID_SIZE ; row++){
		for(int column = 0 ; column < GRID_SIZE ; column++){
			if(board[row][column] == 0){
				for( int totrynumber = 1; totrynumber <= GRID_SIZE; totrynumber++){
					if(ifValidPlacement(board,totrynumber,row,column)){
						board[row][column] = totrynumber;
					
					if(SolverBoard(board)){
						return true;
					}
					else{
						board[row][column] = 0;
					}
				}
			}
			return false;
		}
	}
}
return true;
}
}
