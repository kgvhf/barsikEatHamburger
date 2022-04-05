package mi.hamburger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {

    private Integer id;
    private Integer num;
    private LocalDate dateCreate;
    private LocalDate dateModify;
    private boolean timely;
}
