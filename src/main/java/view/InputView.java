package view;

import domain.dto.CommandDto;
import domain.dto.IssueDto;

import java.util.Scanner;

public class InputView {
    private static final String READ_COMMAND_MESSAGE = "\n기능을 선택하세요.\n"
            + "0. 카드 발급\n"
            + "1. 카드 입금\n"
            + "2. 카드 출금\n"
            + "3. 카드 결제\n"
            + "4. 카드 결제 취소\n"
            + "5. 거래 내역\n"
            + "6. 카드 재발급\n"
            + "Q. 종료";

    private static final String CARD_ISSUE_MESSAGE = "안녕하세요 카드 발급처입니다.\n"
            + "발급 가능한 은행은 우리은행, 신한은행, 기업은행, 하나은행, 국민은행 입니다.\n"
            + "카드를 발급하기 위해서는 아래와 같은 규칙을 따라주시길 바랍니다.\n";
    private static final String EXAMPLE_USER_INFO = "이름, 연락처, 주소, 발급하실 은행 순으로 기재해주세요.";
    private static final String CHECK_IS_WOORI = "우리 계열사 직원이십니까? ";
    private static final String INPUT_DEPOSIT_MONEY = "";
    private static final String INPUT_WITHDRAW_MONEY = "";
    private static final String INPUT_HOW_MANY = "";

    public CommandDto readCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.println(READ_COMMAND_MESSAGE);

        String command = sc.next().toUpperCase();
        return new CommandDto(command);
    }

    public IssueDto readIssue() {
        System.out.println(CARD_ISSUE_MESSAGE);
        System.out.println(EXAMPLE_USER_INFO);
        Scanner sc = new Scanner(System.in);
        String userInfo = sc.nextLine();

        boolean isWoori = isWoori();
        return new IssueDto(userInfo.toUpperCase(), isWoori);
    }

    public boolean isWoori(){
        System.out.println(CHECK_IS_WOORI);
        Scanner sc = new Scanner(System.in);

        return sc.next().toUpperCase().equals("Y");
    }
}

