package cn.itcast.oa.domain;

/**
 * 回复
 * 
 * @author
 */
public class Reply extends Article {
	private Topic topic; // 所属的主题

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
