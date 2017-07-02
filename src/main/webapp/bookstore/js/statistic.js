function activate() {
	$('#dataTables').DataTable({
		responsive : true
	});
};
function appendTable(data,criteria) {  
              var panel_body = document.createElement("div");
              panel_body.className = "panel-body";
              panel_body.id = "panel-body";
              var div = document.createElement("div");  
              div.className = "dataTable_wrapper";
              //init thead
              var table = document.createElement("table");  
              table.className = "table table-striped table-bordered table-hover";
              table.id = "dataTables";
              var thead = document.createElement("thead");  
              var tr = document.createElement("tr");  
              
              var td1 = document.createElement("th");  
              td1.innerHTML = criteria;  
              tr.appendChild(td1);  
              var td2 = document.createElement("th"); 
              td2.innerHTML = "Number of books sold";  
              tr.appendChild(td2);  
              var td3 = document.createElement("th"); 
              td3.innerHTML = "Total Sales Amount";  
              tr.appendChild(td3);  
              
              thead.appendChild(tr);
              table.appendChild(thead);  
              //init tbody
              var tbody = document.createElement("tbody");  
              for ( var tableRowNo = 0; tableRowNo < data.length; tableRowNo++) {  
                        var tr = document.createElement("tr");  
                        var cell1 = document.createElement("td");  
                        cell1.innerHTML = data[tableRowNo]["criteria"];  
                        tr.appendChild(cell1);  
                        var cell2 = document.createElement("td");  
                        cell2.innerHTML = data[tableRowNo]["number"];  
                        tr.appendChild(cell2);  
                        var cell3 = document.createElement("td");  
                        cell3.innerHTML = data[tableRowNo]["amount"];  
                        tr.appendChild(cell3);  
                        tbody.appendChild(tr);  
             }  
             table.appendChild(tbody);
             div.appendChild(table);
             panel_body.appendChild(div);
             document.getElementById("panel").removeChild(document.getElementById("panel-body"));
             document.getElementById("panel").appendChild(panel_body);
             var page_wrapper = document.getElementById("page-wrapper");
             document.getElementById("wrapper").removeChild(document.getElementById("page-wrapper"));
             document.getElementById("wrapper").appendChild(page_wrapper);
             activate();
}

function allByBook(){
	jQuery.ajax({
		url : 'allByBookStatisticPro',
		processData : true,
		dataType : "json",
		success : function(data) {
			appendTable(data,"Book id");
		}
	});
}
function allByUser(){
	jQuery.ajax({
		url : 'allByUserStatisticPro',
		processData : true,
		dataType : "json",
		success : function(data) {
			appendTable(data,"User id");
		}
	});
}
function allByStartDate(){
	jQuery.ajax({
		url : 'allByStartDateStatisticPro',
		processData : true,
		dataType : "json",
		success : function(data) {
			appendTable(data,"Start Date");
		}
	});
}
function allByEndDate(){
	jQuery.ajax({
		url : 'allByEndDateStatisticPro',
		processData : true,
		dataType : "json",
		success : function(data) {
			appendTable(data,"End Date");
		}
	});
}
function allByCategory(){
	jQuery.ajax({
		url : 'allByCategoryStatisticPro',
		processData : true,
		dataType : "json",
		success : function(data) {
			appendTable(data,"Category");
		}
	});
}