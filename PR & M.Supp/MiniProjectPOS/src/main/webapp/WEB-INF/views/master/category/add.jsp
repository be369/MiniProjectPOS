<form id="form-category" method="post" class="form-horizontal">

	<!-- validasi saat save -->
	<input type="hidden" id="action" name="action" value="insert"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="form-group">
		<label class="control-label col-md-2" for="nama">Category</label>
		<div class="col-md-10">
			<input type="text" id="name" name="name" class="form-control"  placeholder ="Category Name"/>
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Cancel</button>
		<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-floppy-disk"></i> Save</button>
	</div>
</form>