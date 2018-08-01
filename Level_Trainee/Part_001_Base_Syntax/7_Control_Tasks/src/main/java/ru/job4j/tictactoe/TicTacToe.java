package ru.job4j.tictactoe;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * Class TicTacToe describes visual component.
 *
 * @author Alex Proshak (olexandr_proshak@ukr.net)
 */
public class TicTacToe extends Application {

    /**
     * The header.
     */
    private static final String JOB4J = "Tic-tac-toe www.job4j.ru";

    /**
     * The board size.
     */
    private final int size = 3;

    /**
     * The cells array.
     */
    private final Figure3T[][] cells = new Figure3T[size][size];

    /**
     * The games logic.
     */
    private final Logic3T logic = new Logic3T(cells);

    /**
     * The method build cell game board.
     * @param x parameter.
     * @param y parameter.
     * @param size parameter.
     * @return rectangle.
     */
    private Figure3T buildRectangle(int x, int y, int size) {
        Figure3T rect = new Figure3T();
        rect.setX(x * size);
        rect.setY(y * size);
        rect.setHeight(size);
        rect.setWidth(size);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        return rect;
    }

    /**
     * The method marks 0.
     * @param x parameter.
     * @param y parameter.
     * @param size parameter.
     * @return visual group.
     */
    private Group buildMarkO(double x, double y, int size) {
        Group group = new Group();
        int radius = size / 2;
        Circle circle = new Circle(x + radius, y + radius, radius - 10);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        group.getChildren().add(circle);
        return group;
    }

    /**
     * The method shows alert.
     * @param message to display.
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(JOB4J);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * The method checks board state.
     * @return true if all cells are filled.
     */
    private boolean checkState() {
        boolean gap = this.logic.hasGap();
        if (!gap) {
            this.showAlert("All cells are filled up! Start new game!");
        }
        return gap;
    }

    /**
     * The method checks who is winner.
     */
    private void checkWinner() {
        if (this.logic.isWinnerX()) {
            this.showAlert("Crosses win! Start new game!");
        } else if (this.logic.isWinnerO()) {
            this.showAlert("Zeros win! Start new game!");
        }
    }

    /**
     * The method build mark X.
     * @param x parameter.
     * @param y parameter.
     * @param size parameter.
     * @return new X visual group.
     */
    private Group buildMarkX(double x, double y, int size) {
        Group group = new Group();
        group.getChildren().addAll(
                new Line(
                        x + 10, y  + 10,
                        x + size - 10, y + size - 10
                ),
                new Line(
                        x + size - 10, y + 10,
                        x + 10, y + size - 10
                )
        );
        return group;
    }

    /**
     * The method describes eventListener.
     * @param panel parameter.
     * @return event handler.
     */
    private EventHandler<MouseEvent> buildMouseEvent(Group panel) {
        return event -> {
            Figure3T rect = (Figure3T) event.getTarget();
            if (this.checkState()) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    rect.take(true);
                    panel.getChildren().add(
                            this.buildMarkX(rect.getX(), rect.getY(), 50)
                    );
                } else {
                    rect.take(false);
                    panel.getChildren().add(
                            this.buildMarkO(rect.getX(), rect.getY(), 50)
                    );
                }
                this.checkWinner();
                this.checkState();
            }
        };
    }

    /**
     * The method builds cells grid.
     * @return panel.
     */
    private Group buildGrid() {
        Group panel = new Group();
        for (int y = 0; y != this.size; y++) {
            for (int x = 0; x != this.size; x++) {
                Figure3T rect = this.buildRectangle(x, y, 50);
                this.cells[y][x] = rect;
                panel.getChildren().add(rect);
                rect.setOnMouseClicked(this.buildMouseEvent(panel));
            }
        }
        return panel;
    }

    /**
     * Ths start method.
     * @param stage parameter.
     */
    @Override
    public void start(Stage stage) {
        BorderPane border = new BorderPane();
        HBox control = new HBox();
        control.setPrefHeight(40);
        control.setSpacing(10.0);
        control.setAlignment(Pos.BASELINE_CENTER);
        Button start = new Button("Start");
        start.setOnMouseClicked(
                event -> border.setCenter(this.buildGrid())
        );
        control.getChildren().addAll(start);
        border.setBottom(control);
        border.setCenter(this.buildGrid());
        stage.setScene(new Scene(border, 300, 300));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.show();
    }
}