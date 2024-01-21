package com.qtcoding.maker.model;

import lombok.Data;

/**
 * Description 动态模板配置
 *
 * @author: xlf
 * @date: 2023/11/14
 */
@Data
public class DataModel {

    /**
     * 是否生成循环
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author = "qtcoding";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";

}
