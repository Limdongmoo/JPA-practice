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
//            Member findMember = em.find(Member.class,1L);
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(1)      //페이징 최소
                    .setMaxResults(10)      //페이징 최대
                    .getResultList();
            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
