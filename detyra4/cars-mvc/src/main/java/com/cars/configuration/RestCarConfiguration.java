package com.cars.configuration;

import com.cars.client.CarClient;
import com.cars.client.EngineClient;
import com.cars.client.WheelsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestCarConfiguration {
    @Value("${cars.rest.host}")
    private String carsHost;

    @Value("${engine.rest.host}")
    private String engineHost;

    @Value("${wheels.rest.host}")
    private String wheelsHost;

    @Bean
    public CarClient setUpRestCarClient() {
        WebClient webClient = WebClient.builder().baseUrl(carsHost)
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        CarClient client = factory.createClient(CarClient.class);
        return client;
    }

    @Bean
    public WheelsClient setUpRestWheelsClient() {
        WebClient webClient = WebClient.builder().baseUrl(wheelsHost)
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        WheelsClient client = factory.createClient(WheelsClient.class);
        return client;
    }

    @Bean
    public EngineClient setUpRestEngineClient() {
        WebClient webClient = WebClient.builder().baseUrl(engineHost)
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        EngineClient client = factory.createClient(EngineClient.class);
        return client;
    }
}

