package view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    /*
     * 0 : 이름
     * 1 : 연락처
     * 2 : 주소
     * 3 : 발급할 은 행
     * */
    public void validateIssueTheCard(String userInfo) {
        String[] info = userInfo.split(", ");

        validateNameLength(info[0]);
        validatePhoneNumber(info[1]);
        validateAddressLength(info[2]);
    }

    public void validateNameLength(String name) {
        if (name.length() > 25) {
            throw new IllegalArgumentException("이름은 최대 25글자까지 가능합니다.");
        }
    }

    public void validatePhoneNumber(String number) {
        Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("잘못된 전화번호 형식입니다.");
        }
    }

    public void validateAddressLength(String address) {
        if (address.length() > 255) {
            throw new IllegalArgumentException(("주소는 최대 255글자까지 작성하실 수 있씁니다."));
        }
    }
}
