<% request.setAttribute("contextName", request.getContextPath()); %>
<div id="modal-form" class="modal modal-primary" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 id="modal-title">Form Supplier</h4>
			</div>
			<div class="modal-body">
				<%@include file="supplier/add.jsp"  %>
			</div>
		</div>
	</div>
</div>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Supplier</h3>
		<div class="box-tools">
           <div class="input-group input-group-sm" style="width: 250px;">
             <input type="text" id="txt-search" class="form-control pull-right" placeholder="Search">

             <div class="input-group-btn">
               	<button type="button" id="btn-search" class="btn btn-default"><i class="fa fa-search"></i></button>
               	<button type="button" id="btn-add" class="btn btn-primary"><i class="fa fa-plus"></i></button>
             </div>
           </div>
         </div>
	</div>
	<div class="box-body">
		<table class="table table-considered">
			<thead>
				<tr>
					<!-- <td>ID</td> -->
					<td>Name</td>
					<td>Address</td>
					<td>Phone</td>
					<td>Email</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody id="list-data">
			
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
	function loadData(){
		$.ajax({
			url:'${contextName}/master/supplier/list',
			dataType:'html',
			type:'get',
			success:function(result){
				$("#list-data").html(result);
			}
		});
	}
	
	function loadRegion(provinceId, selectedId=0){
		$.ajax({
			url:'${contextName}/master/region/listByProvince.json',
			data:{'provinceId':provinceId, '${_csrf.parameterName}': '${_csrf.token}'},
			type:'get',
			dataType:'json',
			success:function(result){
				$("#modal-form").find("#regionId").empty();
				$("#modal-form").find("#regionId").append('<option value="">= Choose Region =</option>');
				
				$.each(result.list,function(index,item){
					$("#modal-form").find("#regionId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
				});
				
				if(selectedId > 0){
					$("#modal-form").find("#regionId").val(selectedId);
				}
			}
		});
	};
	
	function loadDistrict(regionId, selectedId=0){
		$.ajax({
			url:'${contextName}/master/district/listByRegion.json',
			data:{'regionId':regionId, '${_csrf.parameterName}': '${_csrf.token}'},
			type:'get',
			dataType:'json',
			success:function(result){
				$("#modal-form").find("#districtId").empty();
				$("#modal-form").find("#districtId").append('<option value="">= Choose District =</option>');
				
				$.each(result.list,function(index,item){
					$("#modal-form").find("#districtId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
				});
				
				if(selectedId > 0){
					$("#modal-form").find("#districtId").val(selectedId);
				}
			}
		});
	};
	
	// combo kecamataan di klik
	/* function loadVillage(districtId, selectedId=0){
		$.ajax({
			url:'${contextName}/master/village/listByDistrict.json',
			data:{'districtId':districtId, '${_csrf.parameterName}': '${_csrf.token}'},
			type:'get',
			dataType:'json',
			success:function(result){
				$("#modal-form").find("#villageId").empty();
				$("#modal-form").find("#villageId").append('<option value="">= Pilih Desa =</option>');
				$.each(result.list,function(index,item){
					$("#modal-form").find("#villageId").append('<option value="'+ item.id +'">'+ item.name +'</option>');
				});
				
				if(selectedId > 0){
					$("#modal-form").find("#villageId").val(selectedId);
				}
			}
		});
	};
	 */
	$(document).ready(function(){
		// load data first display
		loadData();
		
		// combo province di klik
		$("#modal-form").on("change","#provinceId", function(){
			var provinceId = $(this).val();
			// memanggil method loadKota diatas
			loadRegion(provinceId);
			// kosongkan combo district
			$("#modal-form").find("#districtId").empty();
			$("#modal-form").find("#districtId").append('<option value="">= Choose District =</option>');
			
			/* // kosongkan combo village
			$("#modal-form").find("#villageId").empty();
			$("#modal-form").find("#villageId").append('<option value="">= Pilih Desa =</option>');
		 */});
		
		// combo region di klik
		$("#modal-form").on("change","#regionId", function(){
			var regionId = $(this).val();
			// manggil load district
			loadDistrict(regionId);
			
			/* // kosongkan combo village
			$("#modal-form").find("#villageId").empty();
			$("#modal-form").find("#villageId").append('<option value="">= Pilih Desa =</option>');
		 */});
		
		// combo region di klik
		$("#modal-form").on("change","#districtId", function(){
			var districtId = $(this).val();
			// manggil load district
			loadVillage(districtId);
		});
		
		$("#btn-add").click(function(){
			$.ajax({
				url:'${contextName}/master/supplier/add',
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					/* $("#modal-title").html("Create New Supplier"); */
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		$("#btn-search").click(function(){
			var key = $("#txt-search").val();
			$.ajax({
				url:'${contextName}/master/supplier/search',
				data:{'key':key},
				dataType:'html',
				type:'get',
				success:function(result){
					$("#list-data").html(result);
				}
			});
		});
		
		$("#list-data").on('click','.btn-edit',function(){
			var id = $(this).val();
			$.ajax({
				url:'${contextName}/master/supplier/edit',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Edit Data Supplier");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		$("#list-data").on('click','.btn-delete',function(){
			var id = $(this).val();
			$.ajax({
				url:'${contextName}/master/supplier/delete',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menghapus Data Supplier");
					$("#modal-form").addClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		// simpan data dari form
		$("#modal-form").on("submit","#form-supplier", function(){
			$.ajax({
				url:'${contextName}/master/supplier/save.json',
				type:'post',
				data:$(this).serialize(),
				success:function(result){
					if(result.message=="success"){
						$("#modal-form").modal("hide");
						loadData();
					}
				}
			});				
			return false;
		});
	});
</script>