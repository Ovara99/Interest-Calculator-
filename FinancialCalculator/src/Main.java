import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)  {

        Stage scene1= new Stage();


        //Finance Calculator MainPage

        Button button1 = new Button("Savings Calculator");
        button1.setLayoutX(300);
        button1.setLayoutY(100);
        button1.setPrefSize(250,20);
        button1.setStyle("-fx-background-color: #3baee5;");
        button1.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,16));
        Button button2 = new Button("Fixed Deposit Calculator");
        button2.setLayoutX(300);
        button2.setLayoutY(150);
        button2.setPrefSize(250,20);
        button2.setStyle("-fx-background-color: #3baee5;");
        button2.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,16));

        Button button3 = new Button("Loan Calculator");
        button3.setLayoutX(300);
        button3.setLayoutY(200);
        button3.setPrefSize(250,20);
        button3.setStyle("-fx-background-color: #3baee5;");
        button3.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,16));

        Button button4 = new Button("Mortgage Calculator");
        button4.setLayoutX(300);
        button4.setLayoutY(250);
        button4.setPrefSize(250,20);
        button4.setStyle("-fx-background-color: #3baee5;");
        button4.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,16));


        Button btnhelp = new Button("Help View");
        btnhelp.setLayoutX(600);
        btnhelp.setLayoutY(350);
        btnhelp.setPrefSize(150,20);
        btnhelp.setStyle("-fx-background-color: #FF7F50;");
        btnhelp.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,16));




        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage1=(Stage)button1.getScene().getWindow();
                Savings.getsSavingsFV();

            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage1=(Stage)button2.getScene().getWindow();
                Fixed_Deposit.getFixedDepositFV();

            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage1=(Stage)button3.getScene().getWindow();
                loan.getEMIforLoan();

            }
        });

        button4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage stage1=(Stage)button4.getScene().getWindow();
                Mortgage.getMortgageValue();

            }
        });
        btnhelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stagehelp=(Stage) btnhelp.getScene().getWindow();
                help.gethelpView();


            }
        });



        Pane root = new Pane();
        root.setStyle("-fx-background-color: #73947d");
        root.getChildren().add(button1) ;
        root.getChildren().add(button2);
        root.getChildren().add(button3);
        root.getChildren().add(button4);
        root.getChildren().add(btnhelp);
        Scene scene=new Scene(root, 800, 400);
        scene1.setScene(scene);
        scene1.show();
        scene1.setTitle("Finance Calculator");


    }

}
