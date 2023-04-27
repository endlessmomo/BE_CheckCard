package main.view;

import domain.dto.CommandDto;

import java.util.Scanner;

public class InputView {

    static Scanner sc = new Scanner(System.in);
    private static final String READ_COMMAND_MESSAGE = "\n기능을 선택하세요.\n"
            + "1. 카드 발급\n"
            + "2. 카드 입/출금\n"
            + "3. 카드 결제\n"
            + "4. 거래 내역\n"
            + "5. 카드 재발급\n"
            + "Q. 종료";

    private static final String EXAMPLE_ISSUE_CARD = "";
    private static final String INPUT_DEPOSIT_MONEY = "";
    private static final String INPUT_WITHDRAW_MONEY = "";
    private static final String INPUT_HOW_MANY = "";

    public CommandDto readCommand() {
        System.out.println(READ_COMMAND_MESSAGE);
        String command = sc.next().toUpperCase();
        return new CommandDto(command);
    }
}

