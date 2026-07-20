package com.example.recycle.dto;

import lombok.Data;

@Data
public class RecycleHistoryDto {
    private String objectType;
    private String status;
    private String createTime;

    private int collectionCount;
    private int successCount;
    private int failCount;

    private SearchDto searchDto;
}
