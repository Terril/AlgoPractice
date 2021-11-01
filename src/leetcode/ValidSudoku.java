package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static void main(String args[]) {
        char[][] board =
                {{'8' , '3' , '.' , '.' , '7' , '.' , '.' , '.' , '.'}
                        , {'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'}
                        , {'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'}
                        , {'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'}
                        , {'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'}
                        , {'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'}
                        , {'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'}
                        , {'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'}
                        , {'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'}};

        char[][] board1 = {{'.' , '.' , '4' , '.' , '.' , '.' , '6' , '3' , '.'},
                {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'},
                {'5' , '.' , '.' , '.' , '.' , '.' , '.' , '9' , '.'},
                {'.' , '.' , '.' , '5' , '6' , '.' , '.' , '.' , '.'},
                {'4' , '.' , '3' , '.' , '.' , '.' , '.' , '.' , '1'},
                {'.' , '.' , '.' , '7' , '.' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , '5' , '.' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'},
                {'.' , '.' , '.' , '.' , '.' , '.' , '.' , '.' , '.'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku1(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        boolean result = true;
        HashMap<Integer, Character> mapRow = new HashMap<>();
        HashMap<Integer, Character> mapCol = new HashMap<>();
        if (row == 0 || col == 0) {
            return false;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char val = board[i][j];
                if (mapRow.containsKey(i) || mapCol.containsKey(j)) {
                    char row1 = mapRow.getOrDefault(i, '.');
                    char col1 = mapCol.getOrDefault(j, '.');

                    if (Character.isDigit(val) && (row1 == val || col1 == val)) {
                        result = false;
                        break;
                    }
                }
                if(Character.isDigit(val))  {
                    mapRow.put(i, val);
                    mapCol.put(j, val);
                }
//                 if(i + 1 % 3 == 0 && j + 1 % 3 == 0) {

//                 } else {

//                 }
            }
        }

        return result;
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean result = true;

        for(int i = 0 ; i < 9 ; i++) {
            HashSet<Character> ch = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !ch.add(board[i][j])) {
                    return  false;
                }
            }

        }
        for(int i = 0 ; i < 9 ; i++) {
            HashSet<Character> ch = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[j][i] != '.' && !ch.add(board[j][i])) {
                    return false;
                }
            }
        }

        for(int i = 0 ; i < 9 ; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                HashSet<Character> ch = new HashSet<>();
                for(int k = i; k < i + 3; k++){
                    for(int l = j; l < j + 3; l++) {
                        if(board[k][l] != '.' && !ch.add(board[k][l])) {
                            return false;
                        }
                    }
                }

            }

        }

        return result;
    }
}

