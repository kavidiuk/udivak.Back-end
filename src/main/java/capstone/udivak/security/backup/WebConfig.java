package capstone.udivak.security.backup;

//package capstone.udivak.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.format.FormatterRegistry;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class WebConfig implements WebMvcConfigurer {
//
//    private final SqlDateConverter sqlDateConverter;
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*").maxAge(3600);
//    }
//
//    public WebConfig(SqlDateConverter sqlDateConverter) {
//        this.sqlDateConverter = sqlDateConverter;
//    }
//
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(sqlDateConverter);
//    }
//}
