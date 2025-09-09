package com.weixin.providerbackup.application.Generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * DDD代码自动生成工具（已修复所有格式化错误）
 * 根据表信息，自动生成标准的DDD分层代码：Mapper、DO、Repository、领域服务、应用服务、RPC服务
 * 运行后生成到 ./output 目录，包路径规范，结构清晰
 */
public class DDDAutoCodeGenerator {

    // ========== 【可修改配置项】 ===// ...省略其他代码...


    // ==== 修改后代码 ====
    // 包名前缀，例如：com.liyue.weixin
    private static final String PACKAGE_PREFIX = "com.liyue.weixin";

    // 业务模块名，例如：testRecordDetail
    private static final String MODULE_NAME = "testRecordDetail";

    // 数据库表名，例如：test_record_detail
    private static final String TABLE_NAME = "test_record_detail";

    // 实体类名称，例如：TestRecordDetailDO
    private static final String ENTITY_CLASS_NAME = "TestRecordDetailDO";

    // ========== 【表字段定义】 ===// ...省略其他代码...


    // ==== 修改后代码 ====
    // 定义表中每个字段对应的 Java 属性名、类型、是否可为空、中文注释
    private static final List<Field> FIELDS = Arrays.asList(
            new Field("id", "Integer", false, "明细ID，主键"),
            new Field("userId", "Integer", false, "测试用户ID"),
            new Field("bizType", "String", false, "业务模块，如：情绪测试"),
            new Field("bizTypeCode", "String", false, "业务类型代码，如：anxiety"),
            new Field("resultDesc", "String", true, "测试结果描述"),
            new Field("score", "Integer", true, "测试得分"),
            new Field("createdAt", "LocalDateTime", false, "创建时间"),
            new Field("updatedAt", "LocalDateTime", false, "更新时间")
    );

    // ========== 【主方法：运行生成所有分层代码】 ===// ...省略其他代码...


    // ==== 修改后代码 ====
    public static void main(String[] args) {
        String baseOutputDir = "./output"; // 代码输出根目录
        generateAllLayers(baseOutputDir);
        System.out.println("✅ DDD分层代码已生成到目录：" + baseOutputDir);
    }

    // ========== 【生成所有分层代码】 ===// ...省略其他代码...


    // ==== 修改后代码 ====
    private static void generateAllLayers(String baseDir) {
        String modulePackage = PACKAGE_PREFIX + "." + MODULE_NAME;

        generateMapper(baseDir, modulePackage);
        generateDO(baseDir, modulePackage);
        //generateRepositoryInterface(baseDir, modulePackage);
        generateRepositoryImpl(baseDir, modulePackage);
        generateDomainServiceInterface(baseDir, modulePackage);
        generateDomainServiceImpl(baseDir, modulePackage);
        generateAppServiceInterface(baseDir, modulePackage);
        generateAppServiceImpl(baseDir, modulePackage);
        generateRpcServiceInterface(baseDir, modulePackage);
        generateRpcServiceImpl(baseDir, modulePackage);
    }

    // ========== 【各层代码生成方法】 ===// ...省略其他代码...


// ==== 修改后代码 ====

    private static void generateMapper(String baseDir, String modulePackage) {
        String content = String.format(MAPPER_TEMPLATE,
                modulePackage + ".infra.persistent.mapper",       // 第1个 %s：包名
                modulePackage + ".domain.entity",                 // 第2个 %s：导入实体包路径
                ENTITY_CLASS_NAME,                                // 第3个 %s：导入的类名
                ENTITY_CLASS_NAME,                                // 第4个 %s：selectById 返回类型
                ENTITY_CLASS_NAME,                                // 第5个 %s：insert 参数类型
                ENTITY_CLASS_NAME                                 // 第6个 %s：update 参数类型
        );
        writeToFile(baseDir, modulePackage, "infra/persistent/mapper", "TestRecordDetailMapper", content);
    }

