package ra.com.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","haonguyen118",
                "api_key","471648999945932",
                "api_secret","cxnrtNCRkIId-2QGWjZdr0UAEoo"
        ));
    }
}
