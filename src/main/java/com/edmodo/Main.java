package com.edmodo;

import com.edmodo.modelController.UserRec;
import com.edmodo.viewController.ObjController;
import com.edmodo.util.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by pc on 29.01.2017.
 */
public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("E-Trade v1.2.0");
        initRootLayout();
        prepareToShow("/view/AccessView.fxml");
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/RootLayout.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareToShow(String pathToFXML) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(pathToFXML));
            AnchorPane window = loader.load();
            rootLayout.setCenter(window);
            ObjController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegistrationForm() {
        prepareToShow("/view/RegistrationView.fxml");
    }

    public void showTradeForm() {
        prepareToShow("/view/TradeView.fxml");
    }

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        Application.launch(args);
    }
}
