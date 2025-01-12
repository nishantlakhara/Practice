package low_level_design.atm;

import java.util.Objects;

public class Card {
    long cardNo;

    public Card(long cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNo == card.cardNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNo);
    }
}
