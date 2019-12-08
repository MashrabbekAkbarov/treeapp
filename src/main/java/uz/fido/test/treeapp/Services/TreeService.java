package uz.fido.test.treeapp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import uz.fido.test.treeapp.Models.Course;
import uz.fido.test.treeapp.Models.Faculty;
import uz.fido.test.treeapp.Models.University;

import java.util.List;

@Service
public class TreeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Course> getCoursesByFacultyId(int fid) {
        List<Course> courseList =
                jdbcTemplate.query(
                        "select t.course_id,t.course_name from LEO_FAC_UNIV_JOIN_V t where t.fac_id= "+fid+"",
                        (rs, rowNum) -> new Course(rs.getInt("course_id"), rs.getString("course_name")));
        return courseList;
    }

    public List <Faculty> getFacultiesByUniversityId(int uid){
        List<Faculty> facultyList =
                jdbcTemplate.query(
                        "select DISTINCT t.fac_id,t.fac_name,t.univ_id from LEO_FAC_UNIV_JOIN_V t where t.univ_id = "+uid+"",
                        (rs, rowNum) -> new Faculty(rs.getLong("fac_id"), rs.getString("fac_name"), rs.getLong("univ_id"),getCoursesByFacultyId(rs.getInt("fac_id"))));
        return facultyList;
    }

    public List <University> getUniversities(){
        List<University> universityList =
                jdbcTemplate.query("select distinct t.univ_id,t.univ_name from LEO_FAC_UNIV_JOIN_V t",
                (rs, rowNum) -> new University(rs.getLong("univ_id"), rs.getString("univ_name"), getFacultiesByUniversityId(rs.getInt("univ_id"))));
        return universityList;
    }

    public List<University> getTheUniversity(int uid){
        List<University> theUniversity =   jdbcTemplate.query("select distinct t.univ_id,t.univ_name from LEO_FAC_UNIV_JOIN_V t where t.univ_id ="+uid+"",
                (rs, rowNum) -> new University(rs.getLong("univ_id"), rs.getString("univ_name"), getFacultiesByUniversityId(rs.getInt("univ_id"))));

        return theUniversity;
    }
}
