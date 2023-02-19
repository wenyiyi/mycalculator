1 项目整体设计

AbstractCommand 是抽象类，定义三个抽象方法，CalculateCommand 类继承 AbstractCommand 类，对 AbstractCommand 进行扩展。这样就可以灵活的改变命令的内容，和添加新命令。Calculator类通过调用 AbstractCommand 的方法，实现两个数的加、减、乘、除运算，并可以进行 undo 和 redo 操作。

加、减、乘、除运算分别定义在四个类里：Adder，Divider，Multiplier，Subtracter，便于扩展和灵活组装。

优点：整体采用了命令模式，降低了系统的耦合度，也方便加入新命令。

2 undo 和 redo 的实现原理

采用两个栈来实现撤回和恢复的效果，一个栈用来存储操作的每个步骤的结果，命名为撤回栈，另一个表用来存储撤回栈弹出的数据，命名为恢复栈。在进行运算操作时，将最新的结果压入撤回栈，清空恢复栈。undo 时，将撤回栈的栈顶弹出，并将其压入恢复栈进行保存。redo 时，将恢复栈的栈顶弹出，并将其压入撤回栈，这样就完成了基本的实现。
