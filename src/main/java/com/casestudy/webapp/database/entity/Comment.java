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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commenter_id")
    @EqualsAndHashCode.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speedrun_id")
    @EqualsAndHashCode.Exclude
    private Speedrun speedrun;

    @Column(name = "commenter_id", insertable = false, updatable = false)
    private Integer commenterId;

    @Column(name = "speedrun_id", insertable = false, updatable = false)
    private Integer speedrunId;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "comment_contents")
    private String contents;
}