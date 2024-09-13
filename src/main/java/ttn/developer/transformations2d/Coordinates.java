package ttn.developer.transformations2d;

import javafx.beans.property.SimpleDoubleProperty;

public class Coordinates {
    private final SimpleDoubleProperty x = new SimpleDoubleProperty();
    private final SimpleDoubleProperty y = new SimpleDoubleProperty();
    private final SimpleDoubleProperty translatedX = new SimpleDoubleProperty();
    private final SimpleDoubleProperty translatedY =  new SimpleDoubleProperty();
    private final SimpleDoubleProperty scaledX = new SimpleDoubleProperty();
    private final SimpleDoubleProperty scaledY = new SimpleDoubleProperty();
    private final SimpleDoubleProperty rotatedX = new SimpleDoubleProperty();
    private final SimpleDoubleProperty rotatedY = new SimpleDoubleProperty();
    private final SimpleDoubleProperty shearedX = new SimpleDoubleProperty();
    private final SimpleDoubleProperty shearedY = new SimpleDoubleProperty();

    public double getX() {
        return x.get();
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public double getY() {
        return y.get();
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public double getTranslatedX() {
        return translatedX.get();
    }

    public void setTranslatedX(double translatedX) {
        this.translatedX.set(translatedX);
    }

    public double getTranslatedY() {
        return translatedY.get();
    }

    public void setTranslatedY(double translatedY) {
        this.translatedY.set(translatedY);
    }

    public double getScaledX() {
        return scaledX.get();
    }

    public void setScaledX(double scaledX) {
        this.scaledX.set(scaledX);
    }

    public double getScaledY() {
        return scaledY.get();
    }

    public void setScaledY(double scaledY) {
        this.scaledY.set(scaledY);
    }

    public double getRotatedX() {
        return rotatedX.get();
    }

    public void setRotatedX(double rotatedX) {
        this.rotatedX.set(rotatedX);
    }

    public double getRotatedY() {
        return rotatedY.get();
    }

    public void setRotatedY(double rotatedY) {
        this.rotatedY.set(rotatedY);
    }

    public double getShearedX() {
        return shearedX.get();
    }

    public void setShearedX(double shearedX) {
        this.shearedX.set(shearedX);
    }

    public double getShearedY() {
        return shearedY.get();
    }

    public void setShearedY(double shearedY) {
        this.shearedY.set(shearedY);
    }
}
