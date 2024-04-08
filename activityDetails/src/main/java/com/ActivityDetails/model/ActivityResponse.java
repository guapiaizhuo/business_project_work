package com.ActivityDetails.model;

import lombok.Data;

@Data
public class ActivityResponse {
    private String id;
    private String name;
    private String description;
    private String publisher;
    private int numberOfParticipants;
    private String time;
    private String location;
}
