$(function() {
    $("#new").focus();

    $(document).ready(function() {
	// BookmarkProxy.findAll(findAllOk);
	findAllOk();
    });

    $("form").submit(function(event) {
	event.preventDefault();
    });

    $("#new").click(function() {
	location.href = "bookmark-edit.html";
    });

    $("#delete").click(function() {
	var ids = [];

	$("input:checked").each(function(index, value) {
	    ids.push($(value).val());
	});

	if (ids.length == 0) {
	    alert('Nenhum registro selecionado');
	} else if (confirm('Tem certeza que deseja apagar?')) {
	    BookmarkProxy.remove(ids, removeOk);
	}
    });
});

function findAllOk(data) {
    var oTable = $('#resultList').dataTable(
	    {
		"aoColumns" : [
			{
			    "aTargets" : [ 0 ],
			    "mData" : "id",
			    "mRender" : function(id) {
				return '<input id="remove-' + id
					+ '" type="checkbox" value="' + id
					+ '">';
			    }
			}, {
			    "aTargets" : [ 1 ],
			    "mData" : "description"
			}, {
			    "aTargets" : [ 2 ],
			    "mData" : "link"
			} ],
		"oLanguage" : {
		    "sInfo" : "Mostrando _START_ a _END_ de _TOTAL_ registros",
		},
		// "bDestroy" : true,
		"bRetrieve" : true,
		"sPaginationType" : "bs_normal",

		// "aaData" : data,
		// "bSort" : true

		"sAjaxSource" : 'api/bookmark/datatables',
		"bServerSide" : true,
		"bSort" : false
	    });
    oTable.fnClearTable();
}

function removeOk(data) {
    $.each(data, function(index, value) {
	findAllOk();
    });
}
