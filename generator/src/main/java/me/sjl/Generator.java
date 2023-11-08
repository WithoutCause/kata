package me.sjl;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.type.JdbcType;

import java.util.Collections;

public class Generator {

//    private static final String URL = "jdbc:mysql://rm-bp1u3s46u6zhmnwg63o.mysql.rds.aliyuncs.com:3306/employee?useSSL=false";
//    public static final String USER_NAME = "kuafu";
//    public static final String PASSWORD = "cDzvr04reKv2";

    private static final String URL = "jdbc:mysql://rm-bp1u3s46u6zhmnwg6.mysql.rds.aliyuncs.com:3306/employee?useSSL=false";
    public static final String USER_NAME = "kuafu";
    public static final String PASSWORD = "cDzvr04reKv2";

    public static final String AUTHOR = "施杰灵";

    public static final String OUTPUT_DIR = "/Users/sjl/work/youngor/shop-guide-server/shop-guide-service/src/main/java";

    public static final String XML_PATH = "/Users/sjl/work/youngor/shop-guide-server/shop-guide-service/src/main/resources/repository";

    /** 这里配置表名，多张表逗号分隔*/
    public static final String[] TABLES = {"qywx_welcome_config"};


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
                    builder.parent("com.kkd.shopguide") // 设置父包名
                            .mapper("repository.shopguide")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XML_PATH)) // 设置mapperXml生成路径
                            .entity("model.entity")
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLES) // 设置需要生成的表名
                            .entityBuilder()
//                            .enableColumnConstant() // 生成字段对应的常量
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableFileOverride()
                            .serviceBuilder()
                            .convertServiceFileName(
                                    entityName -> entityName + ConstVal.SERVICE
                            )//接口名称，默认带 I ，给他去掉
                            .mapperBuilder()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .enableFileOverride()
                            .mapperAnnotation(Mapper.class)
                            .build()
                    ;
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .templateConfig(config -> config.disable(
                        TemplateType.CONTROLLER,
                        TemplateType.SERVICE
//                        TemplateType.SERVICE_IMPL
                ))
                .execute();
    }

}
