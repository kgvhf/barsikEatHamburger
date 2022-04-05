package mi.hamburger.mappers;

import mi.hamburger.dto.DocumentDto;
import mi.hamburger.models.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    public DocumentDto createFromEntity(Document document, boolean timely) {
        return new DocumentDto()
                .setId(document.getId())
                .setNum(document.getNum())
                .setDateCreate(document.getDateCreate())
                .setDateModify(document.getDateModify())
                .setTimely(timely);
    }
}
