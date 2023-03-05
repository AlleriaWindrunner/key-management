/**
 * Copyright (C) 2018 webank, Inc. All Rights Reserved.
 */

package io.github.alleriawindrunner.exception;


/**
 * JacksonException
 *
 * @author eleven
 * @date 2023年02月17日 10:43 PM
 * @see
 * @since 1.0.0
 */

public class JacksonException extends RuntimeException {

    private static final long serialVersionUID = -3313868940376241665L;

    public JacksonException() {
        super();
    }

    public JacksonException(String message, Throwable cause) {
        super(message, cause);
    }

    public JacksonException(String message) {
        super(message);
    }

    public JacksonException(Throwable cause) {
        super(cause);
    }

}
