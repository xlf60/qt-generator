package com.qtcoding.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.qtcoding.maker.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;

/**
 * Description 输出允许用户传入的动态参数的消息
 *
 * @author: xlf
 * @date: 2023/11/19
 */
@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        // 实现config 命令的逻辑
        System.out.println("查看参数信息");

        Field[] fields = ReflectUtil.getFields(DataModel.class);
        for (Field field : fields) {
            System.out.println("字段名称： " + field.getName());
            System.out.println("字段类型： " + field.getType());
            System.out.println("----");
        }
    }
}
