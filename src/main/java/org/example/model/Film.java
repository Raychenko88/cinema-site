package org.example.model;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "movie_title", length = 100)
    String movieTitle;
    @Column(name = "release_date", length = 30)
    String releasDate;
    @Column(name = "stage_director", length = 100)
    String stageDirector;
    @Column(name = "starring", length = 100)
    String starring;
    @Column(name = "film_at_the_box_office", length = 30)
    String filmAtTheBoxOffice;
}
