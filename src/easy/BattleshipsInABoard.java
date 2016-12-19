package easy;

/**Given an 2D board, count how many different battleships are in it. The battleships are represented with
 * 'X's, empty slots are represented with '.'s. You may assume the following rules:
 *
 * You receive a valid board, made of only battleships or empty slots.
 *
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the
 * shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 *
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent
 * battleships.
 *
 * Created by Jeffrey on 2016/12/19.
 */
public class BattleshipsInABoard {
    /**
     * 这道题让我们求战舰的个数，所谓的战舰就是只能是一行或者一列，不能有拐弯。这道题降低了难度的做法是限定了不会有相邻的两个
     * 战舰的存在，有了这一点限制，那么我们只需要遍历一次二维数组就行了，只要找出战舰的起始点。所谓的战舰起始点，就是为X的点，
     * 而且该点的上方和左边的点不能为X，所以我们只要找出所有满足这个条件的点即可，参见代码如下：
     * @param board
     * @return
     */
    public int countBattleships(char[][] board) {
        int m = board.length;
        if(m == 0)
            return 0;
        int n = board[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.' || (i > 0) && board[i - 1][j] == 'X' || (j > 0) && board[i][j - 1] == 'X') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
