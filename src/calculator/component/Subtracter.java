package calculator.component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author noelwen
 * @date 19.2.23 12:23 上午
 * @description 减法器
 */
public class Subtracter {

    public BigDecimal subtract(BigDecimal num1, BigDecimal num2) {
        return num1.subtract(num2).setScale(2, RoundingMode.HALF_UP);
    }
}
