package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor_detail")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class InstructionDetail {

    // annotate the class as an entity and map to db table

    // define the fields

    // annotate the fields with db column names


    // create constructors

    // generate getter/setter methods

    // generate toString() method
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "youtube_channel")
    private  String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;

    public InstructionDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }
}
