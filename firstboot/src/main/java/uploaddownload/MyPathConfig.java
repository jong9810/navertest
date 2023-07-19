package uploaddownload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPathConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// <resources mapping="/upload/**" 
		// location="file:///c:/kdt/upload" />
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/kdt/upload/");
	}
	
}
