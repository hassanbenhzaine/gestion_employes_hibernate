package com.youcode.gestionemployes.shared;

import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class TemplateResolverProvider {
    private static TemplateResolverProvider instance;
    private final ClassLoaderTemplateResolver templateResolver;

    public TemplateResolverProvider() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        templateResolver = resolver;
    }

    public static TemplateResolverProvider getInstance() {
        if (instance == null) {
            instance = new TemplateResolverProvider();
        }
        return instance;
    }

    public ClassLoaderTemplateResolver get() {
        return templateResolver;
    }
}
