package com.duvalhub.dummy.artifact2.service;

import com.duvalhub.dummy.artifact2.aop.RoleAndPermission;
import org.springframework.stereotype.Component;

@Component
@RoleAndPermission(value={"role_3"}, permissions = {"perm_1", "perm_2"})
public class PrivilegedService_Impl implements PrivilegedService {

    @Override
    public String somethingProhibited() {
        return "oh! no!".toLowerCase();
    }

}
