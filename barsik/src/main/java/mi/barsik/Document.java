package mi.barsik;

import java.time.LocalDate;

public class Document {
    private Integer id;
    private Integer num;
    private LocalDate dateCreate;
    private LocalDate dateModify;
    private Boolean actual;

    public Document(Integer id, Integer num, LocalDate dateCreate, LocalDate dateModify, Boolean actual) {
        this.id = id;
        this.num = num;
        this.dateCreate = dateCreate;
        this.dateModify = dateModify;
        this.actual = actual;
    }


    public Integer getId() {
        return id;
    }

    public Integer getNum() {
        return num;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public LocalDate getDateModify() {
        return dateModify;
    }

    public Boolean getActual() {
        return actual;
    }
}
