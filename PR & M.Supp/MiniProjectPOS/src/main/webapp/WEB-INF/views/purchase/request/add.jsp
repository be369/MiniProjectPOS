<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="form-purchase" method="post" class="form-horizontal">

	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="insert"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="form-group">
		<label class="control-label col-md-2" for="readyTime">Tanggal Ready</label>
		<div class="col-md-4">
			<div class="input-group">
				<div class="input-group-addon">
					<i class="fa fa-calendar"></i>
				</div>
				<input type="text" id="readyTime" name="readyTime" class="form-control date-picker" />
			</div>	
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-2" for="notes">Notes</label>
		<div class="col-md-10">
			<input type="text" id="notes" name="notes" class="form-control" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="box box-info">
				<div class="box-header">
					<h3 class="box-title">Purchase Request</h3>
					<div class="box-tools">
			         	<button type="button" id="btn-add-item" class="btn btn-primary btn-sm"><i class="fa fa-plus"></i></button>
			         </div>
				</div>
				<div class="box-body">
					<table class="table table-considered">
						<thead>
							<tr>
								<td class="col-md-4">Item</td>
								<td class="col-md-2">In Stock</td>
								<td class="col-md-2">Request Qty</td>
								<td class="col-md-1">Action</td>
							</tr>
						</thead>
						<tbody id="list-variant">
						
						</tbody>
					</table>
				</div>
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
</script>