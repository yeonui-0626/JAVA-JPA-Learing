package jpabook.jpashop;


import com.sun.org.apache.xpath.internal.operations.Or;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // db connection과 비슷한 역할

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 시작
        try{
            Order order = new Order();
            order.addOrderItem(new OrderItem());

            tx.commit(); // 꼭 ! db에 반영
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close(); // 언결 종료
        }
        emf.close();

    }

}
