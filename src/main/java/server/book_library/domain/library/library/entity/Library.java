package server.book_library.domain.library.library.entity;

import lombok.Getter;
import lombok.Setter;
import server.book_library.domain.library.inventory.entity.LibraryInventory;
import server.book_library.util.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Library extends BaseEntity {
    private String name;
    private boolean isDeleted = false;
    private String location;

    @OneToMany(mappedBy = "library", cascade = CascadeType.REMOVE)
    private List<LibraryInventory> libraryInventories = new ArrayList<>();
}
