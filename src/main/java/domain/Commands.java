package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Commands {
    ISSUE("1"),
    DEPOSIT_AND_WITHDRAWAL("2"),
    PAYED("3"),
    RECORD("4"),
    RE_ISSUE("5"),
    QUIT("Q");

    private static final String INVALID_COMMAND_MESSAGE = "올바르지 않은 커맨드입니다.";

    private final String command;


    public static Commands from(String command) {
        return Arrays.stream(values())
                .filter(controllerCommand -> controllerCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }

    public boolean isNotQuit() {
        return this != QUIT;
    }
}
