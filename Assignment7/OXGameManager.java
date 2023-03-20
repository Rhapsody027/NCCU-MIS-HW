public class OXGameManager {
    private boolean state = true;
    private boolean finish = false;
    private int count = 0;
    private int[] checkerboard = new int[9];
    private String winner = null;
    private int scoreO = 0;
    private int scoreX = 0;

    // Play the O, X on checkerboard
    public String play(int index) {
        count++;

        if (state) {
            state = false;
            checkerboard[index] = 1;
            return "O";
        } else {
            state = true;
            checkerboard[index] = -1;
            return "X";
        }
    }

    // Return if the game is finish or not
    public boolean finish() {
        return count == 9 ? true : finish;
    }

    // Initialize the game
    public void initialize() {
        state = true;
        finish = false;
        count = 0;
        checkerboard = new int[9];
        winner = null;
    }

    // Get O score
    public int getScoreO() {
        return scoreO;
    }

    // Get X score
    public int getScoreX() {
        return scoreX;
    }

    // Checking who is the winner or null
    public String checkWin() {
        int[][] lines = new int[][] {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 },
                { 0, 3, 6 },
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 0, 4, 8 },
                { 2, 4, 6 }
        };

        // 檢查O時(+1)，state已切換至X的狀態(-1)，反之亦然
        int current = state ? -1 : 1;

        for (int[] line : lines) {
            boolean makeLine = true;

            for (int idx : line) {
                if (checkerboard[idx] != current)
                    makeLine = false;
            }

            if (makeLine) {
                winner = calScore();
                break;
            }
        }

        return winner;
    }

    public String calScore() {
        if (!state) {
            scoreO++;
            return "O";
        } else {
            scoreX++;
            return "X";
        }
    }
}