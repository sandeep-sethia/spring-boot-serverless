package springBootServerless.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(
        schema = "users",
        name = "user"
)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private int org_id;
    private String name;

    @Column(unique = true)
    private String email;

    private Instant created_at;
    private Instant updated_at;

}
