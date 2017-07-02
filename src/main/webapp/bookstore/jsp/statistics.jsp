<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"  %>
<%@ page import="model.Statistic"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>BookStore</title>

<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>

<body >
	<%
		ArrayList<Statistic> statisticList = new ArrayList<Statistic>();
			if (request.getAttribute("statistics") != null) {
				statisticList = (ArrayList<Statistic>) request.getAttribute("statistics");
			}
	%>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="HomepagePro">BookStore</a>
		</div>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="allUserPro"><i class="fa fa-user fa-fw"></i>
							Users</a></li>
					<li><a href="allBookPro"><i
							class="fa fa-book fa-fw"></i> Books</a></li>
					<li><a href="allOrderPro"><i class="fa fa-reorder fa-fw"></i>
							Orders</a></li>
					<li><a href="allOrderitemPro"><i
							class="fa fa-table fa-fw"></i> Orderitems</a></li>
					<li><a href="allByBookTotalStatisticPro" class="active"><i
							class="fa fa-signal fa-fw"></i> Sales Statistics</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper" id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Sales Statistics</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default" id="panel">
						<div class="panel-heading">
							sorted by
							<button class="btn btn-default" type="button" onclick="allByBook()">
								Book
							</button>
							<button class="btn btn-default" type="button" onclick="allByUser()">
								User
							</button>
							<button class="btn btn-default" type="button" onclick="allByStartDate()">
								Start date
							</button>
							<button class="btn btn-default" type="button" onclick="allByEndDate()">
								End date
							</button>
							<button class="btn btn-default" type="button" onclick="allByCategory()">
								Book Category
							</button>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body" id="panel-body">
							<div class="dataTable_wrapper"id="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
										    <th id="criteria">Book Id</th>
											<th>Number of books sold</th>
											<th>Total Sales Amount</th>
										</tr>
									</thead>
									<tbody id="tbody">
										<%
											for (int i = 0; i < statisticList.size(); i++) {
												Statistic statistic = statisticList.get(i);
										%>
										<tr>
										    <td valign="middle"><%=statistic.getCriteria()%></td>
											<td><%=statistic.getNumber()%></td>
											<td><%=statistic.getAmount()/100.00%></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	
	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/statistic.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>

