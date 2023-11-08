package com.exception;

public class MyUncheckedBusinessException extends RuntimeException {

    private static final long serialVersionUID = -8460356990632230194L;
    private final ErrorCode code;

    public MyUncheckedBusinessException(ErrorCode code) {
        super();
        this.code = code;
    }

    public MyUncheckedBusinessException(String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.code = code;
    }

    public MyUncheckedBusinessException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public MyUncheckedBusinessException(Throwable cause, ErrorCode code) {
        super(cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}
