package model;

import java.io.Serializable;
import java.util.Date;

import model.enums.StatusEnum;

public class Consult implements Serializable {
    private int id;
    private StatusEnum status;
    private String description;
    private String room;
    private Date startTime;
    private Date endTime;
    private Procedure procedure;

	public Consult(int id, Procedure procedure, StatusEnum status, String description, String room, Date startTime, Date endTime) {
		super();
		this.id = id;
		this.status = status;
		this.description = description;
		this.room = room;
		this.startTime = startTime;
		this.endTime = endTime;
		this.procedure = procedure;
	}

	public Consult(int id) {
		super();
		this.id = id;
		this.status = StatusEnum.NotScheduled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}
    
}
