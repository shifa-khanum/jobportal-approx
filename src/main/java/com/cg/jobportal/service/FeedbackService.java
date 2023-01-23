package com.cg.jobportal.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import com.cg.jobportal.entity.Feedback;
import com.cg.jobportal.exceptions.InvalidFeedbackException;

import jakarta.validation.constraints.Min;
@Validated
public interface FeedbackService {

	Feedback addFeedback(Feedback feedback);

	List<Feedback> getAllFeedbacks();

	Feedback updateFeedback(long id, Feedback ent)throws InvalidFeedbackException;

	Feedback getFeedbackById(@Min(1) long adminId)throws InvalidFeedbackException;


}
