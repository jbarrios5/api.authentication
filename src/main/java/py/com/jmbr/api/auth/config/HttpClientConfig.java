package py.com.jmbr.api.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpClientConfig {
    //configuracion general

    @Bean("apiRestTemplate")
    public RestTemplate buildRestTemplate(){

        return new RestTemplate();
    }


}
