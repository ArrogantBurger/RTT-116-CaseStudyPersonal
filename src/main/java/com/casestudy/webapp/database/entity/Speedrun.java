package com.casestudy.webapp.database.entity;

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

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "game_id")
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

}
