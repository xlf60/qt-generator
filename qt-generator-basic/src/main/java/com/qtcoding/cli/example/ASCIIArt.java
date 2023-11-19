package com.qtcoding.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

/**
 * Description picocliDemo
 *
 * @author: xlf
 * @date: 2023/11/19
 */


// 2. 使用@Command 注解标记该类并为其命名，mixinStandardHelpOptions 属性设置为true可以给应用程序自动添加--help 和--version选项
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
// 1.创建一个实现Runnable或Callable接口的类，这就是一个命令
public class ASCIIArt implements Runnable {

    // 3.通过@Option注解将字段设置为命令行选项，可以给选项这种名称和描述
    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    // 4.通过@Parameters注解将字段设置为命令行参数，可以指定默认值、描述等信息
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"}; // 5.Picocli会将命令行参数装换为强类型值，并自动注入到注解字段中

    @Override
    public void run() {  // 6.在类的run或call方法中定义业务逻辑，当命令解析成功（用户敲了回车）后被调用
      // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",",words));
    }

    // 7.在main方法中，通过CommandLine对象的execute方法来处理用户输入命令，剩下的交给Picocli框架来解析命令并执行业务逻辑
    public static void main(String[] args) {
        // 8.CommandLine.execute方法返回一个退出代码，可以调用System.exit并将该退出代码作为参数，从而向调用进程表示成功或失败
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}