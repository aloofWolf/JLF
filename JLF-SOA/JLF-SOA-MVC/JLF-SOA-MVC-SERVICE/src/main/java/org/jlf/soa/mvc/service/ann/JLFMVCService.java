package org.jlf.soa.mvc.service.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jlf.soa.mvc.container.ann.JLFMVCBean;
import org.jlf.soa.mvc.service.JLFMVCServiceGenerate;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@JLFMVCBean(generate=JLFMVCServiceGenerate.class)
public @interface JLFMVCService {

}
