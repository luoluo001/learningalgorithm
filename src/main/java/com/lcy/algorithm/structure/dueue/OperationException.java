package com.lcy.algorithm.structure.dueue;

/**
 * Created by： luochengyue
 * date: 2018/12/3.
 * desc：操作异常
 * @version:
 */
public class OperationException extends RuntimeException {

    public OperationException() {
    }

    public OperationException(String message) {
        super(message);
    }

    public OperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public OperationException(Throwable cause) {
        super(cause);
    }
}
