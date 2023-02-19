package calculator;

import java.math.BigDecimal;
import calculator.dto.CommandDTO;

/**
 * @author noelwen
 * @date 19.2.23 12:42 上午
 * @description 计算器
 */
public class Calculator {

    private AbstractCommand command;

    /**
     * 设置命令
     * @param command
     */
    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    /**
     * 执行运算
     */
    public BigDecimal compute(CommandDTO commandDTO) {
        BigDecimal result = command.execute(commandDTO);
        System.out.println(
                commandDTO.getNum1() + commandDTO.getSymbol() + commandDTO.getNum2() + "="
                        + result);
        return result;
    }

    /**
     * 撤回
     */
    public void undo() {
        BigDecimal i = command.undo();
        if (i.intValue() == -1) {
            System.out.println("缓存中已不存在数据");
        } else {
            System.out.println("执行成功，运算结果是：" + i);
        }
    }

    /**
     * 恢复
     */
    public void redo() {
        BigDecimal i = command.redo();
        if (i.intValue() == -1) {
            System.out.println("已恢复至最新数据");
        } else {
            System.out.println("执行成功，运算结果是：" + i);
        }
    }

}
