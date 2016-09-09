/*
 * Rishabh Mahajani
 * Program Statement: tours a knight through a grid for as many squares as possible
 */

package Mahajani;

import java.util.ArrayList;


public class KnightsTour {
	
	private int[][] acc = {{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},
	{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2}}; 
	
	private int currentRow = 0;
	
	private int currentCol = 0;
	
	private int moveNumber=8;
	
	private int[][] board = new int[8][8]; 
	
	private int numMoves=2;
	
	private int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
	
	private int[] vertical = {-1,-2,-2,-1,1,2,2,1};
	
	
	/**
	 * default constructor-sets fields currentRow and currentCol to 0
	 */
	public KnightsTour() {
		
		setCurrentRow(0);
		
		setCurrentCol(0);
		
	} // default constructor to initialize row and column of knight
	
	
	/**
	 * constructor which sets currentRow and currentCol to parameters
	 * @param currentRow- the field currentRow is set to this value 
	 * @param currentCol-the field currentCol is set to this value
	 */
	public KnightsTour(int currentRow, int currentCol) {
		
		this.currentRow = currentRow;
		
		this.currentCol = currentCol;
		
	} // constructor that sets row and column of knight to values in parameters
	
	
	/**
	 * getter/returns currentRow
	 * @return the field currentRow
	 */
	public int getCurrentRow() {
		
		return currentRow;
		
	} // returns currentRow
	
	/**
	 * setter/sets currentRow to value in the parameter
	 * @param currentRow-new value for the field currentRow
	 */
	public void setCurrentRow(int currentRow) {
		
		this.currentRow = currentRow;
		
	} // sets currentRow to value in the parameter 
	
	/**
	 * getter/returns currentCol
	 * @return the field currentCol
	 */
	public int getCurrentCol() {
		
		return currentCol;
		
	}// returns currentCol
	
	/**
	 * setter/sets currentCol to the value in the parameter
	 * @param currentCol-the new value for the field currentCol
	 */
	public void setCurrentCol(int currentCol) {
		
		this.currentCol = currentCol;
		
	}// sets currentCol to the value in the parameter
	
	/**
	 * getter/returns numMoves
	 * @return the field numMoves
	 */
	public int getNumMoves() {
		return numMoves;
	}// returns the field numMoves
	
	/**
	 * sets all the values in the array board[][] to 0
	 */
	public void initialize() {
		for(int i=0;i<board.length;i++) {
			
			for(int j=0;j<board.length;j++) {
				
				board[i][j] = 0;
				
			}// ends inner for loop which sets all values in board to 0
			
		}// ends outer for loop
	}// ends method initialize
	/**
	 * prints out the array acc[][]
	 */
	public void returnAcc() {
		for(int i=0;i<acc.length;i++) {
			for(int j=0;j<acc[i].length;j++) {
				System.out.print(acc[i][j] + " ");
			}// this for loop prints out the acc array
			System.out.println(); 
		}// goes to next line at the end of each row
		
	}// closes the method returnAcc
	/**
	 * returns the optimal moveNumber for the knight
	 * @return the valid moveNumber that leads the knight to the space with the lowest accessibility
	 */
	public int returnMoveNumber() {
		boolean isOne = true;
		for(int i=0;i<acc.length;i++) {
			for(int j=0;j<acc[i].length;j++) {
				if(acc[i][j]!=0 && acc[i][j]!=1) 
					isOne = false;
			}// this loop checks whether the values in the acc array are all 0 or 1
		}// closes outer loop
		int myInd = 0;
		int[] validNum = new int[8];  
		for(moveNumber=0;moveNumber<vertical.length;moveNumber++) {
				if(isOne) {
			if(getCurrentRow()+vertical[moveNumber]<8 && getCurrentRow()+vertical[moveNumber]>=0 
			   
			   && getCurrentCol()+horizontal[moveNumber]<8 && getCurrentCol()+horizontal[moveNumber]>=0
			   
			   && acc[getCurrentRow()+vertical[moveNumber]][getCurrentCol()+horizontal[moveNumber]]!=0) {
				validNum[myInd] = moveNumber;
				myInd++;
				
			}// adds possible move numbers to the array validNum[]
				}// checks whether all numbers in acc array are 1
				else if(getCurrentRow()+vertical[moveNumber]<8 && getCurrentRow()+vertical[moveNumber]>=0 
			   
			   && getCurrentCol()+horizontal[moveNumber]<8 && getCurrentCol()+horizontal[moveNumber]>=0
			   
			   && acc[getCurrentRow()+vertical[moveNumber]][getCurrentCol()+horizontal[moveNumber]]!=0 &&
			   acc[getCurrentRow()+vertical[moveNumber]][getCurrentCol()+horizontal[moveNumber]]!=1) {
				   validNum[myInd] = moveNumber;
					myInd++;
				}// this statement has the extra statement that checks whether the moveNumber lands on a 1 in the acc array 
		}//closes the for loop
			if(myInd==0) {
				for(moveNumber=0;moveNumber<vertical.length;moveNumber++) {
					if(getCurrentRow()+vertical[moveNumber]<8 && getCurrentRow()+vertical[moveNumber]>=0 
							   
							   && getCurrentCol()+horizontal[moveNumber]<8 && getCurrentCol()+horizontal[moveNumber]>=0
							   
							   && acc[getCurrentRow()+vertical[moveNumber]][getCurrentCol()+horizontal[moveNumber]]!=0) {
								validNum[myInd] = moveNumber;
								myInd++;
								
							} // does this again in case i missed any moveNumbers before
				}//closes outer for loop
			}//closes if statement
		if(myInd>1)	{
			moveNumber = validNum[0];
			for(int i=1;i<myInd;i++) {
				if(acc[getCurrentRow()+vertical[validNum[i]]][getCurrentCol()+horizontal[validNum[i]]]<acc[getCurrentRow()+vertical[moveNumber]][getCurrentCol()+horizontal[moveNumber]]) moveNumber = validNum[i];
			} // checks out of the possible moveNumbers, which one will land in the lowest accessibility 
		}// closes if statement
		else if(myInd == 1) moveNumber = validNum[0];
		
		return moveNumber;
	
}// closes method returnMoveNumber
	
