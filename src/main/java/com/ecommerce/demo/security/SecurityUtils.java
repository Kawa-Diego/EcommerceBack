package com.ecommerce.demo.security;

import com.ecommerce.demo.exception.UnauthorizedException;
import com.ecommerce.demo.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof User user)) {
            throw new UnauthorizedException("Autenticação necessária");
        }

        return user;
    }
}
