package com.weixin.providerbackup.application.Generator;

/**
 * 用于描述数据库表中的一个字段
 */
public class Field {
    private String name;          // 字段名，如 "id"
    private String type;          // Java 类型，如 "Integer"、"String"
    private boolean isNullable;   // 是否可为空（主要用于注释，非实际约束）
    private String comment;       // 字段中文注释说明

    /**
     * 构造函数
     */
    public Field(String name, String type, boolean isNullable, String comment) {
        this.name = name;
        this.type = type;
        this.isNullable = isNullable;
        this.comment = comment;
    }

    // Getter 方法（可选，当前工具类中未使用到 getter，仅构造传参使用）
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isNullable() {
        return isNullable;
    }

    public String getComment() {
        return comment;
    }
}
