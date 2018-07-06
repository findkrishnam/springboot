package com.krishnamg.app.enums;

public enum AwsStagingLabelsEnum {
    AWSCURRENT("AWSCURRENT"),
    AWSPREVIOUS("AWSPREVIOUS"),
    AWSPENDING("AWSPENDING");

    String label;

    AwsStagingLabelsEnum(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
