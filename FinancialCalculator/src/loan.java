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



public class loan {
    public static void getEMIforLoan() {
        Stage scene4 = new Stage();
        GridPane gridloan = new GridPane();
        gridloan.setPadding(new Insets(10, 10, 10, 10));
        gridloan.setVgap(8);
        gridloan.setHgap(10);
        Label title1 = new Label("--------Installments for Loans----- ");
        title1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,16));

        Label loanterm = new Label("    Loan Term(in years):   ");
        loanterm.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        TextField loanterm_textField = new TextField();

        Label Start_principal = new Label("    Principal Amount :  ");
        TextField Start_principal_textField = new TextField();
        Start_principal.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        Label Interest = new Label("    Interest Rate per Year    :     ");
        TextField Interest_textField = new TextField();
        Interest.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        Label amount_year = new Label("    No. of Installments per Year :");
        TextField amount_textField = new TextField();
        amount_year.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));


        Button btnL = new Button("Calculate");
        btnL.setPrefSize(100,20);
        btnL.setStyle("-fx-background-color: #48d09b;");
        btnL.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));

        Button BackL = new Button("Back");
        BackL.setPrefSize(100,20);
        BackL.setStyle("-fx-background-color: #eea2ad;");
        BackL.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));



        //gridpane layout
        gridloan.setConstraints(title1, 2, 0);
        gridloan.setConstraints(loanterm, 0, 1);
        gridloan.setConstraints(loanterm_textField, 1, 1);
        gridloan.setConstraints(Start_principal, 0, 2);
        gridloan.setConstraints(Start_principal_textField, 1, 2);
        gridloan.setConstraints(Interest, 0, 3);
        gridloan.setConstraints(Interest_textField, 1, 3);
        gridloan.setConstraints(amount_year, 0, 4);
        gridloan.setConstraints(amount_textField, 1, 4);
        gridloan.setConstraints(btnL, 1, 10);
        gridloan.setConstraints(BackL, 2, 13);


        gridloan.getChildren().addAll(title1, loanterm, loanterm_textField, Start_principal, Start_principal_textField, Interest, Interest_textField,amount_year,amount_textField,btnL, BackL);
        scene4 = new Stage();


        btnL.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String val1 = Start_principal_textField.getText();
                String val2 = loanterm_textField.getText();
                String val3 = Interest_textField.getText();
                String val4 = amount_textField.getText();

                if (val1.isEmpty()){
                    Alert alert1= new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("ERROR");
                    alert1.setHeaderText("Please Enter your Start Principal!");
                    alert1.showAndWait();
                }else if(val2.isEmpty()){
                    Alert alert2= new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("ERROR");
                    alert2.setHeaderText("Please Enter the term of your Loan!");
                    alert2.showAndWait();

                }else if(val3.isEmpty()){
                    Alert alert3= new Alert(Alert.AlertType.ERROR);
                    alert3.setTitle("ERROR");
                    alert3.setHeaderText("Please the Interest Value!");
                    alert3.showAndWait();

                }else if(val4.isEmpty()){
                    Alert alert4= new Alert(Alert.AlertType.ERROR);
                    alert4.setTitle("ERROR");
                    alert4.setHeaderText("Please Enter the number of installments you wish to make in one year!");
                    alert4.showAndWait();

                }else {
                    try {
                        double i = Double.parseDouble(val3) / 100;
                        double x = 1 + i;
                        double y = (Math.pow(x, Double.parseDouble(val2)));
                        double a = (Math.pow(x, (Double.parseDouble(val2) - 1)));
                        double EMI = Math.round(((Double.parseDouble(val1) * i) * y) / a) * 100.0 / 100.0;
                        double EMImonth=Math.round(EMI / 12)*100/100;
                        double total_interest = (EMI * (Double.parseDouble(val2))) - (Double.parseDouble(val1));
                        double total_paid = (EMI * (Double.parseDouble(val2)));

                        //Labels for FV
                        Label lb1 = new Label(" Installment : " + "$" + (EMI / (Double.parseDouble(val4))));
                        lb1.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));
                        Label lb2 = new Label(" Amount paid per month :  " + EMImonth);
                        lb2.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb3 = new Label(" Principal Amount: " + "$" + val1);
                        lb2.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb4 = new Label(" Total Paid :" + total_paid);
                        lb4.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));

                        Label lb5 = new Label(" Interest Rate: " + val3 + "%");
                        lb5.setFont(Font.font("Calibri Body", FontWeight.NORMAL, FontPosture.REGULAR,14));
                        Label lb6 = new Label(" Total Interest: " + "$" + total_interest);
                        lb6.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR,14));

                        //Label layout
                        gridloan.setConstraints(lb1, 4, 1);
                        gridloan.setConstraints(lb2, 4, 2);
                        gridloan.setConstraints(lb3, 4, 3);
                        gridloan.setConstraints(lb4, 4, 4);
                        gridloan.setConstraints(lb5, 4, 5);
                        gridloan.setConstraints(lb6, 4, 6);


                        gridloan.getChildren().addAll(lb1, lb2, lb3, lb4, lb5, lb6);

                    }catch (Exception e){
                        Alert alert5= new Alert(Alert.AlertType.ERROR);
                        alert5.setTitle("ERROR");
                        alert5.setHeaderText("Please Enter integers only!");
                        alert5.showAndWait();

                    }

                }


            }
        });
        BackL.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage scene2 = (Stage) BackL.getScene().getWindow();
                scene2.close();
            }
        });


        gridloan.setStyle("-fx-background-color: #e1e7c3;");
        scene4.setScene(new Scene(gridloan, 900, 400));
        scene4.show();
        scene4.setTitle("Loan Calculator");
    }
}


