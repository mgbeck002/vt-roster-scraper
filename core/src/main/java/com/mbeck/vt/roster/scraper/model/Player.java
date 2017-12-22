package com.mbeck.vt.roster.scraper.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {

	@Id
	private Long id;
	private Integer number;
	private String name;
	
	@Column(name="varsity_letters")
	private int varsityLetters;
	
	@Enumerated(EnumType.STRING)
	private Position position;
	private int height;
	private int weight;
	
	@Enumerated(EnumType.STRING)
	@Column(name="eligibility_class")
	private EligibilityClass eligibilityClass;
	
	@Column(name="home_state")
	private String homeState;
	private String hometown;

	@Column(name = "high_school")
	private String highSchool;
	
	@Column(name = "first_seen_time")
	private LocalDateTime firstSeenTime;
	
	@Column(name = "last_seen_time")
	private LocalDateTime lastSeenTime;
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVarsityLetters() {
		return varsityLetters;
	}
	public void setVarsityLetters(int varsityLetters) {
		this.varsityLetters = varsityLetters;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public EligibilityClass getEligibilityClass() {
		return eligibilityClass;
	}
	public void setEligibilityClass(EligibilityClass eligibilityClass) {
		this.eligibilityClass = eligibilityClass;
	}
	public String getHomeState() {
		return homeState;
	}
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}
	public LocalDateTime getFirstSeenTime() {
		return firstSeenTime;
	}
	public void setFirstSeenTime(LocalDateTime firstSeenTime) {
		this.firstSeenTime = firstSeenTime;
	}
	public LocalDateTime getLastSeenTime() {
		return lastSeenTime;
	}
	public void setLastSeenTime(LocalDateTime lastSeenTime) {
		this.lastSeenTime = lastSeenTime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(eligibilityClass, height, homeState, hometown, name, number, position, highSchool, varsityLetters, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(eligibilityClass, other.getEligibilityClass()) 
				&& Objects.equals(height, other.getHeight()) 
				&& Objects.equals(homeState, other.getHomeState())
				&& Objects.equals(hometown, other.getHometown())
				&& Objects.equals(name, other.getName())
				&& Objects.equals(number, other.getNumber())
				&& Objects.equals(position, other.getPosition())
				&& Objects.equals(highSchool, other.getHighSchool())
				&& Objects.equals(varsityLetters, other.getVarsityLetters());
	}
	@Override
	public String toString() {
		return "Player [number=" + number + ", name=" + name + ", varsityLetters=" + varsityLetters + ", position="
				+ position + ", height=" + height + ", weight=" + weight + ", eligibilityClass=" + eligibilityClass
				+ ", homeState=" + homeState + ", hometown=" + hometown + ", previousSchool=" + highSchool 
				+ ", firstSeenTime=" + firstSeenTime + ", lastSeenTime=" + lastSeenTime +"]";
	}
}
