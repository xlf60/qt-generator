package com.qtcoding.maker.generator.main;

/**
 * 生成代码生成器
 */
public class MainGenerator extends com.yupi.maker.generator.main.GenerateTemplate {

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要给我输出 dist 啦！");
    }
}