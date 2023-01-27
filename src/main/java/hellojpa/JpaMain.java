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
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloJPAJPA");

            // 영속
            em.persist(member);

            //1차 캐시에서 조회
            Member findMember1 = em.find(Member.class, 1L);
            //DB에서 조회 이후 1차 캐시에 저장
            Member findMember2 = em.find(Member.class, 2L);

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
