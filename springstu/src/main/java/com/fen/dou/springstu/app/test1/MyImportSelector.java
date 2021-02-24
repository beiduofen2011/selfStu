package com.fen.dou.springstu.app.test1;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {


        System.out.println("MyImportSelector selectImports ...");
        return new String[]{User.class.getName()};
    }
}
