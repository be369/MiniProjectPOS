<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="form-supplier" method="post" class="form-horizontal">

	<input type="hidden" id="action" name="action" value="update"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" id="id" name="id" value="${item.id}" />
	
	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label col-md-1" for="nama">Supplier Name</label>
				<div class="col-md-11">
					<input type="text" id="name" name="name" class="form-control" value="${item.name }" />
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
			<div class="form-group">
				<label class="control-label col-md-1" for="address">Address</label>
				<div class="col-md-11">
					<input type="text" id="address" name="address" class="form-control" value="${item.address }" />
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<!-- dropdown province mengambil dari database -->
			<div class="form-group">
				<label class="control-label col-md-3" for="provinceId" >Province</label>
				<div class="col-md-9">			
					<select id="provinceId" name="provinceId" class="form-control">
						<option value="">= Choose Province =</option>
						<c:forEach var="province" items="${provinceList}">
							<option value="${province.id}"> ${province.name} </option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<!-- Dropdown region akan diisi lewat ajax -->
			<div class="form-group">
				<label class="control-label col-md-3" for="regionId" >Region</label>
				<div class="col-md-9">			
					<select id="regionId" name="regionId" class="form-control">
						<option value="">= Choose Region =</option>
					</select>
				</div>
			</div>
		</div>

		<div class="col-md-4">
			<!-- Dropdown district akan diisi lewat ajax -->
			<div class="form-group">
				<label class="control-label col-md-3" for="districtId" >District</label>
				<div class="col-md-9">			
					<select id="districtId" name="districtId" class="form-control">
						<option value="">= Choose District =</option>
					</select>
				</div>
			</div>
		</div>
	</div>	
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label col-md-3" for="postalCode">Postal Code</label>
				<div class="col-md-9">
					<input type="text" id="postalCode" name="postalCode" class="form-control" value="${item.postalCode }" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label col-md-3" for="phone">Phone</label>
				<div class="col-md-9">
					<input type="text" id="phone" name="phone" class="form-control" value="${item.phone }" />
				</div>
			</div>
		</div>
		
		<div class="col-md-4">
			<div class="form-group">
				<label class="control-label col-md-3" for="email">Email</label>
				<div class="col-md-9">
					<input type="text" id="email" name="email" class="form-control" value="${item.email }" />
				</div>
			</div>
		</div>	
		
	</div>	

	
		<!-- <div class="col-md-6">
			Dropdown village akan diisi lewat ajax
			<div class="form-group">
				<label class="control-label col-md-2" for="villageId" >village</label>
				<div class="col-md-10">			
					<select id="villageId" name="villageId" class="form-control">
						<option value="">= Pilih Desa =</option>
					</select>
				</div>
			</div>
		</div>
	</div> -->
	
	<div class="modal-footer">
		<button type="reset" class="btn btn-default"><i class="fa fa-close"></i> Cancel</button>
		<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-floppy-disk"></i> Save</button>
	</div>
</form>

<script type="text/javascript">
	$(".date-picker").datepicker({
		autoclose: true,
		format:'mm/dd/yyyy',
	});
	
	// set select peritem
	$("#provinceId").val('${item.provinceId}');
	
	// load kota
	loadRegion('${item.provinceId}','${item.regionId}');
	
	// load kecamatan
	loadDistrict('${item.regionId}','${item.districtId}');
	
</script>