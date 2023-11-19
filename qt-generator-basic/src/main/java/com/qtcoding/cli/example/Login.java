package com.qtcoding.cli.example;


import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * @author xlf
 * @date 2023/11/19
 */
class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    // interactive = true 支持交互式
    // arity是否交互式0..1表示可以输入可不输入
    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "CheckPassword", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
//        new CommandLine(new Login()).execute("-u", "user123", "-p", "xxx", "-cp", "6666");
//        new CommandLine(new Login()).execute("-u", "user123", "-p", "-cp");
        new CommandLine(new Login()).execute("-u", "user123");
    }

}