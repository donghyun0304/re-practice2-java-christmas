package christmas.view;

import christmas.domain.Basi;
import christmas.domain.Food;
import christmas.domain.Order;
import christmas.domain.Present;
import christmas.utils.Converter;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.Optional;

public class OutputView {

    public void printStart(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printResult(Order order){
        printOrderedMenus(order.getOrderedFoods());
        printTotalPriceBeforeDiscount(order.calcTotalPriceBeforeDiscount());
        printPresent(order);
        printBenefit(order);
        printTotalBenefit(order.calcTotalBenefitPrice());
        printTotalPriceAfterDiscount(order.calcTotalPriceAfterDiscount());
        printBasi(order);
    }

    private void printOrderedMenus(Map<Food, Integer> orderedFoods){
        System.out.println("<주문 메뉴>");
        for (Map.Entry<Food, Integer> entry : orderedFoods.entrySet()) {
            System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
        }
        System.out.println();
    }

    private void printTotalPriceBeforeDiscount(int price){
        String formatted = Converter.formatNumberWithCommas(price);
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formatted + "원");
        System.out.println();
    }

    private void printPresent(Order order){
        System.out.println("<증정 메뉴>");
        Optional<Present> present = order.getPresent();
        if (present.isPresent()) {
            System.out.println(present.get().getName() + " 1개");
            return;
        }
        System.out.println("없음");
        System.out.println();
    }

    private void printBenefit(Order order){
        System.out.println("<혜택 내역>");
        int christmasDiscount = order.calcChristmasDiscount();
        int weekdayDiscount = order.calcWeekdayDiscount();
        int weekendDiscount = order.calcWeekendDiscount();
        int specialDiscount = order.calcSpecialDiscount();
        int presentPrice = order.calcPresentPrice();
        if(christmasDiscount != 0){
            System.out.println("크리스마스 디데이 할인: -" + Converter.formatNumberWithCommas(christmasDiscount) + "원");
        }
        if(weekdayDiscount != 0){
            System.out.println("평일 할인: -" + Converter.formatNumberWithCommas(weekdayDiscount) + "원");
        }
        if(weekendDiscount != 0){
            System.out.println("주말 할인: -" + Converter.formatNumberWithCommas(weekendDiscount) + "원");
        }
        if(specialDiscount != 0){
            System.out.println("특별 할인: -" + Converter.formatNumberWithCommas(specialDiscount) + "원");
        }
        if(presentPrice != 0){
            System.out.println("증정 이벤트: -" + Converter.formatNumberWithCommas(presentPrice) + "원");
        }
        if(order.calcTotalDiscountPrice() == 0){
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printTotalBenefit(int price){
        String formatted = Converter.formatNumberWithCommas(price);
        System.out.println("<총혜택 금액>");
        System.out.println("-" + formatted + "원");
        System.out.println();
    }

    private void printTotalPriceAfterDiscount(int price){
        String formatted = Converter.formatNumberWithCommas(price);
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(formatted + "원");
        System.out.println();
    }

    private void printBasi(Order order) {
        Optional<Basi> basi = order.getBasi();
        System.out.println("<12월 이벤트 배지>");
        if (basi.isPresent()) {
            System.out.println(basi.get().name());
            return;
        }
        System.out.println("없음");
        System.out.println();
    }
}
