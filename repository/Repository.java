package repository;


import java.util.LinkedHashMap;

import pojo.Member;

public class Repository {

    private LinkedHashMap<Integer, Member> mDatastore = new LinkedHashMap<>();

    public Member createMember(int id, Member member) {
        return this.mDatastore.put(member.getId(), new Member(member));
    }

    public Member retrievMember(int id) {
        if(this.mDatastore == null || id > this.mDatastore.size() || id < this.mDatastore.size()) throw new IllegalArgumentException("No member found");
        return new Member(this.mDatastore.get(id));
    }

    public Member updateMember(Member newMember) {
        return new Member(this.mDatastore.put(newMember.getId(), new Member(newMember)));
    }
}