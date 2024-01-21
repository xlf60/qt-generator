package com.qtcoding.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.qtcoding.maker.generator.file.FileTemplate;
import com.qtcoding.maker.model.DataModel;
import lombok.Data;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * Description 代码生成器的核心命令
 *
 * @author: xlf
 * @date: 2023/11/19
 */
@Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否生成循环", interactive = true, echo = true)
    private boolean loop ;

    @Option(names = {"-a", "--author"}, arity = "0..1", description = "作者注释", interactive = true, echo = true)
    private String author = "qtcoding";

    @Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出信息", interactive = true, echo = true)
    private String outputText = "sum : ";

    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        System.out.println("配置信息：" + dataModel);
        FileTemplate.doGenerate(dataModel);
        return 0;
    }
}
