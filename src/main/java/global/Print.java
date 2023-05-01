package global;

public class Print {
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";

    public static void commandMessage() {
        System.out.println(GREEN + "\n================");
        System.out.println("기능을 선택하세요.");
        System.out.println("0. 카드 발급");
        System.out.println("1. 카드 입금");
        System.out.println("2. 카드 출금");
        System.out.println("3. 카드 결제");
        System.out.println("4. 카드 결제 취소");
        System.out.println("5. 거래 내역");
        System.out.println("6. 카드 재발급");
        System.out.println("Q. 종료");
        System.out.println("================");
        System.out.print(PURPLE + "명령를 입력해주세요 : ");
    }

    public static void issueTheCard() {
        System.out.println(GREEN + "\n==========================================================");
        System.out.println("안녕하세요 카드 발급처입니다.");
        System.out.println("발급 가능한 은행은 우리은행, 신한은행, 기업은행, 하나은행, 국민은행 입니다.");
        System.out.println("카드를 발급하기 위해서는 아래와 같은 규칙을 따라주시길 바랍니다.");
        System.out.println("이름, 휴대폰 번호, 주소, 발급하실 은행 순으로 기재해주세요.");
        System.out.println("휴대폰 번호 양식은 010 - XXXX - XXXX");
        System.out.println("==========================================================");
        System.out.print(PURPLE + "정보를 입력해주세요 : ");
    }

    public static void checkWoori(){
        System.out.print( "우리 계열사 직원이십니까? (Y/N) : ");
    }
}
