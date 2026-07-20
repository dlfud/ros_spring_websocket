package com.example.recycle.recycleHistory.service;

import com.example.recycle.dao.RecycleHistoryDao;
import com.example.recycle.dto.RecycleHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecycleHistoryService implements RecycleHistoryServiceI{
    @Autowired
    private RecycleHistoryDao recycleHistoryDao;

    @Override
    public RecycleHistoryDto getCollectionCount(RecycleHistoryDto recycleHistoryDto) throws Exception {
        return recycleHistoryDao.getCollectionCount(recycleHistoryDto);
    }
}
