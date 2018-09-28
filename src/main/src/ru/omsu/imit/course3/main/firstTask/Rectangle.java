package src.ru.omsu.imit.course3.main.firstTask;

import java.io.*;

public class Rectangle {
    private Point2D leftTop;
    private Point2D rightBottom;

    public Rectangle(double leftTopX, double leftTopY, double rightBottomX, double rightBottomY){
        leftTop = new Point2D(leftTopX, leftTopY);
        rightBottom = new Point2D(rightBottomX, rightBottomY);
    }

    public Rectangle(Point2D lt, Point2D rb){
        this(lt.x, lt.y, rb.x, rb.y);
    }

    public Point2D getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(Point2D leftTop) {
        this.leftTop = leftTop;
    }

    public Point2D getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(Point2D rightBottom) {
        this.rightBottom = rightBottom;
    }

    @Override
    public String toString() {
        return leftTop.x + ";" + leftTop.y + ";" + rightBottom.x + ";" + rightBottom.y + ";";
    }
}