package ttn.developer.transformations2d;

import javafx.collections.ObservableList;

import java.util.Objects;

public class Transformations2D {
    private final double[] xPoints;
    private final double[] yPoints;

    public Transformations2D(double[] xPoints, double[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public void translation(ObservableList<Coordinates> items, double xValue, double yValue) {
        int counter = 0;
        for (Coordinates item : items) {
            item.setTranslatedX(item.getX() + xValue);
            item.setTranslatedY(item.getY() + yValue);
            xPoints[counter] += xValue * 30;
            yPoints[counter] += (yValue > 0) ? (-yValue * 30) : (yValue * 30 * -1);
            counter++;
        }
    }

    public void scale(ObservableList<Coordinates> items, double xValue, double yValue, double width, double height) {
        int counter = 0;
        for (Coordinates item : items) {
            item.setScaledX(item.getX() * xValue);
            item.setScaledY(item.getY() * yValue);
            /*xPoints[counter] += item.getScaledX() * 30;
            yPoints[counter] += (yValue > 0) ? (-item.getScaledY() * 30) : (item.getScaledY() * 30 * -1);*/
            xPoints[counter] = width / 2 + (item.getScaledX() * 30);
            yPoints[counter] = (yValue > 0) ? (height / 2 - (item.getScaledY() * 30)) : (height / 2 + item.getScaledY() * 30 * -1);
            /*xPoints[counter] = item.getScaledX();
            yPoints[counter] = item.getScaledY();*/
            counter++;
        }
    }

    public void rotate(ObservableList<Coordinates> items, double angle, double width, double height) {
        int counter = 0;
        for (Coordinates item : items) {
            /*item.setRotatedX(item.getX() * Math.cos(angle / 57.2957795) - item.getY() * Math.sin(angle / 57.2957795));
            item.setRotatedY(item.getY() * Math.cos(angle / 57.2957795) + item.getX() * Math.sin(angle / 57.2957795));*/
            item.setRotatedX(items.getFirst().getX() + (item.getX() - items.getFirst().getX()) * Math.cos(angle / 57.2957795) - (item.getY() - items.getFirst().getY()) * Math.sin(angle / 57.2957795));
            item.setRotatedY(items.getFirst().getY() + (item.getX() - items.getFirst().getX()) * Math.sin(angle / 57.2957795) + (item.getY() - items.getFirst().getY()) * Math.cos(angle / 57.2957795));

            xPoints[counter] = width / 2 + (item.getRotatedX() * 30);
            yPoints[counter] = (angle > 0) ? (height / 2 - (item.getRotatedY() * 30)) : (height / 2 + item.getRotatedY() * 30 * -1);

            counter++;
        }
    }

    public void shear(ObservableList<Coordinates> items, String axis, double factor, double width, double height) {
        int counter = 0;
        for (Coordinates item : items) {
            if (Objects.equals(axis, "X")) {
                item.setShearedX(item.getX() + item.getY() * factor);
                item.setShearedY(item.getY());
            } else {
                item.setShearedX(item.getX());
                item.setShearedY(item.getY() + item.getX() * factor);
            }

            xPoints[counter] = width / 2 + (item.getShearedX() * 30);
            yPoints[counter] = (factor > 0) ? (height / 2 - (item.getShearedY() * 30)) : (height / 2 + item.getShearedY() * 30 * -1);

            counter++;
        }
    }

    public double[] getTransformedXPoints() {
        return xPoints;
    }
    public double[] getTransformedYPoints() {
        return yPoints;
    }
}
