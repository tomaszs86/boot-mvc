package pl.boot.mvc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.boot.mvc.model.Employee;

@Controller
@Transactional
@RequestMapping(value = "/employee")
public class EmployeeController {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		Query query = entityManager.createQuery("SELECT e FROM Employee e");	    
		model.addAttribute("employees", query.getResultList());
		
		return "employee/list";
		
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
    public String create(Model model) {
		
		Employee employee = new Employee();
        model.addAttribute("employeeForm", employee);
        return "employee/create";
    }
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("employeeForm") @Valid Employee emploee, BindingResult result) {
         
		if(result.hasErrors()) {
            return "employee/create";
		}
		
		entityManager.persist(emploee);
	
		return "redirect:/employee/list";	
    }
	
	 @RequestMapping("/details/{id}")
	    public String details(@PathVariable("id") long id, Model model) {
		
	        model.addAttribute("employeeForm", entityManager.find(Employee.class, id));	        
	        return "employee/details";
	 }
	 
	 @RequestMapping("/edit/{id}")
	 public String edit(@PathVariable("id") long id, Model model) {
		 
		 model.addAttribute("employeeForm", entityManager.find(Employee.class, id));	        
	     return "employee/edit";
	 }
	 
	 @RequestMapping(value="/edit/{id}", method = RequestMethod.POST)
	    public String editPost(@ModelAttribute("employeeForm") @Valid Employee form, BindingResult result) {
	         
			if(result.hasErrors()) {
	            return "employee/edit";
			}
			
			Employee emplyoee = entityManager.find(Employee.class, form.getId());
			emplyoee.setName(form.getName());
			emplyoee.setContactNumber(form.getContactNumber());
		
			return "redirect:/employee/list";	
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
