import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class help {
    public static void gethelpView() {

        Stage stagehelp = new Stage();
        Pane pane = new Pane();

        Label lb1 = new Label("Instructions");
        Label lb2 = new Label("1. Please choose the Required Calculator you wish to use by clicking on the respective button.");
        Label lb3 = new Label("2. Savings- Gives you the value you will have in the future after depositing a certain amount and then depositing in a yearly basis.");
        Label lb4 = new Label("3. Fixed Deposit- The amount you will receive after a number of years after depositing a amount.");
        Label lb5 = new Label("4. Loan Calculator- Amount you need to pay as an Installment after getting your loan.");
        Label lb6 = new Label("5. Mortage Calculator- Amount you need to pay monthly.");
        Label lb7 = new Label("6. Fill in the required fields and click 'Calculate'.");
        Label lb8 = new Label("7. Click 'Back' to return to the main menu.");
        Button helpback= new Button("Back");
        helpback.setLayoutX(600);
        helpback.setLayoutY(300);
        helpback.setPrefSize(150,20);
        helpback.setStyle("-fx-background-color: #FF7F50;");
        helpback.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,16));



        //styles
        lb1.setFont(Font.font("Verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
        lb1.setLayoutX(380);
        lb2.setLayoutY(50);
        lb2.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb2.setLayoutX(50);
        lb2.setLayoutY(80);
        lb3.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb3.setLayoutX(50);
        lb3.setLayoutY(110);
        lb4.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb4.setLayoutX(50);
        lb4.setLayoutY(140);
        lb5.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb5.setLayoutX(50);
        lb5.setLayoutY(170);
        lb6.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb6.setLayoutX(50);
        lb6.setLayoutY(200);
        lb7.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb7.setLayoutX(50);
        lb7.setLayoutY(230);
        lb8.setFont(Font.font("Calibri Body",FontWeight.NORMAL,FontPosture.REGULAR,14));
        lb8.setLayoutX(50);
        lb8.setLayoutY(260);
        pane.getChildren().addAll(lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,helpback);


        helpback.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage scene2 = (Stage) helpback.getScene().getWindow();
                scene2.close();
            }
        });


        stagehelp.setScene(new Scene(pane, 900, 400));
        pane.setStyle("-fx-background-color: #e1e7c3");
        stagehelp.show();
        stagehelp.setTitle("Help");



    }
}

