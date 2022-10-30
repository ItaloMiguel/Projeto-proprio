package br.com.microsservice.course.endpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.microsservice.course.endpoint.model.Course;
import br.com.microsservice.course.endpoint.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository cursoRepository;

	public CourseService(CourseRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	public Iterable<Course> list(Pageable pageable) {		
		return cursoRepository.findAll(pageable);
	}
	

}
