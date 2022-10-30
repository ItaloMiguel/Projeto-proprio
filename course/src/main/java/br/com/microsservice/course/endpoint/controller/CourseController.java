package br.com.microsservice.course.endpoint.controller;

import br.com.microsservice.core.model.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microsservice.course.endpoint.service.CourseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("v1/admin/course")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Course>> list(Pageable pageable) {
		return new ResponseEntity<>(courseService.list(pageable), HttpStatus.OK);
	}
}
