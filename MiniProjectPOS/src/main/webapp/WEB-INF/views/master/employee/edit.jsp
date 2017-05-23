<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="form-employee" action="" method="POST" class="form">
	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="update"/>
	<input type="hidden" id="id" name="id" value="${item.id }"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="firstName">First Name</label>
				<input type="text" name="firstName" id="firstName" value="${item.firstName }" class="form-control" />
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="middleName">Midle Name</label>
				<input type="text" name="middleName" id="middleName" value="${item.middleName }" class="form-control"/>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="lastName">Last Name</label>
				<input type="text" name="lastName" id="lastName" value="${item.lastName }" class="form-control"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="title">Title</label>
				<input type="text" name="title" id="title" value="${item.title }" class="form-control"/>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="email">Email</label>
				<input type="text" name="email" id="email" value="${item.email }" class="form-control"/>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="phone">Phone</label>
				<input type="text" name="phone" id="phone" value="${item.phone }" class="form-control"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="provinceId">Propinsi</label>
				<select id="provinceId" name="provinceId" class="form-control">
					<option>Select Province</option>
					<c:forEach var="province" items="${provinceList}">
						<option value="${province.id}"> ${province.name} </option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="regionId">Region</label>
				<select id="regionId" name="regionId" class="form-control">
					<option>Select Region</option>
				</select>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="districtId">District</label>
				<select id="districtId" name="districtId" class="form-control">
					<option>Select Region</option>
				</select>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="villageId">Village</label>
				<select id="villageId" name="villageId" class="form-control">
					<option>Select Village</option>
				</select>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="address">Address</label>
				<input type="text" name="address" id="address" class="form-control"/>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="dateOfBirth">Date Of Birth</label>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-calendar"></i>
					</div>
					<input type="text" id="dateOfBirth" name="dateOfBirth" value="${item.dateOfBirth }" class="form-control date-picker" />
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-md-10">
			<div class="checkbox">
				<label>
					<input type="checkbox" id="haveAccount" name="haveAccount" value="${item.haveAccount }">
					Have Account ?
				</label>
			</div>
		</div>
	</div>
	
	<div class="row" id="role-account">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="roleId">Role</label>
				<select id="roleId" name="roleId" class="form-control">
					<option>Select Role</option>
					<c:forEach var="role" items="${roleList}">
						<option value="${role.id}"> ${role.name} </option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="userName">Username</label>
				<input type="text" name="userName" id="userName" value="${item.user.username }" class="form-control"/>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label" for="password">Password</label>
				<input type="text" name="password" id="password" value="${item.user.password }" class="form-control"/>
			</div>
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
		<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-floppy-disk"></i> Simpan</button>
	</div>
</form>

<script type="text/javascript">
	$(".date-picker").datepicker({
		autoclose: true,
		format:'mm/dd/yyyy',
	});
	
	// set select role
	$("#roleId").val('${item.user.roleId}');
	
	// set select per provice
	$("#provinceId").val('${item.provinceId}');
	
	// load kota
	loadRegion('${item.provinceId}','${item.regionId}');
	
	// load kecamatan
	loadDistrict('${item.regionId}','${item.districtId}');
	
	// load desa
	loadVillage('${item.districtId}','${item.villageId}');
</script>