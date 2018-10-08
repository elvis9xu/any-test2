package com.xjd.test.any.db.mongo.mapper;

import java.lang.annotation.*;

/**
 * @author elvis.xu
 * @since 2018-09-06 13:59
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Property {
	String value() default "";
	boolean ignore() default false;
	Class<? extends Codec> codec() default Codec.class;
	Class<? extends Codec> componentCodec() default Codec.class;
	Class<?> componentClass() default Void.class;
}
