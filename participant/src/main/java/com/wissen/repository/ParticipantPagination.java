package com.wissen.repository;

import com.wissen.entity.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParticipantPagination extends PagingAndSortingRepository<Participant,Integer> {

}
