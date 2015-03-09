package cn.itcast.oa.view.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.oa.base.BaseAction;
import cn.itcast.oa.domain.Reply;
import cn.itcast.oa.domain.Topic;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class ReplyAction extends BaseAction<Reply> {

	private Long topicId;

	/** 发表新回复页面 */
	public String addUI() throws Exception {
		// 准备数据
		Topic topic = topicService.getById(topicId);
		ActionContext.getContext().put("topic", topic);
		return "addUI";
	}

	/** 发表新回复 */
	public String add() throws Exception {
		// 封装
		// >> 表单字段，已经封装了title, content
		// model.setTitle(title);
		// model.setContent(content);
		model.setTopic(topicService.getById(topicId));
		// >> 当前信息
		model.setAuthor(getCurrentUser()); // 当前用户
		model.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		model.setPostTime(new Date()); // 当前时间

		// 保存
		replyService.save(model);

		return "toTopicShow"; // 转到新回复所在主题的显示页面
	}

	// ---

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

}
