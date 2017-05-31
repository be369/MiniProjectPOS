<% request.setAttribute("contextName", request.getContextPath());%>
<div id="modal-form" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 id="modal-title">Form Purchase</h4>
			</div>
			<div class="modal-body">
				
			</div>
		</div>
	</div>
</div>

<!-- modal item  -->
<div id="modal-item" class="modal" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 id="modal-title" class="modal-title">Add Item</h4>
			</div>
			<div class="modal-body">
				<%@include file="request/add-item.jsp" %>
			</div>
		</div>
	</div>
</div>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Purchase</h3>
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
					<td>ID</td>
					<td>PR No.</td>
					<td>Notes</td>
					<td>Read Time</td>
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
			url:'${contextName}/purchase/request/list',
			dataType:'html',
			type:'get',
			success:function(result){
				$("#list-data").html(result);
			}
		});
	}
	
	$(".date-picker").datepicker({
		autoclose: true,
		format:'mm/dd/yyyy',
	});
	
	$(document).ready(function(){
		// load data first display
		loadData();
		
		$("#btn-add").click(function(){
			$.ajax({
				url:'${contextName}/purchase/request/add',
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menambah Purchase Baru");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		// add item
		$("#modal-form").on("click","#btn-add-item", function(){
			$("#modal-item").modal("show");
		});
		
		// search item variant
		$("#btn-item-search").click(function(){
			var keySearch = $("#txt-search-item").val();
			if(keySearch != null || keySearch==""){
				$.ajax({
					url:'${contextName}/master/item/searchVariant.json',
					data:{"key": keySearch},
					type:'get',
					dataType:'json',
					success:function(result){
						var dataVariant = "";
						$.each(result.list, function(index, item){
							dataVariant+='<tr>'+
									'<td>'+ item[1] +'</td>'+
									'<td>'+ item[5] +'</td>'+
									'<td><input type="text" class="form-control request"/></td>'+
									'<td><button type="button" class="btn btn-success btn-xs btn-add-variant" data-varId="'+ item[0] +'" data-varName="'+ item[1] +'" data-itemId="'+ item[2]+'" data-itemName="'+ item[3] +'" data-inStock="'+ item[5] +'"><i class="fa fa-plus"></i></button> </td>'+
								'</tr>';
						});
						
						$("#list-data-item").html(dataVariant);
					}
				});
			}
		});
		
		// tombol plus diclick
		$("#list-data-item").on("click",".btn-add-variant", function(e){
			e.preventDefault();
			// define properti yang akan diambil		
			var variantId = $(this).attr("data-varId");
			var variantName = $(this).attr("data-varName");
			var itemId = $(this).attr("data-itemId");
			var itemName = $(this).attr("data-itemName");
			var inStock = $(this).attr("data-inStock");
			var request = $(this).parent().parent().find(".request").val();
			if(isNaN(request) || request == "" || Number(request)==0){
				alert("Isi dahulu jumlah request ");
			} else {
				// mencari jumlah variant
				var row = $("#modal-form").find("#list-variant >tr").length;
				// definisikan data yang akan ditambahkan
				var data = '<tr id="'+ row +'">'+
						'<td>'+
							'<input type="hidden" id="detail_'+ row +'_variantId" name="detail['+ row +'].variantId" value="'+ variantId +'" class="form-control" /> '+
							'<input type="hidden" id="detail_'+ row +'_variantName" name="detail['+ row +'].variantName" value="'+ variantName +'" class="form-control" /> '+
							variantName +
						'</td>'+
						'<td><input type="text" id="detail_'+ row +'_inStockQty" name="detail['+ row +'].inStockQty" value="'+ inStock +'" class="form-control" /> </td>'+
						'<td><input type="text" id="detail_'+ row +'_requestQty" name="detail['+ row +'].requestQty" value="'+ request +'" class="form-control" /> </td>'+
						'<td>'+
							'<button type="button" value="" class="btn btn-danger btn-xs btn-delete-item"><i class="fa fa-trash-o"></i></button> '+
						'</td>'+
					'</tr>';
				// add ke list
				$("#modal-form").find("#list-variant").append(data);
			}
		});
		
		// tombol delete di klik
		$("#modal-form").on("click",".btn-delete-item", function(e){
			var id = $(this).val();
			// jika id tidak sama null
			// maka delete ke database
			if(id.length > 0 || id != "" || !isNaN(id)){
				$.ajax({
					url:'${contextName}/purchase/request/deleteDetail.json',
					data:{'id':id , '${_csrf.parameterName}':'${_csrf.token}'},
					dataType:'json',
					type:'post',
					success:function(result){
						alert("data berhasil dihapus");
					}
				});
			} 
			
			// remove row
			$(this).parent().parent().remove();
			// urutkan index nya kembali
			$.each($("#modal-form").find("#list-variant >tr"), function(index, item){
				var trID = $(this).attr("id");
				// replace id
				$(this).attr('id',index);
				
				$(this).find(".form-control").each(function(key,val){
					// Replaced Name
                    var oldName = $(this).attr('name');
                   	var newName = oldName.replace('[' + trID + ']', '[' + index + ']');
                    $(this).attr('name', newName);
         
					// Replaced ID
                    var oldID = $(this).attr('id');
                    var newID = oldID.replace('_' + trID + '_', '_' + index + '_');
                    $(this).attr('id', newID);
                 
				});
			});
		});
		
		$("#modal-item").on("click","#btn-item-search",function(){
			var key = $("#modal-item").find("#txt-search-item").val();
			
			$.ajax({
				url:'${contextName}/master/item/listVariant',
				dataType:'html',
				type:'get',
				success:function(result){
					$("#list-data").html(result);
				}
			});
		});
		
		$("#btn-search").click(function(){
			var key = $("#txt-search").val();
			$.ajax({
				url:'${contextName}/purchase/search',
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
				url:'${contextName}/purchase/request/edit',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Merubah Data Purchase");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		$("#list-data").on('click','.btn-delete',function(){
			var id = $(this).val();
			$.ajax({
				url:'${contextName}/purchase/request/delete',
				data:{'id':id, '${_csrf.parameterName}':'${_csrf.token}'},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menghapus Data Purchase");
					$("#modal-form").addClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		// simpan data dari form
		$("#modal-form").on("submit","#form-purchase", function(){
			$.ajax({
				url:'${contextName}/purchase/request/save.json',
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