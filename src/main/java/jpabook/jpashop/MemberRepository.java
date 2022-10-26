package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository { //Repository 어노테이션은 component로 띄워짐 Bean으로 등록된다

    @PersistenceContext         // Spring boot 가 PersistenceContext에 있으면 EntityManager를 생성해준다
    private EntityManager em;

    public Long save(Member member){ // command랑  쿼리를 분리해라
                                    // 원칙에의해서 저장을하고나면 가급적이면 side effect를 일으키는 command 성이기떄문에 return value를 거의 안만듬
                                    // 대신 id정도는 있으면 다시 조회하면되니깐
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

}
