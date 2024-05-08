package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventID")
    private int eventID;

    @Column(name = "EventName", nullable = false, length = 255)
    private String eventName;

    @Column(name = "EventImage", columnDefinition = "LONGTEXT")
    @Lob
    private String EventImage;
}