	/**
	 * Tours the knight to as many possible squares and prints out the grid
	 */
	public void Tour() {
		board[getCurrentRow()][getCurrentCol()]=1;
		acc[getCurrentRow()][getCurrentCol()]=0;
		for(int b=0;b<vertical.length;b++) {
			if (getCurrentRow()+vertical[b]<8 && getCurrentRow()+vertical[b]>=0 
				
				&& getCurrentCol()+horizontal[b]<8 && getCurrentCol()+horizontal[b]>=0 && acc[getCurrentRow() + vertical[b]][getCurrentCol() + horizontal[b]]!=0) 
				acc[getCurrentRow() + vertical[b]][getCurrentCol() + horizontal[b]]-=1;
		
		} // subtracts 1 from accessibility of surrounding squares for starting position 
		
		
		
		
		while(returnMoveNumber()!=8) {         			
			int minNum = returnMoveNumber();
			board[getCurrentRow()+vertical[minNum]][getCurrentCol()+horizontal[minNum]]=numMoves;
			
			for(int a=0;a<vertical.length;a++) {
				if (getCurrentRow()+vertical[a]<8 && getCurrentRow()+vertical[a]>=0 
					
					&& getCurrentCol()+horizontal[a]<8 && getCurrentCol()+horizontal[a]>=0 && acc[getCurrentRow() + vertical[a]][getCurrentCol() + horizontal[a]]!=0) 
					acc[getCurrentRow() + vertical[a]][getCurrentCol() + horizontal[a]]-=1;
				
			}// subtracts 1 from accessibility of surrounding squares after a move 
			
			setCurrentRow(getCurrentRow()+vertical[minNum]);
			
			setCurrentCol(getCurrentCol()+horizontal[minNum]);
			
			acc[getCurrentRow()][getCurrentCol()] = 0;
			
			numMoves++;
			
			
		}// the loop moves knight and changes accessibility matrix accordingly
		
		
		
		
		
		
		
		for(int h=0;h<board.length;h++) {
			
			for(int k=0;k<board.length;k++) {
				if(board[h][k]<10)
					System.out.print(board[h][k] + "   ");
				else System.out.print(board[h][k] + "  ");
				
			} // prints the board after the knight has finished the tour
			System.out.println();
			
		} // goes to the next line when the row has finished
		
		System.out.println("The number of moves is: " + (numMoves-1));	
		
		
		
	}// close method Tour
	
}//closes class KnightsTour