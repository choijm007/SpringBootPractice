package me.choijaemin.springbootdeveloper;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers(){
        List<Member> members = memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);
    }
    @Sql("/insert-members.sql")
    @Test
    void getMemberById(){
        Member members = memberRepository.findById(2L).get();

        assertThat(members.getName()).isEqualTo("B");
    }
    @Sql("/insert-members.sql")
    @Test
    void getMemberByName(){
        Member members = memberRepository.findByName("C").get();

        assertThat(members.getId()).isEqualTo(3);
    }

    @Test
    void saveMember(){
        Member member = new Member(3L,"A");

        memberRepository.save(member);

        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");
    }

    @Test
    void saveMembers(){
        List<Member> members = List.of(new Member(2l,"B"), new Member(3L, "C"));

        memberRepository.saveAll(members);
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }

    @Sql("/insert-members.sql")
    @Test
    void deleteMemberById(){
        memberRepository.deleteById(2L);

        assertThat(memberRepository.findById(2L).isEmpty()).isTrue();
    }

    @Sql("/insert-members.sql")
    @Test
    void update(){
        Member member = memberRepository.findById(2L).get();

        member.changeName("BC");

        assertThat(memberRepository.findById(2L).get().getName()).isEqualTo("BC");
    }
}