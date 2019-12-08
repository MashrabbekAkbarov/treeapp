package uz.fido.test.treeapp.Models;


import java.util.List;

public class Faculty {

    private Long fac_id;
    private String fac_name;
    private Long univ_id;

    private List<Course> courses;

    public Faculty(){
    }

    public Faculty(Long fac_id, String fac_name, Long univ_id, List<Course> courses) {
        this.fac_id = fac_id;
        this.fac_name = fac_name;
        this.univ_id = univ_id;
        this.courses = courses;
    }

    public Long getFac_id() {
        return fac_id;
    }

    public void setFac_id(Long fac_id) {
        this.fac_id = fac_id;
    }

    public String getFac_name() {
        return fac_name;
    }

    public void setFac_name(String fac_name) {
        this.fac_name = fac_name;
    }

    public Long getUniv_id() {
        return univ_id;
    }

    public void setUniv_id(Long univ_id) {
        this.univ_id = univ_id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
