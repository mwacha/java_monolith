package tk.mwacha.domain.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tk.mwacha.domain.valueobject.Id;


import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class BaseEntity {

    private Id id;
    private LocalDateTime createdAt;

    @Setter
    private LocalDateTime updatedAt;
}
