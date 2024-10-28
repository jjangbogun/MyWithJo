function customerCheckFnc() {
 	let customerAns2 = $('#customerAns2').val();
	customerAns2 = customerAns2.replaceAll(/'/g, '`');
	customerAns2 = customerAns2.replaceAll(/"/g, '&quot;');
	$('#customerAns').val(customerAns2);	
	document.getElementById("customerForm").submit();  
}