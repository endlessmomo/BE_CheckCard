package view;

import domain.dto.CommandDto;
import domain.dto.IssueDto;
import global.Print;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static InputValidator inputValidator = new InputValidator();

    public CommandDto readCommand() {
        Print.commandMessage();

        String command = sc.nextLine().toUpperCase();
        return new CommandDto(command);
    }

    public IssueDto readIssue() {
        Print.issueTheCard();

        String userInfo = sc.nextLine();
        boolean isWoori = isWoori();

        inputValidator.validateIssueTheCard(userInfo);
        return new IssueDto(userInfo.toUpperCase(), isWoori);
    }

    public boolean isWoori() {
        Print.checkWoori();

        return sc.nextLine().toUpperCase().equals("Y");
    }
}

