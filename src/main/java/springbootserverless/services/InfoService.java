package springbootserverless.services;

import org.springframework.stereotype.Service;
import springbootserverless.dto.InfoDto;

@Service
public class InfoService {
    public InfoDto getInfo() {
        return InfoDto.builder()
                .API_SERVICE_NAME("Spring Boot Serverless API service")
                .API_VERSION("1.0")
                .build();
    }
}
