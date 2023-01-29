package tk.mwacha.domain.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Id implements ValueObject {

    private UUID id;
}
