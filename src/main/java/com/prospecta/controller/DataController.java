package com.prospecta.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.prospecta.dto.ResultDto;
import com.prospecta.model.ApiData;
import com.prospecta.model.Entries;
import com.prospecta.service.EntriesService;

@RestController
public class DataController {

	@Autowired 
	private RestTemplate restTemplate;
	
	@Autowired
	private EntriesService eService;
	
	// This API create that lists the title and description
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<List<ResultDto>> getEntriesHandler(@PathVariable("category") String category){
		
		ApiData apiData=restTemplate.getForObject("https://api.publicapis.org/entries", ApiData.class);
		
			List<Entries>  et=apiData.getEntries();
			
			List<ResultDto> result =new ArrayList<>();
		
		for(Entries en: et) {
			
			// if String like "Math & Hindi" will come then it got handle by this way .
			
			String[] str= en.getCategory().split(" ");
			if(str[0].equals(category)) {
				result.add(new ResultDto(en.getApi(), en.getDescriptions()));
			}
			
		}
		
		return new ResponseEntity<List<ResultDto>>(result, HttpStatus.OK);
		
	}
	
	// This API is used to save a new entry 
	@PostMapping("/entries")
	public ResponseEntity<String> saveEntriesHandler(@RequestBody Entries entries){
		
		String str= eService.saveData(entries);
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
		
	}
	
	
}
