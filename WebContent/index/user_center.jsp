<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="verify_login.jsp"%><%--包含验证用户是否登录的代码 --%>
<jsp:useBean id="img_url" class="javabean.get_img" scope="session" />
<jsp:setProperty property="user_id" name="img_url"
	value="<%=session.getAttribute(\"user_id\")%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户中心</title>
<link type="text/css" rel="stylesheet"
	href="/scenic_ticket/index/css/core.css">
<link type="text/css" rel="stylesheet"
	href="/scenic_ticket/index/css/icon.css">
<link type="text/css" rel="stylesheet"
	href="/scenic_ticket/index/css/home.css">

<script src="index/js/jquery.min.js"></script>
<script src="index/js/jquery.pure.tooltips.js"></script>
</head>
<body>

	<div class="ydc-entered" style="height: 11%; width: 100%;">
		<div class="ydc-header-content ydc-flex">

			<div class="ydc-column">
				<div class="ydc-column-user">
					<div class="ydc-user-photo">
						<a href="javascript:;"> <img src="<%=img_url.getImg()%>"
							title="" alt="">
						</a>
					</div>
					<div class="ydc-user-info">

						<div class="ydc-user-info-func ydc-flex">
							<span class="ydc-tag"> <%
 	if (session.getAttribute("user_id").equals("admin")) {
 		out.println("admin");
 	} else {
 		out.println(session.getAttribute("user_id"));
 	} //不要问我为什么要这么操作，因为我是管理员^c^
 %>
							</span> <span class="ydc-mal"><i
								class="ydc-icon ydc-icon-mail fl"></i><em>0</em></span> <a
								href="/scenic_ticket/index/logout.jsp">退出</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="ydc-content-slide ydc-body" style="height: 86%;">
		<div class="ydc-flex" style="height: 100%;">
			<!-- left begin -->
			<div class="ydc-column ydc-column-2">
				<div class="ydc-menu">
					<ul>
						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-home fl"></i>首页
						</span>
							<ul>
								<li><a id="user_info"
									href="/scenic_ticket/user_center?type=user_info">个人资料</a></li>
								<li><a id="edit_info"
									href="/scenic_ticket/user_center?type=edit_info" href="#">修改信息</a></li>
							</ul></li>

						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-record fl"></i>订单
						</span>
							<ul>
								<li><a id="order_list"
									href="/scenic_ticket/user_center?type=order_list">订单列表</a></li>
							</ul></li>

						<li class="ydc-menu-item"><span class="ydc-menu-sub-title">
								<i class="ydc-icon ydc-icon-file fl"></i>管理
						</span>
							<ul>
								<li><a href="/scenic_ticket/default/index.jsp">返回首页</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<!-- left end -->

			<!-- right start -->
			<div style="width: 76%; height: 100%;">
				<iframe id="iframe_content" scrolling="auto" width="100%"
					height="100%" frameborder="0"></iframe>
			</div>
			<!-- right end -->
		</div>
	</div>

</body>
<script>
	function select(type) {
		
		//移除所有选中
		$("li").removeClass("active");

		switch (type) {
		case "user_info":
			//给选中项添加选中样式
			$("#user_info").addClass("active");
			//设置内容地址
			iframe_content.src = "/scenic_ticket/index/edit_info.jsp";
			break;
		case "edit_info":
			 $("#edit_info").addClass("active");
			iframe_content.src = "/scenic_ticket/index/edit_info.jsp";
			break;
		case "order_list":
			$("#order_list").addClass("active");
			iframe_content.src = "/scenic_ticket/index/order_list.jsp";
			break;
		default:
			$("#user_info").addClass("active");
			iframe_content.src = "/scenic_ticket/index/edit_info.jsp";
			break;
		}
	};

	//获取地址栏数据
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); //匹配目标参数
		if (r != null)
			return unescape(r[2]);
		return null; //返回参数值
	}

	//获取地址栏中type的值
	var type = getUrlParam('type');
	//选中目标
	select(type);
</script>
</html>