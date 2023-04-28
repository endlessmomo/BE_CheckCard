package controller;

import domain.Commands;
import domain.dto.CommandDto;
import domain.dto.IssueDto;
import global.Retry;
import view.InputView;
import view.OutputView;
import service.CardService;

import java.util.HashMap;
import java.util.Map;

public class CardController {
    private Map <Commands,Runnable> service = new HashMap <>();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
        service.put(Commands.ISSUE, this::issue);
        service.put(Commands.DEPOSIT, this::depositAndWithdrawal);
        service.put(Commands.WITHDRAWAL, this::depositAndWithdrawal);
        service.put(Commands.PAYED, this::payed);
        service.put(Commands.CANCELED, this::payed);
        service.put(Commands.RECORD, this::record);
        service.put(Commands.RE_ISSUE, this::reIssue);
    }

    public void run() {
        Commands command = readCommand();
        while (command.isNotQuit()) {
            try{
                service.get(command).run();
            } catch (IllegalArgumentException e){
            }
            command = readCommand();
        }
    }

    // 카드 발급 API
    public void issue() {
        IssueDto dto = Retry.execute(inputView::readIssue);
        cardService.issue(dto);
    }

    // 카드 입금/출금 API
    public void depositAndWithdrawal() {

    }

    // 결제 API
    public void payed() {

    }

    // 카드 거래 내역 확인 API
    public void record() {

    }

    // 카드 재발급 API
    public void reIssue() {

    }

    public Commands readCommand() {
        try {
            CommandDto dto = Retry.execute(inputView::readCommand);
            return Commands.from(dto.getCommand());
        } catch (IllegalArgumentException e) {
             outputView.printException(e.getMessage());
        }
        return null;
    }
}