    private static void generateDO(String baseDir, String modulePackage) {
        String content = String.format(DO_TEMPLATE,
                modulePackage + ".domain.entity",   // 第1个 %s：包名
                ENTITY_CLASS_NAME                   // 第2个 %s：类名
        );
        writeToFile(baseDir, modulePackage, "domain/entity", ENTITY_CLASS_NAME, content);
    }

    private static void generateRepositoryInterface(String baseDir, String modulePackage) {
        String content = String.format(REPOSITORY_INTERFACE_TEMPLATE,
                modulePackage + ".domain.repo"      // 第1个 %s：包名
        );
        writeToFile(baseDir, modulePackage, "domain/repo", "TestRecordDetailRepository", content);
    }

    private static void generateRepositoryImpl(String baseDir, String modulePackage) {
        String content = String.format(REPOSITORY_IMPL_TEMPLATE,
                modulePackage + ".domain.repo",             // 第1个 %s：仓库接口包
                modulePackage + ".infra.persistent",        // 第2个 %s：持久层包
                modulePackage + ".domain.repo",             // 第3个 %s：仓库接口包
                "TestRecordDetailRepository",               // 第4个 %s：仓库接口名
                ENTITY_CLASS_NAME,                          // 第5个 %s：实体类名
                ENTITY_CLASS_NAME,                          // 第6个 %s：save 参数类型
                ENTITY_CLASS_NAME                           // 第7个 %s：update 参数类型
        );
        writeToFile(baseDir, modulePackage, "infra/persistent", "TestRecordDetailRepositoryImpl", content);
    }

    private static void generateDomainServiceInterface(String baseDir, String modulePackage) {
        String content = String.format(DOMAIN_SERVICE_INTERFACE_TEMPLATE,
                modulePackage + ".domain.service"   // 第1个 %s：包名
        );
        writeToFile(baseDir, modulePackage, "domain/service", "TestRecordDetailDomainService", content);
    }

    private static void generateDomainServiceImpl(String baseDir, String modulePackage) {
        String content = String.format(DOMAIN_SERVICE_IMPL_TEMPLATE,
                modulePackage + ".domain.repo",             // 第1个 %s：仓库包
                modulePackage + ".domain.service",          // 第2个 %s：服务接口包
                "TestRecordDetailRepository",               // 第3个 %s：仓库接口名
                ENTITY_CLASS_NAME,                          // 第4个 %s：实体类名
                ENTITY_CLASS_NAME,                          // 第5个 %s：get 返回类型
                ENTITY_CLASS_NAME,                          // 第6个 %s：save 参数类型
                ENTITY_CLASS_NAME                           // 第7个 %s：update 参数类型
        );
        writeToFile(baseDir, modulePackage, "domain/service/impl", "TestRecordDetailDomainServiceImpl", content);
    }

    private static void generateAppServiceInterface(String baseDir, String modulePackage) {
        String content = String.format(APP_SERVICE_INTERFACE_TEMPLATE,
                modulePackage + ".application.service"   // 第1个 %s：包名
        );
        writeToFile(baseDir, modulePackage, "application/service", "TestRecordDetailAppService", content);
    }

    private static void generateAppServiceImpl(String baseDir, String modulePackage) {
        String content = String.format(APP_SERVICE_IMPL_TEMPLATE,
                modulePackage + ".domain.service",          // 第1个 %s：领域服务包
                modulePackage + ".application/service",     // 第2个 %s：应用服务接口包
                "TestRecordDetailDomainService",            // 第3个 %s：领域服务接口名
                ENTITY_CLASS_NAME,                          // 第4个 %s：实体类名
                ENTITY_CLASS_NAME,                          // 第5个 %s：get 返回类型
                ENTITY_CLASS_NAME,                          // 第6个 %s：create 参数类型
                ENTITY_CLASS_NAME                           // 第7个 %s：update 参数类型
        );
        writeToFile(baseDir, modulePackage, "application/service/impl", "TestRecordDetailAppServiceImpl", content);
    }

