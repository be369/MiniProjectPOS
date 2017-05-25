<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="form-supplier" method="post" class="form-horizontal">
	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="insert"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-2" for="nama">Nama</label>
				<div class="col-md-10">
					<input type="text" id="name" name="name" class="form-control" />
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-2" for="email">Email</label>
				<div class="col-md-10">
					<input type="text" id="email" name="email" class="form-control" />
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-2" for="phone">Phone</label>
				<div class="col-md-10">
					<input type="text" id="phone" name="phone" class="form-control" />
				</div>
			</div>
		</div>
		
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-2" for="address">Address</label>
				<div class="col-md-10">
					<input type="text" id="address" name="address" class="form-control" />
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<!-- dropdown province mengambil dari database -->
			<div class="form-group">
				<label class="control-label col-md-2" for="provinceId">Province</label>
				<div class="col-md-10">			
					<select id="provinceId" name="provinceId" class="form-control">
						<option value="">= Pilih Propinsi =</option>
						<c:forEach var="province" items="${provinceList}">
							<option value="${province.id}"> ${province.name} </option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<!-- Dropdown region akan diisi lewat ajax -->
			<div class="form-group">
				<label class="control-label col-md-2" for="regionId" >Region</label>
				<div class="col-md-10">			
					<select id="regionId" name="regionId" class="form-control">
						<option value="">= Pilih Kota =</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-6">
			<!-- Dropdown district akan diisi lewat ajax -->
			<div class="form-group">
				<label class="control-label col-md-2" for="districtId" >District</label>
				<div class="col-md-10">			
					<select id="districtId" name="districtId" class="form-control">
						<option value="">= Pilih Kecamatan =</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<!-- Dropdown village akan diisi lewat ajax -->
			<div class="form-group">
				<label class="control-label col-md-2" for="villageId" >Village</label>
				<div class="col-md-10">			
					<select id="villageId" name="villageId" class="form-control">
						<option value="">= Pilih Desa =</option>
					</select>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label col-md-2" for="postalCode">Postal Code</label>
				<div class="col-md-10">
					<input type="text" id="postalCode" name="postalCode" class="form-control" />
				</div>
			</div>
		</div>
		
		<div class="col-md-6">
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
</script>