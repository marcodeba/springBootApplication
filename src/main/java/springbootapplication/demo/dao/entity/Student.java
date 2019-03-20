package springbootapplication.demo.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    @Min(value = 18, message = "cannot under 18 year old")
    Integer age;

    public Student() {
    }

    public Student(String name, @Min(value = 18, message = "cannot under 18 year old") Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
