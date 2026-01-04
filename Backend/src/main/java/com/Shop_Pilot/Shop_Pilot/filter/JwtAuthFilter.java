package com.Shop_Pilot.Shop_Pilot.filter;

import com.Shop_Pilot.Shop_Pilot.Utils.JWT;
import com.Shop_Pilot.Shop_Pilot.Service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JWT jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthFilter(JWT jwtUtil, CustomUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response,
                                FilterChain filterChain)
        throws ServletException, IOException {

    String header = request.getHeader("Authorization");
    String token = null;
    String email = null;

    if (header != null && header.startsWith("Bearer ")) {
        token = header.substring(7);
        email = jwtUtil.getEmailFromToken(token);
    }

    if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
        String userEmail = userDetailsService.getEmail(email);

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(userEmail)
                .password("")  // not used
                .roles("USER") // or fetch real role from DB if needed
                .build();

        if (jwtUtil.validateToken(token)) {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
    }

    filterChain.doFilter(request, response);
}

}
