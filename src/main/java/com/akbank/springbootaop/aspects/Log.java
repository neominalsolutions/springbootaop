package com.akbank.springbootaop.aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// anotasyon olutururken interface olarak tanımladık
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// Runtimede kod JVM üzerindeykende çalışır.
public @interface Log {
}
