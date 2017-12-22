package com.mbeck.vt.roster.scraper.web.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.mbeck.vt.roster.scraper.model.Player;
import com.mbeck.vt.roster.scraper.utils.NodeToPlayerConverter;
import com.mbeck.vt.roster.scraper.web.service.RosterDownloader;

@Service
public class RosterDownloaderImpl implements RosterDownloader {

	private static final String URL = "http://www.hokiesports.com/football/players/";
	
	public List<Player> getPlayers() throws IOException {
		Document doc = Jsoup.connect(URL).get();
		Elements tableLike = doc.select("ul.table-like");
		Element playerList = tableLike.get(1);
		List<Player> players = playerList.childNodes().stream().map(NodeToPlayerConverter::convertNodeToPlayer).collect(Collectors.toList());
		return players;
	}
	
	public static void main(String[] args) {
		RosterDownloader downloader = new RosterDownloaderImpl();
		try {
			downloader.getPlayers();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
