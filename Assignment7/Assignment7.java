import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Assignment7 {
    static OXGameManager manager = new OXGameManager();
    static JButton[] btns = new JButton[9];
    static JLabel score = new JLabel(String.format("O: %d ; X: %d", 0, 0));
    static JButton reStart = new JButton("ReStart");
    static JButton finish = new JButton("Finish");
    static JFrame frame = new JFrame();
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 700;

    public static void main(String[] args) {
        frame.setVisible(true);
        frame.setTitle("Frame");
        frame.setLayout(new GridLayout(4, 2));
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        score.setFont(new Font("Arial", Font.PLAIN, 40));
        reStart.setFont(new Font("Arial", Font.PLAIN, 40));
        finish.setFont(new Font("Arial", Font.PLAIN, 40));

        // Lambda寫法
        reStart.addActionListener(e -> reStart());
        finish.addActionListener(e -> frame.dispose());

        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton();
            int index = i;
            btn.setText(Integer.toString(i));
            btn.setFont(new Font("Arial", Font.PLAIN, 50));

            btn.addActionListener(e -> {
                String player = manager.play(index);
                btn.setText(player);
                btn.setEnabled(false);

                if (manager.checkWin() != null)
                    finish();
            });

            btns[i] = btn;
        }

        frame.add(score);
        frame.add(reStart);
        frame.add(finish);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 9; i++) {
            frame.add(btns[i]);
        }
    }

    public static void reStart() {
        manager.initialize();

        for (int i = 0; i < 9; i++) {
            btns[i].setText(Integer.toString(i));
            btns[i].setFont(new Font("Arial", Font.PLAIN, 50));
            btns[i].setEnabled(true);
        }
    }

    public static void finish() {
        for (JButton jButton : btns) {
            jButton.setEnabled(false);
        }

        score.setText(String.format("O: %d ; X: %d",
                manager.getScoreO(), manager.getScoreX()));
    }
}
