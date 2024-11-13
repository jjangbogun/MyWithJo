function customerCheck() {
	let customerQue2 = $('#customerQue2').val();
	customerQue2 = customerQue2.replaceAll(/'/g, '`');
	customerQue2 = customerQue2.replaceAll(/"/g, '&quot;');
	$('#customerQue').val(customerQue2);		
	document.getElementById("customerForm").submit(); 
	alert("질문이 등록되었습니다.");
}

function pageMoveList() {
    location.href = '/customer/list';
}