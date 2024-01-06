package br.com.apisimplepicpay.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum UserTypeEnum {
    COMMON("common"),
    MERCHANT("merchant");

    private final String type;

    UserTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Converter(autoApply = true)
    public static class Mapper implements AttributeConverter<UserTypeEnum, String> {
        @Override
        public String convertToDatabaseColumn(UserTypeEnum attribute) {
            return String.valueOf(attribute.getType());
        }

        @Override
        public UserTypeEnum convertToEntityAttribute(String dbData) {
            if (dbData == null) return null;
            else if ("common".equalsIgnoreCase(dbData)) return COMMON;
            else if ("merchant".equalsIgnoreCase(dbData)) return MERCHANT;
            throw new IllegalStateException();
        }
    }
}
