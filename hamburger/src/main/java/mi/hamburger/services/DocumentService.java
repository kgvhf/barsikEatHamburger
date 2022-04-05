package mi.hamburger.services;

import mi.hamburger.dto.DocumentDto;
import mi.hamburger.mappers.DocumentMapper;
import mi.hamburger.models.Document;
import mi.hamburger.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentService {
    private static final int TIMELY_DAYS = 60;

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentMapper documentMapper;

    public List<DocumentDto> getDocuments() {
        return documentRepository.findAll()
                .stream()
                .map(d -> documentMapper.createFromEntity(d, isTimely(d)))
                .collect(Collectors.toList());
    }

    /**
     * Актуальность документа
     *
     * @param document
     * @return
     */
    public boolean isTimely(Document document) {
        LocalDate deadline = LocalDate.now().minusDays(TIMELY_DAYS + 1);

        return document.getDateModify().isAfter(deadline);
    }
}
