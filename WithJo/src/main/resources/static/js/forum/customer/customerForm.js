function customerCheck() {
	let customerQue2 = $('#customerQue2').val();
	customerQue2 = customerQue2.replaceAll(/'/g, '`');
	customerQue2 = customerQue2.replaceAll(/"/g, '&quot;');
	$('#customerQue').val(customerQue2);		
	document.getElementById("customerForm").submit(); 
}

function pageMoveList() {
    location.href = '/customer/list';
}