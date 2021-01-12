import javafx.application.*;
import javafx.beans.value.*;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
public class A7 extends Application {
    Stage myStage;
    Scene myScene1, myScene2;
    Label ti, fn, ln, pn, gender, uv, sk, check, p1, p2, p3, p4, p5,st, sg, op, ou,sk2;
    ListView<String> lvTitle, lvSkills;
    TextField tfFN, tfLN, tfPN;
    RadioButton rb1, rb2, rb3;
    ComboBox<String> cbUn;
    Button bRv, back, submit;
    String selectedTitle, inputPhonenumber, outputPhonenumber , ge, selectedGender, inputUniversity, outputUniversity, selectedSkill;
    ObservableList<String> getList;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage stage){
        Stage myStage = stage;
        myStage.setTitle("New Grad Application");

        GridPane grid = new GridPane();
        GridPane gd = new GridPane();
        myScene1 = new Scene(grid, 400,500 );

        myStage.setScene(myScene1);
        ti = new Label("Titles");
        lvTitle = new ListView<String>();
        lvTitle.setPrefWidth(90);
        lvTitle.setPrefHeight(60);
        lvTitle.getItems().addAll("Mr", "Mrs", "Ms");
        lvTitle.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tfFN = new TextField();
        tfLN = new TextField();
        tfPN = new TextField();
        fn = new Label("FirstName");
        ln = new Label("LastName");
        pn = new Label("Phone Number");

        gender = new Label("Gender");
        rb1 = new RadioButton("Male");
        rb2 = new RadioButton("Female");
        rb3 = new RadioButton("Other");
        rb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                if(rb1.isSelected()){
                    rb2.setSelected(false);
                    rb3.setSelected(false);
                }
            }
        });
        rb2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                if(rb2.isSelected()){
                    rb1.setSelected(false);
                    rb3.setSelected(false);
                }
            }
        });
        rb3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                if(rb3.isSelected()){
                    rb1.setSelected(false);
                    rb2.setSelected(false);
                }
            }
        });

        uv = new Label("University");
        cbUn = new ComboBox<>();
        cbUn.setPrefSize(100, 60);
        cbUn.getItems().addAll("Santa Clara University","San Jose State University");
        cbUn.setPromptText("Santa Clara University");

        sk = new Label("Skills");
        lvSkills = new ListView<String>();
        lvSkills.getItems().addAll("Java", "Python", "C++");
        lvTitle.setPrefWidth(90);
        lvTitle.setPrefHeight(60);
        lvSkills.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        bRv = new Button("Review");

        gd.add(ti, 0, 0);
        gd.add(lvTitle, 0, 1);
        gd.add(fn, 0, 2);
        gd.add(tfFN, 0, 3);
        gd.add(ln, 1, 2);
        gd.add(tfLN, 1, 3);
        gd.add(gender, 0, 4);
        gd.add(rb1, 0, 5);
        gd.add(rb2, 0, 6);
        gd.add(rb3, 0, 7);
        gd.add(pn, 1, 4);
        gd.add(tfPN, 1, 5);
        gd.add(uv, 0, 8);
        gd.add(cbUn, 0, 9);
        gd.add(sk, 0, 10);
        gd.add(lvSkills, 0, 11);
        gd.add(bRv, 0, 12);
        grid.add(gd, 0, 0);

        gd.setHgap(10);
        gd.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));




        bRv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                buttonClicked();
                myStage.setScene(myScene2);
            }
        });


        FlowPane fp = new FlowPane(Orientation.VERTICAL, 10, 10);
        fp.setAlignment(Pos.CENTER_LEFT);
        back = new Button("< Back");
        submit = new Button("Submit");
        check = new Label("Thank you for applying, please review your details");
        fp.setPadding(new Insets(10, 10, 10, 20));
        st = new Label(selectedTitle);
        sg = new Label(selectedGender);
        op = new Label(outputPhonenumber);
        ou = new Label(outputUniversity);
        sk2 = new Label(selectedSkill);

        myScene2 = new Scene(fp, 400,500 );

        //bRv.setOnAction(e -> myStage.setScene(myScene2));


        fp.getChildren().addAll(back, check, st, sg, op, ou, sk2, submit);
        myStage.show();
    }
    private void buttonClicked() {

        //name
        getList = lvTitle.getSelectionModel().getSelectedItems();

        selectedTitle = getList.get(0) + " " + tfLN.getText() + " " + tfLN.getText();
        System.out.println(selectedTitle);

        // gender
        if (rb1.isSelected()) {
            ge = "Male";
        }
        if (rb2.isSelected()) {
            ge = "Female";
        }
        if (rb3.isSelected()) {
            ge = "Other";
        }
        selectedGender = "Gender: " + ge;
        System.out.println(selectedGender);

        //phone number
        outputPhonenumber = "Phone Number: " + tfPN.getText();
        System.out.println(outputPhonenumber);

        //university
        outputUniversity = "University: " + cbUn.getValue();
        System.out.println(outputUniversity);

        //selectedSkill
        getList = lvSkills.getSelectionModel().getSelectedItems();
        selectedSkill = "Skills selected are: " ;
        for(String s : getList){
            selectedSkill +=  s + " ";
        }
        System.out.println(selectedSkill);


    }
}