    private static void generateRpcServiceInterface(String baseDir, String modulePackage) {
        String content = String.format(RPC_SERVICE_INTERFACE_TEMPLATE,
                modulePackage + ".online.application.service"   // 第1个 %s：包名
        );
        writeToFile(baseDir, modulePackage, "online/application/service", "TestRecordDetailRpcAppService", content);
    }

    private static void generateRpcServiceImpl(String baseDir, String modulePackage) {
        String content = String.format(RPC_SERVICE_IMPL_TEMPLATE,
                modulePackage + ".application.service",     // 第1个 %s：应用服务包
                modulePackage + ".online/application/service", // 第2个 %s：RPC服务包
                "TestRecordDetailAppService",               // 第3个 %s：RPC服务接口名
                ENTITY_CLASS_NAME,                          // 第4个 %s：实体类名
                ENTITY_CLASS_NAME,                          // 第5个 %s：get 返回类型
                ENTITY_CLASS_NAME                           // 第6个 %s：create 参数类型
        );
        writeToFile(baseDir, modulePackage, "online/application/service/impl", "TestRecordDetailRpcAppServiceImpl", content);
    }

    // ========== 【文件写入方法】 ===// ...省略其他代码...


    // ==== 修改后代码 ====
    private static void writeToFile(String baseDir, String modulePackage, String subDir, String className, String content) {
        String pkgPath = modulePackage.replace(".", "/") + "/" + subDir;
        String dirPath = baseDir + "/" + pkgPath;
        new File(dirPath).mkdirs();

        String fileName = dirPath + "/" + className + ".java";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("❌ 写入文件失败：" + fileName);
            e.printStackTrace();
        }
    }

    // ========== 【字段定义内部类】 ===// ...省略其他代码...


    // ==== 修改后代码 ====
    static class Field {
        private String name;
        private String type;
        private boolean isNullable;
        private String comment;

        public Field(String name, String type, boolean isNullable, String comment) {
            this.name = name;
            this.type = type;
            this.isNullable = isNullable;
            this.comment = comment;
        }
    }

    // ========== 【各层代码模板（已修复 %s 数量匹配）】 ===// ...省略其他代码...


