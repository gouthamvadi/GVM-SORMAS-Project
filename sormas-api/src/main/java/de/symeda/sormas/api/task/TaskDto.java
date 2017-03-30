package de.symeda.sormas.api.task;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import de.symeda.sormas.api.DataTransferObject;
import de.symeda.sormas.api.ReferenceDto;
import de.symeda.sormas.api.caze.CaseReferenceDto;
import de.symeda.sormas.api.contact.ContactReferenceDto;
import de.symeda.sormas.api.event.EventReferenceDto;
import de.symeda.sormas.api.user.UserReferenceDto;
import de.symeda.sormas.api.utils.PreciseDateAdapter;

public class TaskDto extends DataTransferObject {

	private static final long serialVersionUID = 2439546041916003653L;

	public static final String I18N_PREFIX = "Task";
	
	public static final String ASSIGNEE_REPLY = "assigneeReply";
	public static final String ASSIGNEE_USER = "assigneeUser";
	public static final String CAZE = "caze";
	public static final String CONTACT = "contact";
	public static final String CREATOR_COMMENT = "creatorComment";
	public static final String CREATOR_USER = "creatorUser";
	public static final String PRIORITY = "priority";
	public static final String DUE_DATE = "dueDate";
	public static final String SUGGESTED_START = "suggestedStart";
	public static final String EVENT = "event";
	public static final String PERCEIVED_START = "perceivedStart";
	public static final String STATUS_CHANGE_DATE = "statusChangeDate";
	public static final String TASK_CONTEXT = "taskContext";
	public static final String TASK_STATUS = "taskStatus";
	public static final String TASK_TYPE = "taskType";
	public static final String CONTEXT_REFERENCE = "contextReference";

	private TaskContext taskContext;
	private CaseReferenceDto caze;
	private EventReferenceDto event;
	private ContactReferenceDto contact;
	
	private TaskType taskType;
	private TaskPriority priority;
	private Date dueDate;
	private Date suggestedStart;
	private TaskStatus taskStatus;
	private Date statusChangeDate;
	private Date perceivedStart;
	
	private UserReferenceDto creatorUser;
	private String creatorComment;
	private UserReferenceDto assigneeUser;
	private String assigneeReply;
	

	public TaskContext getTaskContext() {
		return taskContext;
	}
	public void setTaskContext(TaskContext taskContext) {
		this.taskContext = taskContext;
	}
	public CaseReferenceDto getCaze() {
		return caze;
	}
	public void setCaze(CaseReferenceDto caze) {
		this.caze = caze;
	}
	public EventReferenceDto getEvent() {
		return event;
	}
	public void setEvent(EventReferenceDto event) {
		this.event = event;
	}
	public ContactReferenceDto getContact() {
		return contact;
	}
	public void setContact(ContactReferenceDto contact) {
		this.contact = contact;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public Date getDueDate() {
		return dueDate;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public Date getSuggestedStart() {
		return suggestedStart;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public void setSuggestedStart(Date suggestedStart) {
		this.suggestedStart = suggestedStart;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public Date getStatusChangeDate() {
		return statusChangeDate;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public void setStatusChangeDate(Date statusChangeDate) {
		this.statusChangeDate = statusChangeDate;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public Date getPerceivedStart() {
		return perceivedStart;
	}
	@XmlJavaTypeAdapter(PreciseDateAdapter.class)
	public void setPerceivedStart(Date perceivedStart) {
		this.perceivedStart = perceivedStart;
	}
	public UserReferenceDto getCreatorUser() {
		return creatorUser;
	}
	public void setCreatorUser(UserReferenceDto creatorUser) {
		this.creatorUser = creatorUser;
	}
	public String getCreatorComment() {
		return creatorComment;
	}
	public void setCreatorComment(String creatorComment) {
		this.creatorComment = creatorComment;
	}
	public UserReferenceDto getAssigneeUser() {
		return assigneeUser;
	}
	public void setAssigneeUser(UserReferenceDto assigneeUser) {
		this.assigneeUser = assigneeUser;
	}
	public String getAssigneeReply() {
		return assigneeReply;
	}
	public void setAssigneeReply(String assigneeReply) {
		this.assigneeReply = assigneeReply;
	}
	public TaskPriority getPriority() {
		return priority;
	}
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
	
	public ReferenceDto getContextReference() {
		switch (taskContext) {
		case CASE:
			return getCaze();
		case CONTACT:
			return getContact();
		case EVENT:
			return getEvent();
		case GENERAL:
			return null;
		default:
			throw new IndexOutOfBoundsException(taskContext.toString());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDto other = (TaskDto) obj;
		if (assigneeReply == null) {
			if (other.assigneeReply != null)
				return false;
		} else if (!assigneeReply.equals(other.assigneeReply))
			return false;
		if (assigneeUser == null) {
			if (other.assigneeUser != null)
				return false;
		} else if (!assigneeUser.equals(other.assigneeUser))
			return false;
		if (caze == null) {
			if (other.caze != null)
				return false;
		} else if (!caze.equals(other.caze))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (creatorComment == null) {
			if (other.creatorComment != null)
				return false;
		} else if (!creatorComment.equals(other.creatorComment))
			return false;
		if (creatorUser == null) {
			if (other.creatorUser != null)
				return false;
		} else if (!creatorUser.equals(other.creatorUser))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (perceivedStart == null) {
			if (other.perceivedStart != null)
				return false;
		} else if (!perceivedStart.equals(other.perceivedStart))
			return false;
		if (priority != other.priority)
			return false;
		if (statusChangeDate == null) {
			if (other.statusChangeDate != null)
				return false;
		} else if (!statusChangeDate.equals(other.statusChangeDate))
			return false;
		if (suggestedStart == null) {
			if (other.suggestedStart != null)
				return false;
		} else if (!suggestedStart.equals(other.suggestedStart))
			return false;
		if (taskContext != other.taskContext)
			return false;
		if (taskStatus != other.taskStatus)
			return false;
		if (taskType != other.taskType)
			return false;
		return true;
	}
	
}
