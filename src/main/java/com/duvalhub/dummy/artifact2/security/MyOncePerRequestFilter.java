package com.duvalhub.dummy.artifact2.security;

import com.duvalhub.dummy.artifact2.service.role.RoleEntry;
import com.duvalhub.dummy.artifact2.service.role.PermissionEntry;
import com.duvalhub.dummy.artifact2.service.role.RoleAndPermissionCache_Impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
@Slf4j
public class MyOncePerRequestFilter extends OncePerRequestFilter {

    final RoleAndPermissionCache_Impl roleAndPermissionCache;

    @Autowired
    public MyOncePerRequestFilter(RoleAndPermissionCache_Impl roleAndPermissionCache) {
        this.roleAndPermissionCache = roleAndPermissionCache;
    }

    void toto() {

        Collection<PermissionEntry> permissionEntries = Arrays.asList("allo_1", "bobo_1").stream()
                .map(value -> new PermissionEntry(value))
                .collect(Collectors.toList());
        permissionEntries.add(new PermissionEntry("perm_1"));
        permissionEntries.add(new PermissionEntry("perm_2"));

        Collection<RoleEntry> roleEntries =  Arrays.asList("role_1a", "role_2b").stream()
                .map(name -> new RoleEntry(name) {{
                    addAll(permissionEntries);
                }})
                .collect(Collectors.toList());
        roleEntries.add(new RoleEntry("role_3"));

        roleAndPermissionCache.addAllOnce(roleEntries);

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        toto();

        log.info("\n\n\n Inside Once Per Request Filter originated by request {} \n\n\n", request.getRequestURI());
        filterChain.doFilter(request, response);

    }

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return true;
    }

}
