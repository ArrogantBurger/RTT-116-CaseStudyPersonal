package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Page;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "commenter_id")
    private Integer commenterId;

    @Column(name = "speedrun_id")
    private Integer speedrunId;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "comment_contents")
    private String contents;
}