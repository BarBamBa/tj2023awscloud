package com.tj.edu.practice5.jpa.model;


import com.tj.edu.practice5.jpa.model.enums.Nation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "member", uniqueConstraints = {@UniqueConstraint(columnNames = {"colTest2"})})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue
    private Long id;
    //    @NonNull
    @Column(nullable = false)
    private String name;
    private String email;

//    @Column(name = "colTest2", unique = true)
    @Column(name = "colTest2", insertable = false, updatable = false)
    private Integer test2;

    @Column(columnDefinition = "DATETIME comment '생성시간'")
    private LocalDateTime createAt;

    @Column(columnDefinition = "DATETIME DEFAULT now() comment '수정시간'", insertable = false, nullable = false)
    private LocalDateTime updateAt;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

    private Boolean male;

    @Transient // 일시적으로 자바 내부에서 쓰려는 컬럼 데이터(DB연결X)
    private String testData;

//    @Column(columnDefinition = "ENUM")
//    @Enumerated(value = EnumType.STRING)
    private Nation nation;
}