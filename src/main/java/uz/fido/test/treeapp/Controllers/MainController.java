package uz.fido.test.treeapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import uz.fido.test.treeapp.Models.Course;
import uz.fido.test.treeapp.Models.Faculty;
import uz.fido.test.treeapp.Models.University;
import uz.fido.test.treeapp.Services.TreeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MainController {

  @Autowired JdbcTemplate jdbcTemplate;

  @Autowired
  private TreeService treeService;

  // TODO  adding parameter into view

  @RequestMapping("/universities/{uid}/faculties/{fid}/courses")
  public List<Course> getCoursesByFacultyId(@PathVariable int fid) {
    return treeService.getCoursesByFacultyId(fid);
  }

  @RequestMapping("/universities/{uid}/faculties")
  public List <Faculty> getFacultiesByUniversityId(@PathVariable int uid){
    return treeService.getFacultiesByUniversityId(uid);
  }

  @RequestMapping("/universities")
  public List<University>getUniversities(){
    return treeService.getUniversities();
  }

  @RequestMapping("/universities/{uid}")
  public University getTheUniversity(@PathVariable int uid){
    return treeService.getTheUniversity(uid).get(0);
  }

}
