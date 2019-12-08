package uz.fido.test.treeapp.Models;

import java.util.List;

public class University {

    private Long univ_id;
    private String univ_name;
    private List<Faculty> faculties;

    public University(Long univ_id, String univ_name, List<Faculty> faculties) {
        this.univ_id = univ_id;
        this.univ_name = univ_name;
        this.faculties = faculties;
    }

    public Long getId() {
        return univ_id;
    }

    public void setId(Long id) {
        this.univ_id = univ_id;
    }

    public String getUniv_name() {
        return univ_name;
    }

    public void setUniv_name(String univ_name) {
        this.univ_name = univ_name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }
}
