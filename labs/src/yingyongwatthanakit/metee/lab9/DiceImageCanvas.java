package yingyongwatthanakit.metee.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DiceImageCanvas extends JPanel {

    static final long SERIAL_VER_ID =
            4397914223424048061L;

    protected int diceNumber;
    protected Graphics2D g2d;
    protected int width = 150, height = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;
    protected int middleCircleX = startSquareX + (width - circleWidth) / 2;
    protected int middleCircleY = startSquareY + (height - circleHeight) / 2;
    protected int left = startSquareX + margin;
    protected int right = startSquareX + width - margin - circleWidth;
    protected int top = startSquareY + margin;
    protected int bottom = startSquareY + height - margin - circleHeight;
    protected Ellipse2D.Double circleMiddle, circleTopLeft, circleTopRight, circleBottomLeft, circleBottomRight
                            , circleTopMiddle, circleBottomMiddle;
    protected Rectangle2D.Double square;
    protected Ellipse2D.Double[] dice1, dice2, dice3, dice4, dice5, dice6;
    protected Ellipse2D.Double[][] diceSet;

    public DiceImageCanvas(int diceNumber) {
        this.setSize(canvasWidth, canvasHeight);
        // init all components
        initComponents();
        this.diceNumber = diceNumber;
    }

    protected void initComponents() {
        circleMiddle = new Ellipse2D.Double(middleCircleX, middleCircleY, circleWidth, circleHeight);
        circleTopLeft = new Ellipse2D.Double(left, top, circleWidth, circleHeight);
        circleTopRight = new Ellipse2D.Double(right, top, circleWidth, circleHeight);
        circleBottomLeft = new Ellipse2D.Double(left, bottom, circleWidth, circleHeight);
        circleBottomRight = new Ellipse2D.Double(right, bottom, circleWidth, circleWidth);
        circleTopMiddle = new Ellipse2D.Double(middleCircleX, top, circleWidth, circleHeight);
        circleBottomMiddle = new Ellipse2D.Double(middleCircleX, bottom, circleWidth, circleHeight);
        square = new Rectangle2D.Double(startSquareX, startSquareY, width, height);
        dice1 = new Ellipse2D.Double[] {circleMiddle};
        dice2 = new Ellipse2D.Double[] {circleBottomLeft, circleTopRight};
        dice3 = new Ellipse2D.Double[] {circleBottomLeft, circleMiddle, circleTopRight};
        dice4 = new Ellipse2D.Double[] {circleTopLeft, circleTopRight, circleBottomLeft, circleBottomRight};
        dice5 = new Ellipse2D.Double[] {circleTopLeft, circleTopRight, circleMiddle, circleBottomLeft, circleBottomRight};
        dice6 = new Ellipse2D.Double[] {circleTopLeft, circleTopMiddle, circleTopRight, circleBottomLeft, circleBottomMiddle, circleBottomRight};
        diceSet = new Ellipse2D.Double[][] {dice1, dice2, dice3, dice4, dice5, dice6};
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fill(square);
        g2d.setColor(Color.RED);
        for (Ellipse2D.Double circle : diceSet[diceNumber - 1]) {
            g2d.fill(circle);
        }
    }
}
