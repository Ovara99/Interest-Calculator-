import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.geometry.Insets;


public class Mortgage {
    public static void getMortgageValue() {
        Stage scene5 = new Stage();
        GridPane gridmort = new GridPane();
        gridmort.setPadding(new Insets(10, 10, 10, 10));
        gridmort.setVgap(8);
        gridmort.setHgap(10);
        Label title1 = new Label("--------Monthly Installment for Mortgage----- ");
        title1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,16));

        Label mortterm = new Label("    Loan Term(in years):   ");
        TextField mortterm_textField = new TextField();
        mortterm.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        Label Start_principal = new Label("    Principal Amount :  ");
        TextField Start_principal_textField = new TextField();
        Start_principal.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        Label Interest = new Label("     Interest Rate per Year    :     ");
        TextField Interest_textField = new TextField();
        Interest.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));


        Button btnM = new Button("Calculate");
        btnM.setPrefSize(100,20);
        btnM.setStyle("-fx-background-color: #48d09b;");
        btnM.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));

        Button BackM = new Button("Back");
        BackM.setPrefSize(100,20);
        BackM.setStyle("-fx-background-color: #eea2ad;");
        BackM.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));


        //gridpane layout
        gridmort.setConstraints(title1, 2, 0);
        gridmort.setConstraints(mortterm, 0, 1);
        gridmort.setConstraints(mortterm_textField, 1, 1);
        gridmort.setConstraints(Start_principal, 0, 2);
        gridmort.setConstraints(Start_principal_textField, 1, 2);
        gridmort.setConstraints(Interest, 0, 3);
        gridmort.setConstraints(Interest_textField, 1, 3);
        gridmort.setConstraints(btnM, 1, 10);
        gridmort.setConstraints(BackM, 2, 13);


        gridmort.getChildren().addAll(title1, mortterm, mortterm_textField, Start_principal, Start_principal_textField, Interest, Interest_textField,btnM, BackM);
        scene5 = new Stage();


        btnM.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String val1 = Start_principal_textField.getText();
                String val2 = mortterm_textField.getText();
                String val3 = Interest_textField.getText();

                if (val1.isEmpty()){
                    Alert alert1= new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("ERROR");
                    alert1.setHeaderText("Please Enter your Principal Amount borrowed!");
                    alert1.showAndWait();
                }else if(val2.isEmpty()){
                    Alert alert2= new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("ERROR");
                    alert2.setHeaderText("Please Enter your term of Mortage!");
                    alert2.showAndWait();

                }else if(val3.isEmpty()){
                    Alert alert3= new Alert(Alert.AlertType.ERROR);
                    alert3.setTitle("ERROR");
                    alert3.setHeaderText("Please the Interest Rate!");
                    alert3.showAndWait();

                }else {
                    try{
                        double i = Double.parseDouble(val3) / 100;
                        double x = 1 + i;
                        double y = (Math.pow(x, (-Integer.parseInt(val2))));
                        double a = 1-y;
                        double year_pay = Math.round(((Double.parseDouble(val1) *( i/a) ))/12) * 100.0 / 100.0;
                        double total_interest = (year_pay * (Integer.parseInt(val2))) - (Double.parseDouble(val1));
                        double total_paid = (year_pay * (Integer.parseInt(val2)));

                        //Labels for FV
                        Label lb1 = new Label(" Installment : " + "$" + year_pay );
                        lb1.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));
                        Label lb2 = new Label(" Principal Amount: " + "$" + val1);
                        lb2.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb3 = new Label(" Total Mortgage Paid :" + total_paid);
                        lb3.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));
                        Label lb4 = new Label(" Interest Rate: " + val3 + "%");
                        lb4.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb5 = new Label(" Total Interest: " + "$" + total_interest);
                        lb5.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));

                        //Label layout
                        gridmort.setConstraints(lb1, 4, 1);
                        gridmort.setConstraints(lb2, 4, 2);
                        gridmort.setConstraints(lb3, 4, 3);
                        gridmort.setConstraints(lb4, 4, 4);
                        gridmort.setConstraints(lb5, 4, 5);


                        gridmort.getChildren().addAll(lb1, lb2, lb3, lb4, lb5);


                    }catch (Exception e) {
                        Alert alert5 = new Alert(Alert.AlertType.ERROR);
                        alert5.setTitle("ERROR");
                        alert5.setHeaderText("Please Enter integers only!");
                        alert5.showAndWait();
                    }
                }
            }
        });
        BackM.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage scene2 = (Stage) BackM.getScene().getWindow();
                scene2.close();
            }
        });


        gridmort.setStyle("-fx-background-color: #e1e7c3;");
        scene5.setScene(new Scene(gridmort, 900, 400));
        scene5.show();
        scene5.setTitle("Mortgage Calculator");


    }
}
