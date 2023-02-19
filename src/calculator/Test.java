package calculator;

import java.math.BigDecimal;
import calculator.dto.CommandDTO;

/**
 * @author noelwen
 * @date 19.2.23 10:41 上午
 * @description
 */
public class Test {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // 设置命令
        calculator.setCommand(new CalculateCommand());
        System.out.println("------开始计算-----");
        CommandDTO commandDTO = new CommandDTO();
        commandDTO.setNum1(new BigDecimal(1));
        commandDTO.setSymbol("+");
        commandDTO.setNum2(new BigDecimal(6));
        // 计算
        BigDecimal sum = calculator.compute(commandDTO);

        commandDTO.setNum1(sum);
        commandDTO.setSymbol("-");
        commandDTO.setNum2(new BigDecimal(1));
        BigDecimal difference = calculator.compute(commandDTO);

        commandDTO.setNum1(difference);
        commandDTO.setSymbol("*");
        commandDTO.setNum2(new BigDecimal(4));
        BigDecimal product = calculator.compute(commandDTO);

        commandDTO.setNum1(product);
        commandDTO.setSymbol("/");
        commandDTO.setNum2(new BigDecimal(4));
        BigDecimal result = calculator.compute(commandDTO);
        System.out.println("最终结果=" + result);

        //多次撤回
        System.out.println("------撤回过程-----");
        calculator.undo();
        calculator.undo();
        calculator.undo();
        //多次恢复
        System.out.println("------恢复过程-----");
        calculator.redo();
        calculator.redo();
        calculator.redo();
        calculator.redo();
    }
}
