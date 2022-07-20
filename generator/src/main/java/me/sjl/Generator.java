package me.sjl;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.type.ITypeConvertHandler;
import com.baomidou.mybatisplus.generator.type.TypeRegistry;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {

    private static final String URL = "jdbc:mysql://49.235.36.250:3306/MemberCenter_1?useSSL=false";
    public static final String USER_NAME = "kukeduo";
    public static final String PASSWORD = "aA1234!@#$";


    public static final String AUTHOR = "施杰灵";

    public static final String OUTPUT_DIR = "/Users/sjl/work/youngor/member-server/member-service/src/main/java";

    public static final String XML_PATH = "/Users/sjl/work/youngor/member-server/member-service/src/main/resources/repository";

    /** 这里配置表名，多张表逗号分隔*/
    public static final List<String> TABLES = new ArrayList<String>(){{
        add(("birthday_activity"));
    }};


    public static void main(String[] args) {
        generate();
    }

    private static void generate() {
        FastAutoGenerator.create(new DataSourceConfig.Builder(URL, USER_NAME, PASSWORD)
                        // 不能再使用 convertType 进行类型转换了
                        .typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            JdbcType jdbcType = metaInfo.getJdbcType();
                            if (JdbcType.TINYINT == jdbcType) {
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir()  // 不打开输出目录
                            .outputDir(OUTPUT_DIR); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.kkd.member") // 设置父包名
                            .mapper("repository.mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XML_PATH)) // 设置mapperXml生成路径
                            .entity("model.entity")
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLES) // 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableFileOverride()
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .enableFileOverride()
                            .build()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(config -> config.disable(TemplateType.CONTROLLER, TemplateType.SERVICE, TemplateType.SERVICE_IMPL))
                .execute();
    }

}
