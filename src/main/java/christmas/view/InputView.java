package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.EventDate;
import christmas.utils.RetryUtil;
import christmas.validation.InputValidator;

public class InputView {

    public EventDate inputDate(){
        return RetryUtil.getInputForDay(() -> {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            InputValidator.validateNumeric(input);
            InputValidator.validateRangeNumber(Integer.parseInt(input));
            return EventDate.from(Integer.parseInt(input));
        });
    }

}
