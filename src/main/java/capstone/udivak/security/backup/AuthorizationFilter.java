//package capstone.udivak.security;
//
//import java.io.IOException;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.MalformedJwtException;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.util.Enumeration;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Component
//public class AuthorizationFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private CustomUserDetailsService jwtUserDetailsService;
//
//	@Autowired
//	private JwtService  jwtTokenUtil;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//
//	        log.info("INIZIO FILTRO");
//		final String requestTokenHeader = request.getHeader("Authorization");
//		log.info("token:" + requestTokenHeader);
//		Enumeration<String> en = request.getHeaderNames();
//		while (en.hasMoreElements()) {
//			String string = (String) en.nextElement();
//			System.out.println(string);
//			
//		}
//
//		String username = null;
//		String jwtToken = null;
//		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the
//		// Token
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				username = jwtTokenUtil.extractUsername(jwtToken);
//			} catch (IllegalArgumentException e) {
//                            e.printStackTrace();
//				log.error("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//                            e.printStackTrace();
//				log.error("JWT Token has expired");
//			} catch (MalformedJwtException e) {
//                            e.printStackTrace();
//				log.error("JWT Token MalformedJwtException");
//			}
//                        catch(Exception e){
//                            e.printStackTrace();
//                            log.error("JWT Token General Error");
//                        }
//		} else {
//			log.warn("JWT Token does not begin with Bearer String");
//		}
//
//		// Once we get the token validate it.
//		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
//
//			// if token is valid configure Spring Security to manually set authentication
//			if (jwtTokenUtil.isTokenValid(jwtToken, userDetails)) {
//
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken
//						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				// After setting the Authentication in the context, we specify
//				// that the current user is authenticated. So it passes the Spring Security
//				// Configurations successfully.
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//		}
//		chain.doFilter(request, response);
//	}
//
//}
