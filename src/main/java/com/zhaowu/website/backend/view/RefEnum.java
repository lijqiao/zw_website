package com.zhaowu.website.backend.view;

public enum RefEnum {
    SCHEMA("SCHEMA"),
    SPU("SPU"),
    SKU("SKU");

    private String code;

    RefEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    /**
     * 判断是否是合法的
     *
     * @param name
     *            类型code
     * @return true：合法
     */
    public static boolean exist(String name){
        RefEnum[] values = RefEnum.values();
        for (RefEnum type : values){
            if (type.name().equals(name)){
                return true;
            }
        }
        return false;
    }
}
