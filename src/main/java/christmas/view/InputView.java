package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.EventDate;
import christmas.domain.Foods;
import christmas.utils.Converter;
import christmas.utils.Delimiter;
import christmas.utils.InputConverter;
import christmas.utils.RetryUtil;
import christmas.validation.InputValidator;

import java.util.List;

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

    public Foods inputMenu(){
        return RetryUtil.getInputForMenu(() -> {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();
            InputValidator.validateInputMenuFormat(input);
            List<String> menus = Converter.parseToStringListByDelimiter(input, Delimiter.COMMA);
            InputValidator.validateValidFood(menus);
            InputValidator.validateValidOrderedNumber(menus);
            InputValidator.validateDuplicateNames(menus);
            InputValidator.validateFoodSize(menus);
            InputValidator.validateOnlyDrinks(menus);
            return new Foods(InputConverter.parseFoods(menus));
        });
    }

}
