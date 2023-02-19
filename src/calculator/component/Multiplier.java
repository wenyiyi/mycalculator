package calculator.component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author noelwen
 * @date 19.2.23 1:48 上午
 * @description 乘法器
 */
public class Multiplier {

    public BigDecimal multiply(BigDecimal num1, BigDecimal num2) {
        return num1.multiply(num2).setScale(2, RoundingMode.HALF_UP);
    }
}
