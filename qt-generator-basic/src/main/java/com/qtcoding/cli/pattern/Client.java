package com.qtcoding.cli.pattern;

/**
 * Description 客户端 相当于使用遥控器的人
 *
 * @author: xlf
 * @date: 2023/11/19
 */
public class Client {

    public static void main(String[] args) {
        // 创建接受者对象
        Device tv = new Device("TV");
        Device stereo = new Device("Stereo");

        // 创建具体命令对象，可以绑定不同设备
        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);

        // 创建调用者
        RemoteControl remote = new RemoteControl();

        // 执行命令
        remote.setCommand(turnOn);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
