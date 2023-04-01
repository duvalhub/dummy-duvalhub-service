package com.duvalhub.dummy.artifact2.service;

import com.duvalhub.dummy.artifact2.aop.RoleAndPermission;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RoleAndPermission
public class SlowService_Impl implements SlowService  {

    @SneakyThrows
    @Override
    public void create() {
        Thread.sleep(3000);
    }

    @SneakyThrows
    @Override
    public void update() {
        Thread.sleep(2000);
    }

}
