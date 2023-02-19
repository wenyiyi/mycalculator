package calculator.dto;

import java.math.BigDecimal;

/**
 * @author noelwen
 * @date 19.2.23 1:57 下午
 * @description
 */
public class CommandDTO {

    private BigDecimal num1;

    private String symbol;

    private BigDecimal num2;

    public BigDecimal getNum2() {
        return num2;
    }

    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getNum1() {
        return num1;
    }

    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }
}
