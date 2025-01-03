package study.hibernate.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
//@org.hibernate.annotations.DynamicInsert
//@org.hibernate.annotations.DynamicUpdate
//@org.hibernate.annotations.Immutable
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    //W tym przypadku Hibernate ustawia wartość na aktualną
    //godzinę przed wstawieniem egzemplarza encji, do bazy danych. Podobną wbudowaną
    //adnotacją jest @UpdateTimestamp.
    @org.hibernate.annotations.CreationTimestamp
    private Instant createdOn;

    //Ustawiam niedomyślne właściwości kolumny
    @Column(name = "nAme", length = 25, nullable = false)
    //@org.hibernate.annotations.ColumnTransformer(...)
    private String name;
    @org.hibernate.annotations.Formula(
            "substr(NAME, 1, 3) || '...'"
    )
    private String shortName;

    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.MAN;

    // orphanRemoval = true (usuwanie rekordów osieroconych)
    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();

    // Gettery i settery

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public String getShortName() {
        return shortName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
