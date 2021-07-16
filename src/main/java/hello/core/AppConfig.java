package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // 역할
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 역할
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 역할에 따른 구현
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 역할에 따른 구현
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
