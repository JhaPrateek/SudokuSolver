package Fun;
import java.util.Comparator;  
import java.util.HashMap;  
import java.util.Map;  
import java.util.PriorityQueue;
public class x {
	static boolean helper(char board[][],int row,int col){
        if(row==board.length){           //base condition
            return true;
        }
        int nrow=0;
        int ncol=0;
        if(col==board.length-1){
            nrow=row+1;
            ncol=0;
        }
        else{
            nrow=row;
            ncol=col+1;
        }
        if(board[row][col]!='.'){
            if(helper(board,nrow,ncol)){
                return true;
            }
        }
        else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col]=(char)(i+'0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }
                    else{
                        board[row][col]='.';
                    }
                }
            }
        }
        return false;
    }
    static boolean isSafe(char board[][],int row,int col,int num){
        for(int i=0;i<board.length;i++){             
            if(board[row][i]==(char)(num+'0')){             //row
                return false; 
            }
            if(board[i][col]==(char)(num+'0')){             //col
                return false;
            }
        }
        //grid
       int sr = 3 * (row/3);   //starting row of grid
       int sc = 3 * (col/3);   //starting column of grid
      
       for(int i=sr; i<sr+3; i++) {
           for(int j=sc; j<sc+3; j++) {
               if(board[i][j] == (char)(num+'0')) {
                   return false;
               }
           }
       }
        return true;
    }
	public static void main(String[] args) {
		char arr[][]= {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		helper(arr,0,0);
		for( int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
