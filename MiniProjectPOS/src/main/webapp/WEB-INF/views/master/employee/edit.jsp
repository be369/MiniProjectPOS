<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="form-employee" action="" method="POST"
	class="form">
	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="update" /> <input
		type="hidden" id="id" name="id" value="${item.id }" /> <input
		type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="firstName">First Name</label> <input
					type="text" name="firstName" id="firstName"
					value="${item.firstName }" class="form-control" />
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="lastName">Last Name</label> <input
					type="text" name="lastName" id="lastName" value="${item.lastName }"
					class="form-control" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="title">Title</label> <input
					type="text" name="title" id="title" value="${item.title }"
					class="form-control" />
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="email">Email</label> <input
					type="text" name="email" id="email" value="${item.email }"
					class="form-control" />
			</div>
		</div>
	</div>

	<div class="row">
		<div class="form-group col-md-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="haveAccount"
					name="haveAccount" value="${item.haveAccount }"> Have
					Account ?
				</label>
			</div>
		</div>
	</div>

	<div class="row" id="role-account">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="roleId">Role</label> <select
					id="roleId" name="roleId" class="form-control">
					<c:forEach var="role" items="${roleList}">
						<option value="${role.id}">${role.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="userName">Username</label> <input
					type="text" name="userName" id="userName"
					value="${item.user.username }" class="form-control" />
			</div>
		</div>

		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="password">Password</label> <input
					type="text" name="password" id="password"
					value="${item.user.password }" class="form-control" />
			</div>
		</div>
	</div>

	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left"
			data-dismiss="modal">
			<i class="fa fa-close"></i> Close
		</button>
		<button type="submit" class="btn btn-primary">
			<i class="glyphicon glyphicon-floppy-disk"></i> Simpan
		</button>
	</div>
</form>

<script type="text/javascript">
	$(".date-picker").datepicker({
		autoclose : true,
		format : 'mm/dd/yyyy',
	});
</script>