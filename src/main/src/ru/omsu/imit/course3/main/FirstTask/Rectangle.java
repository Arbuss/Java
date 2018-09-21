package src.ru.omsu.imit.course3.main.FirstTask;

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

    public static void main(String[] args) throws IOException {
        Rectangle rec = new Rectangle(2, 4, 6, 8);

        File file = new File("C://Проекты студентов и преподавателей//3 курс//Buss//course3-1//" +
                "src//main//src//ru//omsu//imit//course3//main//FirstTask//files//rectangles");

        FileOutputStream fos = new FileOutputStream(file);

        byte[] buffer = rec.toString().getBytes();
        fos.write(buffer);

        fos.flush();
        fos.close();


        FileInputStream fin = new FileInputStream(file);

        String str = "";

        buffer = new byte[fin.available()];

        fin.read(buffer, 0, fin.available());
        double[] doubleArray = new double[4];
        //System.out.print((char)buffer[3]);
        int j = 0;
        for(int i = 0; i < 4; i++) {
            while(true){
                if((char)buffer[j] == ';') {
                    j++;
                    break;
                }
                str += (char) buffer[j];
                j++;
            }
            doubleArray[i] = Double.parseDouble(str);
            str = "";
        }
        Rectangle rec1 = new Rectangle(doubleArray[0], doubleArray[1], doubleArray[2], doubleArray[3]);

        System.out.println(doubleArray[0] + "; " + doubleArray[1] + "; " + doubleArray[2] + "; " + doubleArray[3]);
    }
}