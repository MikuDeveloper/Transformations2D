package ttn.developer.transformations2d;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Transformations2DController implements Initializable {
    Stage stage;
    Image appIcon;
    @FXML
    BorderPane borderPane;
    @FXML
    Canvas canvas;
    GraphicsContext graphicsContext;
    @FXML
    TextField xPointTextField;
    @FXML
    TextField yPointTextField;
    @FXML
    Button addPointButton;
    @FXML
    Button clearTableButton;
    @FXML
    TableView<Coordinates> coordinatesTableView;
    TableColumn<Coordinates, Double> xColumn;
    TableColumn<Coordinates, Double> yColumn;
    TableColumn<Coordinates, Double> translatedXColumn;
    TableColumn<Coordinates, Double> translatedYColumn;
    TableColumn<Coordinates, Double> scaledXColumn;
    TableColumn<Coordinates, Double> scaledYColumn;
    TableColumn<Coordinates, Double> rotatedXColumn;
    TableColumn<Coordinates, Double> rotatedYColumn;
    TableColumn<Coordinates, Double> shearedXColumn;
    TableColumn<Coordinates, Double> shearedYColumn;
    @FXML
    TextField xTranslateField;
    @FXML
    TextField yTranslateField;
    @FXML
    Button translateButton;
    @FXML
    TextField xScaleTextField;
    @FXML
    TextField yScaleTextField;
    @FXML
    Button scaleButton;
    @FXML
    TextField rotateField;
    @FXML
    Button rotateButton;
    @FXML
    ChoiceBox<String> shearChoiceBox;
    @FXML
    TextField shearField;
    @FXML
    Button shearButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appIcon = new Image(String.valueOf(Transformations2DApplication.class.getResource("icons/favicon.png")));

        shearChoiceBox.getItems().add("X");
        shearChoiceBox.getItems().add("Y");
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFont(new Font(10));

        xColumn = new TableColumn<>("X");
        xColumn.setResizable(false);
        xColumn.setSortable(false);
        xColumn.setReorderable(false);

        yColumn = new TableColumn<>("Y");
        yColumn.setResizable(false);
        yColumn.setSortable(false);
        yColumn.setResizable(false);

        translatedXColumn = new TableColumn<>("Xt");
        translatedXColumn.setResizable(false);
        translatedXColumn.setSortable(false);
        translatedXColumn.setReorderable(false);

        translatedYColumn = new TableColumn<>("Yt");
        translatedYColumn.setResizable(false);
        translatedYColumn.setSortable(false);
        translatedYColumn.setReorderable(false);

        scaledXColumn = new TableColumn<>("Xs");
        scaledXColumn.setResizable(false);
        scaledXColumn.setSortable(false);
        scaledXColumn.setReorderable(false);

        scaledYColumn = new TableColumn<>("Ys");
        scaledYColumn.setResizable(false);
        scaledYColumn.setSortable(false);
        scaledYColumn.setReorderable(false);

        rotatedXColumn = new TableColumn<>("Xr");
        rotatedXColumn.setResizable(false);
        rotatedXColumn.setSortable(false);
        rotatedXColumn.setReorderable(false);

        rotatedYColumn = new TableColumn<>("Yr");
        rotatedYColumn.setResizable(false);
        rotatedYColumn.setSortable(false);
        rotatedYColumn.setReorderable(false);

        shearedXColumn = new TableColumn<>("Xss");
        shearedXColumn.setResizable(false);
        shearedXColumn.setSortable(false);
        shearedXColumn.setReorderable(false);

        shearedYColumn = new TableColumn<>("Yss");
        shearedYColumn.setResizable(false);
        shearedYColumn.setSortable(false);
        shearedYColumn.setReorderable(false);

        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
        translatedXColumn.setCellValueFactory(new PropertyValueFactory<>("translatedX"));
        translatedYColumn.setCellValueFactory(new PropertyValueFactory<>("translatedY"));
        scaledXColumn.setCellValueFactory(new PropertyValueFactory<>("scaledX"));
        scaledYColumn.setCellValueFactory(new PropertyValueFactory<>("scaledY"));
        rotatedXColumn.setCellValueFactory(new PropertyValueFactory<>("rotatedX"));
        rotatedYColumn.setCellValueFactory(new PropertyValueFactory<>("rotatedY"));
        shearedXColumn.setCellValueFactory(new PropertyValueFactory<>("shearedX"));
        shearedYColumn.setCellValueFactory(new PropertyValueFactory<>("shearedY"));

        coordinatesTableView.getColumns().add(xColumn);
        coordinatesTableView.getColumns().add(yColumn);
        coordinatesTableView.getColumns().add(translatedXColumn);
        coordinatesTableView.getColumns().add(translatedYColumn);
        coordinatesTableView.getColumns().add(scaledXColumn);
        coordinatesTableView.getColumns().add(scaledYColumn);
        coordinatesTableView.getColumns().add(rotatedXColumn);
        coordinatesTableView.getColumns().add(rotatedYColumn);
        coordinatesTableView.getColumns().add(shearedXColumn);
        coordinatesTableView.getColumns().add(shearedYColumn);
        coordinatesTableView.setPlaceholder(new Label("Sin coordenadas"));

        drawPlane();
    }

    private void drawPlane() {
        double width = canvas.getWidth();
        double height = canvas.getHeight();

        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setLineWidth(1.0);
        graphicsContext.beginPath();
        graphicsContext.lineTo(0, height / 2);
        graphicsContext.lineTo(width, height / 2);
        graphicsContext.closePath();
        graphicsContext.stroke();

        graphicsContext.beginPath();

        int xCounter = 0;
        for (int i = -10; i <= 10; i++) {
            if (i == 0) {
                xCounter += 30;
                continue;
            }
            graphicsContext.fillText(i + "", xCounter - 1, height / 2 + 13);
            graphicsContext.strokeLine(xCounter + 5, height / 2 - 3, xCounter + 5, height / 2 + 3);
            xCounter += 30;
        }
        int yCounter = 0;
        for (int i = 10; i >= -10; i--) {
            if (i == 0) {
                yCounter += 30;
                continue;
            }
            graphicsContext.fillText(i + "", width / 2 + 5, yCounter + 10);
            graphicsContext.strokeLine(width / 2 - 3, yCounter + 5, width / 2 + 3, yCounter + 5);
            yCounter += 30;
        }

        graphicsContext.closePath();

        graphicsContext.beginPath();
        graphicsContext.lineTo(width / 2, 0);
        graphicsContext.lineTo(width / 2, height);
        graphicsContext.closePath();
        graphicsContext.stroke();
    }

    @FXML
    private void addPointToTableAction() {
        final double xPoint, yPoint;
        try {
            xPoint = Double.parseDouble(xPointTextField.getText());
            yPoint = Double.parseDouble(yPointTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            showInformationAlert("Error de puntos", "El valor ingresado en X o Y no es válido.", Alert.AlertType.ERROR);
            return;
        }
        xPointTextField.clear();
        yPointTextField.clear();

        Coordinates coordinates = new Coordinates();
        coordinates.setX(xPoint);
        coordinates.setY(yPoint);
        coordinatesTableView.getItems().add(coordinates);
    }

    @FXML
    void drawPoints() {
        final int size = coordinatesTableView.getItems().size();
        if (size == 0 || size == 1) {
            showInformationAlert("Faltan coordenadas", "Se necesitan al menos dos puntos para graficar.", Alert.AlertType.INFORMATION);
            return;
        }
        double [] xTablePoints = new double[size];
        double [] yTablePoints = new double[size];

        ObservableList<Coordinates> items = coordinatesTableView.getItems();
        fillArrays(items, xTablePoints, yTablePoints);

        graphicsContext.setStroke(Color.CYAN);
        graphicsContext.setLineWidth(2.0);
        graphicsContext.beginPath();
        graphicsContext.strokePolygon(xTablePoints, yTablePoints, items.size());
        graphicsContext.closePath();
    }

    @FXML
    private void translationAction() {
        final double xValue, yValue;
        try {
            xValue = Double.parseDouble(xTranslateField.getText());
            yValue = Double.parseDouble(yTranslateField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            showInformationAlert("Error de traslación", "El valor ingresado en X o Y no es válido.", Alert.AlertType.ERROR);
            return;
        }

        int size = coordinatesTableView.getItems().size();
        double [] xPoints = new double[size];
        double [] yPoints = new double[size];
        fillArrays(coordinatesTableView.getItems(), xPoints, yPoints);

        Transformations2D transformations2D = new Transformations2D(xPoints, yPoints);
        transformations2D.translation(coordinatesTableView.getItems(), xValue, yValue);

        drawTransformation(transformations2D.getTransformedXPoints(), transformations2D.getTransformedYPoints(), size, Color.SIENNA);
        coordinatesTableView.refresh();
    }

    @FXML
    private void scaleAction() {
        final double xScaleValue, yScaleValue;
        try {
            xScaleValue = Double.parseDouble(xScaleTextField.getText());
            yScaleValue = Double.parseDouble(yScaleTextField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            showInformationAlert("Error de escalamiento", "El valor ingresado en X o Y no es válido.", Alert.AlertType.ERROR);
            return;
        }

        int size = coordinatesTableView.getItems().size();
        double [] xPoints = new double[size];
        double [] yPoints = new double[size];
        fillArrays(coordinatesTableView.getItems(), xPoints, yPoints);

        Transformations2D transformations2D = new Transformations2D(xPoints, yPoints);
        transformations2D.scale(coordinatesTableView.getItems(), xScaleValue, yScaleValue, canvas.getWidth(), canvas.getHeight());
        drawTransformation(transformations2D.getTransformedXPoints(), transformations2D.getTransformedYPoints(), size, Color.YELLOWGREEN);
        coordinatesTableView.refresh();
    }

    @FXML
    private void rotateAction() {
        final double rotateValue;
        try {
            rotateValue = Double.parseDouble(rotateField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            showInformationAlert("Error de rotación", "El valor ingresado no es válido.", Alert.AlertType.ERROR);
            return;
        }

        int size = coordinatesTableView.getItems().size();
        double [] xPoints = new double[size];
        double [] yPoints = new double[size];

        Transformations2D transformations2D = new Transformations2D(xPoints, yPoints);
        transformations2D.rotate(coordinatesTableView.getItems(), rotateValue, canvas.getWidth(), canvas.getHeight());
        drawTransformation(transformations2D.getTransformedXPoints(), transformations2D.getTransformedYPoints(), size, Color.FIREBRICK);
        coordinatesTableView.refresh();
    }

    @FXML
    private void shearAction() {
        if (shearChoiceBox.getSelectionModel().getSelectedItem() == null) {
            showInformationAlert("Faltan datos", "No se ha seleccionado un eje para aplicar el sesgo.", Alert.AlertType.INFORMATION);
            return;
        }
        final double shearFactor;
        try {
            shearFactor = Double.parseDouble(shearField.getText());
        } catch (NumberFormatException | NullPointerException e) {
            showInformationAlert("Error de sesgado", "El valor proporcionado no es válido.", Alert.AlertType.ERROR);
            return;
        }

        final String axis = shearChoiceBox.getSelectionModel().getSelectedItem();
        ObservableList<Coordinates> items = coordinatesTableView.getItems();

        double [] xPoints = new double[items.size()];
        double [] yPoints = new double[items.size()];

        Transformations2D transformations2D = new Transformations2D(xPoints, yPoints);
        transformations2D.shear(items, axis, shearFactor, canvas.getWidth(), canvas.getHeight());
        drawTransformation(transformations2D.getTransformedXPoints(), transformations2D.getTransformedYPoints(), items.size(), Color.GOLDENROD);
        coordinatesTableView.refresh();
    }

    private void drawTransformation(double[] xTranslationPoints, double[] yTranslationPoints, int size, Color color) {
        graphicsContext.setStroke(color);
        graphicsContext.setLineWidth(2.0);
        graphicsContext.beginPath();
        graphicsContext.strokePolygon(xTranslationPoints, yTranslationPoints, size);
        graphicsContext.closePath();
    }

    private void fillArrays(ObservableList<Coordinates> items, double[] xPoints, double[] yPoints) {
        final double width = canvas.getWidth();
        final double height = canvas.getHeight();
        int counter = 0;
        for (Coordinates coordinates : items) {
            double xValue = coordinates.getX();
            double yValue = coordinates.getY();
            xValue = xValue * 30;
            yValue = yValue * 30;
            xPoints[counter] = width / 2 + xValue;
            yPoints[counter] = (yValue > 0) ? (height / 2 - yValue) : (height / 2 + yValue * -1);
            counter++;
        }
    }

    @FXML
    public void clearTableAction() {
        coordinatesTableView.getItems().clear();
    }

    @FXML
    private void clearCanvasAction() {
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        drawPlane();
    }

    private void showInformationAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);

        stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(appIcon);

        alert.setTitle("2D Transformations");
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}