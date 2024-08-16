package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventID")
    private int eventID;        
    @Column(name = "eventname", nullable = false)
    private String eventName;
    @Column(name = "eventimage", columnDefinition = "LONGTEXT")
    @Lob
    private String eventImage;


}
