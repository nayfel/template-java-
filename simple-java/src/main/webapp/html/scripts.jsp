
<script>

//this makes the data tables, making sure to not make them into data tables if they already are (that throws a dialog warning)
$(function() {
	$('.dataTable').each(function(){
		if ( $.fn.dataTable.isDataTable( $(this) )) {
			
		}
		else {
			$(this).dataTable({
		   		"paging": false,
		   		"info": false,
		   		"searching": false
			});
		}
	});
} );
// a different type of data table that has more to display
$(function() {
	$('.pagedSearchableDataTable').each(function(){
		if ( $.fn.dataTable.isDataTable( $(this) )) {
			
		}
		else {
			$(this).dataTable({
		   		"pageLength": 5
			});
		}
	});
} );
//makes the pages compact and easier to navigate
$(function() {
	$( ".accordion ").accordion({
		collapsible: true,
		active: false
	});
});

$(function() {
    $( ".dialog" ).dialog({
       autoOpen: false
    });
 });


function openUpdateAssigment(id) {
	var theID= $( "#updateAssignment"+id+"Dialog" );
	theID.dialog("open");
}
function openCompletedAssigment(id) {
	var theID= $( "#updateCompletedAssignment"+id+"Dialog" );
	theID.dialog("open");
}
function openStartAssigment(id) {
	var theID= $( "#startAssignment"+id+"Dialog" );
	theID.dialog("open");
}
function openMakeLog(id) {
	var theID= $( "#makeDailyLog"+id+"Dialog" );
	theID.dialog("open");
}
function openAssignTrack(id) {
	console.log("Other id "+id);
	var theID= $( "#assignTrack"+id+"Dialog" );
	console.log(theID);
	theID.dialog("open");
}
function openDeleteTrack(id) {
	var theID= $( "#deleteTrack"+id+"Dialog" );
	theID.dialog("open");
}

function showSelect() {
	var theID = $( ".empList" );
	console.log("yehay");
	theID.css("display", "block");
}

</script>
