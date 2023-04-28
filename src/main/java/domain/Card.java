package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Card {
    String id;
    String cardID;
    String balance;
    Bank bank;
}
