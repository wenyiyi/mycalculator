package calculator;

import java.math.BigDecimal;
import calculator.dto.CommandDTO;

/**
 * @author noelwen
 * @date 19.2.23 12:24 上午
 * @description
 */
public abstract class AbstractCommand {

    /**
     * 执行命令
     * @param commandDTO
     * @return
     */
    public abstract BigDecimal execute(CommandDTO commandDTO);

    public abstract BigDecimal undo();

    public abstract BigDecimal redo();

}
