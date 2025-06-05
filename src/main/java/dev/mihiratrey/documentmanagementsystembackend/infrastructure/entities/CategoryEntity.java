package dev.mihiratrey.documentmanagementsystembackend.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class CategoryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer categoryId;
    
    @Column(nullable = false)
    private String categoryName;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
    private UserEntity createdBy;
    
    @Column(nullable = false)
    private Date createdAt;
    
    @Column(nullable = false)
    private Boolean isDeleted;
}
