class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean rowsValid = isRowsValid(board);
        boolean columnsValid = isColumnsValid(board);
        boolean subBoxesValid = isSubBoxesValid(board);

        return rowsValid && columnsValid && subBoxesValid;
    }

    private boolean isRowsValid(char[][] board) {
        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < board.length; i++) {
            map = new HashMap();
            for(int j = 0; j < board[0].length; j++) {
                if(map.containsKey(board[i][j]) && board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }
        return true;
    }

    private boolean isColumnsValid(char[][] board) {
        Map<Character,Integer> map = new HashMap();
        for(int i = 0; i < board[0].length; i++) {
            map = new HashMap();
            for(int j = 0; j < board.length; j++) {
                if(map.containsKey(board[j][i])&& board[j][i] != '.')
                    return false;
                map.put(board[j][i],1);
            }
        }
        return true;
    }

    private boolean isSubBoxesValid(char[][] board) {
        Map<Character,Integer> map = new HashMap();
        
        //0-3 X 0-3
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //3-6 X 0-3
        map = new HashMap();
        for(int i = 3; i < 6; i++) {
            for(int j = 0; j < 3; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //6-9 X 0-3
        map = new HashMap();
        for(int i = 6; i < 9; i++) {
            for(int j = 0; j < 3; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //0-3 X 3-6
        map = new HashMap();
        for(int i = 0; i < 3; i++) {
            for(int j = 3; j < 6; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //0-3 X 6-9
        map = new HashMap();
        for(int i = 0; i < 3; i++) {
            for(int j = 6; j < 9; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //3-6 X 3-6
        map = new HashMap();
        for(int i = 3; i < 6; i++) {
            for(int j = 3; j < 6; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //3-6 X 6-9
        map = new HashMap();
        for(int i = 3; i < 6; i++) {
            for(int j = 6; j < 9; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //6-9 X 3-6
        map = new HashMap();
        for(int i = 6; i < 9; i++) {
            for(int j = 3; j < 6; j++) {
                if(map.containsKey(board[i][j])&& board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        //6-9 X 6-9
        map = new HashMap();
        for(int i = 6; i < 9; i++) {
            for(int j = 6; j < 9; j++) {
                if(map.containsKey(board[i][j]) && board[i][j] != '.')
                    return false;
                map.put(board[i][j],1);
            }
        }

        return true;
    }
}
