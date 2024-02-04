package com.nagarro.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.nagarro.helper.JwtHelper;
import com.nagarro.model.CustomerUserDetails;
import com.nagarro.service.CustomerUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * The JwtRequestFilter extends the Spring Web Filter OncePerRequestFilter
 * class. For any incoming request this Filter class gets executed. It checks if
 * the request has a valid JWT token.
 * 
 * @author saumyaawasthi
 *
 */


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private CustomerUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtHelper jwtTokenUtil;

	/*
	 * This method is used to check token is valid or invalid if valid the allow to
	 * access the API's
	 * 
	 * @Param HttpServletRequst HttpServletResponse
	 * 
	 * @Return nothing
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token".
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.extractUsername(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}

		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			CustomerUserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

			// authentication
			if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		chain.doFilter(request, response);
	}

}