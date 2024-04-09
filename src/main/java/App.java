import controller.Controller;
import model.Deck;
import view.View;

public class App {

    public static void main(String[] args) {
        View view = new View();
        Deck deck = new Deck();
        deck.init();

        Controller controller = new Controller(view,deck);
        controller.run();
    }

}
