package com.tj.edu.practice5.jpa.repository;

import com.tj.edu.practice5.jpa.model.*;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void bookTest() {
        Book book = givenBook();

        bookRepository.findAll();
    }
    @Test
    @Transactional
    void relationTest1() {
        givenBookAndReview();       // 테스트 기초 데이터 생성

        Member member = memberRepository.findByEmail("amsun@thejoeun.com");
        System.out.println(">>> member: " + member);
//        System.out.println(">>> review: " + member.getReviews());
        Book book = member.getReviews().get(0).getBook();
        System.out.println(">>> book: " + book);
        Publisher publisher = book.getPublisher();
        System.out.println(">>> publisher: " + publisher);
    }
    private Book givenBook(Publisher publisher) {
        Book book = Book.builder()
                .name("React와 스프링 부트로 만들기 프로젝트")
                .publisher(publisher)
                .build();
        return bookRepository.save(book);
    }
    private Book givenBook() {
        Book book = Book.builder()
                .name("React와 스프링 부트로 만들기 프로젝트2")
                .build();
        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = Publisher.builder()
                .name("조은출판사")
                .build();
        return publisherRepository.save(publisher);
    }
    private void givenBookAndReview() {
        givenReview(givenMember(), givenBook(givenPublisher()));
    }
    private Review givenReview(Member member, Book book) {
        Review review = Review.builder()
                .title("너무 재미있는 책")
                .member(member)
                .book(book)
                .build();
        return reviewRepository.save(review);
    }
    private Member givenMember() {
        return memberRepository.findByEmail("amsun@thejoeun.com");
    }

    @Test
    void jpqlTest1() {
        List<Book> bookList = bookRepository.findByMyBooks("재미있는 자바책");
        bookList.forEach(System.out::println);
        System.out.println("------------------------1--------------------------");

        List<Book> bookList2 = bookRepository.findByMyBooksAndMyId("재미있는 자바책", 4L);
        bookList2.forEach(System.out::println);
        System.out.println("------------------------2--------------------------");

        List<Book> bookList3 = bookRepository.findByMyBooksAndMyId2("재미있는 자바책", 4L);
        bookList3.forEach(System.out::println);
        System.out.println("------------------------3--------------------------");

        List<String> bookList4 = bookRepository.findNameByMyBooks("재미있는 자바책");
        bookList4.forEach(System.out::println);
        System.out.println("------------------------4--------------------------");

        List<Map<String, Object>> listMap1 = bookRepository.findNameIdByMyBooks("재미있는 자바책");
        listMap1.forEach(x -> System.out.println(x.values()));
        listMap1.forEach(x -> System.out.println(x.entrySet()));
        listMap1.forEach(x -> System.out.println(x.keySet()));
        System.out.println("------------------------5--------------------------");

        List<Map<String, Object>> listMap2 = bookRepository.findNameNameIdByMyBooks("재미있는 자바책");
        listMap2.forEach(x -> System.out.println(x.values()));
        listMap2.forEach(x -> System.out.println(x.entrySet()));
        listMap2.forEach(x -> System.out.println(x.keySet()));
    }

    @Test
    void nativeSqlTest1() {
        List<Book> bookList = bookRepository.findByNativeByMyBooks("재미있는 자바책");
        bookList.forEach(System.out::println);
        System.out.println("------------------------1--------------------------");

        List<Book> bookList2 = bookRepository.findByNativeByMyBooks2("재미있는 자바책");
        bookList2.forEach(System.out::println);
        System.out.println("------------------------2--------------------------");
    }

    @Test
    void customModelJpaTest1() {
        List<BookAndId> bookAndIdList = bookRepository.findNameNameIdByMyBooks2( "재미있는 자바책");
        bookAndIdList.forEach(x -> System.out.println(x.getAbc() + " : " + x.getName2()));

        List<Tuple> bookAndIdList2 = bookRepository.findNameNameIdByMyBooks3( "재미있는 자바책");
        bookAndIdList2.forEach(tuple -> System.out.println(tuple.get(0) + " : " + tuple.get(1)));
    }

    @Test
//    @Transactional
    void updateJpaTest1() {
        int isUpdate = bookRepository.updateSpecificName(2L);
        System.out.println("2번 id를 가진 book의 이름 " + (isUpdate > 0 ? " 바뀜" : " 바뀌지 않음"));

        int isUpdate2 = bookRepository.updateSpecificNameByJPQL(3L);
        System.out.println("2번 id를 가진 book의 이름 " + (isUpdate2 > 0 ? " 바뀜" : " 바뀌지 않음"));

        int isDelete = bookRepository.deleteBooks(4L);
        System.out.println((isDelete > 0 ? "삭제성공" : "삭제실패"));
        
        int isInsert = bookRepository.insertBooks();
        System.out.println((isInsert > 0 ? "추가성공" : "추가실패"));
    }
}