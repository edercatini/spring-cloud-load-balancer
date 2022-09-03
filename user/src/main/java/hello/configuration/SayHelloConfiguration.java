package hello.configuration;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;

import java.util.List;

@Configuration
public class SayHelloConfiguration {

    @Bean
    @Primary
    ServiceInstanceListSupplier serviceInstanceListSupplier() {
        return new DemoServiceInstanceListSuppler("say-hello");
    }

}

@AllArgsConstructor
class DemoServiceInstanceListSuppler implements ServiceInstanceListSupplier {

    private final String serviceId;

    @Override
    public String getServiceId() {
        return serviceId;
    }

    @Override
    public Flux<List<ServiceInstance>> get() {
        return Flux.just(
            List.of(
                new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8090, false),
                new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 9092, false),
                new DefaultServiceInstance(serviceId + "3", serviceId, "localhost", 9999, false)
            )
        );
    }
}