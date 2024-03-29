package com.qtcoding.maker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xlf
 * @date 2023/11/10 9:27
 * 动态模板配置
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataModel {

    /**
     * 是否生成循环
     */
    private boolean loop = false;

    /**
     * 作者
     */
    private String author = "xlf";

    /**
     * 输出信息
     */
    private String outputText = "sum = ";


}
