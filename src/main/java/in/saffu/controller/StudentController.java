package in.saffu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.saffu.entity.StudentEntity;
import in.saffu.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("student",new StudentEntity());	
		return "index";

	}

	@PostMapping("/student")
	public String saveStudent( StudentEntity student, Model model) {
		studentRepository.save(student);
				
		model.addAttribute("student",new StudentEntity());
		model.addAttribute("msg", "Data insert Successfully");
		return "index";

	}
	
	@GetMapping("/view")
	public String getAllData(StudentEntity student, Model model) {
		List<StudentEntity> studentList = studentRepository.findAll();
		model.addAttribute("students", studentList);
		return "View";
		
	}
	
	
	
	
	
	

}
