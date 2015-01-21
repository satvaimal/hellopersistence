package com.satvaimal.hellopersistence;
 
import com.satvaimal.hellopersistence.AppConfig;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public @interface CommonTestConfig {}
