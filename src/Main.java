//Test Comment - J. H.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.repository.SQLiteConnectionSource;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        SQLiteConnectionSource db = new SQLiteConnectionSource();
//        db.initialize();
        try {
        Parent navigation = FXMLLoader.load(getClass().getResource("views/MainView.fxml"));
        Parent find = FXMLLoader.load(getClass().getResource("views/FindView.fxml"));
        Scene navScene = new Scene(navigation, 800, 500);
        Scene findScene = new Scene(find, 300, 300);
        primaryStage.setTitle("Potluck");
        primaryStage.setScene(navScene);
//        navScene.getRoot().getChildrenUnmodifiable().add(findScene.getRoot());
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(800);
        primaryStage.show();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
