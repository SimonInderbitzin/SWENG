package ch.fhnw.richards.lecture13_Networking.browser_url;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This example represents a simple browser, using the URL and HttpURLConnection
 * classes. We correctly fetch web-pages, however, these pages are simply
 * displayed in raw HTML
 */
public class Browser extends Application {
    private BrowserView view;
    private BrowserController controller;
    private BrowserModel model;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Create the standard MVC pattern
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Initialize the GUI
        model = new BrowserModel();
        view = new BrowserView(primaryStage, model);
        controller = new BrowserController(model, view);

        // Display the GUI after all initialization is complete
        view.start();
    }
}
