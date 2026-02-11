package com.zhaowu.website.backend.view;



public enum PropertyTypeEnum {

    SCHEMA_REF("SCHEMA_REF","关联型(SCHEMA)"),
    SPU_REF("SPU_REF","关联型(SPU)"),
    SKU_REF("SKU_REF","关联型(SKU)"),
    //-------
    STRING("STRING", "字符型"),
    DATETIME("DATETIME", "时间型"),
    DATE("DATE", "日期型"),
    MEDIA("MEDIA", "资源"),
    MEDIA_IMG("MEDIA_IMG", "图片"),
    MEDIA_VIDEO("MEDIA_VIDEO", "视频"),
    MEDIA_AUDIO("MEDIA_AUDIO", "音频"),
    MEDIA_TABLE("MEDIA_TABLE", "表格"),
    NUMBER("NUMBER", "数字"),
    SELECT("NUMBER", "下拉框"),
    ATTR_GROUP("ATTR_GROUP", "属性组"),
    RICH_TEXT("RICH_TEXT", "富文本型"),
    KEY_CODE("KEY_CODE", "主键编码型");

    private String code;
    private String message;

    PropertyTypeEnum(String code, String message) {
        this.code = code;
        this.message = message != null ? message : "";
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    /**
     * 判断是否是合法的
     *
     * @param name
     *            类型code
     * @return true：合法
     */
    public static boolean exist(String name){
        PropertyTypeEnum[] values = PropertyTypeEnum.values();
        for (PropertyTypeEnum type : values){
            if (type.name().equals(name)){
                return true;
            }
        }
        return false;
    }
}
