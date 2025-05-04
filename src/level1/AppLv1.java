package level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum, secondNum;
        char operSymbol;
        int result=0;
        String exit;

        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                firstNum = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNum = scanner.nextInt();

                System.out.print("사칙연산 기호를 입력해주세요: ");
                operSymbol = scanner.next().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            switch (operSymbol) {
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if (secondNum == 0) {
                        System.out.println("분모가 0이면 안됩니다.");
                        continue;
                    } else {
                        result = firstNum / secondNum;
                    }
                    break;
                default:
                    System.out.println("연산자를 잘못입력하셨어요. 제대로 입력해주세요.");
                    continue;
            }

            System.out.println("결과 : " + result);

            System.out.println("종료를 원하시면 exit를 입력해주세요.(다른 문자 입력시 더 계산합니다)");
            exit = scanner.next();
            if (exit.equals("exit")) {
                break;
            }
        }

    }
}
