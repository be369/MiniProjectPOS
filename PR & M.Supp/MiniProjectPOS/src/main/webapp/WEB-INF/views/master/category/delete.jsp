<p>
	Anda yakin akan menghapus data kategori ${item.name}
</p>
<form id="form-category" method="post" class="form-horizontal">

	<input type="hidden" id="action" name="action" value="delete"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="hidden" id="id" name="id" value="${item.id}" />
	
	<div class="modal-footer">
		<button type="button" class="btn btn-outline pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Close</button>
		<button type="submit" class="btn btn-danger"><i class="fa fa-trash"></i> Hapus</button>
	</div>
</form>