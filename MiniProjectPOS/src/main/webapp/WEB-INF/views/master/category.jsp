<% request.setAttribute("contextName", request.getContextPath()); %>
<div id="modal-form" class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 id="modal-title">Form Kategori</h4>
			</div>
			<div class="modal-body">
				
			</div>
		</div>
	</div>
</div>
<div class="box box-info">
	<div class="box-header">
		<h3 class="box-title">Data Kategori</h3>
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
					<td>Kategori</td>
					<td>Items</td>
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
			url:'${contextName}/master/category/list',
			dataType:'html',
			type:'get',
			success:function(result){
				$("#list-data").html(result);
			}
		});
	}
	
	$(document).ready(function(){
		// load data first display
		loadData();
		
		$("#btn-add").click(function(){
			$.ajax({
				url:'${contextName}/master/category/add',
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menambah Kategori Baru");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		$("#btn-search").click(function(){
			var key = $("#txt-search").val();
			$.ajax({
				url:'${contextName}/master/category/search',
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
				url:'${contextName}/master/category/edit',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Merubah Data Kategori");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		$("#list-data").on('click','.btn-delete',function(){
			var id = $(this).val();
			$.ajax({
				url:'${contextName}/master/category/delete',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menghapus Data Kategori");
					$("#modal-form").addClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		// simpan data dari form
		$("#modal-form").on("submit","#form-category", function(){
			$.ajax({
				url:'${contextName}/master/category/save.json',
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