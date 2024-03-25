import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class GUI extends Application {
    private Stage primaryStage;
    private VendingMachine vm;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initVendingMachine();

        VBox vbox = new VBox();
        Label label1 = new Label("Vending Machine");
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        Label label2 = new Label("Credit: " + Double.toString(vm.getCredit()));

        label1.setFont(new Font(15));

        Product[] products = vm.getProducts();

        for(int i = 0; i < products.length; ++i) {
            VBox elem = new VBox();
            Button b = new Button(products[i].getName());
            final int I = i;
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        vm.buyProduct(I);
                        label2.setText("Credit: " + vm.getCredit());
                        label1.setText("You have purchased: " + products[I].getName());
                    }
                    catch(Exception ignored) {}
                }
            });
            b.setMinWidth((V.WIDTH - 60 - 40) / 4);
            b.setMinHeight(50);
            b.setFont(new Font(15));

            elem.getChildren().addAll(
                    b,
                    new Label("€" + products[i].getPrice()
            ));
            hbox1.getChildren().add(elem);
        }
        hbox1.setSpacing(20);
        hbox1.setAlignment(Pos.CENTER);


        label2.setMinWidth(V.WIDTH / 2);
        hbox2.getChildren().add(label2);
        double[] coins = {0.50, 1.00, 2.00};

        for(int i = 0; i < coins.length; ++i) {
            Button b = new Button(Double.toString(coins[i]));
            final int I = i;
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        vm.editCredit(coins[I]);
                        label2.setText("Credit: " + Double.toString(vm.getCredit()));
                    }
                    catch(Exception ignored) {}
                }
            });
            b.setMinWidth((V.WIDTH / 2 - 40 - 30) / 3);

            hbox2.getChildren().add(b);
        }
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);

        vbox.getChildren().addAll(label1, hbox1, hbox2);
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(20);

        Scene scene = new Scene(vbox, V.WIDTH, V.HEIGHT);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    private void initVendingMachine() {
        try {
            this.vm = new VendingMachine(0, new Product[]{
                    new Product("Coffee", 0.50),
                    new Product("Tea", 1.00),
                    new Product("Hot Chocolate", 2.10),
                    new Product("Cappuccino", 1.50)
            });
        }
        catch(Exception ignored) {}
    }
}
