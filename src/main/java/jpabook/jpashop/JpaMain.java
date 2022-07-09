package jpabook.jpashop;


import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Movie;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // db connection과 비슷한 역할

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작
        try {

            Movie movie = new Movie();
            movie.setActor("actor");
            movie.setDirector("director");
            movie.setName("바람과 함께 사라지다");
            movie.setPrice(10000);

            em.persist(movie);


            tx.commit(); // 꼭 ! db에 반영
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 언결 종료
        }
        emf.close();
    }
}
