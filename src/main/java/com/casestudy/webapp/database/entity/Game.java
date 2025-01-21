package com.casestudy.webapp.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Page;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "abbr")
    private String abbr;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "approved")
    private Integer approved;

    @Column(name = "ruleset")
    private String ruleset;

    @Column(name = "release_year")
    private Integer releaseYear;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Speedrun> speedruns;
}
