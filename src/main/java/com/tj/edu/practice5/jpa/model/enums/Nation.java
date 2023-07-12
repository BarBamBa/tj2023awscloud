package com.tj.edu.practice5.jpa.model.enums;

//public enum Nation {
//    KOREA,
//    JAPAN,
//    CHINA,
//    ENGLAND,
//    기타
//}
public enum Nation {
    KOREA("kr"),
    JAPAN("jp"),
    CHINA("cn"),
    ENGLAND("uk"),
    기타("etc");

    private String description;

    Nation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
