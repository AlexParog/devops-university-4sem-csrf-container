package ru.abibik.bankapiservice.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Component
@Slf4j
@Order(HIGHEST_PRECEDENCE)
public class HeadersLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {

        Collections.list(request.getHeaderNames())
                .forEach(header -> log.info("Header: {} Value: {}", header, request.getHeader(header)));

        filterChain.doFilter(request, response);
    }
}
