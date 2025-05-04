package level2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Calculator {
    private List<Integer> resultList = new ArrayList<>();

    public int calculate(int firstNum, int secondNum, char operSymbol) {
        int result;

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
                    throw new InputMismatchException();
                } else {
                    result = firstNum / secondNum;
                }
                break;
            default:
                System.out.println("연산자를 잘못입력하셨어요. 제대로 입력해주세요.");
                throw new InputMismatchException();
        }
        resultList.add(result);
        return result;
    }

    //@getter
    public List<Integer> getResultList() {
        return resultList;
    }

    //@setter
    public void setResultList(List<Integer> newList) {
        resultList.clear();
        resultList.addAll(newList);
    }

    //먼저 저장된 데이터 삭제
    public void removeLastResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("가장 먼저 저장된 결과가 삭제되었어요.");
        } else {
            System.out.println("삭제할 결과가 없어요.");
        }
    }

}