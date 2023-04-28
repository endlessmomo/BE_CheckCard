package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    private int id;
    private String userName;
    private String phoneNumber;
    private int address;
    private boolean isWoori;

    public User(int id, String userName, String phoneNumber, int address) {
        this.id = id;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isWoori = false;
    }
}
