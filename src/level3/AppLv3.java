package level3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppLv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> calculator = new ArithmeticCalculator<>();

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double firstNum = scanner.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double secondNum = scanner.nextDouble();

                System.out.print("사칙연산 기호를 입력해주세요: ");
                char operSymbol = scanner.next().charAt(0);
                OperatorType operatorType = OperatorType.fromChar(operSymbol);

                double result = calculator.calculate(firstNum, secondNum, operatorType);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                continue;
            }

            //결과 출력 getter
            System.out.println("결과 목록 : " + calculator.getResultList());

            //기준값보다 큰 결과 조회
            System.out.print("기준값보다 큰 결과들 조회 (숫자를 입력하세요): ");
            double standardNum = scanner.nextDouble();
            System.out.println("조회 결과: " + calculator.findResultListGreaterThan(standardNum));

            //오래된 결과 삭제
            System.out.println("가장 오래된 결과를 삭제하시겠습니까? (yes입력시 삭제)");
            String del = scanner.next();
            if (del.equals("yes")) {
                calculator.removeLastResult();
            }

            //종료
            System.out.println("종료를 원하시면 exit를 입력해주세요.(다른 문자 입력시 더 계산합니다)");
            String exit = scanner.next();
            if (exit.equals("exit")) {
                break;
            }
        }
        System.out.println("프로그램 종료");
    }
}
