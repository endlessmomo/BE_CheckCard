package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Bank {
    WOORI("우리은행"),
    SHINHAN("신한은행"),
    HANA("하나은행"),
    IBK("기업은행"),
    KB("국민은행");

    private String company;

    public static Bank from(String val) {
        return Arrays.stream(values())
                .filter(i -> i.company.equals(val))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("원하시는 은행 카드는 여기서 발급이 불가능합니다."));
    }

    public static String from(Bank val) {
        return Arrays.stream(values())
                .filter(i -> i.equals(val))
                .findFirst()
                .map(i -> i.getCompany())
                .orElseThrow(() -> new IllegalArgumentException("내부적으로 오류가 발생했습니다."));
    }

}
