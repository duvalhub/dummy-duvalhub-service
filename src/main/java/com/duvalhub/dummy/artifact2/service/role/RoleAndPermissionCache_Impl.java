//package com.duvalhub.dummy.artifact2.service.role;
//
//import com.duvalhub.dummy.artifact2.aop.InsufficientPermissionsException;
//import com.duvalhub.dummy.artifact2.aop.InsufficientRolesException;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.RequestScope;
//
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.Optional;
//import java.util.Set;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//@Component
//@RequestScope
//public class RoleAndPermissionCache_Impl implements RoleAndPermissionCache {
//
//    Collection<RoleEntry> store;
//
//    @Override
//    public void addAllOnce(Collection<RoleEntry> rolesAndPermissions) {
//
//        Supplier<Collection<RoleEntry>> roleEntryCollectionSupplier = () -> {
//            return new LinkedList<RoleEntry>() {{
//                addAll(rolesAndPermissions);
//            }};
//        };
//
//        Function<Collection<RoleEntry>, Collection<RoleEntry>> watchDog = rp -> {
//            throw new RuntimeException("RoleAndPermission cannot be set twice within same request.");
//        };
//
//        this.store = Optional.ofNullable(this.store)
//                .map(watchDog)
//                .orElseGet(roleEntryCollectionSupplier);
//
//    }
//
//    @Override
//    public Set<String> getRoles() {
//
//        return store.stream()
//                .map(role -> role.getName())
//                .collect(Collectors.toSet());
//
//    }
//
//    @Override
//    public Set<String> getPermissions() {
//
//        return store.stream()
//                .flatMap(role -> role.getPermissions().stream())
//                .map(permission -> permission.getName())
//                .collect(Collectors.toSet());
//
//    }
//
//    @Override
//    public boolean hasRoles(Collection<String> roles) {
//
//        return getRoles().containsAll(roles);
//
//    }
//
//    @Override
//    public boolean hasPermissions(Collection<String> permissions) {
//
//        return getPermissions().containsAll(permissions);
//
//    }
//
//    @Override
//    public void checkRoles(Collection<String> roles) {
//        Optional.of(roles)
//                .filter(values -> hasRoles(values))
//                .orElseThrow(() -> new InsufficientRolesException("checkRoles: %s hasRoles: %s",
//                        getRoles(), roles));
//    }
//
//    @Override
//    public void checkPermissions(Collection<String> permissions) {
//        Optional.of(permissions)
//                .filter(values -> hasPermissions(values))
//                .orElseThrow(() -> new InsufficientPermissionsException("checkPermissions: %s hasPermissions: %s",
//                        getPermissions(), permissions));
//    }
//
//}
