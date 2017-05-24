<form id="form-category" method="post" class="form-horizontal">

	<input type="hidden" id="action" name="action" value="update"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" id="id" name="id" value="${item.id}" />
	
	<div class="form-group">
		<label class="control-label col-md-2" for="fkNama">Nama</label>
		<div class="col-md-10">
			<input type="text" id="name" name="name" value="${item.name}" class="form-control" />
		</div>
	</div>
	
	<div class="modal-footer">
		<button type="button" class="btn btn-default pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
		<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon-floppy-disk"></i> Simpan</button>
	</div>
</form>