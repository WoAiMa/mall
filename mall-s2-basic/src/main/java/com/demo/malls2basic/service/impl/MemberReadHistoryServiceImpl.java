package com.demo.malls2basic.service.impl;

import com.demo.malls2basic.nosql.mongodb.document.MemberReadHistory;
import com.demo.malls2basic.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.demo.malls2basic.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aima on 2020/12/17/17:19
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;
    @Override
    public int craate(MemberReadHistory memberReadHistory) {
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> memberReadHistoryList = new ArrayList<>();
        MemberReadHistory memberReadHistory;
        for (String id:
             ids) {
            memberReadHistory = new MemberReadHistory();
            memberReadHistory.setId(id);
            memberReadHistoryList.add(memberReadHistory);
        }
        memberReadHistoryRepository.deleteAll(memberReadHistoryList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
