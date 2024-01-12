package org.core.java.lambda;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface PasswordAPI {
    public abstract boolean sendCred(String userName,String password);
}
