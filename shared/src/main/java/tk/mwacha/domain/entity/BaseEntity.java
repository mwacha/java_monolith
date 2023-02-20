package tk.mwacha.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.mwacha.domain.valueobject.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BaseEntity {


    private Id id;
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;

    public void generateID() {
        this.id = new Id(UUID.randomUUID());
    }
}
