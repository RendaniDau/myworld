package za.co.rendani.myworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    private final String YOCO_GATEWAY_URL = "https://online.yoco.com/v1/charges/";
    private final String SYNTAX_ZA_PRIVATE_KEY = "sk_test_7804c9efAozPkgp48cf47d692f4b";

    @Bean
    WebClient yocoWebClient() {
        WebClient yocoClient = WebClient
                .builder()
                .baseUrl(YOCO_GATEWAY_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .defaultHeader("X-Auth-Secret-Key", SYNTAX_ZA_PRIVATE_KEY)
                .build();
        return yocoClient;
    }
}
