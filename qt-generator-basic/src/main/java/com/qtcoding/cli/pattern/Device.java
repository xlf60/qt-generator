package com.qtcoding.cli.pattern;

/**
 * Description 接受者 相当于被遥控的设备
 *
 * @author: xlf
 * @date: 2023/11/19
 */
public class Device {

    private String name;

    public Device(String name){
        this.name = name;
    }

    public void turnOn(){
        System.out.println(name + " 设备打开");
    }

    public void turnOff(){
        System.out.println(name + " 设备关闭");
    }
}
