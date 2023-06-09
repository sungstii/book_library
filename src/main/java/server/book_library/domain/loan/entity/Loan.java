package server.book_library.domain.loan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import server.book_library.domain.member.entity.Member;
import server.book_library.domain.library.inventory.entity.LibraryInventory;
import server.book_library.util.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "loan_history")
@Getter
@Setter
public class Loan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime loanedAt;
    private LocalDateTime returnedAt;

    @Enumerated(value = EnumType.STRING)
    private LoanStats loanStats = LoanStats.대여중;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonBackReference(value = "member_loans")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "library_inventory_id")
    @JsonBackReference(value = "loan_libraryInventory")
    private LibraryInventory libraryInventory;

    public enum LoanStats {
        대여중, 반납완료
    }

}
