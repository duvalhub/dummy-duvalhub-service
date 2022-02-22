package com.duvalhub.dummy.artifact2.service.role;

import lombok.Getter;

import java.util.Collection;
import java.util.LinkedList;

@Getter
public class RoleEntry {

    final String name;

    final Collection<PermissionEntry> permissions;

    public RoleEntry(String name) {
        this.name = name;
        permissions = new LinkedList<>();
    }

    public void add(PermissionEntry permissionEntry) {
        permissions.add(permissionEntry);
    }

    public void addAll(Collection<PermissionEntry> permissionEntries) {
        permissions.addAll(permissionEntries);
    }

}
