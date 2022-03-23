package service;

public class Regex {
    public static final String REGEX_CODE_CUSTOMER = "^(KH)-[0-9]{4}$";
    public static final String REGEX_NAME = "^([A-Z][a-z]+\\s?)+$";
    public static final String REGEX_ID_CARD = "^([0-9]{9}|[0-9]{12})$";
    public static final String REGEX_PHONE = "^(((090)|(091)|(\\(84\\))\\+((90)|(91)))[0-9]{7})$";
    public static final String REGEX_EMAIL = "^[a-z][a-z0-9\\_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$";
}
