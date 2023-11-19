package com.qtcoding.cli.pattern;

/**
 * Description 相当于遥控器的某个操作按钮
 *
 * @author: xlf
 * @date: 2023/11/19
 */
public class TurnOnCommand implements Command {


    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
