package com.casestudy.webapp.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Page;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "speedruns")
public class Speedrun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    @EqualsAndHashCode.Exclude
    private Game game;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Integer userId;

    @Column(name = "game_id", insertable = false, updatable = false)
    private Integer gameId;

    @Column(name = "speedrun_time")
    private Integer speedrunTime;

    @Column(name = "date_submitted")
    private String dateSubmitted;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "approved")
    private Integer approved;

    @OneToMany(mappedBy = "speedrun", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Comment> comments;
}