// ==== 修改后代码 ====

    private static final String MAPPER_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n" +
                    "import org.apache.ibatis.annotations.Mapper;\n\n" +
                    "@Mapper\n" +
                    "public interface TestRecordDetailMapper {\n" +
                    "    %s selectById(Integer id);\n" +
                    "    int insert(%s detail);\n" +
                    "    int update(%s detail);\n" +
                    "    int deleteById(Integer id);\n" +
                    "}\n";

    private static final String DO_TEMPLATE =
            "package %s;\n\n" +
                    "import java.time.LocalDateTime;\n\n" +
                    "public class %s {\n" +
                    "    private Integer id;\n" +
                    "    private Integer userId;\n" +
                    "    private String bizType;\n" +
                    "    private String bizTypeCode;\n" +
                    "    private String resultDesc;\n" +
                    "    private Integer score;\n" +
                    "    private LocalDateTime createdAt;\n" +
                    "    private LocalDateTime updatedAt;\n" +
                    "    // getter/setter 略\n" +
                    "}\n";

    private static final String REPOSITORY_INTERFACE_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n\n" +
                    "public interface TestRecordDetailRepository {\n" +
                    "    %s findById(Integer id);\n" +
                    "    int save(%s detail);\n" +
                    "    int update(%s detail);\n" +
                    "    int deleteById(Integer id);\n" +
                    "}\n";

    private static final String REPOSITORY_IMPL_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n" +
                    "import %s.%s;\n" +
                    "import org.springframework.stereotype.Repository;\n\n" +
                    "@Repository\n" +
                    "public class TestRecordDetailRepositoryImpl implements TestRecordDetailRepository {\n" +
                    "    @javax.annotation.Resource\n" +
                    "    private %s mapper;\n\n" +
                    "    @Override public %s findById(Integer id) { return mapper.selectById(id); }\n" +
                    "    @Override public int save(%s detail) { return mapper.insert(detail); }\n" +
                    "    @Override public int update(%s detail) { return mapper.update(detail); }\n" +
                    "    @Override public int deleteById(Integer id) { return mapper.deleteById(id); }\n" +
                    "}\n";

    private static final String DOMAIN_SERVICE_INTERFACE_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n\n" +
                    "public interface TestRecordDetailDomainService {\n" +
                    "    %s getDetailById(Integer id);\n" +
                    "    int saveDetail(%s detail);\n" +
                    "    int updateDetail(%s detail);\n" +
                    "    int deleteDetailById(Integer id);\n" +
                    "}\n";

    private static final String DOMAIN_SERVICE_IMPL_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n" +
                    "import org.springframework.stereotype.Service;\n\n" +
                    "@Service\n" +
                    "public class TestRecordDetailDomainServiceImpl implements TestRecordDetailDomainService {\n" +
                    "    @javax.annotation.Resource\n" +
                    "    private %s repository;\n\n" +
                    "    @Override public %s getDetailById(Integer id) { return repository.findById(id); }\n" +
                    "    @Override public int saveDetail(%s detail) { return repository.save(detail); }\n" +
                    "    @Override public int updateDetail(%s detail) { return repository.update(detail); }\n" +
                    "    @Override public int deleteDetailById(Integer id) { return repository.deleteById(id); }\n" +
                    "}\n";

    private static final String APP_SERVICE_INTERFACE_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n\n" +
                    "public interface TestRecordDetailAppService {\n" +
                    "    %s getDetailById(Integer id);\n" +
                    "    int createDetail(%s detail);\n" +
                    "    int updateDetail(%s detail);\n" +
                    "    int deleteDetailById(Integer id);\n" +
                    "}\n";

    private static final String APP_SERVICE_IMPL_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n" +
                    "import org.springframework.stereotype.Service;\n\n" +
                    "@Service\n" +
                    "public class TestRecordDetailAppServiceImpl implements TestRecordDetailAppService {\n" +
                    "    @javax.annotation.Resource\n" +
                    "    private %s domainService;\n\n" +
                    "    @Override public %s getDetailById(Integer id) { return domainService.getDetailById(id); }\n" +
                    "    @Override public int createDetail(%s detail) { return domainService.saveDetail(detail); }\n" +
                    "    @Override public int updateDetail(%s detail) { return domainService.updateDetail(detail); }\n" +
                    "    @Override public int deleteDetailById(Integer id) { return domainService.deleteDetailById(id); }\n" +
                    "}\n";

    private static final String RPC_SERVICE_INTERFACE_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n\n" +
                    "public interface TestRecordDetailRpcAppService {\n" +
                    "    %s getDetailById(Integer id);\n" +
                    "    int createDetail(%s detail);\n" +
                    "    int updateDetail(%s detail);\n" +
                    "    int deleteDetailById(Integer id);\n" +
                    "}\n";

    private static final String RPC_SERVICE_IMPL_TEMPLATE =
            "package %s;\n\n" +
                    "import %s.%s;\n" +
                    "import org.springframework.stereotype.Service;\n\n" +
                    "@Service\n" +
                    "public class TestRecordDetailRpcAppServiceImpl implements TestRecordDetailRpcAppService {\n" +
                    "    @javax.annotation.Resource\n" +
                    "    private %s appService;\n\n" +
                    "    @Override public %s getDetailById(Integer id) { return appService.getDetailById(id); }\n" +
                    "    @Override public int createDetail(%s detail) { return appService.createDetail(detail); }\n" +
                    "    @Override public int updateDetail(%s detail) { return appService.updateDetail(detail); }\n" +
                    "    @Override public int deleteDetailById(Integer id) { return appService.deleteDetailById(id); }\n" +
                    "}\n";
}
