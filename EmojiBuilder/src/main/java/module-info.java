module com.mycompany.emojibuilder {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.emojibuilder to javafx.fxml;
    exports com.mycompany.emojibuilder;
}
