package com.qtcoding.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;

/**
 * Description
 *
 * @author: xlf
 * @date: 2023/12/7
 */
public class MetaManager {

    private static volatile Meta meta;

    public static Meta getMetaObject() {
        if (ObjectUtil.isNull(meta)) {
            synchronized (MetaManager.class) {
                if (ObjectUtil.isNull(meta)) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }


    public static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        return newMeta;
    }

}
