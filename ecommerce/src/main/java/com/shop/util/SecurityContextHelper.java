package com.shop.util;

import com.shop.domain.exceptions.ClassicModelException;
import com.shop.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextHelper {

    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            String email = authentication.getName();
            if (email != null) {
                return email;
            } else {
                throw new ClassicModelException("Email not found in authentication object");
            }
        } else {
            throw new ClassicModelException("Authentication object not found");
        }
    }
}
