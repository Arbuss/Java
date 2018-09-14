package src.ru.omsu.imit.cource3.main.FirstTask;

import java.awt.geom.Point2D;
import java.io.*;

public class Rectangle {
    private Point2D.Double leftTop;
    private Point2D.Double rightBottom;

    public Rectangle(double leftTopX, double leftTopY, double rightBottomX, double rightBottomY){
        leftTop = new Point2D.Double(leftTopX, leftTopY);
        rightBottom = new Point2D.Double(rightBottomX, rightBottomY);
    }

    public Rectangle(Point2D.Double lt, Point2D.Double rb){
        this(lt.x, lt.y, rb.x, rb.y);
    }

    public Point2D.Double getLeftTop() {
        return leftTop;
    }

    public void setLeftTop(Point2D.Double leftTop) {
        this.leftTop = leftTop;
    }

    public Point2D.Double getRightBottom() {
        return rightBottom;
    }

    public void setRightBottom(Point2D.Double rightBottom) {
        this.rightBottom = rightBottom;
    }

    @Override
    public String toString() {
        return leftTop.x + ";" + leftTop.y + ";" + rightBottom.x + ";" + rightBottom.y;
    }

    public static void main(String[] args) throws IOException {
        Rectangle rec = new Rectangle(2, 4, 6, 2);

        File file = new File("C://Проекты студентов и преподавателей//3 курс//Buss//course3-1//" +
                "src//main//src//ru//omsu//imit//cource3//main//FirstTask//files//rectangles");

        FileOutputStream fos = new FileOutputStream(file);

        byte[] buffer = rec.toString().getBytes();
        fos.write(buffer);

        fos.flush();
        fos.close();


        FileInputStream fin = new FileInputStream(file);

    }
}