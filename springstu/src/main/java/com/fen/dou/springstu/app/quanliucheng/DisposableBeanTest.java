package com.fen.dou.springstu.app.quanliucheng;

import org.springframework.beans.factory.DisposableBean;

public class DisposableBeanTest  implements DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.out.println("--------------DisposableBean-------destroy------");
    }
}
