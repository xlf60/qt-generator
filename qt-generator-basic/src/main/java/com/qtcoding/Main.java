package com.qtcoding;

import com.qtcoding.cli.CommandExecutor;

/**
 * Description
 *
 * @author: xlf
 * @date: 2023/11/19
 */
public class Main {
    public static void main(String[] args) {
        args = new String[]{"generate", "-l", "-a", "-o"};
//        args = new String[]{"config"};
//        args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
