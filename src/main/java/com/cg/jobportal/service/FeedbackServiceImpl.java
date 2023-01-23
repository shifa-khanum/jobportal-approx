package com.cg.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jobportal.entity.Feedback;
import com.cg.jobportal.exceptions.InvalidFeedbackException;
import com.cg.jobportal.repository.FeedbackRepository;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public Feedback getFeedbackById(long id) throws InvalidFeedbackException {
		if (feedbackRepository.existsById(id)) {
			return feedbackRepository.findById(id).get();
		} else {
			throw new InvalidFeedbackException();
		}
	}

	@Override
	public Feedback updateFeedback(long id, Feedback feedback) throws InvalidFeedbackException {
		if (feedbackRepository.existsById(id)) {
			return feedbackRepository.save(feedback);
		}else {
			throw new InvalidFeedbackException();
		}
		
	}

}
