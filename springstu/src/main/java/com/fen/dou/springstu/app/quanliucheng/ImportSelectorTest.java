package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectorTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("--------------ImportSelector-------selectImports------");
        return new String[0];
    }
}
