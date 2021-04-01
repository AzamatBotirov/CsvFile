package AZB.test1;


import java.time.ZonedDateTime;
import java.util.Date;

public class Customer  {
    private String id;
   private String name;
   private ZonedDateTime doc_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(ZonedDateTime doc_date) {
        this.doc_date = doc_date;
    }
}
