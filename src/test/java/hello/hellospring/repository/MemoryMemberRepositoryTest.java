package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
/*
    테스트의 순서는 보장하지 않는다.
    하나의 테스트메소드가 끝난 후에는 메모리를 정리해줘야한다. -> AfterEach

 */
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 테스트가 끝날때 마다 실행된다.
    // clearStore 데이터 클리어
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        // 값을 대입
        member.setName("spring");
        // 저장
        repository.save(member);
        // 결과값 대입
        Member result = repository.findById(member.getId()).get();

        // 검증 데이터베이스에 값과 내가 테스트한 값이 같은 값인지?
        // 방법1
//        Assertions.assertEquals(member,result);// 기대값 , 실제값
        // 두 값이 같으면 테스트가 수행
        // 방법 2
        assertThat(member).isEqualTo(result);
        // member 가 result 랑 같냐?
        // static import 하면 줄일 수 있다

    }

    @Test
    public void findByName() {
        // 찾을 이름 저장
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        // 하나 더
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
