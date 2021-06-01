package tolgahankilic.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tolgahankilic.hrms.business.abstracts.JobAdvertService;
import tolgahankilic.hrms.core.utilities.results.DataResult;
import tolgahankilic.hrms.core.utilities.results.Result;
import tolgahankilic.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("api/jobAdverts")
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;

	@Autowired 
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }
    
    @GetMapping("/getByStatusTrue")
    public DataResult<List<JobAdvert>> getByIsActiveTrue() {
        return this.jobAdvertService.getByStatusTrue();
    }
    
    @GetMapping("/getByApplicationDeadline")
    public DataResult<List<JobAdvert>> getByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAdvertService.getByApplicationDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByActiveAndApplicationDeadline")
    public DataResult<List<JobAdvert>> getByStatusTrueAndApplicationDeadlineLessThanEqual(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return this.jobAdvertService.getByStatusTrueAndApplicationDeadlineLessThanEqual(date);
    }
    
    @GetMapping("/getByIsActiveAndCompanyName")
    public DataResult<List<JobAdvert>> getByStatusAndEmployer_CompanyName(@RequestParam String companyName) {
        return this.jobAdvertService.getByStatusTrueAndEmployer_CompanyName(companyName);
    }
    
    @GetMapping("/getByEmployer")
    public DataResult<List<JobAdvert>> getByEmployer(@RequestParam int id) {
        return this.jobAdvertService.getByEmployerId(id);
    }
    
    @GetMapping("/changeStatus")
    public DataResult<JobAdvert> changeStatus(@RequestParam int employerId,@RequestParam int advertId,@RequestParam boolean status) {
        return this.jobAdvertService.changeStatus(employerId,advertId,status);
    }
}
