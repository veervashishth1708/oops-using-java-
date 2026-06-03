
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Random;

public class project2 extends JFrame {

    private final BoardPanel board = new BoardPanel();
    private final JButton rollBtn = new JButton("Roll Dice");
    private final JButton resetBtn = new JButton("New Game");
    private final JLabel status = new JLabel("Player 1 Turn");
    private final JLabel diceLabel = new JLabel("Dice: -");

    private int p1 = 1, p2 = 1;
    private boolean p1Turn = true;
    private final Random rnd = new Random();

    private final HashMap<Integer,Integer> jumps = new HashMap<>();

    public project2() {
        setTitle("Advanced Snake & Ladder");
        setSize(950, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMap();

        JPanel bottom = new JPanel();
        bottom.add(status);
        bottom.add(diceLabel);
        bottom.add(rollBtn);
        bottom.add(resetBtn);

        rollBtn.addActionListener(e -> rollDice());
        resetBtn.addActionListener(e -> resetGame());

        add(board, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initMap() {
        jumps.put(4,25);
        jumps.put(13,46);
        jumps.put(33,49);
        jumps.put(42,63);
        jumps.put(50,69);
        jumps.put(62,81);
        jumps.put(74,92);

        jumps.put(27,5);
        jumps.put(40,3);
        jumps.put(54,31);
        jumps.put(66,45);
        jumps.put(89,53);
        jumps.put(95,72);
        jumps.put(99,41);
    }

    private void resetGame() {
        p1 = p2 = 1;
        p1Turn = true;
        status.setText("Player 1 Turn");
        diceLabel.setText("Dice: -");
        board.repaint();
    }

    private void rollDice() {
        rollBtn.setEnabled(false);

        new Thread(() -> {
            int dice = rnd.nextInt(6) + 1;

            SwingUtilities.invokeLater(() ->
                    diceLabel.setText("Dice: " + dice));

            try {
                animateMove(dice);
            } catch (Exception ignored) {}

            SwingUtilities.invokeLater(() -> {
                checkWinner();
                p1Turn = !p1Turn;
                status.setText(p1Turn ? "Player 1 Turn" : "Player 2 Turn");
                board.repaint();
                rollBtn.setEnabled(true);
            });
        }).start();
    }

    private void animateMove(int dice) throws Exception {

        if (p1Turn) {
            for (int i = 0; i < dice; i++) {
                if (p1 < 100) p1++;
                board.repaint();
                Thread.sleep(180);
            }
            if (jumps.containsKey(p1)) {
                p1 = jumps.get(p1);
            }
        } else {
            for (int i = 0; i < dice; i++) {
                if (p2 < 100) p2++;
                board.repaint();
                Thread.sleep(180);
            }
            if (jumps.containsKey(p2)) {
                p2 = jumps.get(p2);
            }
        }

        board.repaint();
    }

    private void checkWinner() {
        if (p1 >= 100) {
            JOptionPane.showMessageDialog(this,"Player 1 Wins!");
            resetGame();
        }
        if (p2 >= 100) {
            JOptionPane.showMessageDialog(this,"Player 2 Wins!");
            resetGame();
        }
    }

    class BoardPanel extends JPanel {

        private final int cell = 80;

        public BoardPanel() {
            setPreferredSize(new Dimension(800,800));
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            for (int row = 0; row < 10; row++) {
                for (int col = 0; col < 10; col++) {

                    int x = col * cell;
                    int y = row * cell;

                    g2.setColor((row + col) % 2 == 0
                            ? new Color(230,240,255)
                            : new Color(255,245,220));

                    g2.fillRect(x,y,cell,cell);
                    g2.setColor(Color.BLACK);
                    g2.drawRect(x,y,cell,cell);

                    int num;
                    if ((9-row) % 2 == 0)
                        num = (9-row)*10 + col + 1;
                    else
                        num = (9-row)*10 + (10-col);

                    g2.drawString(String.valueOf(num), x+5, y+15);
                }
            }

            drawLadder(g2,4,25);
            drawLadder(g2,13,46);
            drawLadder(g2,42,63);
            drawLadder(g2,74,92);

            drawSnake(g2,27,5);
            drawSnake(g2,54,31);
            drawSnake(g2,89,53);
            drawSnake(g2,99,41);

            drawPlayer(g2,p1,Color.RED,0);
            drawPlayer(g2,p2,Color.BLUE,22);
        }

        private Point getPos(int n) {

            int row = 9 - ((n - 1) / 10);
            int pos = (n - 1) % 10;

            int col;
            if (((n - 1) / 10) % 2 == 0)
                col = pos;
            else
                col = 9 - pos;

            return new Point(col * cell + cell/2,
                    row * cell + cell/2);
        }

        private void drawLadder(Graphics2D g2, int a, int b) {
            Point p1 = getPos(a);
            Point p2 = getPos(b);

            g2.setStroke(new BasicStroke(4));
            g2.setColor(new Color(139,69,19));

            g2.drawLine(p1.x-10,p1.y,p2.x-10,p2.y);
            g2.drawLine(p1.x+10,p1.y,p2.x+10,p2.y);

            for(int i=1;i<8;i++) {
                int x1 = p1.x-10 + (p2.x-p1.x)*i/8;
                int y1 = p1.y + (p2.y-p1.y)*i/8;

                int x2 = p1.x+10 + (p2.x-p1.x)*i/8;
                int y2 = p1.y + (p2.y-p1.y)*i/8;

                g2.drawLine(x1,y1,x2,y2);
            }
        }

        private void drawSnake(Graphics2D g2, int a, int b) {
            Point p1 = getPos(a);
            Point p2 = getPos(b);

            g2.setStroke(new BasicStroke(8));
            g2.setColor(new Color(0,140,0));

            g2.drawLine(p1.x,p1.y,p2.x,p2.y);
            g2.fillOval(p1.x-10,p1.y-10,20,20);
        }

        private void drawPlayer(Graphics2D g2, int pos, Color c, int offset) {
            Point p = getPos(pos);
            g2.setColor(c);
            g2.fillOval(p.x-15+offset,p.y-15,25,25);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(project2::new);
    }
}
