import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Fixed_Deposit {
    public static void getFixedDepositFV() {

        Stage scene3 = new Stage();
        GridPane gridfixed = new GridPane();
        gridfixed.setPadding(new Insets(10, 10, 10, 10));
        gridfixed.setVgap(8);
        gridfixed.setHgap(10);
        Label title1 = new Label("--------Fixed Deposit Calculator----- ");
        title1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,16));

        Label no_periods = new Label("  No. of periods(Years) :   ");
        TextField no_periods_textField = new TextField();
        no_periods.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        Label Start_principal = new Label("    Start Principal Amount :  ");
        TextField Start_principal_textField = new TextField();
        Start_principal.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        Label Interest = new Label("     Interest Rate     :     ");
        TextField Interest_textField = new TextField();
        Interest.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));


        //Buttons
        Button btnF = new Button("Calculate");
        btnF.setPrefSize(100,20);
        btnF.setStyle("-fx-background-color: #48d09b;");
        btnF.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));

        Button BackF=new Button("Back");
        BackF.setPrefSize(100,20);
        BackF.setStyle("-fx-background-color: #eea2ad;");
        BackF.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));


        //gridpane layout
        gridfixed.setConstraints(title1, 2, 0);
        gridfixed.setConstraints(no_periods, 0, 1);
        gridfixed.setConstraints(no_periods_textField, 1, 1);
        gridfixed.setConstraints(Start_principal, 0, 2);
        gridfixed.setConstraints(Start_principal_textField, 1, 2);
        gridfixed.setConstraints(Interest, 0, 3);
        gridfixed.setConstraints(Interest_textField, 1, 3);
        gridfixed.setConstraints(btnF, 1, 10);
        gridfixed.setConstraints(BackF, 2, 12);


        gridfixed.getChildren().addAll(title1, no_periods, no_periods_textField, Start_principal, Start_principal_textField,  Interest, Interest_textField, btnF,BackF);
        scene3 = new Stage();


        btnF.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String val1 = Start_principal_textField.getText();
                String val2 = no_periods_textField.getText();
                String val3 = Interest_textField.getText();

                if (val1.isEmpty()){
                    Alert alert1= new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("ERROR");
                    alert1.setHeaderText("Please Enter your Start Principal!");
                    alert1.showAndWait();
                }else if(val2.isEmpty()){
                    Alert alert2= new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("ERROR");
                    alert2.setHeaderText("Please Enter no. of years!");
                    alert2.showAndWait();

                }else if(val3.isEmpty()){
                    Alert alert3= new Alert(Alert.AlertType.ERROR);
                    alert3.setTitle("ERROR");
                    alert3.setHeaderText("Please the Interest Value!");
                    alert3.showAndWait();

                }else {
                    try {
                        double i = Double.parseDouble(val3) / 100;
                        double x = 1 + i;
                        double y = (Math.pow(x, Double.parseDouble(val2)));
                        double a = Math.round(Double.parseDouble(val1) * y)*100.0/100.0;
                        double total_interest = a -(Double.parseDouble(val1));

                        //Labels for FV
                        Label lb1 = new Label(" Future Value: " + "$" + a);
                        lb1.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));
                        Label lb2 = new Label(" Number of Periods :" + val2);
                        lb2.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb3 = new Label(" Interest Rate: " + val3 + "%");
                        lb3.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb4 = new Label(" Starting Investment: " + "$" + val1);
                        lb4.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb5 = new Label(" Total Interest: " + "$" + total_interest);
                        lb5.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));

                        //Label layout
                        gridfixed.setConstraints(lb3, 4, 1);
                        gridfixed.setConstraints(lb1, 4, 2);
                        gridfixed.setConstraints(lb2, 4, 3);
                        gridfixed.setConstraints(lb4, 4, 4);
                        gridfixed.setConstraints(lb5, 4, 5);


                        gridfixed.getChildren().addAll(lb1, lb2, lb3, lb4, lb5);


                    }catch (Exception e) {
                        Alert alert5 = new Alert(Alert.AlertType.ERROR);
                        alert5.setTitle("ERROR");
                        alert5.setHeaderText("Please Enter integers only!");
                        alert5.showAndWait();
                    }



                }

            }
        });
        BackF.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage scene2 = (Stage) BackF.getScene().getWindow();
                scene2.close();
            }
        });


        gridfixed.setStyle("-fx-background-color: #e1e7c3;");
        scene3.setScene(new Scene(gridfixed, 900, 400));
        scene3.show();
        scene3.setTitle("Fixed Deposits");
    }
}



