<% request.setAttribute("contextName", request.getContextPath()); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username" var="username" />
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
    <sec:authentication property="principal" var="username" />
</sec:authorize>
<!DOCTYPE html>
<!-- main.jsp decorator //-->
<html>
<head>
	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<!-- Tell the browser to be responsive to screen width -->
  	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<title>Xsis Academy - <decorator:title/></title>
	<!-- Bootstrap 3.3.6 -->
  	<link rel="stylesheet" href="${contextName}/assets/dist/css/bootstrap.min.css">
  	 <!-- Font Awesome -->
  	<link rel="stylesheet" href="${contextName}/assets/dist/css/font-awesome.min.css">
  	<!-- Ionicons -->
  	<link rel="stylesheet" href="${contextName}/assets/dist/css/ionicons.min.css">
  	<!-- Theme style -->
	<link rel="stylesheet" href="${contextName}/assets/dist/css/AdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins
	folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="${contextName}/assets/dist/css/skins/_all-skins.min.css">
	<!-- iCheck -->
  	<link rel="stylesheet" href="${contextName}/assets/plugins/iCheck/flat/blue.css">
  	<!-- Date Picker -->
  	<link rel="stylesheet" href="${contextName}/assets/plugins/datepicker/datepicker3.css">
  	<!-- jQuery 2.2.3 -->
	<script src="${contextName}/assets/dist/js/jquery-3.1.1.min.js"></script>
	<!-- datepicker -->
	<script src="${contextName}/assets/plugins/datepicker/bootstrap-datepicker.js"></script>
	<decorator:head/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Header -->
		<%@include file="header.jsp" %>
		
		<!-- Sidebar -->
		<%@include file="sidebar.jsp" %>
		
		<!-- content -->
		<div class="content-wrapper">
			 <!-- Content Header (Page header) -->
		    <section class="content-header">
		      <h1>
		        Dashboard
		        <small>Control panel</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		        <li class="active">Dashboard</li>
		      </ol>
		    </section>
		    
		    <!-- Main content -->
	    	<section class="content">
	    		<decorator:body/>
	    	</section>
		</div>
		
		<%@include file="footer.jsp" %>
		
		<%@include file="controlSidebar.jsp" %>
	</div>
	
	
	<!-- jQuery UI 1.11.4 -->
	<script src="${contextName}/assets/dist/js/jquery-ui.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="${contextName}/assets/dist/js/bootstrap.min.js"></script>
	<!-- datepicker -->
	<script src="${contextName}/assets/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- AdminLTE App -->
	<script src="${contextName}/assets/dist/js/app.min.js"></script>
	<script type="text/javascript">
		$.widget.bridge('uibutton', $.ui.button);
	</script>
</body>
</html>
