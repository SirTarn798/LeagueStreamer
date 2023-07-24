package ku.cs.lab02javafx;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Hello World");
        configRoute();
        FXRouter.goTo("me-profile");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("me-profile", viewPath + "me.fxml");
        FXRouter.when("league-streamer-profile", viewPath+"league-streamer-profile.fxml");
        FXRouter.when("league-streamer-list", viewPath + "league-streamer-list.fxml");
        FXRouter.when("add-streamer", viewPath + "add-streamer.fxml");
    }

    public static void main(String[] args) {

        launch();
    }
}