package com.duvalhub.dummy.artifact2.service.role;

import java.util.Collection;
import java.util.Set;

public interface RoleAndPermissionCache {

    void addAllOnce(Collection<RoleEntry> rolesAndPermissions);

    Set<String> getRoles();

    Set<String> getPermissions();

    boolean hasRoles(Collection<String> roles);

    boolean hasPermissions(Collection<String> permissions);

    void checkRoles(Collection<String> roles);

    void checkPermissions(Collection<String> permissions);

}
