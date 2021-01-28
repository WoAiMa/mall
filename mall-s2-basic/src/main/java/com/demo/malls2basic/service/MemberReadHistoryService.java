package com.demo.malls2basic.service;

import com.demo.malls2basic.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * Created by Aima on 2020/12/17/17:14
 */
public interface MemberReadHistoryService {
    /**
     * 生曾浏览记录
     * @param memberReadHistory
     * @return
     */
    int craate(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> list(Long memberId);
}
