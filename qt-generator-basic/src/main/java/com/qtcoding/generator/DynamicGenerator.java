package com.qtcoding.generator;

import com.qtcoding.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Description 动态文件生成
 *
 * @author: xlf
 * @date: 2023/11/14
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {

        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("qtcoding");
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setOutputText("求和结果： ");
        doGenerate(inputPath, outputPath, mainTemplateConfig);

    }

    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName, "UTF-8");


        // 指定生成的文件
//        Writer out = new FileWriter(outputPath);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(outputPath)), StandardCharsets.UTF_8));

        // 生成文件
        template.process(model, out);

        // 生成文件后别忘了关闭流
        out.close();

    }
}
