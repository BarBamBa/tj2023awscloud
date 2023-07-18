package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.Book;
import com.tj.edu.practice5.jpa.model.BookAndId;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByName(String name);

    // JPQL
    @Query(value = "select b from Book b where name = ?1")
    List<Book> findByMyBooks(String name);

    @Query(value = "select b from Book b where name = ?1 and id = ?2")
    List<Book> findByMyBooksAndMyId(String name, Long id);

    @Query(value = "select b from Book b where name like %:name% and id = :id")
    List<Book> findByMyBooksAndMyId2(@Param("name") String name, @Param("id") Long id);

    @Query(value = "select b.name from Book b where name = ?1")
    List<String> findNameByMyBooks(String name);

    // return 해주는 book객체를 convert가 안되서 안되는 메소드
    @Query(value = "select b.id id, b.name name from Book b where name = ?1")
    List<Map<String, Object>> findNameIdByMyBooks(String name);

    @Query(value = "select b.id id, b.name name from Book b where name = :name")
    List<Map<String, Object>> findNameNameIdByMyBooks(@Param("name") String name);

    @Query(value = "select b.id abc, b.name name2 from Book b where name = :name")
    List<BookAndId> findNameNameIdByMyBooks2(@Param("name") String name);

    @Query(value = "select b.id abc, b.name name2 from Book b where name = :name")
    List<Tuple> findNameNameIdByMyBooks3(@Param("name") String name);

    @Query(value = "select * from book where name = ?1", nativeQuery = true)
    List<Book> findByNativeByMyBooks(String name);

    @Query(value = "select * from book where name = :name"
            + " and id = 1 "
            + " and 1 = 1 ", nativeQuery = true)
    List<Book> findByNativeByMyBooks2(@Param("name") String name);

    // Update 문
    @Transactional
    @Modifying
    @Query(value = """
        update 
            book 
        set 
            name = '이상한자바책' 
        where 
            id = :id
        """, nativeQuery = true)
    int updateSpecificName(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
        update 
            Book b 
        set 
            b.name = '기묘한자바책' 
        where 
            b.id = :id
        """)
    int updateSpecificNameByJPQL(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
            delete from 
                book
            where
                id = :id
            """, nativeQuery = true)
    int deleteBooks(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
            insert into book
                (name, publisher_id, create_at, update_at)
            values
                ('새로 넣은 책', 2, now(), now())
            """, nativeQuery = true)
    int insertBooks();

    //    @Query(value = """
//            SELECT  DISTINCT P.PRODUCTNO,
//                    P_PRICE,
//                    P_NAME,
//                    P_CDATETIME,
//                    PI.SRCIMGNO,
//                    PI.IMGSRC,
//                    PI.IMGNAME,
//                    PI.ORGNAME,
//                    PI.IMGTYPE
//            FROM mini_db2.T1_PRODUCT P
//            LEFT JOIN mini_db2.T1_PDIMAGE PI ON PI.PRODUCTNO = P.PRODUCTNO
//            WHERE P.PRODUCTNO = :productNo
//            AND MAINYN = 'T'
//            """, nativeQuery = true)
//    List<Book> findByNativeNameByMyBooks2(String productNos);

    List<Book> findByNameIsNullAndNameEqualsAndCreateAtGreaterThanEqualAndUpdateAtLessThan(String name, LocalDateTime createAt, LocalDateTime updateAt);

}
