package com.qtcoding.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * Description 子命令
 *
 * @author: xlf
 * @date: 2023/11/19
 */
@Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @Command(name = "add", description = "增加", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行增加命令");
        }
    }

    @Command(name = "delete", description = "删除", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @Command(name = "query", description = "查询", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {
        @Override
        public void run() {
            System.out.println("执行查询命令");
        }
    }


    public static void main(String[] args) {
        // 执行主命令
//        String[] myArgs = {};
        // 查看主命令的帮助手册
//        String[] myArgs = {"--help"};
        // 执行增加命令
//        String[] myArgs = {"add"};
        // 执行增加命令的帮助手册
//        String[] myArgs = {"add","--help"};
        // 执行不存在的命令，会报错
        String[] myArgs = {"update"};


        int execute = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(execute);
    }
}
