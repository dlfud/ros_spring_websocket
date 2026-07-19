package com.example.recycle.dto;

import lombok.Data;

@Data
public class RobotDto {
    private String name;
    private String model;
    private String rosVersion;
    private String currentVersion;
    private int runTime;
    private String lastInspection;
}
