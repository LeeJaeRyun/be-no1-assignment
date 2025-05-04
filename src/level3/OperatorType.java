package level3;

import java.util.InputMismatchException;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char value;

    OperatorType(char value) {
        this.value = value;
    }

    public static OperatorType fromChar(char input) {
        for (OperatorType op : values()) {
            if (op.value == input) {
                return op;
            }
        }
        throw new InputMismatchException("유효하지 않은 연산자입니다.");
    }

}
