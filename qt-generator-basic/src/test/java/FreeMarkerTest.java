import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Description FreeMarker学习测试
 *
 * @author: xlf
 * @date: 2023/11/14
 */
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {

        // new出 Configuration对象，参数为FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        // 创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);
        List<Map<String, Object>> menusItems = new ArrayList<>();
        Map<String, Object> menusItem1 = new HashMap<>();
        menusItem1.put("url", "https://www.baidu.com");
        menusItem1.put("label", "百度");
        Map<String, Object> menusItem2 = new HashMap<>();
        menusItem2.put("url", "https://github.com/xlf60?tab=repositories");
        menusItem2.put("label", "qtcoding_github");
        menusItems.add(menusItem1);
        menusItems.add(menusItem2);
        dataModel.put("menusItems", menusItems);

        // 指定生成的文件
        Writer out = new FileWriter("myweb.html");

        // 生成文件
        template.process(dataModel, out);

        // 生成文件后别忘了关闭流
        out.close();
    }


}
