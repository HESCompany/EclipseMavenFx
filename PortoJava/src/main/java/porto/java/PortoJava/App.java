package porto.java.PortoJava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connect {
    static String user="root";
    static String pass="";
    static String url="jdbc:mysql://localhost/dbuas";
    static String driver="com.mysql.cj.jdbc.Driver";
    public static Connection init(){
        Connection conn=null;
        try{
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,pass);
            System.out.println("Connect Successful");
        }catch (ClassNotFoundException | SQLException e){
        	System.out.println("Connect Error");
        }
        return conn;
    }
}



/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        Connect.init();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}