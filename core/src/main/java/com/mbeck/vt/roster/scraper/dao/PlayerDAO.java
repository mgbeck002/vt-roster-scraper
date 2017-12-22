package com.mbeck.vt.roster.scraper.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbeck.vt.roster.scraper.model.Player;

@Repository
public interface PlayerDAO extends CrudRepository<Player, Long> {

}
