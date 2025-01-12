package low_level_design.atm;

import java.util.HashMap;
import java.util.Map;

public class CardService {
    private Map<Card, Integer> cardMap;

    public void init() {
        cardMap = new HashMap<>();
        cardMap.put(new Card(1122334455667788l), 1234);
        cardMap.put(new Card(1122334455667789l), 1234);
        cardMap.put(new Card(1122334455667790l), 1234);
    }

    public int getPinFromCard(Card card) {
        return cardMap.get(card);
    }
}
