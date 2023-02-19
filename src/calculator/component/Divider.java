package calculator.component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author noelwen
 * @date 19.2.23 1:48 上午
 * @description 除法器
 */
public class Divider {

    public BigDecimal divide(BigDecimal num1, BigDecimal num2) {
        return num1.divide(num2, RoundingMode.HALF_UP);
    }
}
