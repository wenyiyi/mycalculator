package calculator;

import java.math.BigDecimal;
import java.util.Stack;
import calculator.component.Adder;
import calculator.component.Divider;
import calculator.component.Multiplier;
import calculator.component.Subtracter;
import calculator.dto.CommandDTO;

/**
 * @author noelwen
 * @date 19.2.23 12:25 上午
 * @description 计算命令，对 AbstractCommand 进行扩展
 */
public class CalculateCommand extends AbstractCommand {

    private Adder adder = new Adder();
    private Divider divider = new Divider();
    private Multiplier multiplier = new Multiplier();
    private Subtracter subtracter = new Subtracter();
    // 撤回栈，记录所做的每一步操作，用于撤回
    private Stack<BigDecimal> unStack = new Stack<>();
    // 恢复栈，存储返回栈弹出的数据，用于恢复
    private Stack<BigDecimal> reStack = new Stack<>();

    /**
     * 撤回
     */
    public BigDecimal undo() {
        BigDecimal result = BigDecimal.ZERO;
        if (unStack.isEmpty()) {
            result = new BigDecimal(-1);
        } else {
            BigDecimal pop = unStack.pop();
            reStack.push(pop);
            // 判断弹出数据后是否为空，如果为空，说明已撤回到最原始状态
            if (!unStack.isEmpty()) {
                // 返回栈顶元素的值
                result = unStack.peek();
            }
        }
        return result;
    }

    /**
     * 恢复
     */
    public BigDecimal redo() {
        BigDecimal result;
        if (reStack.isEmpty()) {
            result = new BigDecimal(-1);
        } else {
            BigDecimal pop = reStack.pop();
            unStack.push(pop);
            result = pop;
        }
        return result;
    }

    /**
     * 执行计算，并进行栈的更新
     * todo 可以基于策略模式进一步优化，但是会有点过度设计的感觉
     */
    public BigDecimal execute(CommandDTO commandDTO) {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal num1 = commandDTO.getNum1();
        BigDecimal num2 = commandDTO.getNum2();
        switch (commandDTO.getSymbol()) {
            case "+":
                result = adder.add(num1, num2);
                break;
            case "-":
                result = subtracter.subtract(num1, num2);
                break;
            case "*":
                result = multiplier.multiply(num1, num2);
                break;
            case "/":
                result = divider.divide(num1, num2);
                break;
        }
        // 说明还没有数据
        if (unStack.isEmpty()) {
            unStack.push(result);
        } else {
            // 需要更新两个栈中的内容，结果压入返回栈，清空重复栈
            unStack.push(result);
            if (!reStack.isEmpty()) {
                for (int i = 0; i < reStack.size(); i++) {
                    reStack.pop();
                }
            }
        }
        return result;
    }

}
