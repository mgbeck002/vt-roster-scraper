package com.mbeck.vt.roster.scraper.web.service;

import java.io.IOException;
import java.util.List;

import com.mbeck.vt.roster.scraper.model.Player;

public interface RosterDownloader {
	List<Player> getPlayers() throws IOException;
}
