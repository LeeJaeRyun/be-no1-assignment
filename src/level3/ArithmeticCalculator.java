package level3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> resultList = new ArrayList<>();

    public double calculatate(T firstnum, T secondnum, OperatorType operator) {
        double a = firstnum.doubleValue();
        double b = secondnum.doubleValue();
        double result;

        switch (operator) {
            case PLUS:
                result = a + b;
                break;
            case MINUS:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                if (b==0)
                    throw new InputMismatchException("분모가 0이면 안됩니다");
                result = a / b;
                break;
            default:
                throw new InputMismatchException("연산자를 잘못입력하셨어요. 제대로 입력해주세요.");
        }
        resultList.add(result);
        return result;
    }

    public List<Double> getResultList() {
        return resultList;
    }

    public void setResultList(List<Double> newList) {
        resultList.clear();
        resultList.addAll(newList);
    }

    public void removeLastResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("가장 오래된 결과가 삭제되었습니다.");
        }
    }

    public List<Double> findResultListGreaterThan(double input) {
        return resultList.stream()
                .filter(r -> r > input)
                .collect(Collectors.toList());
    }

}
