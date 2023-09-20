import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Pet extends Person{

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;

}
