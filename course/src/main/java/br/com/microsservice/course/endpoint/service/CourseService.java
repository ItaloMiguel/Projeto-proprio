package br.com.microsservice.course.endpoint.service;

import br.com.microsservice.core.model.Course;
import br.com.microsservice.core.repository.CourseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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
