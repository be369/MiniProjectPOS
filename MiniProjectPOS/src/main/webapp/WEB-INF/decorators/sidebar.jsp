<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${contextName}/assets/dist/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${username}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<li class="treeview">
				<a href="#"> 
					<i	class="fa fa-dashboard"></i> <span>Master Data</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/master/category.html" class="menu-item"><i class="fa fa-circle-o"></i> Kategori</a></li>
					<li><a href="${contextName}/master/role.html" class="menu-item"><i class="fa fa-circle-o"></i> Role</a></li>
					<li><a href="${contextName}/master/outlet.html" class="menu-item"><i class="fa fa-circle-o"></i> Outlet</a></li>
					<li><a href="${contextName}/master/supplier.html" class="menu-item"><i class="fa fa-circle-o"></i> Supplier</a></li>
					<li><a href="${contextName}/master/item.html" class="menu-item"><i class="fa fa-circle-o"></i> Item</a></li>
				</ul>
			</li>
			<li>
				<a href="#"> 
					<i	class="fa fa-laptop"></i> <span>Purchase</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/purchase/request.html"><i class="fa fa-circle-o"></i> Request</a></li>
					<li><a href="${contextName}/purchase/order.html"><i class="fa fa-circle-o"></i> Order</a></li>
				</ul>
			</li>
			
			<li>
				<a href="#"> 
					<i	class="fa fa-pie-chart"></i> <span>Transaksi</span> 
					<span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>	</span>
				</a>
				<ul class="treeview-menu">
					<li><a href="${contextName}/transaksi/adjustment.html"><i class="fa fa-circle-o"></i> Request</a></li>
					<li><a href="${contextName}/transaksi/transfer.html"><i class="fa fa-circle-o"></i> Order</a></li>
				</ul>
			</li>
			
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>