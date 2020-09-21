package springbootserverless.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    int orgId;
    String name;
    String email;
}
