import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPC on 2018/8/21.
 */
public class GeneratorMain {
    public static void main(String[] args) {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            InputStream input = GeneratorMain.class.getResourceAsStream("generator.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(input);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
