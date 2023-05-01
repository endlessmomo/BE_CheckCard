import controller.CardController;
import service.CardService;

public class Application {
    public static void main(String[] args) {
        CardController controller = new CardController(service());
        controller.run();
    }

    public static CardService service(){
        return new CardService();
    }

}
