package com.cqesamples;

public enum StatusCode {
    INACTIVE(0), ACTIVE(1), PENDING(2), PREASSIGN(3), SCHEDULED(4), COMPLETED(5);

    private int code;

    private StatusCode(int code) {
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    /*
     * public int value() { return code; }
     */

    public void setCode(int code) {
        this.code = code;
    }
}
