package springBootServerless.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class InfoDto {
    private String API_SERVICE_NAME;
    private String API_VERSION;
}
