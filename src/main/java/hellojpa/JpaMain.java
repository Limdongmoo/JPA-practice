package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 비영속
//            Member member = new Member();
//            member.setId(5L);
//            member.setName("SearchWithCache");
//
            // 영속
//            em.persist(member);

            //1차 캐시에서 조회
            Member findMember1 = em.find(Member.class, 5L);
            Member findMember2 = em.find(Member.class, 5L);

            System.out.println(findMember2 == findMember1);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
