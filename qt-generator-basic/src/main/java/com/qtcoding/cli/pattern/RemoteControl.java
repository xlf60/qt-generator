package com.qtcoding.cli.pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 调用者 相当于遥控器
 *
 * @author: xlf
 * @date: 2023/11/19
 */
@Data
@NoArgsConstructor
public class RemoteControl {

    private Command command;

    public RemoteControl(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
