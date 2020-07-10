package com.frewen.designpattern.mediator.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的中介者：房地产中介
 */
public class EstateMedium implements AbsMedium {

    private List<Customer> members = new ArrayList<Customer>();

    @Override
    public void register(Customer member) {
        if (!members.contains(member)) {
            // 注册成为中介的会员
            members.add(member);
            // 将当前的顾客会员与当前中介关联
            member.setMedium(this);
        }
    }

    @Override
    public void relay(String from, String ad) {
        for (Customer ob : members) {
            String name = ob.getName();
            if (!name.equals(from)) {
                ((Customer) ob).receive(from, ad);
            }
        }
    }
}
