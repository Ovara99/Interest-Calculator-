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

public class Savings {
    public static void getsSavingsFV() {


        Stage scene2 = new Stage();
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Label title1 = new Label("--------Savings Calculator----- ");
        title1.setPrefSize(300,20);
        title1.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR,16));


        Label no_periods = new Label("    No. of periods :   ");
        no_periods.setPrefSize(200,20);
        no_periods.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        TextField tx1 = new TextField();


        Label Start_principal = new Label("    Start Principal Amount :  ");
        Start_principal.setPrefSize(200,20);
        Start_principal.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        TextField Start_principaltxt = new TextField();

        Label Interest = new Label("     Interest Rate     :     ");
        Interest.setPrefSize(200,20);
        Interest.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));

        TextField Interesttxt = new TextField();
        Label PMT = new Label("    Amount Deposited Yearly :      ");
        PMT.setPrefSize(200,20);
        PMT.setFont(Font.font("Calibri Body", FontWeight.MEDIUM, FontPosture.REGULAR,14));
        TextField PMTtxt = new TextField();

        Button btnS = new Button("Calculate");
        btnS.setPrefSize(100,20);
        btnS.setStyle("-fx-background-color: #48d09b;");
        btnS.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));
        Button BackS=new Button("Back");
        BackS.setPrefSize(100,20);
        BackS.setStyle("-fx-background-color: #eea2ad;");
        BackS.setFont(Font.font("Calibri Body",FontWeight.BOLD,FontPosture.REGULAR,16));





        //gridpane layout
        grid2.setConstraints(title1, 2, 0);
        grid2.setConstraints(no_periods, 0, 1);
        grid2.setConstraints(tx1, 1, 1);
        grid2.setConstraints(Start_principal, 0, 2);
        grid2.setConstraints(Start_principaltxt, 1, 2);
        grid2.setConstraints(PMT, 0, 3);
        grid2.setConstraints(PMTtxt, 1, 3);
        grid2.setConstraints(Interest, 0, 4);
        grid2.setConstraints(Interesttxt, 1, 4);
        grid2.setConstraints(btnS, 1, 10);
        grid2.setConstraints(BackS, 2, 14);


        grid2.getChildren().addAll(title1, no_periods, tx1, Start_principal, Start_principaltxt, PMT, PMTtxt, Interest, Interesttxt, btnS,BackS);
        scene2 = new Stage();


        btnS.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String val1 = Start_principaltxt.getText();
                String val2 = tx1.getText();
                String val3 = Interesttxt.getText();
                String val4 = PMTtxt.getText();


                if (val1.isEmpty()){
                    Alert alert1= new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("ERROR");
                    alert1.setHeaderText("Please Enter your Start Principal!");
                    alert1.showAndWait();
                }else if(val2.isEmpty()){
                    Alert alert2= new Alert(Alert.AlertType.ERROR);
                    alert2.setTitle("ERROR");
                    alert2.setHeaderText("Please Enter No. of Periods!");
                    alert2.showAndWait();
                }else if(val3.isEmpty()){
                    Alert alert3= new Alert(Alert.AlertType.ERROR);
                    alert3.setTitle("ERROR");
                    alert3.setHeaderText("Please the Interest Value!");
                    alert3.showAndWait();

                }else if(val4.isEmpty()){
                    Alert alert4= new Alert(Alert.AlertType.ERROR);
                    alert4.setTitle("ERROR");
                    alert4.setHeaderText("Please Enter your Yearly deposit!");
                    alert4.showAndWait();

                }else {
                    try {

                        double i = Double.parseDouble(val3) / 100;
                        double x = 1 + i;
                        double y = (Math.pow(x, Double.parseDouble(val2)));
                        double a = Double.parseDouble(val1) * y;
                        double z = ((y - 1) / i) * Double.parseDouble(val4);
                        double FutureValue = Math.round((z + a) * 100.0) / 100.0;
                        double PValue = Math.round((FutureValue / y)*100.0)/100.0;
                        double total_principal = ((Double.parseDouble(val1) + ((Double.parseDouble(val2) * Double.parseDouble(val4)))));
                        double total_interest = FutureValue - total_principal;

                        //Labels for FV
                        Label lb1 = new Label(" Future Value: " + "$" + FutureValue);
                        lb1.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb8 = new Label(" Present Value: " + "$" + PValue);
                        lb8.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb2 = new Label(" Number of Periods :" + val2);
                        lb2.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb3 = new Label(" Interest Rate: " + val3 + "%");
                        lb3.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb4 = new Label(" Periodic Payment: " + val4);
                        lb4.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb5 = new Label(" Starting Investment: " + "$" + val1);
                        lb5.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb6 = new Label(" Total Principal: " + "$" + total_principal);
                        lb6.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));
                        Label lb7 = new Label(" Total Interest: " + "$" + total_interest);
                        lb7.setFont(Font.font("Calibri Body", FontWeight.BOLD, FontPosture.REGULAR, 14));

                        //Label layout
                        grid2.setConstraints(lb1, 4, 1);
                        grid2.setConstraints(lb2, 4, 2);
                        grid2.setConstraints(lb3, 4, 3);
                        grid2.setConstraints(lb4, 4, 4);
                        grid2.setConstraints(lb5, 4, 5);
                        grid2.setConstraints(lb6, 4, 6);
                        grid2.setConstraints(lb7, 4, 7);
                        grid2.setConstraints(lb8, 4, 8);

                        grid2.getChildren().addAll(lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8);
                    }catch (Exception e){
                        Alert alert5= new Alert(Alert.AlertType.ERROR);
                        alert5.setTitle("ERROR");
                        alert5.setHeaderText("Please Enter integers only!");
                        alert5.showAndWait();
                    }

                }
            }
        });
        BackS.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage scene2 = (Stage) BackS.getScene().getWindow();
                scene2.close();
            }
        });


        scene2.setScene(new Scene(grid2, 900, 400));
        grid2.setStyle("-fx-background-color: #e1e7c3");
        scene2.show();
        scene2.setTitle("Savings");
    }
}
