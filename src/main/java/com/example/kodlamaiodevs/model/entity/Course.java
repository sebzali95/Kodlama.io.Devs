package com.example.kodlamaiodevs.model.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @Column(name = "course_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "course_name")
    @NotBlank(message = "Please enter a courseName")
    private String name;

    @Column(name = "fee")
    @Positive(message = "Please do not enter a negative number")
    private double fee;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
    private List<User> users =new ArrayList<>();
}
