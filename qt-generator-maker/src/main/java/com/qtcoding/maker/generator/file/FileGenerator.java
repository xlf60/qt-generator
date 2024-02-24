package com.qtcoding.maker.generator.file;


import com.qtcoding.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @author xlf
 * @date 2023/11/10 10:33
 * 核心生成器
 */
public class FileGenerator {

    /**
     * 核心生成器
     * @param model model数据模型
     * @throws IOException IOException
     * @throws TemplateException TemplateException
     */
    public static void doGenerate(Object model) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "qt-generator-demo-projects/acm-template").getAbsolutePath();
        // 生成静态文件
        StaticFileGenerator.copyFilesByHuTool(inputPath, projectPath);
        // 生成动态文件
        String dynamicInputPath = "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/axlf/acm/MainTemplate.java";
        DynamicFileGenerator.doGenerate(dynamicInputPath, dynamicOutputPath,model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        DataModel dataModel = new DataModel();
        dataModel.setLoop(true);
        dataModel.setAuthor("xlf");
        dataModel.setOutputText("结果 :");
        doGenerate(dataModel);
    }
}
